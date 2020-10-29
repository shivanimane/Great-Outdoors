package com.greatoutdoor.authenticationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatoutdoor.authenticationservice.dao.UserRepository;
import com.greatoutdoor.authenticationservice.entity.User;



/****************************************************************************************************************************************
 * - Function Name : UserDetailsServiceImpl <br>
 * - Description : Get full custom User object using UserRepository, then build a UserDetails object using static build() method,
 * 				   by which we can extract authenticated user details. <br>
 * 
 * @apiNote If the authentication process is successful, we can get User’s information such as username,
 * 		    password, authorities from an Authentication object.
 ****************************************************************************************************************************************/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  (repository.findByUsername(username))
        		.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);
    }
}
