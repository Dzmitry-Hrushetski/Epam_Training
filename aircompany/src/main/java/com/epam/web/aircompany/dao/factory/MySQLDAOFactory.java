/**
 * 
 */
package com.epam.web.aircompany.dao.factory;

import com.epam.web.aircompany.bean.Employee;
import com.epam.web.aircompany.bean.Entity;
import com.epam.web.aircompany.dao.AbstractDAO;
import com.epam.web.aircompany.dao.IDAO;
import com.epam.web.aircompany.dao.mysqldao.MySQLAirportDAO;
import com.epam.web.aircompany.dao.mysqldao.MySQLDAOType;
import com.epam.web.aircompany.dao.mysqldao.MySQLEmployeeDAO;


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
	
	public AbstractDAO getMySQLDAO(MySQLDAOType typeDAO) {
		
		switch(typeDAO) {
		case EMPLOYEE:
			return new MySQLEmployeeDAO(null);
		case AIRPORT:
			return new MySQLAirportDAO(null);
			//break;
		}
		return null;	
	}
}