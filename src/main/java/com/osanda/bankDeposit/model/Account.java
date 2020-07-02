package com.osanda.bankDeposit.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.osanda.bankDeposit.enums.AccountType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * 
 * Account common model to included basic information about an account
 * 
 * @author Osanda Wedamulla
 *
 */

@Entity
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class Account extends BaseModel {

	private static final long serialVersionUID = -1628771124895455125L;

	@Id
	private String accountNo;

	@Enumerated(EnumType.STRING)
	private AccountType accountType;
}
