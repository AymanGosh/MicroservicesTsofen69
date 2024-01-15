package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Optional;

import com.exception.CompanyException;

public interface DBConnectionIFC {

	
	ResultSet selectQuery(String sqlSelect) throws CompanyException;

    Optional<Connection> getConn() throws CompanyException;

    void restoreConn(Optional<Connection> connection) throws CompanyException;
}
