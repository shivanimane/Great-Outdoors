package com.greatoutdoor.retailerinventorymanagementsystem.utility;
/**
 * 
 * @author Deepali
 *
 */

import java.time.Duration;
import java.time.Period;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.greatoutdoor.retailerinventorymanagementsystem.exception.ExceptionConstants;



public class GoUtility {

	public static String getCategoryName(int categoryNumber) {
		switch (categoryNumber) {
		case 1: {return "CAMPING";}
		case 2: {return "GOLF";}
		case 3: {return "MOUNTAINEERING";}
		case 4: {return "OUTDOOR";}
		case 5: {return "PERSONAL";}
		default : {return "OTHER";}		
	}
}
	public static Period calculatePeriod(Calendar timestamp1, Calendar timestamp2) throws RuntimeException{
		if (timestamp1.getTime().after(timestamp2.getTime())) {
			throw new RuntimeException ("calculatePeriod - " + ExceptionConstants.INAPPROPRIATE_ARGUMENT_PASSED);
		}
		else {
			long days = Duration.between (timestamp1.toInstant(), timestamp2.toInstant()).toDays();
			int yearsElapsed = (int) (days / 365);
			int remainingDays = (int) (days % 365);
			int monthsElapsed = remainingDays / 30;
			int daysElapsed = remainingDays % 30;
			return Period.of (yearsElapsed, monthsElapsed, daysElapsed);
		}		
	}
	public static boolean comparePeriod (Period p1, Period p2) {
		if (p1.getYears() > p2.getYears()) {
			return true;
		} else if (p1.getYears() == p2.getYears()) {
			if (p1.getMonths() > p2.getMonths()) {
				return true;
			} else if (p1.getMonths() == p2.getMonths()) {
				if (p1.getDays() > p2.getDays()) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}