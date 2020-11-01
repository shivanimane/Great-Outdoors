/**
 * 
 */
package com.greatoutdoor.addressmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.greatoutdoor.addressmanagementsystem.exception.AddressNotFound;
import com.greatoutdoor.addressmanagementsystem.model.Address;

public interface AddressService {

	List<Address> viewAllAddresss();
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	boolean deleteAddress(Integer addressId);
	Optional<Address> getAddressById(Integer addressId);

	
}