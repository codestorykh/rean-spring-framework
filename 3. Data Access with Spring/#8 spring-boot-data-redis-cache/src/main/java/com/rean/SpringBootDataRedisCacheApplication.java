package com.rean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootDataRedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataRedisCacheApplication.class, args);
	}

}
