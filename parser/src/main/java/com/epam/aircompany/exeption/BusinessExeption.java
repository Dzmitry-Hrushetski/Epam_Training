/**
 * 
 */
package com.epam.aircompany.exeption;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class BusinessExeption extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public BusinessExeption() {
		super();
	}

	/**
	 * @param message
	 */
	public BusinessExeption(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public BusinessExeption(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BusinessExeption(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public BusinessExeption(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
