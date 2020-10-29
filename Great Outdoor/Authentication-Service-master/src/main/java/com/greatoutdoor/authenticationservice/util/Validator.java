package com.greatoutdoor.authenticationservice.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.greatoutdoor.authenticationservice.exception.ValidationException;



/*
 * Name:Validator
 * Description: It will validate phone number and password of a new user else throw an exception.
 * Note: password must contains 7 characters alphanumeric values, upper case and special characters and number must have 10 digits numeric value.
 */
@Component
public class Validator {
	private static final Logger logger = Logger.getLogger(Validator.class);
	public boolean checkPassword(String password) {
		String passCheck[]= new String[4];
		boolean check = true;
		if(password.length()<8)check=false;
		passCheck[0] = ".*[a-z]+.*";
		passCheck[1] = ".*[A-Z]+.*";
		passCheck[2] = ".*[0-9]+.*";
		passCheck[3] = ".*[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*";
		for (String regex : passCheck) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(password);
			if(!matcher.matches())check=false;
			
		}
		if(check==false) {
			logger.error("Invalid password!!");
			throw new ValidationException("Entered password should contains alphanumeric values, upper case and special characters!");
		}
		return check;
	}
	
	
	public boolean checkPhoneNumber(String number) {
		String numberCheck = "\\d+";
		if(number.matches(numberCheck) && number.length()==10) {
			return true;
		}
		logger.error("Invalid number Entered number should be of 10 numeric digits.");
		throw new ValidationException("Invalid number!! Entered number should be 10 digits numeric value.");
		
	}
}
