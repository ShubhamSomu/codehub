package com.assignment.codehub.filter;

import java.io.IOException;


import javax.servlet.*;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class CustomFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.err.println("asdadasd");
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig config) {
		config.getFilterName();
		config.getInitParameterNames().asIterator().forEachRemaining(System.out::println);
	}
	
	@Bean
	public FilterRegistrationBean<CustomFilter> filter(){
		FilterRegistrationBean<CustomFilter> filterBean = 
				new FilterRegistrationBean<CustomFilter>();
		filterBean.setFilter(new CustomFilter());
		filterBean.addUrlPatterns("/user/try/*");
		return filterBean;
	}
}
