/**
 * 
 */
package com.greatoutdoor.addtocart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {


	@Bean
	public Docket swaggerConfigurationCart() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Cart")
				.select()
				.paths(PathSelectors.ant("/cart/*"))
				.apis(RequestHandlerSelectors.basePackage("com.cg.iter.greatoutdooraddtocart"))
				.build()
				.apiInfo(cartDetails());
	}
	
	@Bean
	public Docket swaggerConfigurationOrder() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Order")
				.select()
				.paths(PathSelectors.ant("/order/*"))
				.apis(RequestHandlerSelectors.basePackage("com.cg.iter.greatoutdooraddtocart"))
				.build()
				.apiInfo(orderDetails());
	}
	
	

	@SuppressWarnings("deprecation")
	private ApiInfo cartDetails() {
		return new ApiInfo(
				
				"Add To Cart Service API", 
				"Add to cart, delete and edit products into cart.", 
				"1.0", 
				"Free to use", 
				"Iter", 
				"", 
				"iter.com"
				
				);
	}
	
	@SuppressWarnings("deprecation")
	private ApiInfo orderDetails() {
		return new ApiInfo(
				
				"Add To Cart Service API", 
				"Place an order, view orders, remove orders", 
				"1.0", 
				"Free to use", 
				"Iter", 
				"", 
				"iter.com"
				
				);
	}

}
