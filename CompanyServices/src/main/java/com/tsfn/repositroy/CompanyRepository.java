package com.tsfn.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsfn.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	public Company findByEmailAndPassword(String email, String password);
	public boolean existsByEmail(String email);
}
