package com.amdocs.myProject.exceptions;

@SuppressWarnings("serial")
public class InvalidCustomerDataException extends Exception{
	
	public InvalidCustomerDataException(String message) {
		super(message);
	}
}

