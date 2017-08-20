package com.btpn.retail.controller.user;

import com.btpn.persistence.user.User;
import com.btpn.persistence.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;


@RestController
public class UserController {
	
	@Autowired 
	UserService userDaoService;
	
	@RequestMapping(value = "authorize", method = RequestMethod.POST)
	@CrossOrigin
	public ResponseEntity<Boolean> authorizeLogin(@RequestBody User user) throws NoSuchAlgorithmException {
		User targetUser = userDaoService.findUserByUsername(user.getUserName());
		if (targetUser != null) {
			if (targetUser.getPassword().equals(user.getPassword())) {
				return new ResponseEntity<>(true, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(false, HttpStatus.OK);
	}

    @RequestMapping(method = RequestMethod.GET, value = "userByUsername")
    @CrossOrigin
    public @ResponseBody User findUserByUsername(String username) {

        return userDaoService.findUserByUsername(username);
    }

	@RequestMapping(method = RequestMethod.GET, value = "userList")
	@CrossOrigin
	public @ResponseBody List<User> getAllUserList() {

		return userDaoService.getAllUser();
	}

	@RequestMapping(method = RequestMethod.GET, value = "userById/{userId}")
	@CrossOrigin
	public @ResponseBody User getUserById(@PathVariable Integer userId) {

		return userDaoService.findUserById(userId);
	}

	@RequestMapping(value = "userAdd", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public void addUser(@RequestBody User user) {

		userDaoService.insertUser(user);
	}

	@RequestMapping(value = "userModify", method = RequestMethod.PUT)
	@CrossOrigin
	@ResponseBody
	public void modifyUser(@RequestBody User user) {
		userDaoService.updateUser(user);

	}

	@RequestMapping(value = "userDelete", method = RequestMethod.DELETE)
	@CrossOrigin
	public void deleteUser(@RequestParam(value="userId",defaultValue=" ")Integer userId) {
		userDaoService.deleteUser(userId);
	}
}
