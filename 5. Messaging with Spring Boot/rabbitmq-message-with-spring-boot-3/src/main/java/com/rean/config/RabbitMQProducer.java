package com.rean.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitMQProducer {

    private final AmqpTemplate amqpTemplate;


    public void send(Object payload, String exchange, String routingKey) {
        log.info("Exchange to {} and route {} payload {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Exchange to {} and route {} payload {}", exchange, routingKey, payload);
    }
}
