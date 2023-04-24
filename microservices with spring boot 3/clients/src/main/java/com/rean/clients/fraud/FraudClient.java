package com.rean.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("fraud-services")
public interface FraudClient {
    @PostMapping(path = "api/v1/fraud-checks")
    FraudCheckResponse checkCustomer(@RequestBody FraudRequest fraudRequest);
}
