package com.cg.sprint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.entity.User;
import com.cg.sprint.service.UserService;

@RestController
@CrossOrigin(origins="/localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		
		String tmpUsername=user.getUsername();
		String tmpPassword = user.getPassword();
		User userObj=null;
		if(tmpUsername!=null && tmpPassword!=null ) {
			userObj=userService.fetchUserByUsernameandPassword(tmpUsername, tmpPassword);
		}
		if(userObj==null)
		{
			throw new Exception("bad credentials");
		}
		
		return userObj;
	}
	
}

