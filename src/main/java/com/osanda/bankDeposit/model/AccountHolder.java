package com.osanda.bankDeposit.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.osanda.bankDeposit.enums.Gender;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Account holder details are included in this model
 * 
 * @author Osanda Wedamulla
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountHolder extends BaseModel {

	private static final long serialVersionUID = -4717364086259526854L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String nicNumber;

	@Column(length = 500)
	private String address;

	@Column(length = 15)
	private String contactNumber;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private LocalDate dateOfBirth;

	@OneToMany(mappedBy = "accountHolder", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	private Set<Account> accounts;
}
