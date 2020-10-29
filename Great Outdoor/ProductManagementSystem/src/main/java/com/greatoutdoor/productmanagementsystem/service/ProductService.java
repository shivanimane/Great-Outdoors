/**
 * 
 */
package com.greatoutdoor.productmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.greatoutdoor.productmanagementsystem.model.Product;

/**
 * @author Shivani

 *
 */
public interface ProductService {
	List<Product> viewAllProducts();
	boolean addProduct(Product product);
	boolean editProduct(Product product);
	boolean deleteProduct(String productId);
	Optional<Product> getProductById(String productId);

}
