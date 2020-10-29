/**
 * 
 */
package com.greatoutdoor.addtocart.service;

import java.util.List;

import com.greatoutdoor.addtocart.model.Cart;
import com.greatoutdoor.addtocart.model.CartBean;
import com.greatoutdoor.addtocart.model.Order;
import com.greatoutdoor.addtocart.model.OrderProductMap;
import com.greatoutdoor.addtocart.model.Orders;
import com.greatoutdoor.addtocart.model.Product;

/**
 * @author Shivani

 *
 */
public interface OrderAndCartService {
	
	/**
	 * Add Item to Cart
	 * @param cartItem
	 * @return
	 */
	boolean addItemToCart(CartBean cartItem);
	
	/**
	 * Insert Order-Product map entity
	 * @param orderProductMapEntity
	 * @return
	 */
	boolean insertOrderProductMapEntity(OrderProductMap orderProductMapEntity);
	
	/**
	 * Delete Order-Product map entity
	 * @param orderProductMapEntity
	 * @return
	 */
	boolean deleteOrderProductMapEntity(OrderProductMap orderProductMapEntity);
	
	/**
	 * Remove Item from Cart
	 * @param cartItem
	 * @return
	 */
	boolean removeItemFromCartByUserId(String userId);
	
	/**
	 * Update Quantity of Existing Product
	 * @param cartItem
	 * @return
	 */
	boolean updateItemQuantity(Cart cartItem);
	
	/**
	 * Register a New Order
	 * @param order
	 * @return
	 */
	boolean registerOrder(Order order);
	
	/**
	 * Delete Order
	 * @param order
	 * @return
	 */
	boolean deleteOrder(Order order);
	
	/**
	 * Cancel an Order that is placed
	 * @param orderId
	 */
	boolean cancelOrderByOrderId(String orderId);
	
	/**
	 * Get All Orders as List by Order ID
	 * @param orderId
	 * @return
	 */
	Orders getAllOrdersByOrderId(String orderId);
	
	/**
	 * Get All Orders by OrderId, Product ID
	 * @param orderId
	 * @param productId
	 * @return
	 */
	Orders getAllOrdersByOrderIdProductId(String orderId, String productId);
	
	/**
	 * Cancel a Product by OrderId and Product Id
	 * @param orderId
	 * @param productId
	 */
	boolean cancelProductByOrderIdProductId(String orderId, String productId);
	
	long getOrderTableSize();
	
	long getOrderProductMapTableSize();
	
	/**
	 * Retailer can get All Products in the cart
	 * @param userId
	 * @return
	 */
	List<Product> getAllProductsByUserId(String userId);
	
	/**
	 * Retailer can remove Product from Cart
	 * @param userId
	 * @param productId
	 */
	void removeProductByUserIdProductId(String userId, String productId);
	
	/**
	 * Reatiler can get All placed Orders
	 * @param userId
	 * @return
	 */
	List<Order> getAllOrdersByUserId(String userId);
	
	/**
	 * Get All products from a particular order
	 * @param orderId
	 * @return
	 */
	List<Product> getAllProductsByOrderId(String orderId);

}
