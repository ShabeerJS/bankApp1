package com.exception;

public class BankApplicationException extends Exception {

	private String errorMessege;

	public BankApplicationException(String errorMessege) {
		super();
		this.errorMessege = errorMessege;
	}

	@Override
	public String getMessage() {
		
		return this.errorMessege;
	}
	
	
}
