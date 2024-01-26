package com.tsfn.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tsfn.model.Account;
import com.tsfn.model.Customer;

@Configuration
@ComponentScan({"com.tsfn"})  
public class Config {
	
	/*
	 * @Bean public Customer createCustomerInstance() { return new Customer(); }
	 * 
	 * @Bean (name= "acc1") public Account createAccIns() { return new Account(); }
	 * 
	 * @Bean (name= "acc2") public Account createAccIns2() { return new Account(); }
	 */
}
