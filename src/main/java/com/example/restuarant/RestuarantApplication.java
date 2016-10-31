package com.example.restuarant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring boot application for restuarant application.
 * 
 * @author ganesh
 *
 */
@SpringBootApplication
@ComponentScan
public class RestuarantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestuarantApplication.class, args);
	}

}
