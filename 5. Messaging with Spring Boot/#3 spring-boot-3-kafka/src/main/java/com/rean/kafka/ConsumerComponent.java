package com.rean.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerComponent {

    @KafkaListener(topics = "${app.spring.topicName}")
    public void listen(String event) {
        log.info("Received Message: " + event);
    }

}