package com.rean;

import com.rean.calculator.Calculator;
import com.rean.calculator.Operation;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

@SpringBootApplication
public class SpringBoot3BeanConfigApplication {

/*
	public static void main(String[] args) {
		//SpringApplication.run(SpringBoot3BeanConfigApplication.class, args);

		var context = SpringApplication.run(SpringBoot3BeanConfigApplication.class, args);

		var calculator = context.getBean(Calculator.class);
		calculator.calculate(2, 2, '+');
		calculator.calculate(2, 2, '-');
		calculator.calculate(2, 2, '*');
		calculator.calculate(2, 2, '/');
	}


	@Bean // create bean method
	public Calculator calculator(Collection<Operation> operations) {
		return new Calculator(operations);
	}

	@Bean
	ApplicationRunner calculatorApplicationRunner(Calculator calculator) {
		return args -> {
			calculator.calculate(2, 2, '+');
			calculator.calculate(2, 2, '-');
			calculator.calculate(2, 2, '*');
			calculator.calculate(2, 2, '/');
		};
	}
*/

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3BeanConfigApplication.class, args);
	}

	/*
	@Bean
	public ApplicationRunner calculatorApplicationRunner(Calculator calculator) {
		return args -> {
			calculator.calculate(2, 2, '+');
			calculator.calculate(2, 2, '-');
			calculator.calculate(2, 2, '*');
			calculator.calculate(2, 2, '/');
		};
	}
	*/


	@Autowired
	public Calculator calculator;

	@PostConstruct
	public void initCalculator() {
		calculator.calculate(2, 2, '+');
		calculator.calculate(2, 2, '-');
		calculator.calculate(2, 2, '*');
		calculator.calculate(2, 2, '/');
	}

}
