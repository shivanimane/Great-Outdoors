package com.greatoutdoor.addressmanagementsystem.exception;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.greatoutdoor.addressmanagementsystem.exception.ErrorMessage;
import com.greatoutdoor.addressmanagementsystem.exception.NullParameterException;
import com.greatoutdoor.addressmanagementsystem.exception.AddressNotFound;



@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	private long currentTimeMillis = System.currentTimeMillis();
	private String errorMsg = "Some thing went wrong!";
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> somethingWentWrong(Exception ex){
		
		ErrorMessage exceptionResponse =
				new ErrorMessage(ex.getMessage(), 
						errorMsg,currentTimeMillis);
		return new ResponseEntity<ErrorMessage>(exceptionResponse,
				new HttpHeaders(),HttpStatus.BAD_REQUEST);
		
	}
	
	
//	/*
//	 * Name: validationException
//	 * Description: This exception will be handled if user inputs are not valid.
//	 */
//	@ExceptionHandler(ValidationException.class)
//	public final ResponseEntity<ErrorMessage> validationException(ValidationException ex){
//
//		ErrorMessage exceptionResponse =
//				new ErrorMessage(ex.getMessage(), 
//						"Invalid input.",currentTimeMillis);
//		return new ResponseEntity<ErrorMessage>(exceptionResponse,
//				new HttpHeaders(),HttpStatus.NOT_FOUND);
//	}
	
//	
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Set<String> handleValidationExceptions(
//	  MethodArgumentNotValidException ex) {
//	   // Map<String, String> errors = new HashMap<>();
//	    Set<String> errors = new HashSet<String>();
//	    ex.getBindingResult().getAllErrors().forEach((error) -> {
//	        String fieldName = ((FieldError) error).getField();
//	        String errorMessage = error.getDefaultMessage();
//	        errors.add(errorMessage);
//	      //  errors.put(fieldName, errorMessage);
//	    });
//	    return errors;
//	}
	
	/*
	 * Name: validationException
	 * Description: This exception will be handled if request comes with null values.
	 */
	@ExceptionHandler(NullParameterException.class)
	public final ResponseEntity<ErrorMessage> nullParameter(NullParameterException ex){

		ErrorMessage exceptionResponse =
				new ErrorMessage(ex.getMessage(), 
						errorMsg,currentTimeMillis);
		return new ResponseEntity<ErrorMessage>(exceptionResponse,
				new HttpHeaders(),HttpStatus.NOT_FOUND);
	}
	
	
	
	/*
	 * Name: validationException
	 * Description: This exception will be handled if the requested user in not their in database.
	 */
	@ExceptionHandler(AddressNotFound.class)
	public final ResponseEntity<ErrorMessage> addressNotFound(AddressNotFound ex){

		ErrorMessage exceptionResponse =
				new ErrorMessage(ex.getMessage(), 
						errorMsg,currentTimeMillis);
		return new ResponseEntity<ErrorMessage>(exceptionResponse,
				new HttpHeaders(),HttpStatus.NOT_FOUND);
	}
	
	
}


class ErrorMessage{
	private String message;
	private String details;
	private long timestamp;
	
	public ErrorMessage() {}
	
	
	
	public ErrorMessage(String message, String details, long timestamp) {
		super();
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}



	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}



	public long getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}