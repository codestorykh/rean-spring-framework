package com.rean.service;

import com.rean.dto.NotificationRequest;
import com.rean.model.Notification;
import com.rean.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationConsumerService {

    private final NotificationRepository notificationRepository;


    @KafkaListener(topics = "notification", groupId = "notification-id", containerFactory = "customKafkaFactory")
    public void pushNotification(NotificationRequest notificationRequest, Acknowledgment acknowledgment) {
        log.info("Message queue {}", notificationRequest);

        Notification notification = Notification.builder()
                .notificationId(1)
                .toCustomerId(notificationRequest.getToCustomerId())
                .toCustomerEmail(notificationRequest.getToCustomerName())
                .message(notificationRequest.getMessage())
                .sender("Rean Code")
                .sentAt(LocalDateTime.now())
                .build();
        notificationRepository.save(notification);
        acknowledgment.acknowledge();
    }

}
