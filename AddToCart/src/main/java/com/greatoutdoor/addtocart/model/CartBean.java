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
	
	public CartBean() {}

	public CartBean(String userId, String productId, int quantity) {
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
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

}
