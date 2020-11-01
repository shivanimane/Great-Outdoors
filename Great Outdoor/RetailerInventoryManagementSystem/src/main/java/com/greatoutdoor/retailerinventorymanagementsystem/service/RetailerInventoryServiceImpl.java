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
				object.setRetailerName("Retailer ABC");
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
	public List<RetailerInventoryBean> getCategoryWiseDeliveryTimeReport(String retailerId) throws RetailerInventoryException{
		List<RetailerInventoryBean> result = new ArrayList<RetailerInventoryBean> ();
		List<RetailerInventory> listOfDeliveredItems = retailerInventoryRepository.findAllByretailerId(retailerId); 
		Map<Integer, List<RetailerInventoryBean>> map = new HashMap<Integer, List<RetailerInventoryBean>>();
		for (int category = 1; category <= 5; category++)
			map.put(category, new ArrayList<RetailerInventoryBean>());	
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
				object.setProductCategoryNumber(deliveredItem.getProductCategory());
				object.setProductCategoryName(GoUtility.getCategoryName(deliveredItem.getProductCategory()));
				object.setProductUniqueId(deliveredItem.getProductUniqueId());
				object.setDeliveryTimePeriod(GoUtility.calculatePeriod(deliveredItem.getProductDispatchTimestamp(), deliveredItem.getProductRecieveTimestamp()));
				map.get(Integer.valueOf(object.getProductCategoryNumber())).add(object);
			}
			
			for (int category = 1; category <= 5; category++) {
				if (map.get(category).size() != 0) {
					int years = 0, months = 0, days = 0, count = 0;
					for (RetailerInventoryBean item : map.get(category)) {
						years += item.getDeliveryTimePeriod().getYears(); 
						months += item.getDeliveryTimePeriod().getMonths(); 
						days += item.getDeliveryTimePeriod().getDays();
						count ++;
					}
					years /= count;
					months /= count;
					days /= count;
					RetailerInventoryBean object = new RetailerInventoryBean ();
					object.setProductCategoryNumber((byte)category);
					object.setProductCategoryName(GoUtility.getCategoryName(category));
					object.setProductUniqueId("----");
					object.setDeliveryTimePeriod(Period.of(years, months, days));
					result.add(object);
				}
			}
			
		} catch (RuntimeException error) {
			error.printStackTrace();
			throw new RetailerInventoryException ("getCategoryWiseDeliveryTimeReport - " + ExceptionConstants.INTERNAL_RUNTIME_ERROR);
		}
		return result;
	}

/*	@Override
	public boolean updateProductRecieveTimeStamp(RetailerInventory retailerinventorydto) throws RetailerInventoryException {
		boolean receiveTimestampUpdated = false;

		try {

			RetailerInventory existingItem = (RetailerInventory) retailerInventoryRepository.findByProductUIN(retailerinventorydto.getProductUniqueId());
			System.out.println(existingItem);
			if (existingItem == null) {
			throw new RetailerInventoryException(
						"updateProductReceiveTimeStamp - " + ExceptionConstants.PRODUCT_NOT_IN_INVENTORY);
			}
			existingItem.setProductRecieveTimestamp(retailerinventorydto.getProductRecieveTimestamp());
	
		} catch (IllegalStateException error) {
			throw new RetailerInventoryException(
					"updateProductReceiveTimeStamp - " + ExceptionConstants.INAPPROPRIATE_METHOD_INVOCATION);
		} catch (RollbackException error) {
			throw new RetailerInventoryException(
					"updateProductReceiveTimeStamp - " + ExceptionConstants.FAILURE_COMMIT_CHANGES);
		} 
		receiveTimestampUpdated = true;
		return receiveTimestampUpdated;
		
	}
	*/
	//@Override
//	public boolean updateProductSaleTimeStamp(RetailerInventory retailerinventorydto) throws RetailerInventoryException {
//		boolean saleTimestampUpdated = false;
//
//		try {
//			RetailerInventory existingItem = (RetailerInventory) retailerInventoryRepository.findAll();
//			if (existingItem == null) {
//				throw new RetailerInventoryException(
//						"updateProductSaleTimeStamp - " + ExceptionConstants.PRODUCT_NOT_IN_INVENTORY);
//			}
//			existingItem.setProductSaleTimestamp(retailerinventorydto.getProductSaleTimestamp());
//	
//		} catch (IllegalStateException error) {
//			throw new RetailerInventoryException(
//					"updateProductSaleTimeStamp - " + ExceptionConstants.INAPPROPRIATE_METHOD_INVOCATION);
//		} catch (RollbackException error) {
//			throw new RetailerInventoryException(
//					"updateProductSaleTimeStamp - " + ExceptionConstants.FAILURE_COMMIT_CHANGES);
//		}
//		saleTimestampUpdated = true;
//		return saleTimestampUpdated;
//		
//	}
   
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
	
	public boolean addItemToInventory(String retailerId, byte productCategory, String productId, String productUIN) {
		boolean itemAdded = false;
		Calendar currentSystemTimestamp = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		RetailerInventory queryArgument = new RetailerInventory(retailerId, productCategory, productId, productUIN, currentSystemTimestamp, null, null);
		itemAdded = retailerInventoryRepository.save(queryArgument) != null;
		return itemAdded;
	}

//	@Override
//	public List<RetailerInventoryBean> getMonthlyShelfTimeReport(String retailerId, Calendar dateSelection)
//			throws RetailerInventoryException {
//		List<RetailerInventoryBean> result = new ArrayList<RetailerInventoryBean> ();
//
//		List<RetailerInventory> listOfSoldItems =  retailerInventoryRepository.findAllByretailerId(retailerId);
//		try {
//			List<User> userList = (List<User>) userRepository.findAll();
//			
//			for (RetailerInventory soldItem : listOfSoldItems) {
//				if (soldItem.getProductSaleTimestamp().get(Calendar.MONTH) == dateSelection.get(Calendar.MONTH)) {
//					RetailerInventoryBean object = new RetailerInventoryBean ();
//					object.setRetailerId(retailerId);
//					object.setRetailerName("plawan");
//					for (User user : userList) {
//						if (user.getUserId().equals(retailerId)) {
//							object.setRetailerName(user.getUserName());
//							break;
//						}
//					}
//					object.setProductCategoryNumber(soldItem.getProductCategory());
//					object.setProductCategoryName(GoUtility.getCategoryName(soldItem.getProductCategory()));
//					object.setProductUniqueId(soldItem.getProductUniqueId());
//					object.setShelfTimePeriod(GoUtility.calculatePeriod(soldItem.getProductRecieveTimestamp(), 
//							soldItem.getProductSaleTimestamp()));
//					object.setDeliveryTimePeriod(null);
//					result.add(object);
//				} else {
//					
//				}
//			}
//		} catch (RuntimeException error) {
//			//GoLog.getLogger(RetailerInventoryServiceImpl.class).error(error.getMessage());
//			throw new RetailerInventoryException ("getMonthlyShelfTimeReport - " + ExceptionConstants.INTERNAL_RUNTIME_ERROR);
//		}
//		return result;
//		 
//	}
//
//	@Override
//	public List<RetailerInventoryBean> getQuarterlyShelfTimeReport(String retailerId, Calendar dateSelection)
//			throws RetailerInventoryException {
//		List<RetailerInventoryBean> result = new ArrayList<RetailerInventoryBean> ();
//		List<RetailerInventory> listOfSoldItems =  retailerInventoryRepository.findAllByretailerId(retailerId);
//		try {
//			List<User> userList = (List<User>) userRepository.findAll();
//			
//			for (RetailerInventory soldItem : listOfSoldItems) {
//				RetailerInventoryBean object = new RetailerInventoryBean ();
//				object.setRetailerId(retailerId);
//				for (User user : userList) {
//					if (user.getUserId().equals(retailerId)) {
//						object.setRetailerName(user.getUserName());
//						break;
//					}
//				}
//				object.setProductCategoryNumber(soldItem.getProductCategory());
//				object.setProductCategoryName(GoUtility.getCategoryName(soldItem.getProductCategory()));
//				object.setProductUniqueId(soldItem.getProductUniqueId());
//				object.setShelfTimePeriod(GoUtility.calculatePeriod(soldItem.getProductRecieveTimestamp(), 
//						soldItem.getProductSaleTimestamp()));
//				object.setDeliveryTimePeriod(null);
//				result.add(object);
//			}
//			
//	
//		} catch (RuntimeException error) {
//			//GoLog.getLogger(RetailerInventoryServiceImpl.class).error(error.getMessage());
//			throw new RetailerInventoryException ("getQuarterlyShelfTimeReport - " + ExceptionConstants.INTERNAL_RUNTIME_ERROR);
//		}
//		return result;
//	}
//
//	@Override
//	public List<RetailerInventoryBean> getYearlyShelfTimeReport(String retailerId, Calendar dateSelection)
//			throws RetailerInventoryException {
//		List<RetailerInventoryBean> result = new ArrayList<RetailerInventoryBean>();
//		List<RetailerInventory> listOfSoldItems = retailerInventoryRepository.findAllByretailerId(retailerId);
//		try {
//			List<User> userList = (List<User>) userRepository.findAll();
//
//			for (RetailerInventory soldItem : listOfSoldItems) {
//				RetailerInventoryBean object = new RetailerInventoryBean();
//				object.setRetailerId(retailerId);
//				for (User user : userList) {
//					if (user.getUserId().equals(retailerId)) {
//						object.setRetailerName(user.getUserName());
//						break;
//					}
//				}
//				object.setProductCategoryNumber(soldItem.getProductCategory());
//				object.setProductCategoryName(GoUtility.getCategoryName(soldItem.getProductCategory()));
//				object.setProductUniqueId(soldItem.getProductUniqueId());
//				object.setShelfTimePeriod(GoUtility.calculatePeriod(soldItem.getProductRecieveTimestamp(),
//						soldItem.getProductSaleTimestamp()));
//				object.setDeliveryTimePeriod(null);
//				result.add(object);
//			}
//
//		} catch (RuntimeException error) {
//			// logger.error(error.getMessage());
//			throw new RetailerInventoryException(
//					"getYearlyShelfTimeReport - " + ExceptionConstants.INTERNAL_RUNTIME_ERROR);
//		}
//		return result;
//	}

}