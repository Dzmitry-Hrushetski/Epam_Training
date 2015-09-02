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
 * The Class ConnectionPool provides a thread-safe pool of connections to
 * MySQL database. The pool is constructed using Singleton design pattern. 
 * Database properties are stored in
 * a separate file. The size of the pool is limited. It contains methods for
 * extracting and releasing DB connections.
 *
 * @author Dzmitry Hrushetski
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
	
	/**
	 * The Class ConnectionPoolHolder.
	 *
	 * @author Dzmitry Hrushetski
	 */
	private static class ConnectionPoolHolder {
		private static final ConnectionPool POOL = new ConnectionPool();
	}
	
	/**
	 * Instantiates a new connection pool.
	 */
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
	 * Gets the single instance of ConnectionPool.
	 *
	 * @return single instance of ConnectionPool
	 */
	public static ConnectionPool getInstance() {
		return ConnectionPoolHolder.POOL;
	}
	
	/**
	 * Gets the connection.
	 *
	 * @return Connection
	 * @throws ConnectionPoolException the connection pool exception
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
	 * Release connection.
	 *
	 * @param connection the Connection
	 * @return true, if successful
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
	 * Close all connections.
	 *
	 * @return true, if successful
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

	/**
	 * Creates the connection.
	 *
	 * @return Connection
	 * @throws ConnectionPoolException the connection pool exception
	 */
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