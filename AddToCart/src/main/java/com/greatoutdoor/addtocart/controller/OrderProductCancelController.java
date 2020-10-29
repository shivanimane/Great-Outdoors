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

import com.greatoutdoor.addtocart.exception.NullParameterException;
import com.greatoutdoor.addtocart.exception.OrderNotFoundException;
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
	
	/**
	 *  localhost:8006/order/getOrders?orderId=ORD1113417
	 * @param orderId
	 * @return
	 */
	@GetMapping("/getOrders")
	public Orders getAllOrdersWithOrderId(@RequestParam String orderId){
		
		if(orderAndCartService.getAllOrdersByOrderId(orderId)==null) {
			throw new NullParameterException("Null request, please provide correct orderId!");
		} else {
			return orderAndCartService.getAllOrdersByOrderId(orderId);
		}
		
	}
	
	@PostMapping("/cancelOrder")
	public String cancelOrder(@RequestParam String orderId ) {
		if(orderId==null) {
			throw new NullParameterException("Null request, please provide orderId!");
		}
		if(orderAndCartService.cancelOrderByOrderId(orderId)==false) {
			throw new OrderNotFoundException("Order does not exist");
		}
		orderAndCartService.cancelOrderByOrderId(orderId);
		return "successfully removed";
	}
	
	@GetMapping("/getOrdersByOrderIdProductId")
	public Orders getAllOrdersWithOrderIdProductId(@RequestParam String orderId , @RequestParam String productId){
		if(orderId==null || productId==null) {
			throw new NullParameterException("Null request, please provide  orderId and productId!");
		}
		return orderAndCartService.getAllOrdersByOrderIdProductId(orderId , productId);
	}
	
	@PostMapping("/cancelProduct")
	public String cancelOrderProduct(@RequestParam String orderId , @RequestParam String productId ) {
		if(orderId==null || productId==null) {
			throw new NullParameterException("Null request, please provide  orderId and productId!");
		}
		if(orderAndCartService.cancelProductByOrderIdProductId(orderId, productId)==false) {
			throw new OrderNotFoundException("Order Not Found");
		}
		return "successfully removed";
	}
	
	@GetMapping("/getAllOrdersByUserId")
	public List<Order> getAllOrders(@RequestParam String userId){
		
		if(userId==null) {
			throw new NullParameterException("Null request, please provide  userID!");
		}
		if(orderAndCartService.getAllOrdersByUserId(userId)==null) {
			throw new NullParameterException("User Id is Incorrect");
		}
		return orderAndCartService.getAllOrdersByUserId(userId);
	}
	

}
