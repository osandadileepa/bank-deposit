package com.osanda.bankDeposit.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
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

	@Column(nullable = false)
	private Double amount;

	@Column(nullable = true)
	private Integer periodOfMonths;

	@Column(nullable = true)
	private LocalDate maturityDate;

	@Column(nullable = false)
	private Double rate;

	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	private DepositAccountType depositAccountType;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private AccountHolder accountHolder;

}
