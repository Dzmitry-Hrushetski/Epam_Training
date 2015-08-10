/**
 * 
 */
package com.epam.web.aircompany.dao.factory;

/**
 * @author Dzmitry Hrushetski
 *
 */
public abstract class AbstractDAOFactory {
	
	
	public static AbstractDAOFactory getDAOFactory(DAOFactoryType factoryType) {
		
		switch (factoryType) {
		case MYSQL:
			return MySQLDAOFactory.getInstance();
		default:
			throw new EnumConstantNotPresentException(DAOFactoryType.class,	factoryType.name());
		}
	}
}
