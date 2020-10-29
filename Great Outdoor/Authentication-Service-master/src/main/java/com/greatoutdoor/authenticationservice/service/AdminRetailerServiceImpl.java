package com.greatoutdoor.authenticationservice.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatoutdoor.authenticationservice.dao.UserRepository;
import com.greatoutdoor.authenticationservice.entity.ERole;
import com.greatoutdoor.authenticationservice.entity.User;


@Service
public class AdminRetailerServiceImpl implements AdminRetailerService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	AuthService authService;
	
	
	/****************************************************************************************************************************************
	 * - Function Name : deleteRetailer <br>
	 * - Description : Only admin can add a new retailer. Method returns a boolean. <br>
	 * 
	 * @param int userId
	 * @return boolean
	 ****************************************************************************************************************************************/
	@Override
	public boolean deleteRetailer(int userId) {
		userRepository.deleteById(userId);
		return true;
	}

	
	
	/****************************************************************************************************************************************
	 * - Function Name : addRetailer <br>
	 * - Description : Only admin can delete a retailer. Method return a boolean. <br>
	 * 
	 * @param User user
	 * @return boolean
	 ****************************************************************************************************************************************/
	@Override
	public boolean addRetailer(User user) {
		Set<String> roles = new HashSet<>();
		roles.add(ERole.ROLE_RETAILER.toString());
		user.setRoles(roles);
		authService.addUser(user);
		return true;
	}

	
	
	
	/****************************************************************************************************************************************
	 * - Function Name : viewAllRetailers <br>
	 * - Description : Only admin can view the list of retaliers and return a boolean. Method list. <br>
	 * 
	 * @return List<User>
	 ****************************************************************************************************************************************/
	@Override
	public List<User> viewAllRetailers() {
		List<User> resultList = new ArrayList<>();
		List<User> allUsers = userRepository.findAll();
		
		Iterator<User> itr = allUsers.iterator();
		
		int index = 0;
		
		while (itr.hasNext()) {
			
			if(allUsers.get(index).getRoles().contains(ERole.ROLE_RETAILER.toString())) {
				resultList.add(allUsers.get(index));
			}
			index++;
			itr.next();
		}
		return resultList;
	}

}
