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
	 * name - add to wishlist
	 * description - It will add an item to the wishlist.
	 */
	@Override
	public boolean addToWishlist(Wishlist addItem) {
		
		repository.save(addItem);	
		
		return true;
	}
	/*
	 * name - delete item from the wishlist
	 * description - it will delete available item from the wishlist
	 */
	
	@Override
	public boolean deleteProduct(Wishlist removeItem) {
		
		repository.delete(removeItem);

		return true;
	}
	
	@Override
	public List<Wishlist> viewAllItems() {
		if(repository.count()==0) throw new CrudException("Please add something to wishlist");
		List<Wishlist> list = new ArrayList<>();
		return (List<Wishlist>) repository.findAll();
	}
	 /*
     * showProductsFromWishlist
     * descriptio:shows all products in the wishlist
     */
	@Override
	
	public List<Product> viewAllProductFromWishList() {
		if(repository.count()==0) throw new CrudException("Please add items to wishlist");
		List<Wishlist> listWishListItems = (List<Wishlist>) repository.findAll();
		List<Product> listProducts = new ArrayList<>();
		
		Iterator<Wishlist> itr = listWishListItems.iterator();
		int index = 0;
		
		while (itr.hasNext()) {
			Product product = restTemplate.getForObject(productUrl+"/getProductById?productId="+listWishListItems.get(index).getProductId(),
					Product.class);
			listProducts.add(product);
			index++;
			itr.next();
		}
		return listProducts;
	}




}
