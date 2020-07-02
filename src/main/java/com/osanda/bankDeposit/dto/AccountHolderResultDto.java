package com.osanda.bankDeposit.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class AccountHolderResultDto implements Serializable {

	private static final long serialVersionUID = -2604633265428593116L;

	private String displayName;

	private String nic;

	private List<AccountDetailsDto> accounts;

	private Integer totalNumberOfAccounts;

	private Double totalDepositAmount;

	private Double totalInterestMonthly;

	private Double totalInterestMaturity;

}// AccountHolderResultDto {}
