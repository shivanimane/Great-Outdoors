/**
 * 
 */
package com.greatoutdoor.cancelmanagementsystem.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatoutdoor.cancelmanagementsystem.exception.NullParameterException;
import com.greatoutdoor.cancelmanagementsystem.model.ProductResponse;
import com.greatoutdoor.cancelmanagementsystem.service.CancelService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Shivani

 *
 */
@RestController
@RequestMapping("/cancel")
public class CancelController {
	
	private static final Logger logger = Logger.getLogger(CancelController.class);
	
	@Autowired
	private CancelService cancelService;
	
	@ApiOperation(
			value = "Cancel Order",
			notes = "User can cancel an order that is not yet dispatched using this API",
			response = String.class
			)
	@PostMapping("/cancelOrder")
	public String cancelOrder(@RequestParam String  orderId, @RequestParam String userId) {
		if(orderId==null||userId==null) {
			throw new NullParameterException("Null request, please provide correct orderId or userId");
		}
		String status="Order cancelled succesufully";
		cancelService.cancelOrder(orderId, userId);
		return status;
	}
	
	@ApiOperation(
			value = "Cancel Product",
			notes = "User can cancel a product that is not yet dispatched using this API",
			response = String.class
			)
	@PostMapping("/cancelProduct")
	String cancelProduct(@RequestParam String orderId,  @RequestParam String userId, @RequestParam String productId,@RequestParam int quantity) throws Exception
	{
		if(orderId==null ||userId==null||productId==null) 
		{
			throw new NullParameterException("Null request, please provide userId or orderId or productId");
		}
		String status="Product cancelled succesfully";
		cancelService.cancelProduct(orderId, userId, productId, quantity);
	    return status;
		
	}


	@GetMapping("/getCancelProducts")
	List<ProductResponse> getResponseProducts(){
		return cancelService.getresponseProducts();
	}
   

}
