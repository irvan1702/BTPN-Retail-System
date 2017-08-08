package com.btpn.persistence.entity.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.btpn.persistence.entity.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
	
	public User findByUserId(Integer userId);
}
