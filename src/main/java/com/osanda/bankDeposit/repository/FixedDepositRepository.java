package com.osanda.bankDeposit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.osanda.bankDeposit.model.FixedDeposit;

@RepositoryRestResource(exported = true)
public interface FixedDepositRepository extends JpaRepository<FixedDeposit, String> {

}
