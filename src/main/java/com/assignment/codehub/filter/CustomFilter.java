package com.assignment.codehub.filter;

import java.io.IOException;

import javax.servlet.*;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
public class CustomFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig config) {
		config.getFilterName();
		config.getInitParameterNames().asIterator().forEachRemaining(System.out::println);
	}
	
	
	public FilterRegistrationBean<CustomFilter> filter(){
		FilterRegistrationBean<CustomFilter> filterBean = 
				new FilterRegistrationBean<CustomFilter>();
		filterBean.setFilter(new CustomFilter());
		filterBean.addUrlPatterns("/execute/*");
		return filterBean;
	}
}
