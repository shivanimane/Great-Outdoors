package com.cg.sprint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.entity.Asset;
import com.cg.sprint.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService admin;
	
	
	//@GetMapping(value = "ViewListOfAsset")
	public List<Asset> viewList(){
		return admin.getAssetList();
	}
	
	/*@GetMapping("/ViewListOfRequest")
	public List<Request> viewRequest(){
		return admin.getRequestList();
	}
	
	@PostMapping("/allocateAsset")
	public AssetAllocation allocateAsset(@RequestBody Request request) {
		return admin.allocateAsset(request);
	}*/
	@RequestMapping(value = "/addAsset",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
  
	//@PostMapping("/addAsset")
	public Asset addAsset(Asset asset) {
		return admin.addAsset(asset);
	}
	
	@PostMapping("/updateAsset")
	public Asset updateAsset(@PathVariable int assetId , @RequestBody Asset asset) {
		return admin.updateAsset(assetId, asset);
	}
	
	@RequestMapping("/deleteAsset/{assetId}")
	public Asset deleteAsset(@PathVariable int assetId) {
		return admin.deleteAsset(assetId);
	}
	
}
