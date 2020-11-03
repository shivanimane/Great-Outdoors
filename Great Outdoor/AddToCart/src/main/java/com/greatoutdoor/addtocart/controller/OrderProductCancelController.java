/**
 * 
 */
package com.greatoutdoor.addtocart.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
 * 
 */
@RestController
@RequestMapping("/order")
public class OrderProductCancelController {

	private static final Logger logger = Logger.getLogger(OrderProductCancelController.class);

	@Autowired
	OrderAndCartService orderAndCartService;

	/**
	 * localhost:8006/order/getOrders?orderId=ORD1113417
	 * 
	 * @param orderId
	 * @return
	 */
	@ApiOperation(value = "Get All Products using OrderId", notes = "Get all products for an order with this API", response = Orders.class)
	@GetMapping("/getOrders/{orderId}")
	public Orders getAllOrdersWithOrderId(@PathVariable String orderId) {
		if (orderId.isEmpty()) {
			throw new NullParameterException("Please enter orderId");
		} else if (orderAndCartService.getAllOrdersByOrderId(orderId) == null) {
			throw new OrderNotFoundException("Order not found");
		} else {
			return orderAndCartService.getAllOrdersByOrderId(orderId);
		}

	}

	@ApiOperation(value = "Cancel an order using orderID", response = String.class)
	@PostMapping("/cancelOrder/{orderId}")
	public String cancelOrder(@PathVariable String orderId) {
		if (orderId.isEmpty()) {
			throw new NullParameterException("please enter OrderId");
		}
		if (orderAndCartService.cancelOrderByOrderId(orderId)) {
		//	orderAndCartService.cancelOrderByOrderId(orderId);
			return "Order Cancelled";
		} else {
			throw new OrderNotFoundException("Order does not exist");
		}
		
	}

	@ApiOperation(value = "Get Orders by orderId and productId", response = String.class)
	@GetMapping("/getOrdersByOrderIdProductId/{orderId}/{productId}")
	public Orders getAllOrdersWithOrderIdProductId(@PathVariable String orderId, @PathVariable String productId) {
		if (orderId.isEmpty() || productId.isEmpty()) {
			throw new NullParameterException("Please enter orderId and productId!");
		}
		if (orderAndCartService.getAllOrdersByOrderIdProductId(orderId, productId) == null) {
			throw new OrderNotFoundException("Order Not Found");
		}
		return orderAndCartService.getAllOrdersByOrderIdProductId(orderId, productId);
	}

	@ApiOperation(value = "Cancel a product using orderId and productId", response = String.class)
	@PostMapping("/cancelProduct/{orderId}/{productId}")
	public String cancelOrderProduct(@PathVariable String orderId, @PathVariable String productId) {
		if (orderId.isEmpty() || productId.isEmpty()) {
			throw new NullParameterException("Please enter orderId and productId");
		} else if (orderAndCartService.cancelProductByOrderIdProductId(orderId, productId) == false) {
			throw new OrderNotFoundException("Order Not Found");
		} else {
			return "Product cancelled from your order";
		}
	}

	@ApiOperation(value = "Get All Orders by UserId", response = String.class)
	@GetMapping("/getAllOrdersByUserId/{userId}")
	public List<Order> getAllOrders(@PathVariable String userId) {

		if (userId.isEmpty()) {
			throw new NullParameterException("Please enter userID!");
		}
		if (orderAndCartService.getAllOrdersByUserId(userId) == null) {
			throw new NullParameterException("User Id is Incorrect");
		}
		return orderAndCartService.getAllOrdersByUserId(userId);
	}

}
