package com.assignment.codehub.security.model;

import org.springframework.stereotype.Service;

import com.assignment.codehub.model.User;
import com.google.common.base.Optional;

@Service
public interface UserAuthenticationService {

	Optional<String> login(String username, String password);
	
	Optional<User> findByToken(String token);
	
	void logout(User user);
}
