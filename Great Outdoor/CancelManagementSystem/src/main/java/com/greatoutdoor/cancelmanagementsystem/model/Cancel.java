/**
 * 
 */
package com.greatoutdoor.cancelmanagementsystem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Shivani
 * ProductUIN
 * Order Cancel Time
 * Order Id
 * User Id
 * Product Id
 * Order Cancel Status
 *
 */
@Entity
@Table (name="cancel_table")
public class Cancel {
	@Id 
	@Column(name = "product_uin")
	private String productuin;
	@Column(name="order_cancel_time")
	private Date orderCancelTime;
	
	@Column(name="order_id")
	private String orderid;
	@Column(name="user_id")
	private String userId;
	@Column(name = "product_id")
	private String productId;
	
	@Column(name = "order_cancel_status", unique = false, length = 1)
	private int orderCancelStatus;
	
	/**
	 * 
	 */
	public Cancel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param productuin
	 * @param orderCancelTime
	 * @param orderid
	 * @param userId
	 * @param productId
	 * @param orderCancelStatus
	 */

	public Cancel(String orderid, String userId, String productId, String productuin, Date orderCancelTime,
			int orderCancelStatus) {
		super();
		this.orderid = orderid;
		this.userId = userId;
		this.productId = productId;
		this.productuin = productuin;
		this.orderCancelTime = orderCancelTime;
		this.orderCancelStatus = orderCancelStatus;
	}

	/**
	 * @return the productuin
	 */
	public String getProductuin() {
		return productuin;
	}

	/**
	 * @param productuin the productuin to set
	 */
	public void setProductuin(String productuin) {
		this.productuin = productuin;
	}

	/**
	 * @return the orderCancelTime
	 */
	public Date getOrderCancelTime() {
		return orderCancelTime;
	}

	/**
	 * @param orderCancelTime the orderCancelTime to set
	 */
	public void setOrderCancelTime(Date orderCancelTime) {
		this.orderCancelTime = orderCancelTime;
	}

	/**
	 * @return the orderid
	 */
	public String getOrderid() {
		return orderid;
	}

	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
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
	 * @return the orderCancelStatus
	 */
	public int getOrderCancelStatus() {
		return orderCancelStatus;
	}

	/**
	 * @param orderCancelStatus the orderCancelStatus to set
	 */
	public void setOrderCancelStatus(int orderCancelStatus) {
		this.orderCancelStatus = orderCancelStatus;
	}
	
	

}
