package com.btpn.persistence.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.btpn.persistence.item.Item;

@Component
public interface UserService {

	List<User> getAllUser();

	User findUserById(Integer userId);
	
	User findUserByUsername(String username);

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(Integer userId);

}
