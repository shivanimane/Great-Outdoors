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
import com.greatoutdoor.addtocart.exception.CrudException;
import com.greatoutdoor.addtocart.exception.NullParameterException;
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
			throw new NullParameterException("Null request, please provide cart details!");
		}
		String status = "Item added Succefully";
		orderAndCartService.addItemToCart(cart);
		return status;
	}
	
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestParam String userId, @RequestParam String addressId , @RequestParam double totalCost) {
		
		if(userId==null || addressId==null) {
			throw new NullParameterException("Null request, please provide userId and addressId!");
		}
		
		String status = "Order placed successfully";
		Order order = new Order();
		order.setAddressId(addressId);
		order.setUserId(userId);
		order.setTotalcost(totalCost);
		if(orderAndCartService.registerOrder(order)==false) {
			return "Cart Not Found";
		}
			return status;
		
	}
	
//	@PostMapping("/removeFromCartByUserId")
//	public String removeItemFromCart(@RequestParam String userId){
//		if(userId==null) { 
//			throw new NullParameterException("Null request, please provide correct cart details to remove item from cart!");
//		}
//		
//		String status = "Item removed successfully!";		
//		orderAndCartService.removeItemFromCartByUserId(userId);
//		return status;
//		
//	}
	
	@DeleteMapping("/removeProductByUserIdProductId/{userId}/{productId}")
	public String removeProductByUserIdProductId(@PathVariable String userId , @PathVariable String productId){
		 
		
		if(userId==null || productId==null ) { 
			throw new NullParameterException("Null request, please provide user Id and product Id to remove iteam from cart!");
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
			throw new CrudException("fail to change the quantity");
		}
	}
	
	
	
	
}
