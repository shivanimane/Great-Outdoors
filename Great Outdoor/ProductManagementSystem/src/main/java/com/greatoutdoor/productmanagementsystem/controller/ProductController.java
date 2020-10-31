
 

package com.greatoutdoor.productmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatoutdoor.productmanagementsystem.exception.NullParameterException;
import com.greatoutdoor.productmanagementsystem.exception.ProductNotFoundException;
import com.greatoutdoor.productmanagementsystem.model.Product;
import com.greatoutdoor.productmanagementsystem.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	/**
	 * View All Products
	 * @return List
	 */
	@ApiOperation(
			value = "View All Products",
			notes = "User can view all products using this API"
			)
	@GetMapping("/viewAllProducts")
	List<Product> viewAllProducts(){
		return productService.viewAllProducts();
	}
	
	/**
	 * Add a Product
	 * @param product
	 * @return String
	 *   {
        "productId": "101",
        "price": 10000.0,
        "colour": "red",
        "dimension": "67 cms",
        "specification": "Handle with care",
        "manufacture": "ABC manufacturers",
        "quantity": 60,
        "productCategory": 1,
        "productName": "ABC"
    }
    
	 */
	@ApiOperation(
			value = "Add Product",
			notes = "User can add a product using this API"
			)
	@PostMapping("/addProduct")

	String addProduct(@RequestBody Product product) {
		if(product.getProductId().trim().length()==0) {
			throw new NullParameterException("Please provide Product id");
			
		}
		String status = "Product has been added";

	
		if(productService.addProduct(product)) {
			return status;
		}
		
		else {
			return "Failed to add product!";
		}
		
		//return "Failed to add product!";
	}
	
	/**
	 * Delete a Product
	 * @param productId
	 * @return String
	 */
	@DeleteMapping("/deleteProduct/{productId}")
	String deleteProduct(@PathVariable String productId) throws ProductNotFoundException{
		if(productService.deleteProduct(productId)==false) {
			throw new ProductNotFoundException("Product not found");
		} else {
			return "Product has been deleted!";
		}
		
	}
	
	/**
	 * Edit a Product
	 * @param product
	 * @return String
	 */
	@PutMapping("/editProduct")
	String editProduct(@RequestBody Product product) {
		String status = "Product has been updated";
		
		if(productService.editProduct(product)==false) {
			throw new ProductNotFoundException("Product not found");
		}
		
		return "Successfully updated";
		
	}

	

//	
	@GetMapping("/getProductById")
	Optional<Product> getProductById(@RequestParam String productId){
		if(productService.getProductById(productId)==null) {
			throw new ProductNotFoundException("Product Not Found");
		} else {
			return productService.getProductById(productId);
		}
		
	}


}
