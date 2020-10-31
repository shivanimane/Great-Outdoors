package com.greatoutdoor.retailerinventorymanagementsystem.dao;
/**
 * @Deepali
 */
import org.springframework.data.repository.CrudRepository;

import com.greatoutdoor.retailerinventorymanagementsystem.model.User;



public interface UserDao extends CrudRepository<User, String> {

}