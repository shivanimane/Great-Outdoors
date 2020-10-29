package com.greatoutdoor.authenticationservice.service;

import java.util.List;

import com.greatoutdoor.authenticationservice.entity.User;

public interface AdminProductMasterService {

	
	
	/****************************************************************************************************************************************
	 * - Function Name : deleteProductMaster <br>
	 * - Description : Only admin can add a new product master. Method returns a boolean. <br>
	 * 
	 * @param int userId
	 * @return boolean
	 ****************************************************************************************************************************************/
	boolean deleteProductMaster(int userId);

	
	
	/****************************************************************************************************************************************
	 * - Function Name : addProductMaster <br>
	 * - Description : Only admin can delete a product master. Method return a boolean. <br>
	 * 
	 * @param User user
	 * @return boolean
	 ****************************************************************************************************************************************/
	boolean addProductMaster(User user);

	
	

	/****************************************************************************************************************************************
	 * - Function Name : viewAllProductMasters <br>
	 * - Description : Only admin can view the list of product masters. Method returns a list. <br>
	 * 
	 * @return List<User>
	 ****************************************************************************************************************************************/
	List<User> viewAllProductMasters();

}
