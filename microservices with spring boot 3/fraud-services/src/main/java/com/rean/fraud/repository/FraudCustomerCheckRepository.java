package com.rean.fraud.repository;

import com.rean.fraud.model.FraudCustomerCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FraudCustomerCheckRepository extends JpaRepository<FraudCustomerCheck, Integer> {
    Optional<FraudCustomerCheck> findAllByIdTypeAndIdValue(String idType, String idValue);
}

