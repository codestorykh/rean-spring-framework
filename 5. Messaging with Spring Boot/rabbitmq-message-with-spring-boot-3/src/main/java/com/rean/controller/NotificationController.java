package com.rean.controller;


import com.rean.service.NotificationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationProducer producer;

    @GetMapping("notifi/push")
    public ResponseEntity<Object> pushNotification() {
        producer.pushNotification();
        return ResponseEntity.ok("Push");
    }
}
