package com.tsfn.controller.response;


public class ErrorResponse {

	
	 	private String errorMessage;
	   

	    public ErrorResponse(String errorMessage) {
	        this.errorMessage = errorMessage;
	        
	    }

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

}