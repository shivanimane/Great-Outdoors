package com.cg.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
   public  User findByUsername(String username);
   
   public  User findByUsernameAndPassword(String username,String password );
   
   
}
