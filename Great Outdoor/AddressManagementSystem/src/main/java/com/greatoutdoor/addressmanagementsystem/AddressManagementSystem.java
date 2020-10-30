package com.greatoutdoor.addressmanagementsystem;
import java.util.Collections;

/**
 * @author Deepali
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;

//@EnableSwagger2
@SpringBootApplication
//@EnableDiscoveryClient
public class AddressManagementSystem {

	public static void main(String[] args) {
		SpringApplication.run(AddressManagementSystem.class, args);
	}
	/**@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any()).apis(RequestHandlerSelectors.basePackage("com.cg.ofd")).build().apiInfo(myApiInfo());
	}
	
	private ApiInfo myApiInfo() {
		Contact contact = new Contact("Deepali","www.ofd.com","deepali@gmail.com");
		ApiInfo apiInfo = new ApiInfo("Login service CRUD Api", "Api Creation","2.0","Free to use",contact,"API licence","API licence URL",Collections.emptyList());
		return apiInfo;
	}**/

}
