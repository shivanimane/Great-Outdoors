/**
 * 
 */
package com.greatoutdoor.addtocart.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Shivani

 *
 */
public class Orders{


	private List<OrderProductMap> orderList;

	public Orders() {}

	public Orders(List<OrderProductMap> orderList) {
		super();
		this.orderList = orderList;
	}

	public List<OrderProductMap> getOrders() {
		return orderList;
	}

	public void setOrders(List<OrderProductMap> orderList) {
		this.orderList = orderList;
	}

}
