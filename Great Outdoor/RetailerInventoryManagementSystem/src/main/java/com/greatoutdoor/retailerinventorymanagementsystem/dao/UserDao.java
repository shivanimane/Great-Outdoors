package com.greatoutdoor.retailerinventorymanagementsystem.dao;
/**
 * @Deepali
 */
import org.springframework.data.repository.CrudRepository;

import com.greatoutdoor.retailerinventorymanagementsystem.model.UserDTO;



public interface UserDao extends CrudRepository<UserDTO, String> {

}