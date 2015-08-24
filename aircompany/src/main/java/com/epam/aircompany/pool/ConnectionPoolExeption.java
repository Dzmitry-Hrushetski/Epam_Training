/**
 * 
 */
package com.epam.aircompany.pool;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class ConnectionPoolExeption extends Exception {

	/**
	 * 
	 */
	public ConnectionPoolExeption() {
	}

	/**
	 * @param message
	 */
	public ConnectionPoolExeption(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ConnectionPoolExeption(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ConnectionPoolExeption(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ConnectionPoolExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
