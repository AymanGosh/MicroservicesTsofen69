package com.tsfn.services.exceptions;



public class EmployeeValidationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected long id;
	protected String entityName;
	
	
	
	public EmployeeValidationException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return "the entityName=" + entityName + "with the id="+id +"has a wrong inputs ,please check!!";
	}
	
	
}
