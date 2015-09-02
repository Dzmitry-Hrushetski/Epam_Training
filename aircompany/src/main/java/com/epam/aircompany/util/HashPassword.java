package com.epam.aircompany.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * The Class HashPassword contains methods for calculate hash password.
 *
 * @author Dzmitry Hrushetski
 */
public class HashPassword {
	
	/**
	 * Calculate hash password.
	 *
	 * @param password String
	 * @return String the hash string
	 */
	public static String calculateHashPassword(String password) {
	    String md5Hex = DigestUtils.md5Hex(password);
	    return md5Hex;
	}
}
