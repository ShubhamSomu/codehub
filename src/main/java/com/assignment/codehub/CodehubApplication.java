package com.assignment.codehub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodehubApplication {

	public static void main(String[] args) {
		
		// TODO do dynamic parameter set from request body in case of put patch
		SpringApplication.run(CodehubApplication.class, args);
	}

}
