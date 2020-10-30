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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatoutdoor.addtocart.dao.CartDao;
import com.greatoutdoor.addtocart.exception.CartNotFoundException;
import com.greatoutdoor.addtocart.exception.CrudException;
import com.greatoutdoor.addtocart.exception.NullParameterException;
import com.greatoutdoor.addtocart.exception.OrderNotFoundException;
import com.greatoutdoor.addtocart.exception.ProductNotFoundException;
import com.greatoutdoor.addtocart.model.Cart;
import com.greatoutdoor.addtocart.model.CartBean;
import com.greatoutdoor.addtocart.model.Order;
import com.greatoutdoor.addtocart.model.Product;
import com.greatoutdoor.addtocart.service.OrderAndCartService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/cart")
public class OrderController {
	
	private static final Logger logger = Logger.getLogger(OrderController.class);
	
	@Autowired
	OrderAndCartService orderAndCartService;
	
	@ApiOperation(
			value = "Add products to cart",
			notes = "Retailer can add product to cart with this API",
			response = String.class
			)
	@PostMapping("/addToCart")
	public String addItemToCart(@RequestBody CartBean cart) {
		if(cart==null || cart.getProductId().trim().length() == 0 || cart.getQuantity()==0 ) {
			logger.error("Null request, cart details not provided at /addItemToCart");
			throw new NullParameterException("Null request, please provide cart details!");
		}
		String status = "Item added Succefully";
		orderAndCartService.addItemToCart(cart);
		return status;
	}
	
	@ApiOperation(
			value = "Place an order",
			notes = "Retailer can place an order with this API",
			response = String.class
			)
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestParam String userId, @RequestParam String addressId , @RequestParam double totalCost) {
		
		if(userId==null || addressId==null) {
			logger.error("Null request, please provide userId and addressId/ placeOrder");
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

	@ApiOperation(
			value = "Remove product from cart by UserId and ProductId",
			notes = "Retailer can remove product from cart with this API",
			response = String.class
			)
	@DeleteMapping("/removeProductByUserIdProductId/{userId}/{productId}")
	public String removeProductByUserIdProductId(@PathVariable String userId , @PathVariable String productId){
		 
		
		if(userId==null || productId==null ) { 
			throw new NullParameterException("Null request, please provide user Id and product Id to remove iteam from cart!");
		}
		
		String status = "Item removed successfully!";		
		if(orderAndCartService.removeProductByUserIdProductId(userId, productId)) {
			return status;
		} else {
			throw new CartNotFoundException("Product not found in the Cart");
		}
		
	}
	
	@ApiOperation(
			value = "View all products",
			notes = "Retailer can view all products in the cart with this API",
			response = List.class
			)
	@GetMapping("/getAllProductsByUserId")
	List<Product> getAllProductsByUserId(@RequestParam String userId){
		if(userId==null) {
			throw new NullParameterException("Null Request, Please give valid userId");
		} else if(orderAndCartService.getAllProductsByUserId(userId)==null) {
			throw new ProductNotFoundException("Product Not Found in the Cart");
		}
		return orderAndCartService.getAllProductsByUserId(userId);
	}
	
	
	
	@ApiOperation(
			value = "View order products",
			notes = "Retailer can view all products in a perticular order with orderId with this API",
			response = List.class
			)
	@GetMapping("/getAllProductsByOrderId")
	List<Product> viewOrderProducts(@RequestParam String orderId){
		if(orderAndCartService.getAllProductsByOrderId(orderId)==null) {
			throw new OrderNotFoundException("Order not found");
		} else {
			return orderAndCartService.getAllProductsByOrderId(orderId);
		}
		
	}
	
	@ApiOperation(
			value = "Update quantity",
			notes = "Retailer can ppdate quantity of items in the cart with this API",
			response = String.class
			)
	@PostMapping("/updateQuantity")
	String updateQuantity(@RequestBody Cart cartItem) {
		if(cartItem.getUserId()==null || cartItem.getProductId()==null)
			throw new NullParameterException("UserId por ProductId cannot be null");
		if(orderAndCartService.updateItemQuantity(cartItem)) {
			return "successfully changed";
		}
		else {
			throw new CrudException("fail to change the quantity");
		}
	}
	
	
	
	
}
