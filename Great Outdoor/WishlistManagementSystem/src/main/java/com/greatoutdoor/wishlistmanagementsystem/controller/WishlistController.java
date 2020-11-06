/**
 * 
 */
package com.greatoutdoor.wishlistmanagementsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin("http://localhost:4200")
public class WishlistController {

	@Autowired
	WishlistServiceImpl service;

	@CrossOrigin("http://localhost:4200")
	@PostMapping("/addToWishlist")
	public Wishlist addToWishlist(@RequestBody Wishlist addItem) {

		if (addItem.getUserId() == null || addItem.getProductId() == null || addItem.getUserId().trim().length() == 0
				|| addItem.getProductId().trim().length() == 0) {
			throw new com.greatoutdoor.wishlistmanagementsystem.exception.NullParameterException(
					"Null request, please provide Wishlist details!");
		}
		else {
		String status = "Added to wishlist";
		return service.addToWishlist(addItem);
		}

	}

	@DeleteMapping("deleteProduct(index : number){\r\n" + 
			"    console.log(index);\r\n" + 
			"    return this.http.delete(\"http://localhost:8003/product/deleteProduct/\"+index);")
	public String deleteProduct(@RequestBody Wishlist removeItem) {

		if (removeItem == null || removeItem.getUserId().trim().length() == 0
				|| removeItem.getProductId().trim().length() == 0) {
			throw new NullParameterException(
					"Null request, please provide wishlist details to remove item from wishlist!");

		} else {
			String status = "Removed item";
			if (service.deleteProduct(removeItem)) {
				return status;
			} else {
				throw new CrudException("Product Id not found");
			}
		}

	}

	@GetMapping("/viewAll")
	public List<Wishlist> viewAllItems() {
		List<Wishlist> list = service.viewAllItems();
		return list;
	}
	

	@GetMapping("/viewWishlistByUserId/{userId}")

	public List<Wishlist> viewAllWishlistByUserId(@PathVariable String userId) {
		return service.viewAllWishlistByUserId(userId);
	}

}
