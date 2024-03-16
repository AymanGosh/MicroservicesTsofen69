package com.tsfn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsfn.model.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	public Company findByEmailAndPassword(String email, String password);
	public boolean existsByEmail(String email);
}
