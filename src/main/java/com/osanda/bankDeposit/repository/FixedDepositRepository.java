package com.osanda.bankDeposit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.osanda.bankDeposit.model.FixedDeposit;

/***
 * 
 * manage all the CRUD related operation with including necessary data
 * 
 * @author Osanda Wedamulla
 *
 */

@RepositoryRestResource(exported = true)
public interface FixedDepositRepository extends JpaRepository<FixedDeposit, String> {

}
