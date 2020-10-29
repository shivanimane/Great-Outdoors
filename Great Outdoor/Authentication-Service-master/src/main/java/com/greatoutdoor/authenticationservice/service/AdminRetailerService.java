package com.greatoutdoor.authenticationservice.service;

import java.util.List;

import com.greatoutdoor.authenticationservice.entity.User;

public interface AdminRetailerService {

	
	/****************************************************************************************************************************************
	 * - Function Name : deleteRetailer <br>
	 * - Description : Only admin can add a new retailer. Method returns a boolean. <br>
	 * 
	 * @param int userId
	 * @return boolean
	 ****************************************************************************************************************************************/
	boolean deleteRetailer(int userId);

	
	
	
	/****************************************************************************************************************************************
	 * - Function Name : addRetailer <br>
	 * - Description : Only admin can delete a retailer. Method return a boolean. <br>
	 * 
	 * @param User user
	 * @return boolean
	 ****************************************************************************************************************************************/
	boolean addRetailer(User user);

	
	

	/****************************************************************************************************************************************
	 * - Function Name : viewAllRetailers <br>
	 * - Description : Only admin can view the list of retaliers and return a boolean. Method list. <br>
	 * 
	 * @return List<User>
	 ****************************************************************************************************************************************/
	List<User> viewAllRetailers();



}
