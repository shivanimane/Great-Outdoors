/**
 * 
 */
package com.greatoutdoor.cancelmanagementsystem.model;

/**
 * @author Shivani

 *
 */
public class Product {

	
	
	private String productId;
	private double price;
	private String colour;
	private String dimension;
	private String specification;
	private String manufacture;
	private int quantity;
	private int productCategory;
	private String productName;
	private String productURL;
	
	public Product() {}


	/**
	 * @param productId
	 * @param price
	 * @param colour
	 * @param dimension
	 * @param specification
	 * @param manufacture
	 * @param quantity
	 * @param productCategory
	 * @param productName
	 * @param productURL
	 */
	public Product(String productId, double price, String colour, String dimension, String specification,
			String manufacture, int quantity, int productCategory, String productName, String productURL) {
		super();
		this.productId = productId;
		this.price = price;
		this.colour = colour;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacture = manufacture;
		this.quantity = quantity;
		this.productCategory = productCategory;
		this.productName = productName;
		this.productURL = productURL;
	}





	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getProductURL() {
		return productURL;
	}



	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}
	
	
	
	

}
