package com.greatoutdoor.loginmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatoutdoor.loginmicroservice.exception.NullParameterException;
import com.greatoutdoor.loginmicroservice.model.User;
import com.greatoutdoor.loginmicroservice.service.AdminService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	 AdminService adminService;
	
	@PostMapping("/addProductMaster")
	public User addProductMaster(@RequestBody User user) {

		
			if(user.getUsername().isEmpty() || user.getPassword().trim().length()==0)
			{
				throw new NullParameterException("please provide username and password");
			}
			else {
			     adminService.addProductMaster(user);
				return user;
			}
	}
	
	@PostMapping("/addRetailer")
	public User addRetailer(@RequestBody User user) {

		
			if(user.getUsername().isEmpty() || user.getPassword().trim().length()==0)
			{
				throw new NullParameterException("please provide username and password");
			}
			else {
				adminService.addRetailer(user);
				return user;
			}
	}
	
	
	

	@GetMapping("/viewProductMaster")
	public List<User> viewProductMaster() {
		String role="product master";
		return adminService.fetchUserByRole(role);
		
	}
	
	
	@GetMapping("/viewRetailers")
	public List<User> viewRetailers() {
		String role="retailer";
		return adminService.fetchUserByRole(role);
		
	}

}
