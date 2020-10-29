package com.greatoutdoor.retailerinventorymanagementsystem.dao;
/**
 * @Deepali
 */
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.greatoutdoor.retailerinventorymanagementsystem.model.RetailerInventoryDTO;


public interface RetailerInventoryDao extends CrudRepository<RetailerInventoryDTO, String> {

	@Modifying
	@Transactional
	@Query("select ri from RetailerInventoryDTO ri where ri.retailerId=:retailerId")
	List<RetailerInventoryDTO> findAllByretailerId(String retailerId);

}
