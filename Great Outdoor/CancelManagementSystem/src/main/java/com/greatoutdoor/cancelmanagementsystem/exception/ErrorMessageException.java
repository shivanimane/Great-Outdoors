/**
 * 
 */
package com.greatoutdoor.cancelmanagementsystem.exception;

/**
 * @author Shivani

 *
 */
public class ErrorMessageException extends RuntimeException{

	/**
	 * 
	 */
	public ErrorMessageException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ErrorMessageException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ErrorMessageException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ErrorMessageException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ErrorMessageException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
