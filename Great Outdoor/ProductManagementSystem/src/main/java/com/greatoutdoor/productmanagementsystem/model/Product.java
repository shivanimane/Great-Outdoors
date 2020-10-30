package com.greatoutdoor.productmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product_table")
public class Product {
	@Id
	private String productId;
	
	@NotNull(message = "Price cannot be null")
	private double price;
	
	@NotNull(message = "Color cannot be null")
	private String colour;
	
	@NotNull(message = "Dimension cannot be null")
	private String dimension;
	
	@NotNull(message = "Specification cannot be null")
	private String specification;
	
	@NotNull(message = "Manufacturer cannot be null")
	private String manufacture;
	
	@NotNull(message = "Quantity cannot be null")
	private int quantity;
	
	@Min(value = 1,message = "Product Category is only between 1-5")
	@Max(value = 5,message = "Product Category is only between 1-5")
	private int productCategory;
	private String productName;
	
	/**
	 * 
	 */
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	

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
	 */
	


	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

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
	 */
	public Product(String productId, @NotNull(message = "Price cannot be null") double price,
			@NotNull(message = "Color cannot be null") String colour,
			@NotNull(message = "Dimension cannot be null") String dimension,
			@NotNull(message = "Specification cannot be null") String specification,
			@NotNull(message = "Manufacturer cannot be null") String manufacture,
			@NotNull(message = "Quantity cannot be null") int quantity,
			@Min(value = 1, message = "Product Category is only between 1-5") @Max(value = 5, message = "Product Category is only between 1-5") int productCategory,
			String productName) {
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
	}



	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	/**
	 * @return the dimension
	 */
	public String getDimension() {
		return dimension;
	}

	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	/**
	 * @return the specification
	 */
	public String getSpecification() {
		return specification;
	}

	/**
	 * @param specification the specification to set
	 */
	public void setSpecification(String specification) {
		this.specification = specification;
	}

	/**
	 * @return the manufacture
	 */
	public String getManufacture() {
		return manufacture;
	}

	/**
	 * @param manufacture the manufacture to set
	 */
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
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

	/**
	 * @return the productCategory
	 */
	public int getProductCategory() {
		return productCategory;
	}

	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

}
