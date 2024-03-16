package com.amd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;



@Component
@Entity
@Table(name="customer")

//To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int custId;
	private String custName;

	public Customer(int custId, String custName) {

		this.custId = custId;
		this.custName= custName;
	}

	public Customer() {}


	
	public int getCustId() {
		return custId;
	}
	

	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "Customer [CustId=" + custId + ", CustName=" + custName + "]";
	}

}
