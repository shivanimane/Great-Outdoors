/**
 * 
 */
package com.greatoutdoor.addressmanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatoutdoor.addressmanagementsystem.exception.AddressException;
import com.greatoutdoor.addressmanagementsystem.model.Address;

public interface AddressService {

	List<Address> viewAllAddresss();
	boolean addAddress(Address address)throws AddressException;
	boolean updateAddress(Address address)throws AddressException;
	boolean deleteAddress(String addressId)throws AddressException;
	
}