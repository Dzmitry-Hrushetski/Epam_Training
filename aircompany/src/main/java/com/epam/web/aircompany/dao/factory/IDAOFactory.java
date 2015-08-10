/**
 * 
 */
package com.epam.web.aircompany.dao.factory;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface IDAOFactory {
	
	public IDAOFactory getDAOFactory(DAOFactoryType factoryType);

}
