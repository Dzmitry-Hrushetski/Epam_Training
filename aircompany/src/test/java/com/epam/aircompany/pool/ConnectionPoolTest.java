/**
 * 
 */
package com.epam.aircompany.pool;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.Test;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class ConnectionPoolTest {
	private ConnectionPool pool;
	private Connection connection;

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		if(connection != null) {
			pool.releaseConnection(connection);
			pool.closeAllConnections();
		}
	}

	/**
	 * Test method for {@link com.epam.aircompany.pool.ConnectionPool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		pool = ConnectionPool.getInstance();
		assertNotNull(pool);
	}

	/**
	 * Test method for {@link com.epam.aircompany.pool.ConnectionPool#getConnection()}.
	 * @throws ConnectionPoolException 
	 */
	@Test
	public void testGetConnection() throws ConnectionPoolException {
		pool = ConnectionPool.getInstance();
		connection = pool.getConnection();
		assertNotNull(connection);
	}
}
