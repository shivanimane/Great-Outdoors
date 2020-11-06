/**
 * 
 */
package com.greatoutdoor.addtocart.model;

import java.io.Serializable;

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
@Table(name = "order_product_map")
public class OrderProductMap implements Serializable{

	@Id
	@Column(name = "product_uin")
	private String productUIN;

	@Column(name = "order_id")
	private String orderId;

	@Column(name = "product_id")
	private String productId;

	private int quantity;

	public OrderProductMap() {
	}

	public OrderProductMap(String productUIN, String orderId, String productId,
			int quantity) {
		super();
		this.productUIN = productUIN;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getProductUIN() {
		return productUIN;
	}

	public void setProductUIN(String productUIN) {
		this.productUIN = productUIN;
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


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}