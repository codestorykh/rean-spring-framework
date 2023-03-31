package com.rean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LoadingApplicationProperties {

    @Value("${my.app:DefaultAppName}")
    public String myApp;

    @Value("${my.list}")
    private String myList;

    @Bean
    public void getMyAppValueFromApplication() {
        System.out.println(myApp);
        if(myList.contains("act")) {
            System.out.println(myList);
        }
    }
}
