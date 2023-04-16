package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//a basic setup for a Spring Boot application

@SpringBootApplication //combines three other annotations: 
//@Configuration, @EnableAutoConfiguration, and @ComponentScan.
public class Application {

	public static void main(String[] args) {		
		//starts the Spring Boot application by creating an instance of ApplicationContext
		SpringApplication.run(Application.class, args); 

	}

}