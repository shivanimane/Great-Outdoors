/**
 * 
 */
package com.greatoutdoor.addressmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class AddressController {

	@Autowired
	AddressService addressService;
	private static final Logger Logger = LoggerFactory.getLogger(Address.class);

	@ApiOperation(value = "View all address", notes = "User can add address", response = String.class)
	@GetMapping("/viewALLAddress")
	List<Address> viewAllAddress() {
		return addressService.viewAllAddresss();
	}

	/*
	 * { "addressId":"a-101", "retailerId":"r-101", "buildingNo":"501",
	 * "city":"pune", "state":"Maharastra", "field":"dsgfb", "zip":"411057" }
	 */
	@ApiOperation(value = "Post address"

	)

	@PostMapping("/addAddress")
	ResponseEntity<String> addAddress(@RequestBody Address address) {

		if (addressService.addAddress(address)) {
			return ResponseEntity.ok("Address has been added");
		} else {
			throw new NullParameterException("Address Id or Retailer Id cannot be zero");
		}

	}

	@ApiOperation(value = "Update address"

	)
	@PutMapping("/updateAddress")
	String updateAddress(@RequestBody Address address) {

		if (addressService.updateAddress(address)) {
			return "successfully updated Address";

		} else {
			throw new AddressNotFound("Address not found");
		}

	}

	@ApiOperation(value = "Delete address"

	)
	@DeleteMapping("/deleteAddress")
	String deleteAddress(@RequestParam String addressId) throws AddressNotFound {

		if (addressService.deleteAddress(addressId)) {
			return "Address Deleted Successfully";
		} else {
			throw new AddressNotFound("Address not found");

		}

	}

	@GetMapping("/getAddressById")
	Optional<Address> getAddressById(@RequestParam String addressId) {
		if (addressService.getAddressById(addressId) == null) {
			throw new AddressNotFound("Address Not Found");
		} else {
			return addressService.getAddressById(addressId);
		}

	}

}
