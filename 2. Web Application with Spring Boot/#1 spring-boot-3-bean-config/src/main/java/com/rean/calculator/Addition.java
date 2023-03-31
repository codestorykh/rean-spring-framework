package com.rean.calculator;

import org.springframework.stereotype.Component;

@Component
public class Addition implements Operation{

    @Override
    public long apply(long num1, long num2) {
        return num1 + num2;
    }

    @Override
    public boolean handles(char operation) {
        return '+' == operation;
    }

}
