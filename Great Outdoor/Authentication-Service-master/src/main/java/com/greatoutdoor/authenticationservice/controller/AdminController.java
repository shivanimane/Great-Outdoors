package com.greatoutdoor.authenticationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatoutdoor.authenticationservice.entity.User;
import com.greatoutdoor.authenticationservice.exception.NullParameterException;
import com.greatoutdoor.authenticationservice.exception.UserNotFoundException;
import com.greatoutdoor.authenticationservice.service.AdminProductMasterService;
import com.greatoutdoor.authenticationservice.service.AdminRetailerService;

import io.swagger.annotations.ApiOperation;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/app/admin")
public class AdminController {

	
	@Autowired
	AdminProductMasterService productMasterService;
	@Autowired
	AdminRetailerService retailerService;
	
	
	@ApiOperation(
			value = "Delete product master by Id",
			notes = "Admin can remove a product master in this API",
			response = String.class
			)
	@DeleteMapping("/deleteProductMaster/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteProductMaster(@PathVariable int userId) {
		if(productMasterService.deleteProductMaster(userId)) {
			return "Product master deleted successfully";
		}
		throw new UserNotFoundException("Invalid product master ID!!");
	}
	
	
	@ApiOperation(
			value = "Add product master",
			notes = "Admin add a product master in this API",
			response = User.class
			)
	@PostMapping("/addProductMaster")
	@PreAuthorize("hasRole('ADMIN')")
	public String addProductMaster(@RequestBody User productMaster) {
		
		if(productMaster==null || productMaster.getUsername()==null)throw new NullParameterException("Please provide details of product master!");
		
		if(productMasterService.addProductMaster(productMaster)) {
			return "Product master added successfully";
		}
		return "fail to add Product master!!";
	}
	 
	
	@ApiOperation(
			value = "Add retailer by Id",
			notes = "Admin can add a retailer in this API",
			response = String.class
			)
	@PostMapping("/addRetailer")
	@PreAuthorize("hasRole('ADMIN')")
	public String addRetailer(@RequestBody User retailer) {
		if(retailerService.addRetailer(retailer)) {
			return "Retailer added successfully";
		}
		return "fail to add Retailer!!";
	}
	
	 
	
	
	@ApiOperation(
			value = "View all product masters",
			notes = "Admin view the list of product masters in this API",
			response = List.class
			)
	@GetMapping("/viewAllProductMasters")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> viewAllProductMasters() {
		return productMasterService.viewAllProductMasters();
		
	}
	 
	
	
	@ApiOperation(
			value = "Delete retailer by Id",
			notes = "Admin can remove a retailer in this API",
			response = String.class
			)
	@DeleteMapping("/deleteRetailer/userId")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteRetailer(@PathVariable int userId) {
		if(retailerService.deleteRetailer(userId)) {
			return "Retailer deleted successfully";
		}
		throw new UserNotFoundException("Invalid retailer ID!!");
	}
	
	 
	
	@ApiOperation(
			value = "View all retailers",
			notes = "Admin view the list of retailers in this API",
			response = List.class
			)
	@GetMapping("/viewAllRetailers")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> viewAllRetailers() {
		return retailerService.viewAllRetailers();
		
	}
	
	 
	
	
	
}
