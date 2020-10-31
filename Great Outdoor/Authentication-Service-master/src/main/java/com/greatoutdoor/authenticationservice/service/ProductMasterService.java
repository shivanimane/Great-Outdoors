package com.greatoutdoor.authenticationservice.service;

import com.greatoutdoor.authenticationservice.entity.Product;

public interface ProductMasterService {

	

	/****************************************************************************************************************************************
	 * - Function Name : addProduct <br>
	 * - Description : Only product master can add a new product and return status. <br>
	 * 
	 * @param Product product
	 * @return String
	 ****************************************************************************************************************************************/
	String addProduct(Product product);

	
	

	/****************************************************************************************************************************************
	 * - Function Name : deleteProduct <br>
	 * - Description : Only product master can delete a product by product Id and return status. <br>
	 * 
	 * @param String productId
	 * @return String
	 ****************************************************************************************************************************************/
	String deleteProduct(String productId);
	
	

}
