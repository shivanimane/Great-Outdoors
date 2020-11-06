/**
 * 
 */
package com.greatoutdoor.addtocart.model;

/**
 * @author Shivani

 *
 */
public class CartBean {

	private String userId;
	private String productId;
	private int quantity;
	private String productName;
	private double price;
	
	
	public CartBean() {}



	public CartBean(String userId, String productId, int quantity, String productName, double price) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.productName = productName;
		this.price = price;
	}



	public String getProductName() {
		return productName;
	}



	void setProductName(String productName) {
		this.productName = productName;
	}



	public double getPrice() {
		return price;
	}



	void setPrice(double price) {
		this.price = price;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartBean [userId=" + userId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}

}
