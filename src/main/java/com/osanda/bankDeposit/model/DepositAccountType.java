package com.osanda.bankDeposit.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/***
 * 
 * fix deposit account types details
 * 
 * @author Osanda Wedamulla
 *
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DepositAccountType extends BaseModel {

	private static final long serialVersionUID = 3031101303651816282L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = true)
	private Double rate;

	@Column(nullable = true)
	private Double minimumDeposit;

	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "deposit_account_type_interest_payment", joinColumns = {
			@JoinColumn(name = "deposit_account_type_id", referencedColumnName = "id", nullable = true) }, inverseJoinColumns = {
					@JoinColumn(name = "interest_payment_id", referencedColumnName = "id", nullable = true) })
	private List<InterestPayment> interestPayments = new ArrayList<>();

}
