package com.greatoutdoor.productmanagementsystem.exception;

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


/*
 * Name: CustomExceptionHandler
 * Description: Common exception handler for all the controllers.
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	private long currentTimeMillis = System.currentTimeMillis();
	private String errorMsg = "Some thing went wrong!";
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ApiError> somethingWentWrong(Exception e){
		
		ApiError error = new ApiError();
		error.setException(" " + e.getLocalizedMessage());
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(error, status);
		
	}
	
	
	/*
	 * Name: validationException
	 * Description: This exception will be handled if request comes with null values.
	 */
	@ExceptionHandler(NullParameterException.class)
	public final ResponseEntity<ApiError> nullParameter(NullParameterException e){

		ApiError error = new ApiError();
		error.setException(" " + e.getLocalizedMessage());
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(error, status);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleValidationExceptions(MethodArgumentNotValidException e) {
		ApiError error = new ApiError();
		error.setException(" " + e.getLocalizedMessage());
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(error, status);
	}
	
	/*
	 * Name: validationException
	 * Description: This exception will be handled if request comes with null values.
	 */
//	@ExceptionHandler(ValidationException.class)
//	public final ResponseEntity<ErrorMessage> validationParameter(ValidationException ex){
//
//		ErrorMessage exceptionResponse =
//				new ErrorMessage(ex.getMessage(), 
//						errorMsg,currentTimeMillis);
//		return new ResponseEntity<ErrorMessage>(exceptionResponse,
//				new HttpHeaders(),HttpStatus.NOT_FOUND);
//	}
//	
	
	/*
	 * Name: validationException
	 * Description: This exception will be handled if the requested user in not their in database.
	 */
	@ExceptionHandler(ProductNotFoundException.class)
	public final ResponseEntity<ApiError> userNotFoundException(ProductNotFoundException e){

		ApiError error = new ApiError();
		error.setException(" " + e.getLocalizedMessage());
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(error, status);
	}
	
	
}
//
//
//class ErrorMessage{
//	private String message;
//	private String details;
//	private long timestamp;
//	
//	public ErrorMessage() {}
//	
//	
//	
//	public ErrorMessage(String message, String details, long timestamp) {
//		super();
//		this.message = message;
//		this.details = details;
//		this.timestamp = timestamp;
//	}
//
//
//
//	public String getMessage() {
//		return message;
//	}
//	
//	public void setMessage(String message) {
//		this.message = message;
//	}
//	
//	public String getDetails() {
//		return details;
//	}
//	
//	public void setDetails(String details) {
//		this.details = details;
//	}
//
//
//
//	public long getTimestamp() {
//		return timestamp;
//	}
//
//
//
//	public void setTimestamp(long timestamp) {
//		this.timestamp = timestamp;
//	}
//	
//	
