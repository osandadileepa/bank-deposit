package com.osanda.bankDeposit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.osanda.bankDeposit.model.AccountHolder;

/***
 * 
 * all the CRUD operation for Account holder to manipulate a client
 * 
 * @author Osanda Wedamulla
 *
 */

@RepositoryRestResource(exported = true)
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {

	AccountHolder findByNicNumber(String nicNumber);

}
