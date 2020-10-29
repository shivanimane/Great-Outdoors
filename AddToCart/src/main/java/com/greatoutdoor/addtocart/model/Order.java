/**
 * 
 */
package com.greatoutdoor.addtocart.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Shivani
 * 
 *
 */
@Entity
@Table(name = "order_table")
public class Order implements Serializable{
	/**
	 * OrderId
	 * UserId
	 * AddressId
	 * Order Dispatch Status
	 * Order Initiate Time
	 * Order Dispatch Time
	 */
	@Id
	@Column(name = "order_id" ,nullable = false)
	private String orderId;
	@Column(name = "retailer_id" ,nullable = false)
	private String userId;
	@Column(name = "address_id" ,nullable = false)
	private String addressId;
	@Column(name = "order_dispatch_status" ,nullable = false)
	private byte orderDispatchStatus;
	@Column(name = "order_initiate_time")
	private Date orderInitiateTime;
	@Column(name = "order_dispatch_time")
	private Date orderDispatchTime;
	private double totalcost;
	/**
	 * 
	 */
	public Order() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param orderId
	 * @param userId
	 * @param addressId
	 * @param orderDispatchStatus
	 * @param orderInitiateTime
	 * @param orderDispatchTime
	 * @param totalcost
	 */
	public Order(String orderId, String userId, String addressId, byte orderDispatchStatus, Date orderInitiateTime,
			Date orderDispatchTime, double totalcost) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.addressId = addressId;
		this.orderDispatchStatus = orderDispatchStatus;
		this.orderInitiateTime = orderInitiateTime;
		this.orderDispatchTime = orderDispatchTime;
		this.totalcost = totalcost;
	}
	
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the addressId
	 */
	public String getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	/**
	 * @return the orderDispatchStatus
	 */
	public byte getOrderDispatchStatus() {
		return orderDispatchStatus;
	}
	/**
	 * @param orderDispatchStatus the orderDispatchStatus to set
	 */
	public void setOrderDispatchStatus(byte orderDispatchStatus) {
		this.orderDispatchStatus = orderDispatchStatus;
	}
	/**
	 * @return the orderInitiateTime
	 */
	public Date getOrderInitiateTime() {
		return orderInitiateTime;
	}
	/**
	 * @param orderInitiateTime the orderInitiateTime to set
	 */
	public void setOrderInitiateTime(Date orderInitiateTime) {
		this.orderInitiateTime = orderInitiateTime;
	}
	/**
	 * @return the orderDispatchTime
	 */
	public Date getOrderDispatchTime() {
		return orderDispatchTime;
	}
	/**
	 * @param orderDispatchTime the orderDispatchTime to set
	 */
	public void setOrderDispatchTime(Date orderDispatchTime) {
		this.orderDispatchTime = orderDispatchTime;
	}
	

	public double getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}
	
	

}
