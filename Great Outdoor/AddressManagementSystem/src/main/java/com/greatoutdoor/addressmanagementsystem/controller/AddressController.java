/**
 * 
 */
package com.greatoutdoor.addressmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatoutdoor.addressmanagementsystem.model.Address;
import com.greatoutdoor.addressmanagementsystem.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/address")
public class AddressController {	
	
	@Autowired
	AddressService addressService;
	
	@GetMapping("/viewALLAddress")
	List<Address>viewAllAddress(){
		return addressService.viewAllAddresss();
	}

	/*
	 * {
	"addressId":"a-101",
	 "retailerId":"r-101",
	 "buildingNo":"501",
	 "city":"pune",
	 "state":"Maharastra",
	 "field":"dsgfb",
	"zip":"411057"    
}
	 */
	@PostMapping("/addAddress")
	String addAddress(@RequestBody Address address) {
		String status="Address added";
		
		if(addressService.addAddress(address)) {
		return status;
		}	
		return "fail to add Address";
	}
	
	@PostMapping("/updateAddress")
	String updateAddress(@RequestBody Address address) {
		String status="Address Updated";
		
		if(addressService.updateAddress(address)) {
			return status;
		}
		return "Failed to update Address";
	}
	
	
	@PostMapping("/deleteAddress/{addressId}")
	String deleteAddress(@PathVariable String addressId) {
		if(addressService.deleteAddress(addressId)) {
			return"Address Deleted Successfully";
		}
		return "error";
	}
}
