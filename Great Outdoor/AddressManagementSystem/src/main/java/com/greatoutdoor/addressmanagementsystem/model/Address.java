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

import com.sun.istack.NotNull;

@Entity
@Table(name="address")
public class Address {
	
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Size(min=4, message="addressid should have at least 4 character")
	private String addressId;
	private String retailerId;
	private String buildingNo;
	private String city;
	private String state;
	private String field;
	private String zip;
	
	
	public Address(String addressId, String retailerId, String buildingNo, String city, String state, String field,
			String zip) {
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

	public Address() {}
		
}
