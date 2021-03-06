/**
 * 
 */
package com.greatoutdoor.cancelmanagementsystem.model;


public class OrderProductMap {
	private String productUIN;
	private  String orderId;
	private String productId;
	private int productStatus;
	private int giftStatus;

	/**
	 * 
	 */
	public OrderProductMap() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param productUIN
	 * @param orderId
	 * @param productId
	 * @param productStatus
	 * @param giftStatus
	 */
	public OrderProductMap(String productUIN, String orderId, String productId, int productStatus, int giftStatus) {
		super();
		this.productUIN = productUIN;
		this.orderId = orderId;
		this.productId = productId;
		this.productStatus = productStatus;
		this.giftStatus = giftStatus;
	}

	/**
	 * @return the productUIN
	 */
	public String getProductUIN() {
		return productUIN;
	}

	/**
	 * @param productUIN the productUIN to set
	 */
	public void setProductUIN(String productUIN) {
		this.productUIN = productUIN;
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
	 * @return the productStatus
	 */
	public int getProductStatus() {
		return productStatus;
	}

	/**
	 * @param productStatus the productStatus to set
	 */
	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}

	/**
	 * @return the giftStatus
	 */
	public int getGiftStatus() {
		return giftStatus;
	}

	/**
	 * @param giftStatus the giftStatus to set
	 */
	public void setGiftStatus(int giftStatus) {
		this.giftStatus = giftStatus;
	}
	
	

}
