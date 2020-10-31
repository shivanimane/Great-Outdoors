/**
 * 
 */
package com.greatoutdoor.productmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatoutdoor.productmanagementsystem.dao.ProductDao;
import com.greatoutdoor.productmanagementsystem.model.Product;

/**
 * @author Shivani
 *
 * 
 */

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public List<Product> viewAllProducts() {
		
		return (List<Product>) productDao.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		String prodId = "PRODUCT" + productDao.count();
		product.setProductId(prodId);
		return productDao.save(product);
		
	}

	@Override
	public boolean editProduct(Product product) {
		Optional<Product> find = productDao.findById(product.getProductId());
		if (find.isPresent()) {
			productDao.save(product);
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteProduct(String productId) {
		if (productDao.findById(productId).isPresent()) {
			return false;
		}
		productDao.deleteById(productId);
		return true;
	}

	@Override
	public Optional<Product> getProductById(String productId) {
		if (productDao.findById(productId).isEmpty()) {
			return null;
		} else {
			return productDao.findById(productId);

		}

	}

}
