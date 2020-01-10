package com.assignment.codehub.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Configuration
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class FakerConfig {

	
	private Faker faker;
	
	@Bean(name = "faker")
	public Faker getfakerConfig() {
		return new Faker();
		
	}
	
}
