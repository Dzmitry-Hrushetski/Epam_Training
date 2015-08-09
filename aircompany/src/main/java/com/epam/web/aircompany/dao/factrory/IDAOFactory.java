/**
 * 
 */
package com.epam.web.aircompany.dao.factrory;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface IDAOFactory {
	
	public IDAOFactory getDAOFactory(DAOFactoryType factoryType);

}
