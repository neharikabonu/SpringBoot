package com.example.SpringBoot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBoot2Application {

	public static void main(String[] args) {
		ApplicationContext context =
		SpringApplication.run(SpringBoot2Application.class, args);

	}

}
