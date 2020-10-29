package com.greatoutdoor.retailerinventorymanagementsystem.model;
/**
 * 
 * @author Deepali
 *
 */
import java.time.Period;


public class RetailerInventoryBean {
	private String retailerId;
	private String retailerName;
	private byte productCategoryNumber;
	private String productCategoryName;
	private String productName;
	private String productUniqueId;
	private Period deliveryTimePeriod;
	private Period shelfTimePeriod;
	public RetailerInventoryBean() {
		super();
	}
	public RetailerInventoryBean(String retailerId, String retailerName, byte productCategoryNumber,
			String productCategoryName, String productName, String productUniqueId, Period deliveryTimePeriod,
			Period shelfTimePeriod) {
		super();
		this.retailerId = retailerId;
		this.retailerName = retailerName;
		this.productCategoryNumber = productCategoryNumber;
		this.productCategoryName = productCategoryName;
		this.productName = productName;
		this.productUniqueId = productUniqueId;
		this.deliveryTimePeriod = deliveryTimePeriod;
		this.shelfTimePeriod = shelfTimePeriod;
	}
	public String getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}
	public String getRetailerName() {
		return retailerName;
	}
	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}
	public byte getProductCategoryNumber() {
		return productCategoryNumber;
	}
	public void setProductCategoryNumber(byte productCategoryNumber) {
		this.productCategoryNumber = productCategoryNumber;
	}
	public String getProductCategoryName() {
		return productCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductUniqueId() {
		return productUniqueId;
	}
	public void setProductUniqueId(String productUniqueId) {
		this.productUniqueId = productUniqueId;
	}
	public Period getDeliveryTimePeriod() {
		return deliveryTimePeriod;
	}
	public void setDeliveryTimePeriod(Period deliveryTimePeriod) {
		this.deliveryTimePeriod = deliveryTimePeriod;
	}
	public Period getShelfTimePeriod() {
		return shelfTimePeriod;
	}
	public void setShelfTimePeriod(Period shelfTimePeriod) {
		this.shelfTimePeriod = shelfTimePeriod;
	}
	@Override
	public String toString() {
		return "RetailerInventoryBean [retailerId=" + retailerId + ", retailerName=" + retailerName
				+ ", productCategoryNumber=" + productCategoryNumber + ", productCategoryName=" + productCategoryName
				+ ", productName=" + productName + ", productUniqueId=" + productUniqueId + ", deliveryTimePeriod="
				+ deliveryTimePeriod + ", shelfTimePeriod=" + shelfTimePeriod + "]";
	}

	public static String periodToString (Period period) {
		return "Years: " + period.getYears() + " Months: " + period.getMonths() + " Days: " + period.getDays();
	}
	

}
