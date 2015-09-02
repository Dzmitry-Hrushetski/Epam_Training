package com.epam.aircompany.logic;

/**
 * The Class LogicException represents a general Logic exception.
 *
 * @author Dzmitry Hrushetski
 */
public class LogicException extends Exception {
	private static final long serialVersionUID = -5101468583994727585L;

	/**
	 * Constructs a LogicException with the given details message.
	 * 
	 * @param message
	 *            The details message of LogicException.
	 */
	public LogicException(String message) {
		super(message);
	}

	/**
	 * Constructs a LogicException with the given root cause.
	 * 
	 * @param cause
	 *            The root cause of LogicException.
	 */
	public LogicException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a LogicException with the given details message and root
	 * cause.
	 * 
	 * @param message
	 *            The details message of LogicException.
	 * @param cause
	 *            The root cause of LogicException.
	 */
	public LogicException(String message, Throwable cause) {
		super(message, cause);
	}
}
