package com.tsfn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tsfn.model.Book;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class BookMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMsApplication.class, args);
		
	
		
	}

}
