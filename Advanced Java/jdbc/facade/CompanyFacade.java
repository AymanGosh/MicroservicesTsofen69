package com.facade;

import com.dao.CompanyDAO;
import com.exception.CompanyException;
import com.model.Company;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class CompanyFacade {
    private CompanyDAO companyDAO;

    public CompanyFacade() throws CompanyException {
        this.companyDAO = new CompanyDAO();
    }

    public boolean isCompanyExists(String email, String password) throws CompanyException {
        return companyDAO.isCompanyExists(email, password);
    }

    public void addCompany(Company company) throws CompanyException {
        companyDAO.addCompany(company);
    }

    public void updateCompany(Company company) throws CompanyException {
        companyDAO.updateCompany(company);
    }

    public void deleteCompany(int companyId) throws CompanyException {
        companyDAO.deleteCompany(companyId);
    }

    public List<Company> getAllCompanies() throws CompanyException {
        return companyDAO.getAllCompanies();
    }

    public Optional<Company> getOneCompany(int companyId) throws CompanyException {
        return companyDAO.getOneCompany(companyId);
    }
}
