package com.assignment.codehub.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.codehub.model.User;
import com.assignment.codehub.service.UserService;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/user")
// add swagger
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	Validator validator;

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/")
	public Iterable<User> fetchAllUsers(@AuthenticationPrincipal User user) {
		System.out.println(user.getFullName());
		return userService.retrieveAllUsers();
	}

	@GetMapping(value = "/try")
	public Iterable<User> fetchAllUserstry() {
		return userService.retrieveAllUserstry();
	}

	@GetMapping(value = "/name/{name}")
	public ResponseEntity<?> fetchUserByName(@Valid @PathVariable("name") String fullName) {
		List<User> userList = userService.retrieveUserByName(fullName);
		if (userList.size() == 0)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.status(HttpStatus.OK).body(userList);
	}

	@GetMapping(value = "/{id}")
	public User fetchUserByid(@Valid @PathVariable("id") Long userId) {
		Optional<User> user = userService.retrieveUserByid(userId);
		return user.isEmpty() ? null : user.get();
	}

	// @PostMapping(value="/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveUser(/* @Valid @PathVariable("id") Long userId, */@Valid @RequestBody User user)
			throws URISyntaxException {
		/*
		 * user.setId(userId); Set<> if(fetchUserByid(userId)!=null) { return
		 * ResponseEntity.status(HttpStatus.CONFLICT).build(); }
		 */
			Long userId = user.getId();
		Optional<User> createAUser = userService.createAUser(user);
		if (createAUser.isPresent()) {
			return ResponseEntity.created(new URI("/user/" + userId)).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		// todo add hateoas for created user, use elseThrowError
		// for now returning status
		// send custom response body
		// use snake case for json
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateUser(@Valid @PathVariable("id") Long userId, @Valid @RequestBody User user) {
		Optional<User> updatedUser = userService.createAUser(user, userId);
		if (updatedUser.isPresent())
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<?> patchUser(@Valid @PathVariable("id") Long userId, @Valid @RequestBody User user) {
		Optional<User> updatedUser = userService.createAUser(user, userId);
		if (updatedUser.isPresent())
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteUserById(@Valid @PathVariable("id") Long userId) {
		Optional<Boolean> deleteUserOpt = userService.deleteUserById(userId);

		if (!deleteUserOpt.isEmpty()) {
			if (deleteUserOpt.get() == true) {
				return ResponseEntity.status(HttpStatus.OK).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
