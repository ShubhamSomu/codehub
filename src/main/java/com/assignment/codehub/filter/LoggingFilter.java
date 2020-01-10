package com.assignment.codehub.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
@Component
@Order(1)
public class LoggingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.err.println(""+request.getRemoteAddr()+" "+request.getRemoteHost()
		+" "+request.getRemotePort());
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig filter) throws ServletException {
		
	}
	
	@Override
	public void destroy() {
		
	}
	
	private void printAll(String s) {
		System.out.print(s);
	}
}
