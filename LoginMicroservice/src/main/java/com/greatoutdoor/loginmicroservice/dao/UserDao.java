/**
 * 
 */
package com.greatoutdoor.loginmicroservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greatoutdoor.loginmicroservice.model.User;

/**
 * @author Shivani

 *
 */
@Repository
public interface UserDao extends CrudRepository<User, String> {

	  public  User findByUsername(String username);
	   
	   public  User findByUsernameAndPassword(String username,String password );
	   
	   
	}

