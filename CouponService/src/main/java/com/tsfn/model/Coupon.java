package com.tsfn.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name= "coupons")
@Data
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private int companyId;

	@Enumerated(EnumType.STRING)
	private Category category ;
	
	private String title ;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private int amount ;
	private double price ;

}
