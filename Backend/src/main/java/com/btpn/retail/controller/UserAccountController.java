package com.btpn.retail.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.persistence.entity.UserAccount;
import com.btpn.persistence.entity.service.UserAccountDAO;

@RestController
@RequestMapping(path = "/account")
public class UserAccountController {

	@Autowired
	private UserAccountDAO userAccount;

	
	@GetMapping(path = "/list")
	public UserAccount listAccount(@RequestParam String username) {
		return userAccount.findByUsernameEquals(username);
//
//		if (targetUser != null) {
//			//try {
//				//String sha1Pass = UserAccount.sha1(user.getPassword());
//				if (targetUser.getPassword().equals(user.getPassword())) {
//					return new ResponseEntity<>(true, HttpStatus.OK);
//				}
//			//} catch (NoSuchAlgorithmException err) {
//				//err.printStackTrace();
//				//return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
//			//}
//		}
//		return new ResponseEntity<>(false, HttpStatus.OK);
	}
	
	@PostMapping(path = "/authorize")
	public ResponseEntity<Boolean> authorizeLogin(@RequestParam String username, @RequestParam String password) {
		UserAccount targetUser = userAccount.findByUsernameEquals(username);

		if (targetUser != null) {
			//try {
				//String sha1Pass = UserAccount.sha1(user.getPassword());
				if (targetUser.getPassword().equals(password)) {
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
