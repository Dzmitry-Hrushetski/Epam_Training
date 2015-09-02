package com.epam.aircompany.dao.factory;

import com.epam.aircompany.dao.IDao;
import com.epam.aircompany.dao.mysqldao.MySQLDao;


/**
 * A factory for creating Database objects.
 * 
 *  @author Dzmitry Hrushetski
 */
public class DatabaseFactory {
	
	/**
	 * The Class DatabaseFactoryHolder.
	 *
	 * @author Dzmitry Hrushetski
	 */
	private static class DatabaseFactoryHolder {
		private static final DatabaseFactory DATABASE_FACTORY = new DatabaseFactory();
	}
	
	/**
	 * Instantiates a new database factory.
	 */
	private DatabaseFactory() {	
	}

	/**
	 * Gets the single instance of DatabaseFactory.
	 *
	 * @return single instance of DatabaseFactory
	 */
	public static DatabaseFactory getInstance() {
		return DatabaseFactoryHolder.DATABASE_FACTORY;
	}
	
	/**
	 * Gets the database DAO.
	 *
	 * @param typeDatabaseDao the type of database DAO
	 * @return the database DAO
	 */
	public IDao getDatabaseDao(DaoFactoryType typeDatabaseDao) {
		
		switch (typeDatabaseDao) {
		case MYSQL:
			return new MySQLDao();
		default:
			throw new EnumConstantNotPresentException(DaoFactoryType.class,	typeDatabaseDao.name());
		}
	}
}
