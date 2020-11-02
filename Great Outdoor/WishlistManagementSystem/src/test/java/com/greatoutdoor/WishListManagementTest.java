package com.greatoutdoor;
/**
 * @author Deepali
 */
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;


import com.greatoutdoor.wishlistmanagementsystem.model.Wishlist;
import com.greatoutdoor.wishlistmanagementsystem.service.WishlistService;
import com.greatoutdoor.wishlistmanagementsystem.service.WishlistServiceImpl;

class WishListManagementTest {

	@Test
	void testAddToWishlist() {
		Wishlist addItem=new Wishlist("565","789");
		WishlistService wishlistservice=mock(WishlistServiceImpl.class);
		when(wishlistservice.addToWishlist(addItem)).thenReturn(Boolean.TRUE);
		System.out.println(addItem.toString());
		boolean logp =wishlistservice.addToWishlist(addItem) ;
		assertEquals(Boolean.TRUE, logp);
		
		
	}
	
	@Test
	void testDeleteProduct() {
		Wishlist removeItem=new Wishlist();
		WishlistService wishlistservice=mock(WishlistServiceImpl.class);
		when(wishlistservice.deleteProduct(removeItem)).thenReturn(Boolean.TRUE);
		System.out.println(removeItem.toString());
		boolean logq =wishlistservice.addToWishlist(removeItem) ;
		assertEquals(Boolean.TRUE, logq);
		
	}
	
	

}


