package com.greatoutdoor.loginmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatoutdoor.loginmicroservice.model.SignUpBean;
import com.greatoutdoor.loginmicroservice.model.User;

import com.greatoutdoor.loginmicroservice.dao.UserDao;


@Service
public class UserService {

	@Autowired
	private UserDao userRepository;
	
	public User fetchUserByUsername(String username) {
		return userRepository.findByUsername(username);
		
	}
	
	public User fetchUserByUsernameandPassword(String username,String password) {
		return userRepository.findByUsernameAndPassword(username, password);
		
	}

	public User addUser(User user) {
		//User user=new User(signUp.getUsername(),signUp.getPassword(), signUp.getRole());
		 this.userRepository.save(user);
		return user;
	}

}
