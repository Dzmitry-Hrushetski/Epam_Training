/**
 * 
 */
package com.epam.aircompany.exeption;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class LogicalExeption extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public LogicalExeption() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public LogicalExeption(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LogicalExeption(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public LogicalExeption(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public LogicalExeption(Throwable cause) {
		super(cause);
	}
	
	
	

}
