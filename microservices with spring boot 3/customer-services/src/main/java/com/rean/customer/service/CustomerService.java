package com.rean.customer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rean.clients.fraud.FraudCheckResponse;
import com.rean.clients.fraud.FraudClient;
import com.rean.clients.fraud.FraudRequest;
import com.rean.clients.notification.NotificationClient;
import com.rean.clients.notification.NotificationRequest;
import com.rean.customer.data.CustomerRegistrationRequest;
import com.rean.customer.model.Customer;
import com.rean.customer.repository.CustomerRepository;
import com.rean.rabbitmq.RabbitMQMessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;
    @Value("${rabbitmq.queues.notification}")
    private String notificationQueue;
    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKey;

    private final KafkaTemplate<String, Object> customKafkaTemplate;

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .gender(customerRequest.gender())
                .idType(customerRequest.idType())
                .idValue(customerRequest.idValue())
                .phoneNumber(customerRequest.phoneNumber())
                .build();

        // TODO: 26/3/23 check if fraudster

        FraudRequest fraudRequest = new FraudRequest(
                customerRequest.idType(),
                customerRequest.idValue()
        );

        /*
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            ObjectMapper objectMapper = new ObjectMapper();
            var jsonRequest = objectMapper.writeValueAsString(fraudRequest);
            HttpEntity<Object> http = new HttpEntity<>(jsonRequest, headers);

            ResponseEntity<String> fraudCheckResponse = restTemplate.exchange(
                    // "http://localhost:8081/api/v1/fraud-checks/{customerId}",
                    "http://FRAUD-SERVICES/api/v1/fraud-checks/{customerId}",
                    HttpMethod.POST,
                    http,
                    String.class);
            objectMapper.readValue(fraudCheckResponse.getBody(), FraudCheckResponse.class);
        }catch (Exception ex){
            log.error(ex.getLocalizedMessage());
        }
         */

        FraudCheckResponse fraudCustomerCheckResponse = fraudClient.checkCustomer(fraudRequest);
        if(null != fraudCustomerCheckResponse && fraudCustomerCheckResponse.isFraudulentCustomer()){
            log.warn("Customer ID {} is fraudster", customer.getId());
            throw new IllegalStateException("Fraudster");
        }

        // TODO: 26/3/23 save customer
        customerRepository.saveAndFlush(customer);

        // TODO: 26/3/23 send notification
        /*
        notificationClient.sendNotification(
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        String.format("Hi %s, welcome to Rean Code",
                                customer.getFirstName() + customer.getLastName())
                        )
        );
         */

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Rean Code...",
                        customer.getFirstName() + customer.getLastName())
        );

        // TODO: 27/3/23 send notification with rabbitmq
        /*
        rabbitMQMessageProducer.publish(
                notificationRequest,
                internalExchange,
                internalNotificationRoutingKey
        );
         */

        // TODO: 29/3/23 send notification with kafka
        customKafkaTemplate.send("notification", notificationRequest);
    }

}
