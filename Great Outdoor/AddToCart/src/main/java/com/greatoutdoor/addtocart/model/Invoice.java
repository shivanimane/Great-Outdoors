/**
 * 
 */
package com.greatoutdoor.addtocart.model;

import java.util.Date;
import java.util.List;

/**
 * @author Shivani
 *
 */
public class Invoice {


	private List<OrderProductMap> orderList;
	private String addressId;
	private Date orderInitiateTime;
	private double totalcost;
	private String userId;
	
	public Invoice() {}

	public Invoice(List<OrderProductMap> orderList, String addressId, Date orderInitiateTime,
			double totalcost, String userId) {
		super();
		this.orderList = orderList;
		this.addressId = addressId;
		this.orderInitiateTime = orderInitiateTime;
		this.totalcost = totalcost;
		this.userId = userId;
	}

	public List<OrderProductMap> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderProductMap> orderList) {
		this.orderList = orderList;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public Date getOrderInitiateTime() {
		return orderInitiateTime;
	}

	public void setOrderInitiateTime(Date orderInitiateTime) {
		this.orderInitiateTime = orderInitiateTime;
	}

	public double getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
}
