/**
 * 
 */
package com.greatoutdoor.addtocart.dao;

import org.springframework.data.repository.CrudRepository;

import com.greatoutdoor.addtocart.model.Cart;

/**
 * @author Shivani

 *
 */
public interface CartDao extends CrudRepository<Cart, String>{

}
