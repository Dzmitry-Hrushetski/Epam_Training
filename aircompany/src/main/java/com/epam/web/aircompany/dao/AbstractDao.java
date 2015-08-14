/**
 * 
 */
package com.epam.web.aircompany.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;


/**
 * @author Dzmitry Hrushetski
 *
 */
public abstract class AbstractDao {
	private static final Logger LOG = Logger.getLogger(AbstractDao.class);
	protected Connection connection;

	/**
	 * 
	 */
	public AbstractDao(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Closes the opened statement.
	 * 
	 * @param statement
	 *            java.sql.Statement
	 */
	public void close(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException ex) {
			LOG.error("Error. Unable to close statement!");
		}
	}
}
