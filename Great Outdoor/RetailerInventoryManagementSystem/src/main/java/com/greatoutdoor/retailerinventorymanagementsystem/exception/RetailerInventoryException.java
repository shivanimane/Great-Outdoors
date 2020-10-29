package com.greatoutdoor.retailerinventorymanagementsystem.exception;
/**
 * 
 * @author Deepali
 *
 */
public class RetailerInventoryException extends Exception {
	private static final long serialVersionUID = -2339227516000641134L;

	public RetailerInventoryException() {}

	public RetailerInventoryException(String errorMessage) {
		super(errorMessage);
	}

	public RetailerInventoryException(Throwable cause) {
		super(cause);
	}

	public RetailerInventoryException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}

	public RetailerInventoryException(String errorMessage, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(errorMessage, cause, enableSuppression, writableStackTrace);
	}
}