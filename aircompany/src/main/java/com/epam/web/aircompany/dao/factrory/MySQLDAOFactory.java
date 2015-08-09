/**
 * 
 */
package com.epam.web.aircompany.dao.factrory;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class MySQLDAOFactory extends AbstractDAOFactory {

	private static class MySQLDAOFactorHolder {
		private static final MySQLDAOFactory DAO_FACTORY = new MySQLDAOFactory();
	}
	
	private MySQLDAOFactory() {
		
	}
	
	public static MySQLDAOFactory getInstance() {
		return MySQLDAOFactorHolder.DAO_FACTORY;
	}
}
