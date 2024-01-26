package com.tsfn.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("acc1")

public class Account implements MyAcc{

	@Value("222")
	private int accID ;
	
	
	@Value("222-123-1233321")
	private String accDetails ;
	
	@Value("111")
	private int custID;

	
	public int getAccID() {
		return accID;
	}

	public void setAccID(int accID) {
		this.accID = accID;
	}

	public String getAccDetails() {
		return accDetails;
	}

	public void setAccDetails(String accDetails) {
		this.accDetails = accDetails;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	@Override
	public String toString() {
		return "Account [accID=" + accID + ", accDetails=" + accDetails + ", custID=" + custID + "]";
	}
	
	
	
}
