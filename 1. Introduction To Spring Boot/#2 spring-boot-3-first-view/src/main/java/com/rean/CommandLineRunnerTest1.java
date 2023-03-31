package com.rean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerTest1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Testing CommandLineRunner 1");
    }
}
