package com.assignment.codehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.codehub.model.Role;
import com.assignment.codehub.repository.RolesRepository;

@Service
public class RolesService {

	@Autowired
	RolesRepository rolesRepository;
	
	public void createRole(Role role) {
		rolesRepository.save(role);
	}
}
