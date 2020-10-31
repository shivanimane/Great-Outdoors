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
import com.greatoutdoor.retailerinventorymanagementsystem.model.RetailerInventory;


public interface RetailerInventoryService {
	public List<RetailerInventoryBean> getItemWiseDeliveryTimeReport(String retailerId) throws RetailerInventoryException;
	public List<RetailerInventoryBean> getCategoryWiseDeliveryTimeReport(String retailerId) throws RetailerInventoryException;
	public boolean updateProductRecieveTimeStamp(RetailerInventory retailerinventorydto) throws RetailerInventoryException;
	public boolean updateProductSaleTimeStamp(RetailerInventory retailerinventorydto) throws RetailerInventoryException;
	public List<RetailerInventory> getListOfRetailers();
	public List<RetailerInventory> getInventoryById(String retailerId);
//	public List<RetailerInventoryBean> getMonthlyShelfTimeReport(String retailerId, Calendar dateSelection)throws RetailerInventoryException; 
//	public List<RetailerInventoryBean> getQuarterlyShelfTimeReport(String retailerId, Calendar dateSelection)throws RetailerInventoryException ;
//	public List<RetailerInventoryBean> getYearlyShelfTimeReport(String retailerId, Calendar dateSelection)throws RetailerInventoryException; 

}