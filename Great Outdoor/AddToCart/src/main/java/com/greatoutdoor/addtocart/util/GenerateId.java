/**
 * 
 */
package com.greatoutdoor.addtocart.util;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.greatoutdoor.addtocart.service.OrderAndCartService;

/**
 * @author Shivani

 *
 */
@Component
public class GenerateId {
	
	@Autowired
	OrderAndCartService service;
	
	public String generateOrderId(String userId) {
		String orderId = "";
		Random rand = new Random();
		int selected = rand.nextInt(1000);
		orderId = "ORD"+service.getOrderTableSize()+userId+selected;
		return orderId;
	}
	
	public String generateProductUIN() {
		Random rand = new Random();
		int selected = rand.nextInt(1000);
		return "UIN"+selected+service.getOrderProductMapTableSize();
	}

}
