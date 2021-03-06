/**
 * 
 */
package com.greatoutdoor.wishlistmanagementsystem.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.greatoutdoor.wishlistmanagementsystem.dao.WishlistRepository;
import com.greatoutdoor.wishlistmanagementsystem.exception.CrudException;
import com.greatoutdoor.wishlistmanagementsystem.exception.NullParameterException;
import com.greatoutdoor.wishlistmanagementsystem.model.Product;
import com.greatoutdoor.wishlistmanagementsystem.model.Wishlist;

@Service
public class WishlistServiceImpl implements WishlistService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	WishlistRepository repository;

	private String productUrl = "http://localhost:8003/product";

	/*
	 * name - add to wishlist description - It will add an item to the wishlist.
	 */
	@Override
	public Wishlist addToWishlist(Wishlist addItem) {

		Product product = restTemplate.getForObject(productUrl + "/getProductById/" + addItem.getProductId(),
				Product.class);
	if (product == null) {
			throw new NullParameterException("Product not availabe");
		} else {
			addItem.setProductName(product.getProductName());
			addItem.setPrice(product.getPrice());
			repository.save(addItem);
			return addItem;
		}

	}
	/*
	 * name - delete item from the wishlist description - it will delete available
	 * item from the wishlist
	 */

	@Override
	public boolean deleteProduct(String userId, String productId) {
		if (userId.isEmpty() || productId.isEmpty()) {
			return false;
		} else {
			repository.deleteByUserIdProductId(userId, productId);
			return true;
		}
	}

	@Override
	public List<Wishlist> viewAllItems() {
		if (repository.count() == 0)
			throw new CrudException("Please add something to wishlist");
		List<Wishlist> list = new ArrayList<>();
		return (List<Wishlist>) repository.findAll();
	}

	/*
	 * showProductsFromWishlist descriptio:shows all products in the wishlist
	 */
	@Override
	public List<Wishlist> viewAllWishlistByUserId(String userId) {
		if (repository.count() == 0)
			throw new CrudException("Please add items to wishlist");
		else {
		List<Wishlist> listWishListItems = (List<Wishlist>) repository.getWishlistByUserId(userId);
		if(listWishListItems==null)
		{
			throw new NullParameterException("No Product found in the Wishlist");
		}
		else {
				return listWishListItems;
		}
	}
	}
}
