/**
 * 
 */
package com.greatoutdoor.productmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatoutdoor.productmanagementsystem.model.Product;
import com.greatoutdoor.productmanagementsystem.service.ProductService;

/**
 * @author Shivani

 *
 */

@RestController
@RequestMapping("/product")
//@CrossOrigin(origins="*")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	/**
	 * View All Products
	 * @return List
	 */
	@GetMapping("/viewAllProducts")
	List<Product> viewAllProducts(){
		return productService.viewAllProducts();
	}
	
	/**
	 * Add a Product
	 * @param product
	 * @return String
	 */
	@PostMapping("/addProduct")
	String addProduct(@RequestBody Product product) {
		String status = "Product has been added";
		
		
		if(productService.addProduct(product)) {
			return status;
		}
		
		return "Failed to add product!";
		
	}
	
	/**
	 * Delete a Product
	 * @param productId
	 * @return String
	 */
	@PostMapping("/deleteProduct/{productId}")
	String deleteProduct(@PathVariable String productId) {
		if(productService.deleteProduct(productId)) {
			return "Product has been deleted!";
		}
		return "ERROR";
	}
	
	/**
	 * Edit a Product
	 * @param product
	 * @return String
	 */
	@PostMapping("/editProduct")
	String editProduct(@RequestBody Product product) {
		String status = "Product has been updated";
		
		if(productService.editProduct(product)) {
			return status;
		}
		
		return "Failed to update product!";
		
	}

}
