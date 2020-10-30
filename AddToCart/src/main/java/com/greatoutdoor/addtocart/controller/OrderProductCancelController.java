/**
 * 
 */
package com.greatoutdoor.addtocart.controller;

import java.util.List;

import org.apache.log4j.Logger;
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

import io.swagger.annotations.ApiOperation;

/**
 * @author Shivani

 *
 */
@RestController
@RequestMapping("/order")
public class OrderProductCancelController {
	
	private static final Logger logger = Logger.getLogger(OrderProductCancelController.class);
	
	@Autowired
	OrderAndCartService orderAndCartService;
	
	/**
	 *  localhost:8006/order/getOrders?orderId=ORD1113417
	 * @param orderId
	 * @return
	 */
	@ApiOperation(
			value = "Get All Products using OrderId",
			notes = "Get all products for an order with this API",
			response = Orders.class
			)
	@GetMapping("/getOrders")
	public Orders getAllOrdersWithOrderId(@RequestParam String orderId){
		
		if(orderAndCartService.getAllOrdersByOrderId(orderId)==null) {
			throw new NullParameterException("Null request, please provide correct orderId!");
		} else {
			return orderAndCartService.getAllOrdersByOrderId(orderId);
		}
		
	}
	
	@ApiOperation(
			value = "Cancel an order using orderID",
			response = String.class
			)
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
	
	@ApiOperation(
			value = "Get Orders by orderId and productId",
			response = String.class
			)
	@GetMapping("/getOrdersByOrderIdProductId")
	public Orders getAllOrdersWithOrderIdProductId(@RequestParam String orderId , @RequestParam String productId){
		if(orderId==null || productId==null) {
			throw new NullParameterException("Null request, please provide  orderId and productId!");
		}
		if(orderAndCartService.getAllOrdersByOrderIdProductId(orderId , productId)==null) {
			throw new OrderNotFoundException("Order Not Found");
		}
		return orderAndCartService.getAllOrdersByOrderIdProductId(orderId , productId);
	}
	
	@ApiOperation(
			value = "Cancel a product using orderId and productId",
			response = String.class
			)
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
	
	@ApiOperation(
			value = "Get All Orders by UserId",
			response = String.class
			)
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
