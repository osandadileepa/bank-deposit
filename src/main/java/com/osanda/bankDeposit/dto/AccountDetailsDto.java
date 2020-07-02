package com.osanda.bankDeposit.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class AccountDetailsDto implements Serializable {

	private static final long serialVersionUID = 2900261258078497884L;

	private String accountNumber;

	private String accountType;

	private Double depositAmount;

	private Integer periodOfMonths;

	private Double interestAmount;

	private String interestPaymentMethod;

}// AccountDetailsDto {}
