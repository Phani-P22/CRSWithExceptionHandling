package com.digit.javaTests.week2.CRSWithExceptions;

@SuppressWarnings("serial")
public class InvalidAdminException extends Exception {
	
	public String getMessage() {
		return "Invalid Credentials. You are not authenticated!";
	}
}
