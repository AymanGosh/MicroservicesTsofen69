package com.amd.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amd.Services.CustomerServices;
import com.amd.model.Customer;

@RestController
public class CustomerController {

	@Autowired	
	CustomerServices custServices ;


	@RequestMapping(value= "/customer/all", method= RequestMethod.GET)
	public List<Customer> getCustomers() {
		System.out.println(this.getClass().getSimpleName() + " - Get all Customers custServices is invoked.");
		return custServices.getCustomers();
	}

	@RequestMapping(value= "/customer/{id}", method= RequestMethod.GET)
	public Customer getCustomerById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get Customer details by id is invoked.");

		Optional<Customer> emp =  custServices.getCustomerById(id);
		if(!emp.isPresent())
			throw new Exception("Could not find Customer with id- " + id);

		return emp.get();
	}

	@RequestMapping(value= "/customer/add", consumes="application/json", method= RequestMethod.POST)
		public Customer createCustomer(@RequestBody Customer newcust) {
		System.out.println(this.getClass().getSimpleName() + " - Create new Customer method is invoked.");
		return custServices.addNewCustomer(newcust);
	}

	@RequestMapping(value= "/customer/update/{id}", method= RequestMethod.PUT)
	public Customer updateCustomer(@RequestBody Customer updemp, @PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update Customer details by id is invoked.");

		Optional<Customer> emp =  custServices.getCustomerById(id);
		if (!emp.isPresent())
			throw new Exception("Could not find Customer with id- " + id);

		/* IMPORTANT - To prevent the overiding of the existing value of the variables in the database, 
		 * if that variable is not coming in the @RequestBody annotation object. */		
		if(updemp.getCustName() == null || updemp.getCustName().isEmpty())
			updemp.setCustName(emp.get().getCustName());


		// Required for the "where" clause in the sql query template.
		updemp.setCustId(id);
		return custServices.updateCustomer(updemp);
	}

	@RequestMapping(value= "/customer/delete/{id}", method= RequestMethod.DELETE)
	public void deleteCustomerById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete Customer by id is invoked.");

		Optional<Customer> emp =  custServices.getCustomerById(id);
		if(!emp.isPresent())
			throw new Exception("Could not find Customer with id- " + id);

		custServices.deleteCustomerById(id);
	}

	@RequestMapping(value= "/customer/deleteall", method= RequestMethod.DELETE)
	public void deleteAll() {
		System.out.println(this.getClass().getSimpleName() + " - Delete all Customers is invoked.");
		custServices.deleteAllCustomers();
	}
	
	
	

}
