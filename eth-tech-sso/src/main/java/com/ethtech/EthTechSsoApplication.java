package com.ethtech;

import com.ethtech.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.ethtech.repository"})
@EntityScan(basePackages = "com.ethtech.model")
@EnableConfigurationProperties(AppProperties.class)
public class EthTechSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EthTechSsoApplication.class, args);
    }

}
