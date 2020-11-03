package com.greatoutdoor.loginmicroservice.exception;

public class UserNotFound extends RuntimeException{
	public UserNotFound() {
		super();

	}

	public UserNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public UserNotFound(String message, Throwable cause) {
		super(message, cause);

	}

	public UserNotFound(String message) {
		super(message);

	}

	public UserNotFound(Throwable cause) {
		super(cause);

	}

}
	
