package com.rean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Order(value = 1)
@SpringBootApplication
public class SpringBoot3FirstViewApplication implements CommandLineRunner {

	public static void main(String[] args) {
		//	SpringApplication.run(SpringBoot3FirstViewApplication.class, args);

		// disable spring boot banner console
		SpringApplication app = new SpringApplication(SpringBoot3FirstViewApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Autowired
	ApplicationContext applicationContext;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Testing CommandLine Runner");

		/* String[] beans = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beans);
		for(String b : beans) {
			System.out.println("Bean name " + b + " => " + applicationContext.getBean(b).getClass());
		}*/
	}
}
