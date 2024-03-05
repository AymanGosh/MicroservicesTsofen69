package com.tsfn.model;

import jakarta.persistence.Table;

@Table(name= "category")
public enum Category {
	Food , Furniture,Clothing,Electronics ,Resturant,Cosmetics
}
