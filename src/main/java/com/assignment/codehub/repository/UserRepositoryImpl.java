package com.assignment.codehub.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.assignment.codehub.model.User;

@Repository
public class UserRepositoryImpl /* implements UserRepository */ {
	/*
	 * 
	 * @PersistenceContext private EntityManager entityManager;
	 * 
	 * @Override public List<User> findAll() { CriteriaBuilder cb =
	 * entityManager.getCriteriaBuilder(); CriteriaQuery<User> findAll =
	 * cb.createQuery(User.class); Root<User> root = findAll.from(User.class);
	 * CriteriaQuery<User> query = findAll.select(root); TypedQuery<User>
	 * findAllQuery= entityManager.createQuery(query); return null; }
	 * 
	 * @Override public List<User> findAll(Sort sort) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public List<User> findAllById(Iterable<Long> ids) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public <S extends User> List<S> saveAll(Iterable<S> entities) { //
	 * TODO Auto-generated method stub return null; }
	 * 
	 * @Override public void flush() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public <S extends User> S saveAndFlush(S entity) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public void deleteInBatch(Iterable<User> entities) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void deleteAllInBatch() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public User getOne(Long id) { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public <S extends User> List<S> findAll(Example<S> example) { //
	 * TODO Auto-generated method stub return null; }
	 * 
	 * @Override public <S extends User> List<S> findAll(Example<S> example, Sort
	 * sort) { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public Page<User> findAll(Pageable pageable) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public <S extends User> S save(S entity) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public Optional<User> findById(Long id) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public boolean existsById(Long id) { // TODO Auto-generated method
	 * stub return false; }
	 * 
	 * @Override public long count() { // TODO Auto-generated method stub return 0;
	 * }
	 * 
	 * @Override public void deleteById(Long id) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * @Override public void delete(User entity) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * @Override public void deleteAll(Iterable<? extends User> entities) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void deleteAll() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public <S extends User> Optional<S> findOne(Example<S> example) {
	 * // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public <S extends User> Page<S> findAll(Example<S> example,
	 * Pageable pageable) { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public <S extends User> long count(Example<S> example) { // TODO
	 * Auto-generated method stub return 0; }
	 * 
	 * @Override public <S extends User> boolean exists(Example<S> example) { //
	 * TODO Auto-generated method stub return false; }
	 * 
	 * 
	 * 
	 */}
