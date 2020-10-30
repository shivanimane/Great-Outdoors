/**
 * 
 */
package com.greatoutdoor.wishlistmanagementsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.greatoutdoor.wishlistmanagementsystem.exception.CrudException;
import com.greatoutdoor.wishlistmanagementsystem.exception.NullParameterException;
import com.greatoutdoor.wishlistmanagementsystem.model.Product;
import com.greatoutdoor.wishlistmanagementsystem.model.Wishlist;
import com.greatoutdoor.wishlistmanagementsystem.service.WishlistServiceImpl;
//this is a restcontroller
@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = "*")
public class WishlistController {
	
	
	
	@Autowired
	WishlistServiceImpl service;
	
	
	@PostMapping("/addToWishlist")
	public String addToWishlist(@RequestBody Wishlist addItem) {
		
		if(addItem==null || addItem.getUserId().trim().length()==0 ||addItem.getProductId().trim().length()==0) { 
			throw new com.greatoutdoor.wishlistmanagementsystem.exception.NullParameterException("Null request, please provide Wishlist details!");
		}
		    String status= "Added to wishlist";
		    service.addToWishlist(addItem);
		    return status;
		
               
		}

	@PostMapping("/deleteProduct")
   public String deleteProduct(@RequestBody Wishlist removeItem )  {
		
		if(removeItem==null || removeItem.getUserId().trim().length()==0 ||removeItem.getProductId().trim().length()==0) { 
			throw new NullParameterException("Null request, please provide wishlist details to remove item from wishlist!");
			
		}
		
		String status= "Removed item";
	     if(service.deleteProduct(removeItem)==false) {
	    	 throw new CrudException("Product Id not found");
	     }
	     else
		   return status;
	
	}
		
	
	
	@GetMapping("/viewAll")
	public List<Wishlist> viewAllItems() {
		List<Wishlist> list = service.viewAllItems();
		return list;
	}
	

	@GetMapping("/viewAllProducts")
	
	public List<Product> viewAllProductFromWishList() {
		return service.viewAllProductFromWishList();
	}

		
	}
	

