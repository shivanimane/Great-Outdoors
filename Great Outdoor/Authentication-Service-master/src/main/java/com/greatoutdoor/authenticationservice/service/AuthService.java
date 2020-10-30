package com.greatoutdoor.authenticationservice.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.greatoutdoor.authenticationservice.entity.User;
import com.greatoutdoor.authenticationservice.entity.request.LoginRequest;
import com.greatoutdoor.authenticationservice.entity.request.SignupRequest;
import com.greatoutdoor.authenticationservice.entity.response.JwtResponse;

public interface AuthService {

	
	

	/****************************************************************************************************************************************
	 * - Function Name : authenticateUser <br>
	 * - Description : it will authenticate the user with user id and password and return details and authentication token as response <br>
	 * 
	 * @param LoginRequest loginRequest
	 * @return ResponseEntity<JwtResponse>
	 ****************************************************************************************************************************************/
	
	ResponseEntity<JwtResponse> authenticateUser(@Valid LoginRequest loginRequest);

	
	
	
	/****************************************************************************************************************************************
	 * - Function Name : registerUser <br>
	 * - Description : it will authenticate the user with user , create a new user and return success of failed message. <br>
	 * 
	 * @param SignupRequest signUpRequest
	 * @return ResponseEntity<?> registerUser
	 ****************************************************************************************************************************************/
	ResponseEntity<?> registerUser(@Valid SignupRequest signUpRequest);
	
	
	

	/****************************************************************************************************************************************
	 * - Function Name : editUser <br>
	 * - Description : Any actor can edit existing actor details and return a boolean value. <br>
	 * 
	 * @param User user
	 * @return boolean
	 ****************************************************************************************************************************************/
	boolean editUser(User user);
	
	
	
	
	/****************************************************************************************************************************************
	 * - Function Name : deleteUser <br>
	 * - Description : Admin can delete existing user or product master and return a boolean value. <br>
	 * 
	 * @param User user
	 * @return boolean
	 ****************************************************************************************************************************************/
	boolean deleteUser(User user);
	
	
	
	
	/****************************************************************************************************************************************
	 * - Function Name : addUser <br>
	 * - Description : Admin can add user or product master and return a boolean value. <br>
	 * 
	 * @param User user
	 * @return boolean
	 ****************************************************************************************************************************************/
	boolean addUser(User user);
	
	
	
	
	/****************************************************************************************************************************************
	 * - Function Name : getDbCount <br>
	 * - Description : It will return the number of rows in userDB to generate key. <br>
	 * 
	 * @return long
	 ****************************************************************************************************************************************/
	long getDbCount();

}
