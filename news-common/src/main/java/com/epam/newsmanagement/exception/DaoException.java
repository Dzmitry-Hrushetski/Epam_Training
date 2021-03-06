package com.epam.newsmanagement.exception;

/**
 * Class DAOException represents a general DAO exception. It should wrap
 * any exception of the underlying code, such as SQLExceptions.
 *
 * @author Dzmitry Hrushetski
 *
 */
public class DaoException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a DAOException with the given details message.
	 * 
	 * @param message
	 *            The details message of DAOException.
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * Constructs a DAOException with the given root cause.
	 * 
	 * @param cause
	 *            The root cause of DAOException.
	 */
	public DaoException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a DAOException with the given details message and root cause.
	 * 
	 * @param message
	 *            The details message of DAOException.
	 * @param cause
	 *            The root cause of DAOException.
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}
}
