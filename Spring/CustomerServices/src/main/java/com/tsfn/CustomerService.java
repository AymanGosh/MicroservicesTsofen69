package com.tsfn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.tsfn.conf.Config;
import com.tsfn.model.Account;
import com.tsfn.model.Customer;



//@Configuration // this is the configuration of the applcation 
//@ComponentScan({"com.tsfn.model"})  //tell the spring core container where to find the relevant annotations 
public class CustomerService {

	public static void main(String[] args) {
		
		//build the spring-core  container from spring-context 
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		//create bean of customer
		Customer cust1 = ctx.getBean(Customer.class);
		
		cust1.setCustID(111);
		cust1.setCustName("Zoubi");
	
		
		System.out.println(cust1);
		((AnnotationConfigApplicationContext)ctx).close();

	}


}
