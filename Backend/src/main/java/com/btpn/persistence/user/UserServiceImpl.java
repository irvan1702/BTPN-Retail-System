package com.btpn.persistence.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.btpn.persistence.item.Item;
import com.btpn.persistence.item.ItemDAO;
import com.btpn.persistence.item.ItemService;

@Service
@Repository
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userRepository;

	@Override
	public List<User> getAllUser() {
		List<User> listUser = new ArrayList<User>();
		userRepository.findAll().forEach(listUser::add);
		return listUser;
	}

	@Override
	public User findUserById(Integer userId) {
		return userRepository.findOne(userId);
	}

	@Override
	public void insertUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);

	}

	@Override
	public void deleteUser(Integer userId) {
		userRepository.delete(userId);

	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUserName(username);
	}

}
