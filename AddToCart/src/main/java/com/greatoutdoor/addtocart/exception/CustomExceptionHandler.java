package com.greatoutdoor.addtocart.exception;



import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public final ResponseEntity<ApiError> somethingWentWrong(NullPointerException ex){
		
		ApiError error = new ApiError();
		error.setException(" " + "Please enter details");
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(error, status);
		
	}
	
	@ExceptionHandler(value = NullParameterException.class)
	public ResponseEntity<ApiError> handlingNoValueFoundException(NullParameterException e) {
		ApiError error = new ApiError();
		error.setException(" " + e.getMessage());
		HttpStatus status = HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(error, status);
	}

	@ExceptionHandler(value = CrudException.class)
	public ResponseEntity<ApiError> handlingNotPossibleException(CrudException e) {
		ApiError error = new ApiError();
		error.setException(" " + e.getMessage());
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(error, status);
	}
	
	@ExceptionHandler(value = CartNotFoundException.class)
	public ResponseEntity<ApiError> handlingNotPossibleException(CartNotFoundException e) {
		ApiError error = new ApiError();
		error.setException(" " + e.getMessage());
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(error, status);
	}
	
	@ExceptionHandler(value = OrderNotFoundException.class)
	public ResponseEntity<ApiError> handlingNotPossibleException(OrderNotFoundException e) {
		ApiError error = new ApiError();
		error.setException(" " + e.getMessage());
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(error, status);
	}
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<ApiError> handlingNotPossibleException(ProductNotFoundException e) {
		ApiError error = new ApiError();
		error.setException(" " + e.getMessage());
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
	
	

}
