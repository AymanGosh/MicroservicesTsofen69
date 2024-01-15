package com.exception;

import java.sql.SQLException;

public class CompanyException extends SQLException{

	/**
	 * Dawodk. 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompanyException(String message) {
		super(message);
	}

}
