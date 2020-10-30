package com.greatoutdoor.addressmanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Deepali

 *
 */
@Configuration
public class SwaggerConfig {


	@Bean
	public Docket swaggerConfigurationCart() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Address")
				.select()
				.paths(PathSelectors.ant("/address/*"))
				.apis(RequestHandlerSelectors.basePackage("com.cg.iter.greatoutdooraddressmanagementsystem"))
				.build()
				.apiInfo(addressDetails());
	}
	
		
	

	



	@SuppressWarnings("deprecation")
	private ApiInfo addressDetails() {
		return new ApiInfo(
				
				"Add address ", 
				"Add, delete and edit address.", 
				"1.0", 
				"Free to use", 
				"Iter", 
				"", 
				"iter.com"
				
				);
	}
	
	
}
