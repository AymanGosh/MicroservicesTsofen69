package com.tsfn.controller.client.coupon;

import java.time.LocalDate;

import lombok.Data;


@Data
public class Coupon {

	private int id ;
	private int companyId;
	private Category category ;
	private String title ;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private int amount ;
	private double price ;
	
}
