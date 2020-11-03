package com.cg.sprint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.entity.User;

import com.cg.sprint.repository.UserRepository;

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
