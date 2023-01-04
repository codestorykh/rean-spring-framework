package com.rean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBoot3KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3KafkaApplication.class, args);
	}

}
