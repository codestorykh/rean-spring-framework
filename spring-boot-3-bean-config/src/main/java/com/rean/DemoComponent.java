package com.rean;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component // @SpringBootApplication or @ComponentScan detect all annotation @Component
public class DemoComponent {

    @PostConstruct // is invoked after construction and injection of all dependencies
    public void printHelloWorld() {
        System.out.println("Hello World!");
    }

}
