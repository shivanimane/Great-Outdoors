/**
 * 
 */
package com.greatoutdoor.cancelmanagementsystem.service;

/**
 * @author Shivani

 *
 */
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

}
