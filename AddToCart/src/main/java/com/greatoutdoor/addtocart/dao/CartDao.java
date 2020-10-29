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

import com.greatoutdoor.addtocart.model.Cart;

/**
 * @author Shivani

 *
 */
@Repository
public interface CartDao extends CrudRepository<Cart, String>{
	
	@Modifying
	@Query("DELETE FROM Cart orderProductMap WHERE orderProductMap.userId=:userId and orderProductMap.productId=:productId")
	@Transactional
	void removeItemFromCart(@Param("userId") String userId, @Param("productId") String productId);
	
	@Modifying
	@Query("UPDATE Cart orderProductMap SET orderProductMap.quantity=:quantity WHERE orderProductMap.userId=:userId and orderProductMap.productId=:productId")
	@Transactional
	void updateItemInCart(@Param("userId") String userId, @Param("productId") String productId , @Param("quantity") int quantity);
	
	
	@Modifying
	@Query("SELECT products FROM Cart products WHERE products.userId=:userId")
	@Transactional
	List<Cart> getAllProducts(@Param("userId") String userId);

}
