package com.greatoutdoor.retailerinventorymanagementsystem.dao;
/**
 * @Deepali
 */
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.greatoutdoor.retailerinventorymanagementsystem.model.RetailerInventory;


public interface RetailerInventoryDao extends CrudRepository<RetailerInventory, String> {

	@Modifying
	@Transactional
	@Query("select ri from RetailerInventory ri where ri.retailerId=:retailerId")
	List<RetailerInventory> findAllByretailerId(String retailerId);
	

}
