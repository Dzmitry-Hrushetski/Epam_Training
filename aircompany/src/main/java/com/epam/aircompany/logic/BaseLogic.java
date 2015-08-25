/**
 * 
 */
package com.epam.aircompany.logic;

import java.sql.Connection;

import com.epam.aircompany.dao.IDao;
import com.epam.aircompany.dao.factory.DaoFactoryType;
import com.epam.aircompany.dao.factory.DatabaseFactory;
import com.epam.aircompany.pool.ConnectionPool;

/**
 * @author Dzmitry Hrushetski
 *
 */
public abstract class BaseLogic {
	
	public ConnectionPool connectionPool;
	public Connection connection;
	public IDao databaseDao;

	/**
	 * 
	 */
	public BaseLogic() {
		connectionPool = ConnectionPool.getInstance();
		databaseDao = DatabaseFactory.getInstance().getDatabaseDao(DaoFactoryType.MYSQL);
	}
}
