package com.greatoutdoor.addressmanagementsystem.model;

/**
 *  @author Deepali
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "address")
public class Address {

	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	// @NotEmpty(message = "addressID can not empty")
	private String addressId;
	// @NotEmpty(message = "retailerID can not empty")
	private String retailerId;
	@NotEmpty(message = "buildingno can not empty")
	private String buildingNo;
	@NotEmpty(message = "city can not empty")
	private String city;
	@NotEmpty(message = "state can not empty")
	private String state;
	@NotEmpty(message = "field can not empty")
	private String field;
	@NotEmpty(message = "zip can not empty")
	private String zip;

	public Address(String addressId, String retailerId,
			@NotNull(message = "buildingno cannot be null") String buildingNo,
			@NotNull(message = "city cannot be null") String city,
			@NotNull(message = "state cannot be null") String state,
			@NotNull(message = "field cannot be null") String field,
			@NotNull(message = "zip cannot be null") String zip) {
		super();
		this.addressId = addressId;
		this.retailerId = retailerId;
		this.buildingNo = buildingNo;
		this.city = city;
		this.state = state;
		this.field = field;
		this.zip = zip;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Address() {
	}

}
