package com.btpn.persistence.entity.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.btpn.persistence.entity.UserAccount;

@Repository
public interface UserAccountDAO extends PagingAndSortingRepository<UserAccount, Integer> {
	
	public UserAccount findByUsernameEquals(String username);
}
