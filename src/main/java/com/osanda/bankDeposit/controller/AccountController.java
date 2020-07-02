package com.osanda.bankDeposit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osanda.bankDeposit.dto.AccountHolderResultDto;
import com.osanda.bankDeposit.dto.ErrorResponseDto;
import com.osanda.bankDeposit.exception.NICInvalideException;
import com.osanda.bankDeposit.exception.NICNotFoundException;
import com.osanda.bankDeposit.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController()
@RequiredArgsConstructor
@RequestMapping(value = "${spring.data.rest.base-path}/account/")
public class AccountController {

	private final AccountService accountService;

	
	/***
	 * get account related details from NIC number
	 * 
	 * @author Osanda Wedamulla
	 * 
	 * @param nic
	 * @return  ResponseEntity<?>
	 */
	@GetMapping(value = "get-data")
	public ResponseEntity<?> getAccountsAndDetail(@RequestParam(value = "nic") String nic) {

		try {
			AccountHolderResultDto accountDetails = this.accountService.getAllAccountDetailsFormNic(nic);

			return ResponseEntity.ok(accountDetails);

		} catch (NICInvalideException e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResponseDto("Please enter valid NIC number."));
		} catch (NICNotFoundException e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResponseDto("Bank does not have any account related to this NIC number"));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ErrorResponseDto("Error getting requested data."));
		}

	} // getAccountsAndDetail()

}// AccountController {}
