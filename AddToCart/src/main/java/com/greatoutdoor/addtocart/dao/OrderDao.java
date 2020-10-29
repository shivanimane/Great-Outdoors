/**
 * 
 */
package com.greatoutdoor.addtocart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greatoutdoor.addtocart.model.Order;

/**
 * @author Shivani

 *
 */
@Repository
public interface OrderDao extends CrudRepository<Order, String> {

	/**
	 * Get All Orders
	 * @param userId
	 * @return
	 */
	@Modifying
	@Query("SELECT order FROM Order order WHERE order.userId=:userId")
	@Transactional
	List<Order> getAllOrders(String userId);
}
