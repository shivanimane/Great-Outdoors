package com.greatoutdoor.addtocart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
<<<<<<< HEAD
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@ComponentScan(basePackages = "com.*")
public class AddToCartSystem {
              
	 @Bean
	 public RestTemplate getRestTemplate() {
		 return new RestTemplate();
	 }
	 
	 public static void main(String[] args) {
=======
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AddToCartSystem {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
>>>>>>> fd72d33495d18ff39e622bf90641315fdd8e0584
		SpringApplication.run(AddToCartSystem.class, args);
	}

}
