package com.rean.service;

import com.rean.config.RabbitMQProducer;
import com.rean.dto.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {

    @Value("${rabbitmq.exchanges.internal}")
    private String exchangeInternal;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String routingKeyInternal;


    private final RabbitMQProducer rabbitMQProducer;

    public void pushNotification() {
        NotificationRequest notificationRequest = new NotificationRequest(
                1,
                "reancode@gmail.com",
                "Hi AMQ, welcome to Rean Code"
        );

        rabbitMQProducer.send(notificationRequest, exchangeInternal, routingKeyInternal);
    }

}
