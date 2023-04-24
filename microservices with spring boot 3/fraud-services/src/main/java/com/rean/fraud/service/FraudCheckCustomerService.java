package com.rean.fraud.service;

import com.rean.clients.fraud.FraudRequest;
import com.rean.fraud.model.FraudCustomerCheck;
import com.rean.fraud.repository.FraudCustomerCheckRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public record FraudCheckCustomerService(FraudCustomerCheckRepository fraudCustomerCheckRepository) {

    public boolean fraudCheckingCustomer(FraudRequest fraudRequest) {
        Optional<FraudCustomerCheck> fraudCustomerCheck = fraudCustomerCheckRepository
                .findAllByIdTypeAndIdValue(fraudRequest.idType(), fraudRequest.idValue());
        if(fraudCustomerCheck.isPresent()){
            return true;
        }
        fraudCustomerCheckRepository.save(
                FraudCustomerCheck.builder()
                        .customerKey(fraudRequest.idType()+fraudRequest.idValue())
                        .idType(fraudRequest.idType())
                        .idValue(fraudRequest.idValue())
                        .created(LocalDateTime.now())
                        .build()
        );
        return false;
    }

}
