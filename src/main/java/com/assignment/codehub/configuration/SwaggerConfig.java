package com.assignment.codehub.configuration;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public Docket userApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("com.assignment.codehub"))
				.paths(PathSelectors.regex("/product.*"))
				.build()
				.apiInfo(metaData());
	}
	
    private ApiInfo metaData() {

        ApiInfo apiInfo = new ApiInfo(

                "CodeHub API",
                "CodeHub - A Api for github like repo",
                "1.0",
                "Terms of service",
                new Contact("Shubham Upadhay", 
                		"https://github.com/ShubhamSomu", 
                		"supadhay@craterzone.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", 
                new ArrayList<VendorExtension>());
        return apiInfo;

    }
}
