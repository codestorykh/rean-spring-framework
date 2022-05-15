package com.rean;

import com.rean.service.FakeAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootRedisStackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisStackApplication.class, args);
    }

    @Autowired
    FakeAPIService fakeAPIService;

    @Bean
    void test() {
        fakeAPIService.callingToProductAPI();
        fakeAPIService.callingToUsersAPI();
        fakeAPIService.callingToUserAPI();
    }
}
