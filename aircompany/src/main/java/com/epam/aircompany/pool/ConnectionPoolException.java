package com.epam.aircompany.pool;

/**
 * The Class ConnectionPoolException represents a create ConnectionPool exception.
 *
 * @author Dzmitry Hrushetski
 */
public class ConnectionPoolException extends Exception {
	private static final long serialVersionUID = -1336821047092818599L;

	/**
	 * Constructs a ConnectionPoolException with the given details message.
	 * 
	 * @param message
	 *            The details message of ConnectionPoolException.
	 */
	public ConnectionPoolException(String message) {
		super(message);
	}

	/**
	 * Constructs a ConnectionPoolException with the given root cause.
	 * 
	 * @param cause
	 *            The root cause of ConnectionPoolException.
	 */
	public ConnectionPoolException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a ConnectionPoolException with the given details message and root
	 * cause.
	 * 
	 * @param message
	 *            The details message of ConnectionPoolException.
	 * @param cause
	 */           
	public ConnectionPoolException(String message, Throwable cause) {
		super(message, cause);
	}
}
