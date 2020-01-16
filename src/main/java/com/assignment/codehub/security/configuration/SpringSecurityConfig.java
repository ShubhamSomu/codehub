package com.assignment.codehub.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.assignment.codehub.repository.UserRepositoryImpl;
import com.assignment.codehub.service.UserService;

@Configuration
@EnableWebSecurity(debug = true)
@EnableJpaRepositories(basePackageClasses = UserRepositoryImpl.class)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserService userDetailsService;
	
	@Value(value = "${spring.application.name}")
	String applicationName;
	/**
	 * by default made two users 
	 */
	/**
	 * 
	 */
	
	@Autowired
	AppAuthenticationEntryPoint appAuthenticationEntryPoint;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				if(rawPassword.toString().equals(encodedPassword))
				return true;
				else return false;
			}
			
			@Override
			public String encode(CharSequence rawPassword) {
				// TODO Auto-generated method stub
				return rawPassword.toString();
			}
		};
				
		
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("user").password(encoder.encode("password")).roles("USER") //
		 * NoOpPasswordEncoder removed from default in spring .and()
		 * .withUser("admin").password(encoder.encode("password")).roles("USER","ADMIN")
		 * ;
		 */
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		/*
		 * http.headers().frameOptions().disable(); http. httpBasic() .and()
		 * .authorizeRequests()
		 * 
		 * .antMatchers(HttpMethod.GET, "/user/**").hasAnyRole("USER","ADMIN")
		 * .antMatchers(HttpMethod.POST, "/user/**").hasRole("ADMIN")
		 * .antMatchers(HttpMethod.PUT, "/user/").hasRole("ADMIN")
		 * .antMatchers(HttpMethod.PATCH, "/user/").hasRole("ADMIN")
		 * .antMatchers(HttpMethod.DELETE, "/user/").hasRole("ADMIN")
		 * .antMatchers("/h2/**").permitAll() .anyRequest().fullyAuthenticated() .and()
		 * .csrf().disable() .formLogin().disable() .httpBasic().disable();
		 */
		
		
		
		/*
		 * http.anonymous().disable();
		 * http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
		 * STATELESS); http.headers().frameOptions().disable(); http.csrf().disable();
		 * http.authorizeRequests().antMatchers("/**").permitAll().and()
		 * .authorizeRequests().antMatchers("/h2").permitAll() .antMatchers("/user/**")
		 * .hasAnyRole("ADMIN","USER")
		 * 
		 * .anyRequest().permitAll()
		 * .and().formLogin().disable().httpBasic().realmName(applicationName)
		 * .authenticationEntryPoint(appAuthenticationEntryPoint);;
		 */
	    
	    http.csrf().disable().authorizeRequests().antMatchers("/h2/**").permitAll()
	    .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
	    .anyRequest().permitAll().and().formLogin().disable().httpBasic().realmName(applicationName)
	    .authenticationEntryPoint(appAuthenticationEntryPoint);
	    
	    http.headers().frameOptions().disable();
	    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
}
