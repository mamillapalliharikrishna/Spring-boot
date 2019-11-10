package com.satya.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@SpringBootApplication
public class EmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}
	
	@Bean
	public   ResourceBundleViewResolver     viewResolver() {
		ResourceBundleViewResolver        viewresolver=
				                                               new  ResourceBundleViewResolver();
		viewresolver.setBasename("views");
		return   viewresolver;
	}
	
}





