package com.rean.customer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopConfig {

    @Bean
    public NewTopic notificationTopic() {
        return TopicBuilder
                .name("notification")
                .partitions(10)
                .replicas(1)
                .build();

    }
}
