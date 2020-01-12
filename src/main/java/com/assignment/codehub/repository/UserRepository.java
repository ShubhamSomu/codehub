package com.assignment.codehub.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assignment.codehub.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	@Query(value = "from User u where u.id = ?1")
	List<User> findAllById(Long id);
	
	@Query(value = "from User u where u.fullName like ?1")
	List<User> findUserByName(String fullName);
	
	@Query(value = "from User u")
	List<User> findAll(Sort sort);
	
	@Query(value = "select * from user where deleted=false",nativeQuery = true)
	List<User> findAllTry();

	/*
	 * Optional<User> findByUsername(String username); // just for spring
	 * userdetails service
	 */
	}