package com.greatoutdoor.retailerinventorymanagementsystem.service;
/**
 * 
 * @author Deepali
 *
 */
import java.util.Calendar;
import java.util.List;

import com.greatoutdoor.retailerinventorymanagementsystem.exception.RetailerInventoryException;
import com.greatoutdoor.retailerinventorymanagementsystem.model.RetailerInventoryBean;
import com.greatoutdoor.retailerinventorymanagementsystem.model.RetailerInventoryDTO;


public interface RetailerInventoryService {
	public List<RetailerInventoryBean> getItemWiseDeliveryTimeReport(String retailerId) throws RetailerInventoryException;
	public List<RetailerInventoryBean> getCategoryWiseDeliveryTimeReport(String retailerId) throws RetailerInventoryException;
	public boolean updateProductRecieveTimeStamp(RetailerInventoryDTO retailerinventorydto) throws RetailerInventoryException;
	public boolean updateProductSaleTimeStamp(RetailerInventoryDTO retailerinventorydto) throws RetailerInventoryException;
	public List<RetailerInventoryDTO> getListOfRetailers();
	public List<RetailerInventoryDTO> getInventoryById(String retailerId);
	public List<RetailerInventoryBean> getMonthlyShelfTimeReport(String retailerId, Calendar dateSelection)throws RetailerInventoryException; 
	public List<RetailerInventoryBean> getQuarterlyShelfTimeReport(String retailerId, Calendar dateSelection)throws RetailerInventoryException ;
	public List<RetailerInventoryBean> getYearlyShelfTimeReport(String retailerId, Calendar dateSelection)throws RetailerInventoryException; 

}