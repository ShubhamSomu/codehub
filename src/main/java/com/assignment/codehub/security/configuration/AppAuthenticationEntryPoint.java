package com.assignment.codehub.security.configuration;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
@Component
public class AppAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
	@Value(value = "${spring.application.name}")
	String applicationName;
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
		     AuthenticationException authException) throws IOException {
		response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");

		
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
	}
	@Override
	public void afterPropertiesSet() {
		setRealmName(applicationName);
	}
} 