package com.rean.fraud.controller;

import com.rean.clients.fraud.FraudCheckResponse;
import com.rean.clients.fraud.FraudRequest;
import com.rean.fraud.service.FraudCheckCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-checks")
@Slf4j
public record FraudController(FraudCheckCustomerService fraudCheckCustomerService) {


    @PostMapping()
    public FraudCheckResponse checkCustomer(@RequestBody FraudRequest fraudRequest) {
        boolean isFraudulentCustomer = fraudCheckCustomerService.
                fraudCheckingCustomer(fraudRequest);
        log.info("fraud check request for customer {}", isFraudulentCustomer);

        return new FraudCheckResponse(isFraudulentCustomer);
    }

}