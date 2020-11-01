package com.greatoutdoor.addressmanagementsystem.exception;

public class ApiError {
	String exception;

	public ApiError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiError(String exception) {
		super();
		this.exception = exception;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

}
