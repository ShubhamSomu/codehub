package com.assignment.codehub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assignment.codehub.model.User;
import com.assignment.codehub.repository.UserRepository;
import com.assignment.codehub.security.model.CustomUserDetails;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<User> retrieveAllUsers() {
		return userRepository.findAll(Sort.by(Direction.ASC, "id"));
	}

	/** DELETE AFTER USE ***/
	public Iterable<User> retrieveAllUserstry() {
		return userRepository.findAllTry();
	}

	/** DELETE AFTER USE ***/

	public List<User> retrieveUserByName(String fullName) {
		return userRepository.findUserByName(fullName);
	}

	public Optional<User> retrieveUserByid(Long id) {
		return userRepository.findById(id);
	}

	public Optional<User> createAUser(User user) {
		Optional<User> createdUser = Optional.of(userRepository.save(user));
		return createdUser;
	}

	// used to put
	public Optional<User> createAUser(User user, Long userId) {
		Optional<User> existingUser = this.retrieveUserByid(userId);
		if (existingUser.isPresent()) {
			if (user.getFullName() != null && !user.getFullName().equals("")) // just setting fullName for now but will
				// do dynamic insert
				existingUser.get().setFullName(user.getFullName());
		}

		// Optional<User> createdUser = Optional.of(userRepository.save(user));
		Optional<User> updatedUser = Optional.of(userRepository.save(existingUser.get()));
		return updatedUser;
	}

	public Optional<Boolean> deleteUserById(Long userId) {
		Optional<User> existingUser = this.retrieveUserByid(userId);
		if (existingUser.isPresent()) {
			userRepository.delete(existingUser.get());
			return Optional.of(true);
		} else {
			return Optional.of(false);
		}
	}

	// spring security userdetails
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOpt = Optional.of(retrieveUserByName(username).get(0));
		userOpt.orElseThrow(() -> new UsernameNotFoundException("User name not found"));
		return userOpt.map(CustomUserDetails::new).get();
	}
}
