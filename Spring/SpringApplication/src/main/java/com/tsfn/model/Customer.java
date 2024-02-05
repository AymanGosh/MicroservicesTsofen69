package com.tsfn.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
//POJO class

@Component  // tell the spring core container to create bean from this pojo.

public class Customer {
	
	@Value("112")
	private int custID; 
	@Value("John")
	private String custName;
	
	@Autowired
	@Qualifier("acc1")
	private MyAcc account ;
	

	
	@PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct - Custom initialization method for Customer bean");
        // Simulate initialization logic, e.g., opening a connection or initializing resources.
        System.out.println("Initializing resources for customer: " + custName);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy - Custom destruction method for Customer bean");
        // Simulate destruction logic, e.g., closing a connection or releasing resources.
        System.out.println("Releasing resources for customer: " + custName);
    }
	
	public int getCustID() {
		return custID;
	}
	
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Account getAccount() {
		return (Account) account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [custID=" + custID + ", custName=" + custName + ", account=" + account + "]";
	}

	
	
	
}
