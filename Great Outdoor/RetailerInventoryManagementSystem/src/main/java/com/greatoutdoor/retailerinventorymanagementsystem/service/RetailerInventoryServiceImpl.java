package com.greatoutdoor.retailerinventorymanagementsystem.service;
/**
 * 
 * @author Deepali
 *
 */
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;

import javax.persistence.RollbackException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.greatoutdoor.retailerinventorymanagementsystem.model.Product;
import com.greatoutdoor.retailerinventorymanagementsystem.dao.RetailerInventoryDao;
import com.greatoutdoor.retailerinventorymanagementsystem.dao.UserDao;
import com.greatoutdoor.retailerinventorymanagementsystem.exception.ExceptionConstants;
import com.greatoutdoor.retailerinventorymanagementsystem.exception.RetailerInventoryException;
import com.greatoutdoor.retailerinventorymanagementsystem.model.RetailerInventoryBean;
import com.greatoutdoor.retailerinventorymanagementsystem.model.RetailerInventory;
import com.greatoutdoor.retailerinventorymanagementsystem.model.User;
import com.greatoutdoor.retailerinventorymanagementsystem.utility.GoUtility;


@Service
public class RetailerInventoryServiceImpl implements RetailerInventoryService {
	
	@Autowired
	RestTemplate restTemplate;
	
	private String productURL = "http://localhost:8003/product";
	
	@Autowired
	private RetailerInventoryDao retailerInventoryRepository;
	@Autowired
	private UserDao userRepository;

	@Override
	public List<RetailerInventoryBean> getItemWiseDeliveryTimeReport(String retailerId) throws RetailerInventoryException {
		List<RetailerInventoryBean> result = new ArrayList<RetailerInventoryBean> ();
		List<RetailerInventory> listOfDeliveredItems = retailerInventoryRepository.findAllByretailerId(retailerId);		
		try {
			List<User> userList = (List<User>) userRepository.findAll();
			 for (RetailerInventory deliveredItem : listOfDeliveredItems) {
				RetailerInventoryBean object = new RetailerInventoryBean ();
			object.setRetailerId(retailerId);
				for (User user : userList) {
					if (user.getUserId().equals(retailerId)) {
						object.setRetailerName(user.getUserName());
					break;
				}
				}
				
				Product product = restTemplate.getForObject(productURL+"/getProductById?productId="+deliveredItem.getProductId(),
						Product.class);
				object.setProductName(product.getProductName());
				object.setProductCategoryNumber(deliveredItem.getProductCategory());
				object.setProductCategoryName(GoUtility.getCategoryName(deliveredItem.getProductCategory()));
				object.setProductUniqueId(deliveredItem.getProductUniqueId());
				object.setDeliveryTimePeriod(GoUtility.calculatePeriod(deliveredItem.getProductDispatchTimestamp(), deliveredItem.getProductRecieveTimestamp()));
				result.add(object);
			}		
		} catch (RuntimeException error) {
			throw new RetailerInventoryException ("getItemWiseDeliveryTimeReport - " + ExceptionConstants.INTERNAL_RUNTIME_ERROR);
		}
		return result;
	}


	
   
	@Override
	public List<RetailerInventory> getListOfRetailers() {
				return (List<RetailerInventory>) retailerInventoryRepository.findAll();
	}

	@Override
	public List<RetailerInventory> getInventoryById(String retailerId) {
		
		return retailerInventoryRepository.findAllByretailerId(retailerId);
	}
	
	public boolean deleteItemFromInventory(int retailerId, String productUIN) throws RetailerInventoryException {
	
		boolean itemDeleted = false;
		if(retailerInventoryRepository.findById(productUIN).isPresent())
		{
			retailerInventoryRepository.deleteById(productUIN);
			itemDeleted=true;
		}

		return itemDeleted;
	}


}