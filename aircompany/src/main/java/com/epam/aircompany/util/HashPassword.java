package com.epam.aircompany.util;

import org.apache.commons.codec.digest.DigestUtils;

public class HashPassword {
	public static String calculateHashPassword(String st) {
	    String md5Hex = DigestUtils.md5Hex(st);
	    return md5Hex;
	}
}
