package com.tsfn.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value = "address")
public class Address {
	
	private String country;
	private String city ;
	private String postalCode;
	

}
