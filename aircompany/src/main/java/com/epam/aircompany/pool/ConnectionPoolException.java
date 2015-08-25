/**
 * 
 */
package com.epam.aircompany.pool;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class ConnectionPoolException extends Exception {

	/**
	 * 
	 */
	public ConnectionPoolException() {
	}

	/**
	 * @param message
	 */
	public ConnectionPoolException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ConnectionPoolException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ConnectionPoolException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ConnectionPoolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
