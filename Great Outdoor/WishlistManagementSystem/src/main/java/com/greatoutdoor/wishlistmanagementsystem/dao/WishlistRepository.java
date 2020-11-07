/**
 * 
 */
package com.greatoutdoor.wishlistmanagementsystem.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.greatoutdoor.wishlistmanagementsystem.model.Product;
import com.greatoutdoor.wishlistmanagementsystem.model.Wishlist;


public interface WishlistRepository extends CrudRepository<Wishlist,String> {
	

	@Modifying
	@Query("SELECT wl FROM Wishlist wl WHERE wl.userId=:userId")
	@Transactional
	List<Wishlist> getWishlistByUserId(@Param("userId") String userId);
	
	@Modifying
	@Query("DELETE FROM Wishlist wl WHERE wl.userId=:userId and wl.productId=:productId")
	@Transactional
	void deleteByUserIdProductId(@Param("userId") String userId, @Param("productId") String productId);
	
	
	 
}