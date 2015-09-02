package com.epam.aircompany.pool;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.Test;

/**
 * The Class ConnectionPoolTest is used for testing the correct
 * initialization of ConnectionPool and correct operation of getConnection()
 * method.
 *
 * @author Dzmitry Hrushetski
 */
public class ConnectionPoolTest {
	private ConnectionPool pool;
	private Connection connection;

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		if(connection != null) {
			pool.releaseConnection(connection);
			pool.closeAllConnections();
		}
	}

	/**
	 * Test get instance.
	 */
	@Test
	public void testGetInstance() {
		pool = ConnectionPool.getInstance();
		assertNotNull(pool);
	}

	/**
	 * Test get connection.
	 *
	 * @throws ConnectionPoolException the connection pool exception
	 */
	@Test
	public void testGetConnection() throws ConnectionPoolException {
		pool = ConnectionPool.getInstance();
		connection = pool.getConnection();
		assertNotNull(connection);
	}
}
