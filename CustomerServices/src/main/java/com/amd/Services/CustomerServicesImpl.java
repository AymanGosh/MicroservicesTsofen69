package com.amd.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amd.dao.CustomerRepository;
import com.amd.model.Customer;



@Service
public class CustomerServicesImpl  implements CustomerServices
{

	
	@Autowired
	CustomerRepository dao;

	@Override
	public List<Customer> getCustomers() {
		return dao.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(int custid) {
		return dao.findById(custid);
	}

	@Override
	public Customer addNewCustomer(Customer customer) {
		return dao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return dao.save(customer);
	}

	@Override
	public void deleteCustomerById(int custid) {
		dao.deleteById(custid);
		
	}

	@Override
	public void deleteAllCustomers() {
		dao.deleteAll();
		
	}
	
	
}
