
 

package com.greatoutdoor.productmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
		return productService.viewAllProducts();
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
	
	/**@PostMapping("/addProduct")
	Product addProduct(@Valid @RequestBody Product product)
	 {
		return productService.addProduct(product);
		
		}**/
	
	@PostMapping("/addProduct")
	ResponseEntity<String> addAddress(@Valid @RequestBody Product product) {

		if (productService.addProduct(product)) {
			return ResponseEntity.ok("Product has been added");
		} else {
			throw new NullParameterException("Product Id cannot be zero");
		}

	}
	
	
	/**
	 * Delete a Product
	 * @param productId
	 * @return String
	 */
//	@PostMapping("/deleteProduct/{productId}")
//	String deleteProduct(@PathVariable String productId) {
//		if(productService.deleteProduct(productId)) {
//			return "Product has been deleted!";
//		}
//		return "ERROR";
//	}
//	
	                                                      
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
