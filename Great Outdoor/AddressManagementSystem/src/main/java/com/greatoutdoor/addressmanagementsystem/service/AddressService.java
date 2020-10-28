/**
 * 
 */
package com.greatoutdoor.addressmanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatoutdoor.addressmanagementsystem.model.Address;

public interface AddressService {

	List<Address> viewAllAddresss();
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	boolean deleteAddress(String addressId);
	
}