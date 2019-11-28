package com.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}
	
	@Bean
	public     Docket    docket() {
		Docket    docket=new  Docket(DocumentationType.SWAGGER_2);
		docket.select().apis(RequestHandlerSelectors.basePackage("com.restapi.controller"))
		.paths(PathSelectors.any()).build().useDefaultResponseMessages(false);
		
		return   docket;
	}
}
