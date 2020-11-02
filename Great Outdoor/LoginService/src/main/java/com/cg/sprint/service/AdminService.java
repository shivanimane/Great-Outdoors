package com.cg.sprint.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.sprint.entity.Asset;




@Service
public class AdminService {
	private RestTemplate rest = new RestTemplate();

	public List<Asset> getAssetList() {
		return Arrays.asList(rest.getForObject("http://localhost:6161/asset/ListOfAsset", Asset.class));
	}

	/*public List<Request> getRequestList() {
		return Arrays.asList(rest.getForObject("http://localhost:6164/request/ListOfRequest", Request.class));
	}

	public AssetAllocation allocateAsset(Request request) {
		return rest.postForObject("http://localhost:6163/allocation/allocate/"+ request.getRequestId()+"/" + request.getEmployee() +"/"+ request.getAsset() +"/"+ request.getQuantity(), request,AssetAllocation.class);
	}*/
	
	//Curd Operation for asset 
	public Asset addAsset(Asset asset) {
		return rest.postForObject("http://localhost:6161/asset/addAsset", asset, Asset.class);
	}
	
	public Asset updateAsset(int assetId , Asset asset) {
		return rest.postForObject("http://localhost:6161/asset/update/"+assetId , asset , Asset.class);
	}
	
	public Asset deleteAsset(int assetId) {
		return rest.postForObject("http://localhost:6161/asset/delete"+assetId,"",Asset.class);
	}
}
