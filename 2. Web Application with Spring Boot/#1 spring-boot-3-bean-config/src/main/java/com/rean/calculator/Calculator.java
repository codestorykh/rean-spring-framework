package com.rean.calculator;

import org.springframework.stereotype.Component;

import java.util.Collection;


@Component
public class Calculator {

    private final Collection<Operation> operations;

    public Calculator(Collection<Operation> operations) {
        this.operations = operations;
    }

    public void calculate(long num1, long num2, char op) {
        for(var operation : operations) {
            if(operation.handles(op)) {
                var result = operation.apply(num1, num2);
                System.out.printf("%d %s %d = %s%n", num1, op, num2, result);
                return;
            }
        }
        System.out.println("Invalid Input Operation " + op);
    }

}
