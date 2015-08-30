/**
 * 
 */
package com.epam.aircompany.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Dzmitry Hrushetski
 *
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
	private static Pattern pattern;
	private static Matcher matcher;

	/* initializes the ResourceBundle instance */
	static {
		REGEX_BOUNDLE = ResourceBundle.getBundle("regExp");
	}
	
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
	 * Validates the entered password.
	 * 
	 * @param password
	 *            the password to validate
	 * @return {@code true} when entered password passes validation and
	 *         {@code false} otherwise
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
}
