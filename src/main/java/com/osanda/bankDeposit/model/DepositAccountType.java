package com.osanda.bankDeposit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.osanda.bankDeposit.enums.InterestPaymentMethod;

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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "name", "interestPayement" }))
public class DepositAccountType extends BaseModel {

	private static final long serialVersionUID = 3031101303651816282L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = true)
	private Double minimumDeposit;

	@Enumerated(EnumType.STRING)
	private InterestPaymentMethod interestPayement;

}
