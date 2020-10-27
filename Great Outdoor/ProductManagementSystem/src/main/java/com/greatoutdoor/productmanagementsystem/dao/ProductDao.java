/**
 * 
 */
package com.greatoutdoor.productmanagementsystem.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greatoutdoor.productmanagementsystem.model.Product;

/**
 * @author Shivani

 *
 */
@Repository
public interface ProductDao extends CrudRepository<Product, String> {

}
