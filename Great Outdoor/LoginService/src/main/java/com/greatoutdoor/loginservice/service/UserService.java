package com.greatoutdoor.loginservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatoutdoor.loginservice.dao.UserRepository;
import com.greatoutdoor.loginservice.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User fetchUserByUsername(String username) {
		return userRepository.findByUsername(username);
		
	}
	
	public User fetchUserByUsernameandPassword(String username,String password) {
		return userRepository.findByUsernameAndPassword(username, password);
		
	}

	public User addUser(User user) {
		return this.userRepository.save(user);
	}

}
