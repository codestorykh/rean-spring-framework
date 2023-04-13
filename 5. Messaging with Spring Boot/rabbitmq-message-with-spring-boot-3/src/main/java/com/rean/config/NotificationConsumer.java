package com.rean.config;

import com.rean.dto.NotificationRequest;
import com.rean.model.Notification;
import com.rean.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository notificationRepository;


    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumeNotification(NotificationRequest notificationRequest) {
        log.info("MSG Queue ... {}", notificationRequest);


        notificationRepository.save(
            Notification.builder()
                    .toCustomerId(notificationRequest.getToCustomerId())
                    .toCustomerEmail(notificationRequest.getToCustomerEmail())
                    .sender("Rean Code")
                    .message(notificationRequest.getMessage())
                    .sentAt(LocalDateTime.now())
                    .build()
        );
    }

}
