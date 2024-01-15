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



    // Synchronized method to get a connection
    public synchronized void executeWithConnection(ConnectionTask task) throws CompanyException {
        try {
            Optional<Connection> connectionOptional = companyDAO.getConn();
            if (connectionOptional.isPresent()) {
                Connection connection = connectionOptional.get();
                try {
                    task.execute(connection);
                } finally {
                    companyDAO.restoreConn(Optional.of(connection));
                }
            }
        } catch (CompanyException e) {
            throw new CompanyException("Exception in executeWithConnection - " + e.getMessage());
        }
    }

    // Functional interface for tasks to be executed with a Connection
    @FunctionalInterface
    public interface ConnectionTask {
        void execute(Connection connection) throws CompanyException;
    }
}
