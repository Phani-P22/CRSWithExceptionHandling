package com.digit.javaTests.week2.CRSWithExceptions;

public class InvalidIDException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	
	public InvalidIDException() {
		this.message = "Invalid ID!";
	}
	
	public InvalidIDException(String msg) {
		this.message = msg;
	}
	
	public String getMessage() {
		return message;
	}
}
