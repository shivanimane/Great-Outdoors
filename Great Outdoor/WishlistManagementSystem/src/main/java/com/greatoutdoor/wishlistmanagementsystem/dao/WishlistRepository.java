/**
 * 
 */
package com.greatoutdoor.wishlistmanagementsystem.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greatoutdoor.wishlistmanagementsystem.model.Product;
import com.greatoutdoor.wishlistmanagementsystem.model.Wishlist;


public interface WishlistRepository extends CrudRepository<Wishlist,String> {

}