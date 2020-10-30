/**
 * 
 */
package com.greatoutdoor.addressmanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatoutdoor.addressmanagementsystem.exception.AddressNotFound;
import com.greatoutdoor.addressmanagementsystem.model.Address;

public interface AddressService {

	List<Address> viewAllAddresss();
	boolean addAddress(Address address)throws AddressNotFound;
	boolean updateAddress(Address address)throws AddressNotFound;
	boolean deleteAddress(String addressId)throws AddressNotFound;
	
}