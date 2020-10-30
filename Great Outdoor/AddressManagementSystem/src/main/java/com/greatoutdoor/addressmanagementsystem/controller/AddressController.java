/**
 * 
 */
package com.greatoutdoor.addressmanagementsystem.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatoutdoor.addressmanagementsystem.exception.AddressNotFound;
import com.greatoutdoor.addressmanagementsystem.exception.NullParameterException;
import com.greatoutdoor.addressmanagementsystem.model.Address;
import com.greatoutdoor.addressmanagementsystem.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/address")
public class AddressController {	
	
	@Autowired
	AddressService addressService;
	private static final Logger Logger= LoggerFactory.getLogger(Address.class);
	
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
	String addAddress(@RequestBody Address address) throws AddressNotFound, NullParameterException {
		if (address.getAddressId() == null)
		{
			throw new NullParameterException("Please provide Address Id");
		}
		String status="Address added";
		
		
			if(addressService.addAddress(address)) {
			return status;
			
		} 
		return "fail to add Address";
	}
	
	@PostMapping("/updateAddress")
	String updateAddress(@RequestBody Address address) throws AddressNotFound {
		String status="Address Updated";
		
		
			if(addressService.updateAddress(address)) {
				return status;
			
		} 
		return "Failed to update Address";
	}
	
	
	@PostMapping("/deleteAddress/{addressId}")
	String deleteAddress(@PathVariable String addressId) throws AddressNotFound {
		
			if(addressService.deleteAddress(addressId)) {
				return"Address Deleted Successfully";
			
		} 
		return "error";
	}
}
