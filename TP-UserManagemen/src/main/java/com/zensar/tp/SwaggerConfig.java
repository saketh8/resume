package com.zensar.tp;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
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
   @Bean
   public Docket getCustomizedDocket() {
      return new Docket(DocumentationType.SWAGGER_2)
      		.select()
      		.paths(PathSelectors.any())
      		.apis(RequestHandlerSelectors.basePackage("com"))
      		.build()
      		.apiInfo(getApiInfo());
}    
   private ApiInfo getApiInfo() {
       return new ApiInfo(
               "User Management REST API Documentation",
               "This API is designed for User Management",
               "1.0.0",
               "http://www.zensar.com",
               new Contact("Saketh", "http://gpl.com", "saisaketh.c@zensar.com"),
               "GPL",
               "http://gpllicense.com",
               new ArrayList<VendorExtension>());
   }
   
}