/**
 * 
 */
package com.epam.aircompany.logic;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class LogicException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5101468583994727585L;

	/**
	 * 
	 */
	public LogicException() {
	}

	/**
	 * @param message
	 */
	public LogicException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public LogicException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LogicException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public LogicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
