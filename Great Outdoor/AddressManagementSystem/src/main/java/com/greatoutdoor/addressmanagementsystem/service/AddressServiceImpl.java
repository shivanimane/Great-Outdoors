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

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressDao addressRepository;

	@Override
	public List<Address> viewAllAddresss() {
		// TODO Auto-generated method stub
		return (List<Address>) addressRepository.findAll();
	}

	@Override
	public boolean deleteAddress(String addressId) {
		if (addressRepository.findById(addressId).isEmpty()) {
			return false;
		} else {

			addressRepository.deleteById(addressId);
			return true;
		}

	}

	@Override
	public boolean addAddress(Address address) {
		if (address.getAddressId() == null || address.getRetailerId() == null) {
			return false;
		} else {
			addressRepository.save(address);
			return true;
		}

	}

	@Override
	public boolean updateAddress(Address address) {
		Optional<Address> find = addressRepository.findById(address.getAddressId());
		if (find.isPresent()) {
			addressRepository.save(address);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Optional<Address> getAddressById(String addressId) {
		if (addressRepository.findById(addressId).isPresent()) {
			return addressRepository.findById(addressId);
		} else {
			return null;
		}

	}

}