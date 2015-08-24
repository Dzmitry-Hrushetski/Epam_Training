/**
 * 
 */
package com.epam.aircompany.dao.factory;

import com.epam.aircompany.dao.IDao;
import com.epam.aircompany.dao.mysqldao.MySQLDao;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class DatabaseFactory {
	
	private static class DatabaseFactoryHolder {
		private static final DatabaseFactory DATABASE_FACTORY = new DatabaseFactory();
	}
	
	private DatabaseFactory() {	
	}

	public static DatabaseFactory getInstance() {
		return DatabaseFactoryHolder.DATABASE_FACTORY;
	}
	
	public IDao getDatabaseDao(DaoFactoryType typeDatabaseDao) {
		
		switch (typeDatabaseDao) {
		case MYSQL:
			return new MySQLDao();
		default:
			throw new EnumConstantNotPresentException(DaoFactoryType.class,	typeDatabaseDao.name());
		}
	}
}
