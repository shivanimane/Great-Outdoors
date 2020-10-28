/**
 * 
 */
package com.greatoutdoor.addtocart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatoutdoor.addtocart.model.Order;
import com.greatoutdoor.addtocart.model.Orders;
import com.greatoutdoor.addtocart.service.OrderAndCartService;

/**
 * @author Shivani

 *
 */
@RestController
@RequestMapping("/order")
public class OrderProductCancelController {
	
	@Autowired
	OrderAndCartService orderAndCartService;
	
	@GetMapping("/getOrders/{orderId}")
	public Orders getAllOrdersWithOrderId(@PathVariable String orderId){
		
		if(orderId==null) {
			return null;
		}
		return orderAndCartService.getAllOrdersByOrderId(orderId);
	}
	
	@PostMapping("/cancelOrder/{orderId}")
	public String cancelOrder(@PathVariable String orderId ) {
		if(orderId==null) {
			return null;
		}
		orderAndCartService.cancelOrderByOrderId(orderId);
		return "successfully removed";
	}
	
	@GetMapping("/getOrders/{orderId}/{productId}")
	public Orders getAllOrdersWithOrderIdProductId(@PathVariable String orderId , @RequestParam String productId){
		if(orderId==null || productId==null) {
			return null;
		}
		return orderAndCartService.getAllOrdersByOrderIdProductId(orderId , productId);
	}
	
	@PostMapping("/cancelProduct/{orderId}/{productId}")
	public String cancelOrderProduct(@PathVariable String orderId , @PathVariable String productId ) {
		if(orderId==null || productId==null) {
			return null;
		}
		orderAndCartService.cancelProductByOrderIdProductId(orderId, productId);
		return "successfully removed";
	}
	
	@GetMapping("/getOrders/{userId}")
	public List<Order> getAllOrders(@RequestParam String userId){
		
		if(userId==null) {
			return null;
		}
		return orderAndCartService.getAllOrdersByUserId(userId);
	}
	

}
