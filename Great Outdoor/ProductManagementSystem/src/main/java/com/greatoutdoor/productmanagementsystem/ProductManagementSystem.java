package com.greatoutdoor.productmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableSwagger2WebMvc
public class ProductManagementSystem {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementSystem.class, args);
	}

}
