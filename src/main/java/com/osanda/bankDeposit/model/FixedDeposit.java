package com.osanda.bankDeposit.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * 
 * information regarding a FixedDeposit account
 * 
 * @author Osanda Wedamulla
 *
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FixedDeposit extends Account {

	private static final long serialVersionUID = 6230669794078024507L;

	private Double amount;

	private Integer periodOfMonths;

	private LocalDate maturityDate;

	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private DepositAccountType depositAccountType;

}
