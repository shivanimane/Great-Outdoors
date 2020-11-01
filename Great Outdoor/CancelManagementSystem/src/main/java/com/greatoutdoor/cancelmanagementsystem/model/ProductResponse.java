/**
 * 
 */
package com.greatoutdoor.cancelmanagementsystem.model;

/**
 * @author Shivani

 *
 */
public class ProductResponse {

	private String userId;
	private String orderId;
	private String productId;

	private String productName;
	private double price;
	public ProductResponse(String userId, String orderId, String productId, String productName, double price) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.productId = productId;
		
		this.productName = productName;
		this.price = price;
	}
	public ProductResponse() {
		super();
		
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
