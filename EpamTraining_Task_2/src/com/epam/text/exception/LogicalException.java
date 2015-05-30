/**
 * 
 */
package com.epam.text.exception;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class LogicalException extends Exception {
	private static final long serialVersionUID = 1L;

	public LogicalException() {
	}

	/**
	 * @param message
	 */
	public LogicalException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public LogicalException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LogicalException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public LogicalException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
