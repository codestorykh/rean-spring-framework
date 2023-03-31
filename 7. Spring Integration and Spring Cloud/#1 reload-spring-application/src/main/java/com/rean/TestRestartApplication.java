package com.rean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Slf4j
@Component
public class TestRestartApplication {

    @Autowired
    private RestartEndpoint restartEndpoint;

    @PostConstruct
    public void ala() {
        log.info("Running PostConstruct...");
    }

    @PreDestroy
    public void restartApp() {
        log.info("Running PreDestroy...");
      //  restartEndpoint.restart();
    }
}
