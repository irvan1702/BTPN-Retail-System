package com.btpn.retail.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.persistence.user.User;
import com.btpn.persistence.user.UserService;

@RestController
@RequestMapping(value="user")
public class UserController {
	
	@Autowired 
	UserService userDaoService;
	
	@RequestMapping(value = "authorize", method = RequestMethod.POST)
	@CrossOrigin
	public ResponseEntity<Boolean> authorizeLogin(@RequestBody User user) {
		User targetUser = userDaoService.findUserByUsername(user.getUserName());

		if (targetUser != null) {
			//try {
				//String sha1Pass = UserAccount.sha1(user.getPassword());
				if (targetUser.getPassword().equals(user.getPassword())) {
					return new ResponseEntity<>(true, HttpStatus.OK);
				}
			//} catch (NoSuchAlgorithmException err) {
				//err.printStackTrace();
				//return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
			//}
		}
		return new ResponseEntity<>(false, HttpStatus.OK);
	}
}
