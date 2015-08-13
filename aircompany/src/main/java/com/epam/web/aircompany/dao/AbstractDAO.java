/**
 * 
 */
package com.epam.web.aircompany.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.web.aircompany.bean.Entity;

/**
 * @author Dzmitry Hrushetski
 *
 */
public abstract class AbstractDAO {
	private static final Logger LOG = Logger.getLogger(AbstractDAO.class);
	protected Connection connection;
	
	/**
	 * @param connection
	 */
	public AbstractDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	

	/**
	 * Closes the opened statement.
	 * 
	 * @param statement
	 *            java.sql.Statement
	 * @throws DAOException
	 *             If a there was an error while statement closing.
	 */
	public void close(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException ex) {
			LOG.error("Error. Unable to close statement.");
		}
	}
}
