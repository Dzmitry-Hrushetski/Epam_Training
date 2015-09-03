package com.epam.aircompany.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class Validator contains various methods that allow to validate data
 * received from JSPs before inserting them into the database/updating the
 * database.
 *
 * @author Dzmitry Hrushetski
 */
public class Validator {
	private static final ResourceBundle REGEX_BOUNDLE;
	private static final String USER_NAME = "email";
	private static final String PASSWORD = "password";
	private static final String PHONE = "phone";
	private static final String DATE = "date";
	private static final String DATE_TIME = "date_time";
	private static final int MAX_LENGTH_USER_NAME = 50;
	private static final int MAX_LENGTH_PASSWORD = 25;
	private static final String DATE_FORMAT="yyyy-MM-dd";
	private static final String DATE_TIME_FORMAT="yyyy-MM-dd HH:mm:ss";
	private static final String PARAM_FIRST_NAME = "first_name";
	private static final String PARAM_LAST_NAME = "last_name";
	private static final String PARAM_PHONE = "phone";
	private static final String PARAM_ADDRESS = "addres";
	private static final String PARAM_USER_NAME = "user_name";
	private static final String PARAM_PASSWORD = "password";
	private static final String PARAM_START_DATE = "calendar";
	private static final int MAX_LENGTH_NAME = 50;
	private static final int MAX_LENGTH_ADDRESS = 80;
	private static Pattern pattern;
	private static Matcher matcher;

	/* initializes the ResourceBundle instance */
	static {
		REGEX_BOUNDLE = ResourceBundle.getBundle("regExp");
	}
	
	/**
	 * Validate phone number.
	 *
	 * @param phone the phone number
	 * @return true, if successful
	 */
	public static boolean validatePhone(String phone) {
		boolean dataOk = false;
		String regExp = REGEX_BOUNDLE.getString(PHONE);
		pattern = Pattern.compile(regExp);

		if (phone != null && !phone.isEmpty()) {
			matcher = pattern.matcher(phone);
			dataOk = matcher.matches();
			matcher.reset();
		}
		return dataOk;
	}
	
	/**
	 * Validate password.
	 *
	 * @param password the password
	 * @return true, if successful
	 */
	public static boolean validatePassword(String password) {
		boolean dataOk = false;
		String regExp = REGEX_BOUNDLE.getString(PASSWORD);
		pattern = Pattern.compile(regExp);

		if (password != null && !password.isEmpty() && password.length() <= MAX_LENGTH_PASSWORD) {
			matcher = pattern.matcher(password);
			dataOk = matcher.matches();
			matcher.reset();
		}
		return dataOk;
	}
	
	/**
	 * Validate user name.
	 *
	 * @param userName the user e-mail
	 * @return true, if successful
	 */
	/* Validates the entered user_name (e-mail) */
	public static boolean validateUserName(String userName) {
		boolean dataOk = false;
		String regExp = REGEX_BOUNDLE.getString(USER_NAME);
		pattern = Pattern.compile(regExp);

		if (userName != null && !userName.isEmpty() && userName.length() <= MAX_LENGTH_USER_NAME) {
			matcher = pattern.matcher(userName);
			dataOk = matcher.matches();
			matcher.reset();
		}
		return dataOk;
	}

	/**
	 * Validate employee data.
	 *
	 * @param userName the user e-mail
	 * @param pass the password
	 * @param tel the phone number
	 * @param startDate the start date
	 * @return true, if successful
	 */
	public static boolean validateEmployeeData(String userName,	String pass, String tel, String startDate) {
		
		if(!validateUserName(userName)) {
			return false;
		}
		
		if(!validatePassword(pass)) {
			return false;
		}
		
		if(!validatePhone(tel)) {
			return false;
		}
		
		if(!validateDateFormat(startDate)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Validate date format.
	 *
	 * @param date the date
	 * @return true, if successful
	 */
	public static boolean validateDateFormat(String date) {
		boolean isOk = false;
		
		String regExp = REGEX_BOUNDLE.getString(DATE);
		pattern = Pattern.compile(regExp);

		if (date != null && !date.isEmpty()) {
			matcher = pattern.matcher(date);
			isOk = matcher.matches();
			matcher.reset();
		}
		if (isOk) {
			isOk = false;
			SimpleDateFormat formattedDate = new SimpleDateFormat(DATE_FORMAT);
			try {
				formattedDate.parse(date);
				isOk = true;
			} catch (ParseException e) {
			}
		}
		return isOk;
	}
	
	/**
	 * Validate date/time format.
	 *
	 * @param date the date/time
	 * @return true, if successful
	 */
	public static boolean validateDateTimeFormat(String date) {
		boolean isOk = false;
		String regExp = REGEX_BOUNDLE.getString(DATE_TIME);
		pattern = Pattern.compile(regExp);

		if (date != null && !date.isEmpty()) {
			matcher = pattern.matcher(date);
			isOk = matcher.matches();
			matcher.reset();
		}
		if (isOk) {
			isOk = false;
			SimpleDateFormat formattedDate = new SimpleDateFormat(DATE_TIME_FORMAT);
			try {
				formattedDate.parse(date);
				isOk = true;
			} catch (ParseException e) {
			}
		}
		return isOk;
	}
	
	/**
	 * Validate employee data.
	 *
	 * @param employeeData the full employee data
	 * 
	 * @return true, if successful
	 */

	public static boolean validateEmployeeData(HashMap<String, String> employeeData) {
		String paramData = employeeData.get(PARAM_FIRST_NAME);
		if(paramData.isEmpty() || paramData.length()>MAX_LENGTH_NAME) {
			return false;
		}
		
		paramData = employeeData.get(PARAM_LAST_NAME);
		if(paramData.isEmpty() || paramData.length()>MAX_LENGTH_NAME) {
			return false;
		}
		
		paramData = employeeData.get(PARAM_ADDRESS);
		if(paramData.isEmpty() || paramData.length()>MAX_LENGTH_ADDRESS) {
			return false;
		}
		
		if(!validateUserName(employeeData.get(PARAM_USER_NAME))) {
			return false;
		}
		
		if(!validatePassword(employeeData.get(PARAM_PASSWORD))) {
			return false;
		}
		
		if(!validatePhone(employeeData.get(PARAM_PHONE))) {
			return false;
		}
		
		if(!validateDateFormat(employeeData.get(PARAM_START_DATE))) {
			return false;
		}
		return true;
	}
}
