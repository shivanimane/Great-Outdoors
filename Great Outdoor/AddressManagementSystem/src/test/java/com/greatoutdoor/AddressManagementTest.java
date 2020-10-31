package com.greatoutdoor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.greatoutdoor.addressmanagementsystem.model.Address;
import com.greatoutdoor.addressmanagementsystem.service.AddressService;
import com.greatoutdoor.addressmanagementsystem.service.AddressServiceImpl;


class AddressManagementTest {

	@Test
	void testupdateAddress() {
		
		Address address=new Address("4597", "a123", "678", "pune", "maharashtra", "56t5" ,"345322");
		AddressService addressservice=mock(AddressServiceImpl.class);
		when(addressservice.updateAddress(address)).thenReturn(Boolean.TRUE);
		System.out.println(address.toString());
		boolean logp = addressservice.updateAddress(address);
		assertEquals(Boolean.TRUE, logp);
		
		
	}
	  @Test
	 void testaddAddress(){
		  Address address=new Address("4597", "a123", "678", "pune", "maharashtra", "56t5" ,"345322");
		  AddressService addressservice=mock(AddressServiceImpl.class);
		  when(addressservice.addAddress(address)).thenReturn(Boolean.TRUE);
		  System.out.println(address.toString());
			boolean loge = addressservice.addAddress(address);
			assertEquals(Boolean.TRUE, loge);
	  }
			
	/* @Test
	 void testdeleteAddress() {
		 Address address=new Address("4597", "a123", "678", "pune", "maharashtra", "56t5" ,"345322");
		 AddressService addressservice=mock(AddressServiceImpl.class);
		  when(addressservice.deleteAddress(addressId)).thenReturn(Boolean.TRUE);
		  System.out.println(address.toString());
			boolean loge = addressservice.deleteAddress(addressId);
			assertEquals(Boolean.TRUE, loge);
		 
		 
	 }*/
		  
		  
		  
		  
	  }
	
	


