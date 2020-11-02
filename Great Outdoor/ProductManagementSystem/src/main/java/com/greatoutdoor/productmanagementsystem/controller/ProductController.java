
package com.greatoutdoor.productmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.greatoutdoor.productmanagementsystem.exception.NullParameterException;
import com.greatoutdoor.productmanagementsystem.exception.ProductNotFoundException;
import com.greatoutdoor.productmanagementsystem.model.Product;
import com.greatoutdoor.productmanagementsystem.service.ProductService;



@RestController
@RequestMapping("/product")
@Validated
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
		if(productService.viewAllProducts()==null) {
			throw new ProductNotFoundException("Products not found");
		} else {
			return productService.viewAllProducts();
		}
	}
	
	/**
	 * Add a Product
	 * @param product
	 * @return String
	 * {
        "productId": "101",
        "price": 50.5,
        "colour": "green",
        "dimension": "erf",
        "specification": "dggcn",
        "manufacture": "dewf",
        "quantity": 5,
        "productCategory": 4,
        "productName": "adsf"
    },
    
	 */
	
	
	@PostMapping("/addProduct")
	String addProduct(@Valid @RequestBody Product product) {
		if(product==null) {
			throw new NullParameterException("Please enter Product details");
		}
		if (productService.addProduct(product)) {
			return "Product has been added";
		} else {
			throw new NullParameterException("Please enter Product details");
		}

	}
	
	
	/**
	 * Delete a Product
	 * @param productId
	 * @return String
	 */
	@DeleteMapping("/deleteProduct")
	String deleteProduct(@RequestParam String productId) {
		if(productId.trim().length()==0) {
			throw new NullParameterException("Please enter productId");
		}
		if(productService.deleteProduct(productId)) {
			return "Product has been deleted!";
		} else {
			throw new ProductNotFoundException("Product not found");
		}
		
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

	

//	
	@GetMapping("/getProductById")
	Optional<Product> getProductById(@RequestParam String productId){
		//return productService.getProductById(productId);
		if(productService.getProductById(productId)==null) {
			throw new ProductNotFoundException("Product Not Found");
		}else {
			return productService.getProductById(productId);
		}
	}


}
