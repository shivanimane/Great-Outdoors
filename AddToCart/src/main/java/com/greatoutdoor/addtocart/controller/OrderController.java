/**
 * 
 */
package com.greatoutdoor.addtocart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestParam String userId, @RequestParam String addressId , @RequestParam double totalCost) {
		
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
			return "cart or product does not exist";
		}
		
		String status = "Item removed successfully!";		
		orderAndCartService.removeItemFromCart(cart);
		return status;
		
	}
	
	@DeleteMapping("/removeProductByUserIdProductId")
	public String removeProductByUserIdProductId(@RequestParam String userId , @RequestParam String productId){
		
		
		if(userId==null || userId==null ) { 
			return "cart or product does not exist";
		}
		
		String status = "Item removed successfully!";		
		orderAndCartService.removeProductByUserIdProductId(userId, productId);
		return status;
		
	}
	
	@GetMapping("/getAllProductsByUserId")
	List<Product> getAllProductsByUserId(@RequestParam String userId){
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
