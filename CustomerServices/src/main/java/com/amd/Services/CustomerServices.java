package com.amd.Services;

import java.util.List;
import java.util.Optional;

import com.amd.model.Customer;


public interface CustomerServices {
	public List<Customer> getCustomers();
	public Optional<Customer> getCustomerById(int custid);
	public Customer addNewCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomerById(int custid);
	public void deleteAllCustomers();
}
