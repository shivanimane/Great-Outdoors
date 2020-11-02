/**
 * 
 */
package com.greatoutdoor.cancelmanagementsystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.greatoutdoor.cancelmanagementsystem.dao.CancelDao;
import com.greatoutdoor.cancelmanagementsystem.model.Cancel;
import com.greatoutdoor.cancelmanagementsystem.model.OrderProductMap;
import com.greatoutdoor.cancelmanagementsystem.model.Orders;
import com.greatoutdoor.cancelmanagementsystem.model.Product;
import com.greatoutdoor.cancelmanagementsystem.model.ProductResponse;

/**
 * @author Shivani

 *
 */
@Service
public class CancelServiceImpl implements CancelService{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CancelDao cancelDao;
	
	Orders orders;
	private String orderProductUrl ="http://localhost:8006/order";
	private String productUrl = "http://localhost:8003/product";

	@Override
	public String cancelOrder(String orderId, String userId) {
		
		long millis = System.currentTimeMillis();
		Date currentDate = new Date(millis);
		
		Orders orders = restTemplate.getForObject(orderProductUrl+"/getOrders/"+orderId, Orders.class);
		List<OrderProductMap> list = orders.getOrders();
		Iterator<OrderProductMap> itr = list.iterator();
		int index= 0;
		while(itr.hasNext()) {
			
			Cancel cancelOrder = new Cancel( orderId,userId, list.get(index).getProductId(),
					list.get(index).getProductUIN(), currentDate, 0);
			
			cancelDao.save(cancelOrder);
			
			index++;
			itr.next();
		}
		
		MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
		parametersMap.add("orderId", orderId);
		return restTemplate.postForObject(orderProductUrl+"/cancelOrder/", parametersMap, String.class);
		
	}

	@Override
	public String cancelProduct(String orderId, String userId, String productId, int quantity) {
		long millis=System.currentTimeMillis();  
		Date currentDate = new java.util.Date(millis);
		
		Orders orders = restTemplate.getForObject(orderProductUrl+"/getOrdersByOrderIdProductId/"
						+orderId+"/"+productId, Orders.class);
		List<OrderProductMap> list = orders.getOrders();
		Iterator<OrderProductMap> itr = list.iterator();
		int index = 0;
		
		while(itr.hasNext()) {
			Cancel cancelProduct = new Cancel( orderId,userId, list.get(index).getProductId(),
					list.get(index).getProductUIN(), currentDate, 0);
			
			cancelDao.save(cancelProduct);
			index++;
			itr.next();
			
		}
		MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
		parametersMap.add("orderId", orderId);
		parametersMap.add("productId", productId);

		
		return restTemplate.postForObject(orderProductUrl+"/cancelProduct", parametersMap, String.class);
	}

	@Override
	public List<ProductResponse> getresponseProducts() {
		List<Cancel> cancelOrders = (List<Cancel>) cancelDao.findAll();
		List<ProductResponse> response = new ArrayList<>();
		Iterator<Cancel> itr = cancelOrders.iterator();
		int index = 0;
		while (itr.hasNext()) {
			Product product = restTemplate.getForObject(productUrl+"/getProductById?productId="+cancelOrders.get(index).getProductId(),
					Product.class);
			ProductResponse productResponse = new ProductResponse(cancelOrders.get(index).getUserId(),
					cancelOrders.get(index).getOrderid(),cancelOrders.get(index).getProductId(), product.getProductName(), product.getPrice());
			
			response.add(productResponse);
			index++;
			itr.next();
		}

		
		
		return response;
	}

}
