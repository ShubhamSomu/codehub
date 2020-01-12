package com.assignment.codehub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodehubApplication {

	public static void main(String[] args) {
		 Logger logger = LoggerFactory.getLogger(CodehubApplication.class);
		// TODO do dynamic parameter set from request body in case of put patch
		SpringApplication.run(CodehubApplication.class, args);
		logger.debug("************APPLICATION STARTED **************");
	}

}
