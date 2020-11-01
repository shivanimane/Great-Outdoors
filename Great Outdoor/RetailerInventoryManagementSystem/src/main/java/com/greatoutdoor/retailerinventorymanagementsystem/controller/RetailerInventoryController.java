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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatoutdoor.retailerinventorymanagementsystem.exception.RetailerInventoryException;
import com.greatoutdoor.retailerinventorymanagementsystem.model.RetailerInventoryBean;
import com.greatoutdoor.retailerinventorymanagementsystem.model.RetailerInventory;
import com.greatoutdoor.retailerinventorymanagementsystem.service.RetailerInventoryService;


@RestController

@RequestMapping("/getRetailerInventory")

public class RetailerInventoryController {
	
	@Autowired
	private RetailerInventoryService retailerInventoryService;
	private static final Logger Logger= LoggerFactory.getLogger(RetailerInventoryBean.class);
		
	@ResponseBody
	@GetMapping("/getDeliveryTimeReport")
	public List<RetailerInventoryBean> getDeliveryTimeReport(@RequestParam String retailerId, @RequestParam int reportType)
	{
		
		List<RetailerInventoryBean> result = null;
		switch (reportType) {
		case 1: {
			try {
				result = retailerInventoryService.getItemWiseDeliveryTimeReport(retailerId);
			} catch (RetailerInventoryException error) {
				error.printStackTrace();
				System.out.println("Delivery Time Report - " + error.getMessage());
			}
			break;
		}
		case 2: {
			try {
				result = retailerInventoryService.getCategoryWiseDeliveryTimeReport(retailerId);
			} catch (RetailerInventoryException error) {
				error.printStackTrace();
				System.out.println("Delivery Time Report - " + error.getMessage());
			}
			break;
		}
		default: {		
			System.out.println("Delivery Time Report - " + "Invalid Argument Recieved");
		}
	}
	
		return result;
		
		}
	@GetMapping("/RetailerInventoryById")
	public List<RetailerInventory> getRetailerInventoryById (@RequestParam String retailerId) {
		
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
	public List<RetailerInventory> getRetailerList () {
		List<RetailerInventory> result = null;
		try {
			result = this.retailerInventoryService.getListOfRetailers();

		} catch (Exception error) {
			error.printStackTrace();
			System.out.println("Retailer List - " + error.getMessage());
		}
		return result;
	}

	@PostMapping("/addToRetailerInventory")
	public String addToInventory(@RequestParam String retailerId, byte productCategory, String productId, String productUIN) {
		if(this.retailerInventoryService.addItemToInventory(retailerId, productCategory, productId, productUIN))
			return "Added Successfully";
		else {
			return "Failed to add";
		}
		
	}
}
	
	
