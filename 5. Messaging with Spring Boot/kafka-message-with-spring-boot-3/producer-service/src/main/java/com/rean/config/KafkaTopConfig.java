package com.rean.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopConfig {

    @Value("${spring.kafka.topic.notification}")
    private String topicNotification;


    @Bean
    public NewTopic notificationTopic() {
        return TopicBuilder
                .name(topicNotification)
                .partitions(10)
                .replicas(1)
                .build();

    }

}