/**
 * 
 */
package com.greatoutdoor.wishlistmanagementsystem.service;

import java.util.List;

import com.greatoutdoor.wishlistmanagementsystem.model.Product;
import com.greatoutdoor.wishlistmanagementsystem.model.Wishlist;

public interface WishlistService {
	/*
	 * name - add to wishlist
	 * description - It will add an item to the wishlist.
	 */
	
	boolean addToWishlist(Wishlist addItem) ;
	
	

	List<Wishlist> viewAllItems() ;
	/*
	 * name - delete item from the wishlist
	 * description - it will delete available item from the wishlist
	 */
	boolean deleteProduct(Wishlist removeItem);
	
	 /*
     * showProductsFromWishlist
     * descriptio:shows all products in the wishlist
     */

	public List<Wishlist> viewAllWishlistByUserId(String userId) ;



	



}
