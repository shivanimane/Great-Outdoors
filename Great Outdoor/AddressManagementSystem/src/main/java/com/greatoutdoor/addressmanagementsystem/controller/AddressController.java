/**
@Deepali
 * 
 */
package com.greatoutdoor.addressmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/address")
@Validated // change
public class AddressController {

	@Autowired
	AddressService addressService;
	private static final Logger Logger = LoggerFactory.getLogger(Address.class);

	@ApiOperation(value = "View all address", notes = "Retailer can add address", response = String.class)
	@GetMapping("/viewAllAddress")
	List<Address> viewAllAddress() {
		return addressService.viewAllAddresss();
	}

	/*
	 * { "addressId": "2345",
	 *  "retailerId": "ABC Retailers", 
	 *  "buildingNo": "234",
	 * "city": "Mumbai",
	 *  "state": "Maharastra", 
	 *  "field": "Goregaon", 
	 *  "zip": "400063"
	 * }
	 */
	@ApiOperation(value = "Post address")
	@PostMapping("/addAddress")
	ResponseEntity<String> addAddress(@Valid @RequestBody Address address) {
		
		if (addressService.addAddress(address)) {
			return ResponseEntity.ok("Address has been added");
		} else {
			throw new NullParameterException("Retailer Id cannot be zero");
		}
		
		

	}

	@ApiOperation(value = "Update address")
	@PutMapping("/updateAddress")
	String updateAddress(@RequestBody Address address) {
		if(address.getAddressId()==null) {
			throw new NullParameterException("Address Id cannot be empty");
		}
		if (addressService.updateAddress(address)) {
			return "successfully updated Address";

		} else {
			throw new AddressNotFound("Please enter correct address Id");
		}

	}

	@ApiOperation(value = "Delete address")
	@DeleteMapping("/deleteAddress/{addressId}")
	String deleteAddress(@PathVariable Integer addressId) throws AddressNotFound {
		if(addressId==null) {
			throw new NullParameterException("Please provide AddressId");
		}
		if (addressService.deleteAddress(addressId)) {
			return "Address Deleted Successfully";
		} else {
			throw new AddressNotFound("Address not found");
		}

	}

	@GetMapping("/getAddressById/{addressId}")
	Optional<Address> getAddressById(@PathVariable Integer addressId) {
		if (addressId==null) {
			throw new NullParameterException("Please enter address Id");
		}
		if (addressService.getAddressById(addressId) == null) {
			throw new AddressNotFound("Address Not Found");
		} else {
			return addressService.getAddressById(addressId);
		}

	}

}
