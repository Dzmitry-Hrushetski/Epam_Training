/**
 * 
 */
package com.epam.aircompany.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class ConnectionPool {
	private static final Logger LOG = Logger.getLogger(ConnectionPool.class);
	private static final String DB_PROPERTIES_FILE_NAME = "mysql_db";
	private static final String USER = "user";
	private static final String PASSWORD = "password";
	private static final String AUTO_RECONNECT = "autoReconnect";
	private static final String CHARACTER_ENCODING = "characterEncoding";
	private static final String USE_UNICODE = "useUnicode";
	private static final String DB_URL = "url";
	private static final String DB_DRIVER = "driver";
	private static final ReentrantLock LOCK = new ReentrantLock(true);
	private ResourceBundle rb;
	private Properties prop;
	private String dbUrl;
	private String driver;
	private int poolSize;
	private int currentPoolSize;
	private LinkedBlockingQueue<Connection> dbConnections;
	
	private static class ConnectionPoolHolder {
		private static final ConnectionPool POOL = new ConnectionPool();
	}
	
	private ConnectionPool() {
		try {
			rb = ResourceBundle.getBundle(DB_PROPERTIES_FILE_NAME);
			poolSize = Integer.parseInt(rb.getString("poolsize"));
			dbConnections = new LinkedBlockingQueue<Connection>(poolSize);
			
			dbUrl = rb.getString(DB_URL);
			driver = rb.getString(DB_DRIVER);
								
			prop = new Properties();
			prop.put(USER, rb.getString(USER));
			prop.put(PASSWORD, rb.getString(PASSWORD));
			prop.put(AUTO_RECONNECT, rb.getString(AUTO_RECONNECT));
			prop.put(CHARACTER_ENCODING, rb.getString(CHARACTER_ENCODING));
			prop.put(USE_UNICODE, rb.getString(USE_UNICODE));
			
		} catch (MissingResourceException ex) {
			String errorMessage = String.format("Error. The resource %s file isn't found or file bad", DB_PROPERTIES_FILE_NAME);
			LOG.fatal(errorMessage,ex);
			throw new RuntimeException(errorMessage, ex);
		} 
	}

	/**
	 * Returns the only instance of ConnectionPool
	 * 
	 * @return com.epam.aircompany.pool.ConnectionPool
	 */
	public static ConnectionPool getInstance() {
		return ConnectionPoolHolder.POOL;
	}
	
	/**
	 * Takes a database connection from pool
	 * 
	 * @return java.sql.Connection
	 * @throws ConnectionPoolException 
	 */
	public Connection getConnection() throws ConnectionPoolException {
		Connection connection = null;

		LOCK.lock();
		try {
			if (dbConnections.isEmpty() && currentPoolSize < poolSize) {
				connection = createConnection();
			} else {
				connection = dbConnections.take();
			}
		} catch (InterruptedException exception) {
			LOG.error("Error. A waiting thread was interrupted");
		} finally {
			LOCK.unlock();
		}

		return connection;
	}

	/**
	 * Releases a database connection by returning it to the pool
	 * 
	 * @param connection
	 *            Connection that was previously taken
	 * @return {@code true} if Connection was successfully returned to the pool,
	 *         and {@code false} otherwise.
	 */
	public boolean releaseConnection(Connection connection) {
		boolean isReleased = false;

		if (connection != null) {
			try {
				/* puts the Connection into the pool */
				dbConnections.put(connection);
				isReleased = true;
			} catch (InterruptedException exception) {
				LOG.error("Error. A waiting thread was interrupted");
			}
		}
		return isReleased;
	}

	/**
	 * Closes all initialized database connections
	 * 
	 * @return {@code true} if all DB Connections were closed and {@code false}
	 *         otherwise.
	 */
	public boolean closeAllConnections() {
		boolean areClosed = false;

		try {
			/* closing all connections by iterating over the pool */
			for (Connection connection : dbConnections) {
				connection.close();
			}
			areClosed = true;
		} catch (SQLException exception) {
			LOG.error("Error. Unable to close connection");
		}
		return areClosed;
	}

	private Connection createConnection() throws ConnectionPoolException {
		Connection connection = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(dbUrl, prop);
			currentPoolSize++;
		} catch (SQLException | ClassNotFoundException e) {
			//LOG.error("Error. Unable to create connection");
			throw new ConnectionPoolException("Error. Unable to create connection",e);
		}
		return connection;
	}
}