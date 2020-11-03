package com.cg.sprint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.cg.sprint.entity.User;
import com.cg.sprint.repository.UserRepository;

@SpringBootApplication
public class LoginServiceApplication  {

	
	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}

}
