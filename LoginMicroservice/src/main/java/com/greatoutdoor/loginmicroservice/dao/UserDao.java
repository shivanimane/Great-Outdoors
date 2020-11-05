/**
 * 
 */
package com.greatoutdoor.loginmicroservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
	  
	  @Modifying
		@Query("SELECT user FROM User user WHERE user.role=:role")
		@Transactional
	  public  List<User> findByRole(String role);
		 
	   
	   public  User findByUsernameAndPassword(String username,String password );
	   
//	   @Modifying
//		@Query("SELECT user FROM User user WHERE user.emailId=:emailId")
//		@Transactional
//	   public boolean findByEmailId(String emailId);

	   
	}

