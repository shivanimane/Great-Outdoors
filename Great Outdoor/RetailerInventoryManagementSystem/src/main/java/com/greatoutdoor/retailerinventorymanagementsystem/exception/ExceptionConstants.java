package com.greatoutdoor.retailerinventorymanagementsystem.exception;
/**
 * 
 * @author Deepali
 *
 */
public class ExceptionConstants {
	
	// RETAILER INVENTORY EXCEPTION CONSTANTS
		public static final String PRODUCT_NOT_IN_INVENTORY = "Item is not present in inventory";
		public static final String INAPPROPRIATE_METHOD_INVOCATION = "Method has been invoked at an illegal or inappropriate time";
		public static final String FAILURE_COMMIT_CHANGES = "Could not commit changes to retailer inventory";
		public static final String PRODUCT_ALREADY_PRESENT_IN_INVENTORY = "Item already present in inventory";
		public static final String INAPPROPRIATE_ARGUMENT_PASSED = "Illegal arguments passed";
		public static final String NO_DATA_FOUND = "The requested data was not found";
		public static final String PERSISTENCE_ERROR = "Persistence error occurred";
		public static final String INTERNAL_RUNTIME_ERROR = "Internal runtime error occured";
		public static final String FAILED_TO_RETRIEVE_USERNAME = "Could not retrieve retailer name from Database";
		// END OF RETAILER INVENTORY EXCEPTION CONSTANTS
		
		// USER EXCEPTION CONSTANTS
		public static final String USER_EXISTS = " User with the given user id already exists";
		public static final String USER_MAIL_EXISTS = " User with the given mail id already exists";
		public static final String USER_NUMBER_EXISTS = " User with the given phone number already exists";
		public static final String USER_NOT_EXISTS = " User with the given user id doesn't exists";
		public static final String USER_REG_ERROR = " Error in registering a new User >>>";
		public static final String USER_LOGIN_ERROR = " Error in logging in >>>";
		public static final String PASSWORD_MISMATCH = " Username or Password is incorrect";
		public static final String ALREADY_LOGGEDIN = " User Already Logged in ! Please log out first";
		public static final String USER_LOGOUT_ERROR = " User logged out succesfully";
		public static final String ITEM_ALREADY_PRESENT_IN_CART = "Item already present in the cart";
		public static final String ITEM_NOT_IN_CART="Item is not present in the cart";
		public static final String  ITEM_ALREADY_MAPPED_TO_ORDER="Item is already mapped to order";
		// END OF USER EXCEPTION CONSTANTS

}
