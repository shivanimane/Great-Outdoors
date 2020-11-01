package com.greatoutdoor;
/**
 * @author Deepali
 */
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.greatoutdoor.cancelmanagementsystem.model.Orders;
import com.greatoutdoor.cancelmanagementsystem.service.CancelService;
import com.greatoutdoor.cancelmanagementsystem.service.CancelServiceImpl;


class CancelManagementTest {
	
	/**@Test
	void testcancelOrder() {
		
		Orders orders=new Orders("567","789");
		CancelService cancelservice=mock(CancelServiceImpl.class);
		when(cancelservice.cancelOrder(orderId, userId)).thenReturn(Boolean.TRUE);
		System.out.println(orders.toString());
		boolean logo = cancelservice.cancelOrder(orderId, userId);
		assertEquals(Boolean.TRUE, logo);
		
	}**/

	
}


/**@Test
void testeditProduct() {
	Product product=new Product("454", 1, "467","876","589", "743", 1, 4, "7123");
	ProductService productservice=mock(ProductServiceImpl.class);
	when(productservice.editProduct(product)).thenReturn(Boolean.TRUE);
	System.out.println(product.toString());
	boolean logo = productservice.editProduct(product);
	assertEquals(Boolean.TRUE, logo);
	
}**/