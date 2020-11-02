package com.greatoutdoor.retailerinventorymanagementsystem.controller;

/**
 * @Deepali
 */
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatoutdoor.retailerinventorymanagementsystem.exception.NullParameterException;
import com.greatoutdoor.retailerinventorymanagementsystem.exception.RetailerInventoryException;
import com.greatoutdoor.retailerinventorymanagementsystem.model.RetailerInventoryBean;
import com.greatoutdoor.retailerinventorymanagementsystem.model.RetailerInventory;
import com.greatoutdoor.retailerinventorymanagementsystem.service.RetailerInventoryService;

@RestController

@RequestMapping("/getRetailerInventory")

public class RetailerInventoryController {

	@Autowired
	private RetailerInventoryService retailerInventoryService;
	private static final Logger Logger = LoggerFactory.getLogger(RetailerInventoryBean.class);

	@ResponseBody
	@GetMapping("/getItemWiseDelivery/{retailerId}")
	public List<RetailerInventoryBean> getDeliveryTimeReport(@PathVariable String retailerId) {
		if(retailerId.isEmpty()) {
			throw new NullParameterException("Please enter retailerId");
		}
		List<RetailerInventoryBean> result = null;

		try {
			result = retailerInventoryService.getItemWiseDeliveryTimeReport(retailerId);
		} catch (RetailerInventoryException error) {
			error.printStackTrace();
			System.out.println("Delivery Time Report - " + error.getMessage());

			System.out.println("Delivery Time Report - " + "Invalid Argument Recieved");
		}
		return result;

	}

	@GetMapping("/getRetailerInventoryById/{retailerId}")
	public List<RetailerInventory> getRetailerInventoryById(@PathVariable String retailerId) {
		if(retailerId.isEmpty()) {
			throw new NullParameterException("Please enter retailerId");
		}
		List<RetailerInventory> result = null;
		try {
			result = this.retailerInventoryService.getInventoryById(retailerId);
		} catch (Exception error) {
			error.printStackTrace();
			System.out.println("Retailer List By Invenory By Id - " + error.getMessage());
		}
		return result;
	}

	@ResponseBody
	@GetMapping("/RetailerList")
	public List<RetailerInventory> getRetailerList() {
		List<RetailerInventory> result = null;
		try {
			result = this.retailerInventoryService.getListOfRetailers();

		} catch (Exception error) {
			error.printStackTrace();
			System.out.println("Retailer List - " + error.getMessage());
		}
		return result;
	}


}
