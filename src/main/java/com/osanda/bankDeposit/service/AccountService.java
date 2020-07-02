package com.osanda.bankDeposit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.osanda.bankDeposit.dto.AccountDetailsDto;

import com.osanda.bankDeposit.dto.AccountHolderResultDto;
import com.osanda.bankDeposit.enums.Gender;
import com.osanda.bankDeposit.enums.InterestPaymentMethod;
import com.osanda.bankDeposit.exception.NICInvalideException;
import com.osanda.bankDeposit.exception.NICNotFoundException;
import com.osanda.bankDeposit.model.AccountHolder;
import com.osanda.bankDeposit.model.DepositAccountType;
import com.osanda.bankDeposit.model.FixedDeposit;
import com.osanda.bankDeposit.repository.AccountHolderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/***
 * all the account holder related details processing service
 * 
 * @author Osanda Wedamulla
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountHolderRepository accountHolderRepository;

	/***
	 * 
	 * get all the account details relevant for a NIC number and all the interests
	 * amount paid based on specified conditions
	 * 
	 * @author Osanda Wedamulla
	 * 
	 * @param nic
	 * @return AccountHolderResultDto
	 * @throws Exception
	 */
	public AccountHolderResultDto getAllAccountDetailsFormNic(String nic) throws Exception {

		if (nic == null) {
			log.warn("NIC has no value.");
			throw new Exception();
		}

		Boolean validNICNumber = this.isValidNICNumber(nic);

		if (!validNICNumber) {
			log.info("NIC has a invalid format.");
			throw new NICInvalideException();
		}

		AccountHolder accountHolder = this.accountHolderRepository.findByNicNumber(nic);

		AccountHolderResultDto resultDto = new AccountHolderResultDto();

		if (accountHolder == null) {
			log.info("Accounts not available for NIC " + nic);
			throw new NICNotFoundException();
		} else {

			String salutation = "Mr. ";

			if (accountHolder.getGender() != null && accountHolder.getGender() == Gender.FEMALE) {
				salutation = "Ms. ";
			}

			String displayName = salutation + (accountHolder.getFirstName() != null ? accountHolder.getFirstName() : "")
					+ (accountHolder.getLastName() != null ? accountHolder.getLastName() : "");

			resultDto.setDisplayName(displayName);
			resultDto.setNic(accountHolder.getNicNumber());

			List<AccountDetailsDto> accounts = this
					.getAccountDetailListFromFixDepositList(accountHolder.getFixedDeposits());

			resultDto.setAccounts(accounts);

			Double totalDeposit = accountHolder.getFixedDeposits().stream().map(d -> d.getAmount())
					.collect(Collectors.summingDouble(Double::doubleValue));

			int totalNumberOfAccounts = accountHolder.getFixedDeposits().size();

			resultDto.setTotalDepositAmount(totalDeposit);
			resultDto.setTotalNumberOfAccounts(totalNumberOfAccounts);

			Double totalInterestMonthly = accounts.stream()
					.filter(ac -> ac.getInterestPaymentMethod().equals(InterestPaymentMethod.MONTHLY.toString()))
					.map(acc -> acc.getInterestAmount()).collect(Collectors.summingDouble(Double::doubleValue));

			Double totalInterestMaturity = accounts.stream()
					.filter(ac -> ac.getInterestPaymentMethod().equals(InterestPaymentMethod.MATURITY.toString()))
					.map(acc -> acc.getInterestAmount()).collect(Collectors.summingDouble(Double::doubleValue));

			resultDto.setTotalInterestMonthly(totalInterestMonthly);
			resultDto.setTotalInterestMaturity(totalInterestMaturity);

		}

		return resultDto;

	}// getAllAccountDetailsFormNic()

	/***
	 * 
	 * validate NIC number via external library or available source
	 * 
	 * @author Osanda Wedamulla
	 * 
	 * @param nic
	 * @return Boolean
	 */
	private Boolean isValidNICNumber(String nic) {

		boolean valid = true;

		// NIC validation logic implement here

		return valid;
	}// isValidNICNumber ()

	/***
	 * 
	 * get all the account list with interests amount that is calculated based on
	 * the account type and interest defined at the account opening stage
	 * 
	 * @author Osanda Wedamulla
	 * 
	 * @param deposits
	 * @return List<AccountDetailsDto>
	 */
	private List<AccountDetailsDto> getAccountDetailListFromFixDepositList(List<FixedDeposit> deposits) {

		List<AccountDetailsDto> accounDetails = new ArrayList<>();

		deposits.forEach(deposit -> {

			AccountDetailsDto account = new AccountDetailsDto();

			account.setAccountNumber(deposit.getAccountNo());

			DepositAccountType accountType = deposit.getDepositAccountType();
			account.setAccountType(accountType != null ? accountType.getName() : "Not Available");

			account.setDepositAmount(deposit.getAmount());
			account.setPeriodOfMonths(deposit.getPeriodOfMonths());

			String interestPaymentMethod = "Not Available";

			if (accountType != null) {
				interestPaymentMethod = accountType.getInterestPayement() != null
						? accountType.getInterestPayement().toString()
						: "Not Available";
			}
			account.setInterestPaymentMethod(interestPaymentMethod);

			// for interest calculation assume that when creating the deposit account with
			// relevant type, based on that, deposit amount and Interest Payment method
			// correct interest is calculated and persist into the deposit account rate as
			// the final interest Rate

			Double interestAmount = null;

			switch (accountType.getInterestPayement()) {

			case MATURITY:
				interestAmount = ((deposit.getAmount() * deposit.getRate()) / 100 * 12) * deposit.getPeriodOfMonths();
				break;

			case MONTHLY:
				interestAmount = (deposit.getAmount() * deposit.getRate()) / 100 * 12;
				break;

			default:
				log.error("Interest payemet method is not defined !!");
				break;
			}

			log.info("Interest calculated for Account Number {} with Deposit Account type {} ",
					account.getAccountNumber(), account.getAccountType());

			account.setInterestAmount(interestAmount);

		});

		return accounDetails;

	}// getAccountDetailListFromFixDepositList()

}// AccountService {}