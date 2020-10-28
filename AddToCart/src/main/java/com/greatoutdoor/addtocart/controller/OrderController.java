/**
 * 
 */
package com.greatoutdoor.addtocart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatoutdoor.addtocart.dao.CartDao;
import com.greatoutdoor.addtocart.model.Cart;
import com.greatoutdoor.addtocart.model.CartBean;
import com.greatoutdoor.addtocart.model.Order;
import com.greatoutdoor.addtocart.model.Product;
import com.greatoutdoor.addtocart.service.OrderAndCartService;

/**
 * @author Shivani

 *
 */
@RestController
@RequestMapping("/cart")
public class OrderController {
	
	@Autowired
	OrderAndCartService orderAndCartService;
	
	@PostMapping("/addToCart")
	public String addItemToCart(@RequestBody CartBean cart) {
		if(cart==null || cart.getProductId().trim().length() == 0 || cart.getQuantity()==0 ) {
			return "Item already exists";
		}
		String status = "Item added Succefully";
		orderAndCartService.addItemToCart(cart);
		return status;
	}
	
	@PostMapping("/placeOrder/{userId}/{addressId}/{totalCost}")
	public String placeOrder(@PathVariable String userId, @PathVariable String addressId , @PathVariable double totalCost) {
		
		if(userId==null || addressId==null) {
			return "User or Address does not match";
		}
		
		String status = "Order placed successfully";
		Order order = new Order();
		order.setAddressId(addressId);
		order.setUserId(userId);
		order.setTotalcost(totalCost);
		orderAndCartService.registerOrder(order);
		return status;
	
	}
	
	@PostMapping("/removeFromCart")
	public String removeItemFromCart(@RequestBody CartBean cart){
		if(cart==null || cart.getProductId()==null || cart.getQuantity()==0 || cart.getUserId()==null) { 
			return "Does not Exist";
		}
		
		String status = "Item removed successfully!";		
		orderAndCartService.removeItemFromCart(cart);
		return status;
		
	}
	
	@DeleteMapping("/removeProductByUserIdProductId/{userId}/{productId}")
	public String removeProductByUserIdProductId(@PathVariable String userId , @PathVariable String productId){
		 
		
		if(userId==null || productId==null ) { 
			return "cart or product does not exist";
		}
		
		String status = "Item removed successfully!";		
		orderAndCartService.removeProductByUserIdProductId(userId, productId);
		return status;
		
	}
	
	@GetMapping("/getAllProductsByUserId/{userId}")
	List<Product> getAllProductsByUserId(@PathVariable String userId){
		return orderAndCartService.getAllProductsByUserId(userId);
	}
	
	
	
	
	@GetMapping("/getAllOrdersByOrderId")
	List<Product> viewOrderProducts(@RequestParam String orderId){
		return orderAndCartService.getAllProductsByOrderId(orderId);
	}
	
	@PostMapping("/updateQuantity")
	String updateQuantity(@RequestBody Cart cartItem) {
		if(orderAndCartService.updateItemQuantity(cartItem)) {
			return "successfully changed";
		}
		else {
			return "Failed to change quantity";
		}
	}
	
	
	
	
}
