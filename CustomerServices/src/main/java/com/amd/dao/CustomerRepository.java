package com.amd.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amd.model.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Integer>{

}
