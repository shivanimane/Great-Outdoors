package com.greatoutdoor.loginmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatoutdoor.loginmicroservice.exception.NullParameterException;
import com.greatoutdoor.loginmicroservice.model.User;
import com.greatoutdoor.loginmicroservice.service.UserService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginController {
	
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
	
	@PostMapping("/loginUser")
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
