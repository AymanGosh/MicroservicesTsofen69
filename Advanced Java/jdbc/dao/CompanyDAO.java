package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

import com.db.DBConnection;
import com.db.DBConnectionIFC;
import com.exception.CompanyException;
import com.model.Company;

public class CompanyDAO implements CompanyDAOIFC, DBConnectionIFC {

	private Connection connection;
	private DBConnection DBConnection;

	public CompanyDAO() throws CompanyException {
		DBConnection = DBConnection.getInstance();
	}
	
	@Override
	public boolean isCompanyExists(String email, String password) throws CompanyException {
		boolean bool = false;
		try {
			ResultSet rs = selectQuery("select * from companies where email = '" + email + "' and password = '" + password + "'");
			while(rs.next()) {
				bool = true;
				System.out.println("* isCompanyExists *");
			}
		} catch (SQLException e) {
			throw new CompanyException("Exception in isCompanyExists - " + e.getMessage());
		}
		
		return bool;
	}

	@Override
	public void addCompany(Company company) throws CompanyException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into companies(name,email,password) values (?,?,?)");
			preparedStatement.setString(1, company.getName());
			preparedStatement.setString(2, company.getEmail());
			preparedStatement.setString(3, company.getPassword());
			preparedStatement.executeUpdate();
			
			System.out.println("* Company Added *");
		} catch (SQLException e) {
			throw new CompanyException("Exception in addCompany - " + e.getMessage());
		}	
	}

	public void updateCompany(Company company) throws CompanyException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update companies set name = ?, email = ?, password = ? where id = " + company.getId());
			preparedStatement.setString(1, company.getName());
			preparedStatement.setString(2, company.getEmail());
			preparedStatement.setString(3, company.getPassword());
			preparedStatement.executeUpdate();
			
			System.out.println("* Company Updated *");

		} catch (SQLException e) {
			throw new CompanyException("Exception in updateCompany - " + e.getMessage());
		}	
	}

	@Override
	public void deleteCompany(int companyID) throws CompanyException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from companies where id =?");
			preparedStatement.setInt(1,companyID);
			preparedStatement.executeUpdate();
			
			System.out.println("* Company Deleted *");

		} catch (SQLException e) {
			throw new CompanyException("Exception in deleteCompany - " + e.getMessage());
		}
	}

	@Override
	public ArrayList<Company> getAllCompanies() throws CompanyException {
		ArrayList<Company> arComp = new ArrayList<Company>();
		try {
			ResultSet rs = selectQuery("select * from companies");
			while(rs.next()) {
				arComp.add(new Company (rs.getString("name"), rs.getString("email"), rs.getString("password")));
			}
		} catch (SQLException e) {
			throw new CompanyException("Exception in getAllCompanies - " + e.getMessage());
		}
		if(!arComp.isEmpty()) {
			System.out.println("* Getting all Companies *");
		}
		return arComp;
	}

	@Override
	public Optional<Company> getOneCompany(int companyID) throws CompanyException {
		Company comp = null;
		try {
			ResultSet rs = selectQuery("select * from companies where id = " + companyID);
			while(rs.next()) {
				comp = new Company( rs.getString("name"), rs.getString("email"), rs.getString("password"));
			}
		} catch (SQLException e) {
			throw new CompanyException("Exception in getOneCompany - " + e.getMessage());
		}
		if(comp != null) {
			System.out.println("* Getting one Company *");
		}
		return Optional.ofNullable(comp);
	}

	public ResultSet selectQuery(String sqlSelect) throws CompanyException {
		ResultSet rs = null;
		try {
			Statement statement = connection.createStatement() ;
			rs = statement.executeQuery(sqlSelect);
		} catch (SQLException e) {
			throw new CompanyException("Exception in select values - " + e.getMessage());
		}
		return rs;
	}

	@Override
    public synchronized Optional<Connection> getConn() throws CompanyException {
        if (connection == null) {
            connection = DBConnection.getConnection();
        }
        return Optional.ofNullable(connection);
    }

    @Override
    public synchronized void restoreConn(Optional<Connection> connection) throws CompanyException {
        if (connection.isPresent()) {
            this.connection = connection.get();
        } else {
            throw new CompanyException("Connection is null");
        }
    }

}
