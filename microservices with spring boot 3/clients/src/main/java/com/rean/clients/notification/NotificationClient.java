package com.rean.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "notification-services"
)
public interface NotificationClient {

    @PostMapping("api/v1/notifications")
    void sendNotification(NotificationRequest notificationRequest);
}