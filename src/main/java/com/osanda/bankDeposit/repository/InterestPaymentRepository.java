package com.osanda.bankDeposit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.osanda.bankDeposit.model.InterestPayment;

@RepositoryRestResource(exported = true)
public interface InterestPaymentRepository extends JpaRepository<InterestPayment, Long> {

}
