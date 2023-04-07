package com.rean.controller;

import com.rean.dto.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final KafkaTemplate<String, Object> customKafkaTemplate;

   // private final KafkaTemplate<String, String> simpleKafkaTemplate;

    @Value("${spring.kafka.topic.notification}")
    private String topicNotification;

    @GetMapping("push/notification")
    public ResponseEntity<Object> pushNotification() {
        customKafkaTemplate.send(topicNotification,
                new NotificationRequest(1,
                        "Rean Code",
                        "Welcome to my channel")
        );

        return ResponseEntity.ok("Successfully");
    }

}
