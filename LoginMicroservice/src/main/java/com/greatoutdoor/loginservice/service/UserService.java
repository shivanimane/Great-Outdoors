<<<<<<< HEAD:LoginMicroservice/src/main/java/com/greatoutdoor/loginservice/service/UserService.java
package com.greatoutdoor.loginservice.service;
=======
package com.greatoutdoor.loginmicroservice.service;
>>>>>>> a21c65d6b019dcae2c87f3ad3d8cabbcb79ce8d1:LoginMicroservice/src/main/java/com/greatoutdoor/loginmicroservice/service/UserService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD:LoginMicroservice/src/main/java/com/greatoutdoor/loginservice/service/UserService.java
import com.greatoutdoor.loginservice.dao.UserRepository;
import com.greatoutdoor.loginservice.model.User;
=======
import com.greatoutdoor.loginmicroservice.model.SignUpBean;
import com.greatoutdoor.loginmicroservice.model.User;

import com.greatoutdoor.loginmicroservice.dao.UserDao;

>>>>>>> a21c65d6b019dcae2c87f3ad3d8cabbcb79ce8d1:LoginMicroservice/src/main/java/com/greatoutdoor/loginmicroservice/service/UserService.java

@Service
public class UserService {

	@Autowired
	private UserDao userRepository;
	
	public User fetchUserByUsername(String username) {
		return userRepository.findByUsername(username);
		
	}
	
	public User fetchUserByUsernameandPassword(String username,String password) {
		return userRepository.findByUsernameAndPassword(username, password);
		
	}

	public User addUser(User user) {
		//User user=new User(signUp.getUsername(),signUp.getPassword(), signUp.getRole());
		 this.userRepository.save(user);
		return user;
	}

}
