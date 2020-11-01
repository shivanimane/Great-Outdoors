/**
 * 
 */
package com.greatoutdoor.addressmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatoutdoor.addressmanagementsystem.dao.AddressDao;
import com.greatoutdoor.addressmanagementsystem.model.Address;
import com.greatoutdoor.addressmanagementsystem.exception.AddressNotFound;
import com.greatoutdoor.addressmanagementsystem.exception.CrudException;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressDao addressRepository;

	@Override
	public List<Address> viewAllAddresss() {
		// TODO Auto-generated method stub
		if (addressRepository.count() == 0) {
			throw new AddressNotFound("No Addresses found");
		} else {
			return (List<Address>) addressRepository.findAll();
		}

	}

	@Override
	public boolean deleteAddress(Integer addressId) {
		if (addressRepository.findById(addressId).isPresent()) {
			addressRepository.deleteById(addressId);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean addAddress(Address address) {

		addressRepository.save(address);
		return true;

	}

	@Override
	public boolean updateAddress(Address address) {
		if (addressRepository.findById(address.getAddressId()).isPresent()){
			addressRepository.save(address);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Optional<Address> getAddressById(Integer addressId) {
		if (addressRepository.findById(addressId).isPresent()) {
			return addressRepository.findById(addressId);
		} else {
			return null;
		}

	}

}