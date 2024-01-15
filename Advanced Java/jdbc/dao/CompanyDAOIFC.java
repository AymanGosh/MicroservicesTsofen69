package com.dao;

import java.util.ArrayList;
import java.util.Optional;

import com.exception.CompanyException;
import com.model.Company;

public interface CompanyDAOIFC {

    void addCompany(Company company) throws CompanyException;

    void updateCompany(Company company) throws CompanyException;

    void deleteCompany(int companyID) throws CompanyException;

    ArrayList<Company> getAllCompanies() throws CompanyException;

    Optional<Company> getOneCompany(int companyID) throws CompanyException;

	boolean isCompanyExists(String email, String password) throws CompanyException;   
}
