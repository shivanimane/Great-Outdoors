package com.greatoutdoor.loginservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatoutdoor.loginservice.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
   public  User findByUsername(String username);
   
   public  User findByUsernameAndPassword(String username,String password );
   
   
}
