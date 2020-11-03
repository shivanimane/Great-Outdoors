package com.greatoutdoor.loginservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.greatoutdoor.loginservice.dao.UserRepository;
import com.greatoutdoor.loginservice.model.User;

@SpringBootApplication
public class LoginServiceApplication  {

	
	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}

}
