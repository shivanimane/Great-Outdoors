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
		if (productDao.count() == 0) {
			return null;
		} else {
			return (List<Product>) productDao.findAll();
		}

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
			productDao.deleteById(productId);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Optional<Product> getProductById(String productId) {
		if (productDao.findById(productId).isPresent()) {
			return productDao.findById(productId);
		} else {
			return null;

		}

	}

	@Override
	public boolean addProduct(Product product) {
		if(product==null) {
			return false;
		} else {
			String prodId = "PRODUCT" + productDao.count();
			product.setProductId(prodId);
			productDao.save(product);
			return true;

		}
		
	}

}
