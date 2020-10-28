/**
 * 
 */
package com.greatoutdoor.addressmanagementsystem.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greatoutdoor.addressmanagementsystem.model.Address;

/**
 * @author Deepali

 *
 */
@Repository
public interface AddressDao extends CrudRepository<Address, String> {

}

