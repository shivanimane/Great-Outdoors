package com.greatoutdoor.retailerinventorymanagementsystem.dao;
/**
 * @Deepali
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greatoutdoor.retailerinventorymanagementsystem.model.User;


@Repository
public interface UserDao extends CrudRepository<User, String> {

}