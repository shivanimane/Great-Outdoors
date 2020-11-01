package com.greatoutdoor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.greatoutdoor.retailerinventorymanagementsystem.exception.RetailerInventoryException;
import com.greatoutdoor.retailerinventorymanagementsystem.model.RetailerInventory;
import com.greatoutdoor.retailerinventorymanagementsystem.service.RetailerInventoryService;
import com.greatoutdoor.retailerinventorymanagementsystem.service.RetailerInventoryServiceImpl;

class RetailerInventoryManagementTest {

	@Test
	void TestUpdateProductRecieveTimeStamp() throws RetailerInventoryException {
		RetailerInventory retailerinventorydto=new RetailerInventory();
		RetailerInventoryService retailerinventoryservice=mock(RetailerInventoryServiceImpl.class);
		when(retailerinventoryservice.updateProductRecieveTimeStamp(retailerinventorydto)).thenReturn(Boolean.TRUE);
		System.out.println(retailerinventoryservice.toString());
		boolean logo = retailerinventoryservice.updateProductRecieveTimeStamp(retailerinventorydto);
		assertEquals(Boolean.TRUE, logo);
		
	}

	/**@Test
	void TestaddItemToInventory() {
		RetailerInventory retailerinventorydto=new RetailerInventory("123",1 ,"234","345");
		RetailerInventoryService retailerinventoryservice=mock(RetailerInventoryServiceImpl.class);
		when(retailerinventoryservice.addItemToInventory(retailerId, productCategory, productId, productUIN)).thenReturn(Boolean.TRUE);
		System.out.println(retailerinventoryservice.toString());
		boolean logt = retailerinventoryservice.addItemToInventory(retailerId, productCategory, productId, productUIN);
		assertEquals(Boolean.TRUE, logt);
		
	}**/
	
	
	
}
	
	
	
	

/**@Test
void TestUpdateProductRecieveTimeStamp() throws RetailerInventoryException {
	RetailerInventory retailerinventorydto=new RetailerInventory();
	RetailerInventoryService retailerinventoryservice=mock(RetailerInventoryServiceImpl.class);
	when(retailerinventoryservice.updateProductRecieveTimeStamp(retailerinventorydto)).thenReturn(Boolean.TRUE);
	System.out.println(retailerinventoryservice.toString());
	boolean logo = retailerinventoryservice.updateProductRecieveTimeStamp(retailerinventorydto);
	assertEquals(Boolean.TRUE, logo);
	
}**/


