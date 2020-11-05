package com.greatoutdoor.wishlistmanagementsystem.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



@Entity
@Table(name = "wishlist")
@IdClass(Wishlist.class)
public class Wishlist implements Serializable{
	
	@Id
	@Column(name = "user_id" ,nullable=false)
	private String userId;
	@Id
	@Column(name= "product_id",nullable=false)
	private String productId;
	
	private String productName;
	private double price;
	
	
	
public Wishlist() {}

	@Override
public String toString() {
	return "Wishlist [userId=" + userId + ", productId=" + productId + ", productName=" + productName + ", price="
			+ price + "]";
}

	public Wishlist(String userId, String productId, String productName, double price) {
	super();
	this.userId = userId;
	this.productId = productId;
	this.productName = productName;
	this.price = price;
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

	
	
	

}