package com.osanda.bankDeposit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.osanda.bankDeposit.model.AccountHolder;

@RepositoryRestResource(exported = true)
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {

}
