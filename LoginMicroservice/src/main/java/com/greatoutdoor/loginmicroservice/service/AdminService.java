package com.greatoutdoor.loginmicroservice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.greatoutdoor.loginmicroservice.dao.UserDao;
import com.greatoutdoor.loginmicroservice.model.User;






@Service
public class AdminService {
	@Autowired
	private UserDao userRepository;
	
	private RestTemplate rest = new RestTemplate();
	
	public List<User> fetchUserByRole(String role) {
		return userRepository.findByRole(role);
		
	}
	

	
	public User addUser(User user) {
		//User user=new User(signUp.getUsername(),signUp.getPassword(), signUp.getRole());
		 this.userRepository.save(user);
		return user;
	}
	



}
