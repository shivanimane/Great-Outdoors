package com.greatoutdoor;
/**
 * @author Deepali

 */
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.greatoutdoor.productmanagementsystem.model.Product;
import com.greatoutdoor.productmanagementsystem.service.ProductService;
import com.greatoutdoor.productmanagementsystem.service.ProductServiceImpl;


class ProductManagementSystemTest {

	/**@Test 
	void testaddProduct()
	{
		Product product=new Product("454", 1, "467","876","589", "743", 1, 4, "7123");
		ProductService productservice=mock(ProductServiceImpl.class);
		when(productservice.addProduct(product)).thenReturn(Boolean.TRUE);
		System.out.println(product.toString());
		boolean logp = productservice.addProduct(product);
		assertEquals(Boolean.TRUE, logp);
		
	}**/
	
	@Test
	void testeditProduct() {
		Product product=new Product("454", 1, "467","876","589", "743", 1, 4, "7123");
		ProductService productservice=mock(ProductServiceImpl.class);
		when(productservice.editProduct(product)).thenReturn(Boolean.TRUE);
		System.out.println(product.toString());
		boolean logo = productservice.editProduct(product);
		assertEquals(Boolean.TRUE, logo);
		
	}
	
	
	
	
	
	
	

}
