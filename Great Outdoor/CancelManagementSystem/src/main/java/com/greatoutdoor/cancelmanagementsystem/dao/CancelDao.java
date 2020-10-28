/**
 * 
 */
package com.greatoutdoor.cancelmanagementsystem.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greatoutdoor.cancelmanagementsystem.model.Cancel;

/**
 * @author Shivani

 *
 */
@Repository
public interface CancelDao extends CrudRepository<Cancel, String>{

}
