/**
 * 
 */
package com.greatoutdoor.cancelmanagementsystem.service;

import java.util.List;

import com.greatoutdoor.cancelmanagementsystem.model.ProductResponse;

public interface CancelService {
	/**
	 * To Cancel an Order that is placed
	 * @param orderId
	 * @param userId
	 * @return
	 * @throws CrudException
	 */
	String cancelOrder(String orderId , String userId);
	
	/**
	 * Cancel a product of a particular Order
	 * @param orderId
	 * @param userId
	 * @param productId
	 * @param quantity
	 * @return
	 */
	String cancelProduct(String orderId, String userId, String productId, int quantity);
	
	/**
	 * Get All ResponseProducts as List
	 * @return
	 */
	List<ProductResponse> getresponseProducts();

}
