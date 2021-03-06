/**
 * 
 */
package com.greatoutdoor.addtocart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author Shivani
 */

@Entity
@Table(name = "cart")
@IdClass(Cart.class)
public class Cart implements Serializable{
	@Id
	@Column(name = "retailer_id" , nullable = false)
	private String userId;
	@Id
	@Column(name = "product_id" , nullable = false )
	private String productId;
	@Column(name = "quantity" , nullable = false )
	private int quantity;
	private String productName;
	private double price;
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	
	public Cart(String userId, String productId, int quantity, String productName, double price) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.productName = productName;
		this.price = price;
	}
	/**
	 * @param userId
	 * @param productId
	 * @param quantity
	 */
		/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	String getProductName() {
			return productName;
		}

		void setProductName(String productName) {
			this.productName = productName;
		}

		double getPrice() {
			return price;
		}

		void setPrice(double price) {
			this.price = price;
		}

	

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
