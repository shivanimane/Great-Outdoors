package com.greatoutdoor.loginmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.greatoutdoor.loginmicroservice.exception.NullParameterException;
import com.greatoutdoor.loginmicroservice.model.User;
import com.greatoutdoor.loginmicroservice.service.UserService;


public class AdminController {

	@Autowired
	 UserService userService;
	@PostMapping("/register")
	public User addUser(@RequestBody User user) {

		
			if(user.getUsername().isEmpty() || user.getPassword().trim().length()==0)
			{
				throw new NullParameterException("please provide username and password");
			}
			else {
				userService.addUser(user);
				return user;
			}
	}

}
