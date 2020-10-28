/**
 * 
 */
package com.greatoutdoor.addtocart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.greatoutdoor.addtocart.model.OrderProductMap;

/**
 * @author Shivani

 *
 */
@Repository
public interface OrderProductMapDao extends CrudRepository<OrderProductMap, String>{

	/**
	 * Delete Orders by OrderId, ProductID
	 * @param orderId
	 * @param productId
	 */
	@Modifying
	@Query("DELETE FROM OrderProductMap opm WHERE opm.orderId=:orderId and opm.productId=:productId")
	@Transactional
	void deleteOrderByOrderIdProductId(@Param("orderId") String orderId, @Param("productId") String productId);
	
	/**
	 * Delete Order by OrderId
	 * @param orderId
	 */
	@Modifying
	@Query("DELETE FROM OrderProductMap opm WHERE opm.orderId=:orderId")
	@Transactional
	void deleteOrderByOrderId(@Param("orderId") String orderId);
	
	/**
	 * Get All Orders by Id
	 * @param orderId
	 * @return
	 */
	@Modifying
	@Query("SELECT opm FROM OrderProductMap opm WHERE opm.orderId=:orderId")
	@Transactional
	List<OrderProductMap> getAllOrdersByOrderId(@Param("orderId") String orderId);

	/**
	 * Get All Orders by Order Id, Product Id
	 * @param orderId
	 * @param productId
	 * @return
	 */
	@Modifying
	@Query("SELECT opm FROM OrderProductMapD opm WHERE opm.orderId=:orderId and opm.productId=:productId")
	@Transactional
	List<OrderProductMap> getAllOrdersByOrderIdProductId(String orderId, String productId);
}
