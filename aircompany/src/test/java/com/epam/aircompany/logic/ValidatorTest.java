package com.epam.aircompany.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.epam.aircompany.util.Validator;

/**
 * The Class ValidatorTest is used for testing methods of
 * com.epam.aircompany.util.Validator class.
 *
 * @author Dzmitry Hrushetski
 * 
 * @see com.epam.aircompany.util.Validator
 */
public class ValidatorTest {
	private ArrayList<String> validPhone = new ArrayList<String>();
	private ArrayList<String> invalidPhone = new ArrayList<String>();
	private ArrayList<String> validDate = new ArrayList<String>();
	private ArrayList<String> invalidDate = new ArrayList<String>();

	
	/**
	 * Sets the up validate phone.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUpValidatePhone() throws Exception {
		validPhone.add("+375291233800");
		validPhone.add("+375251572210");
		validPhone.add("+375447892210");
		
		invalidPhone.add("+91291233800");
		invalidPhone.add("+37525x157221");
		invalidPhone.add("+3754478922109");
	}
	
	/**
	 * Sets the up validate date format.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUpValidateDateFormat() throws Exception {
		validDate.add("2015-08-15");
		validDate.add("2014-01-09");
		validDate.add("2015-12-30");
		
		invalidDate.add("20x5-08-15");
		invalidDate.add("2014-91-09");
		invalidDate.add("2015-12-32");
	}

	/**
	 * Test validate phone.
	 */
	@Test
	public void testValidatePhone() {
		for(String phone: validPhone) {
			boolean valid = Validator.validatePhone(phone);
			assertTrue(valid);
		}
		
		for(String phone: invalidPhone) {
			boolean valid = Validator.validatePhone(phone);
			assertFalse(valid);
		}
	}

	/**
	 * Test validate date format.
	 */
	@Test
	public void testValidateDateFormat() {
		for(String date: validDate) {
			boolean valid = Validator.validateDateFormat(date);
			assertTrue(valid);
		}
		
		for(String date: invalidDate) {
			boolean valid = Validator.validateDateFormat(date);
			assertFalse(valid);
		}
	}
}

