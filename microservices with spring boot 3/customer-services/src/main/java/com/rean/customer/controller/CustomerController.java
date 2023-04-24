package com.rean.customer.controller;

import com.rean.customer.data.CustomerRegistrationRequest;
import com.rean.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("api/v1/customers")
@RestController
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
        log.info("Intercept request register customer {}", customerRequest);
        customerService.registerCustomer(customerRequest);
    }
}
