/**
 * 
 */
package com.epam.web.aircompany.command;

import javax.servlet.http.HttpServletRequest;

import com.epam.web.aircompany.dao.AbstractDAO;
import com.epam.web.aircompany.dao.factory.AbstractDAOFactory;
import com.epam.web.aircompany.dao.factory.DAOFactoryType;
import com.epam.web.aircompany.dao.factory.MySQLDAOFactory;
import com.epam.web.aircompany.dao.mysqldao.MySQLDAOType;
import com.epam.web.aircompany.dao.mysqldao.MySQLEmployeeDAO;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class LoginCommand implements ICommand {

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		
		MySQLDAOFactory factory = (MySQLDAOFactory)AbstractDAOFactory.getDAOFactory(DAOFactoryType.MYSQL);
		
		MySQLEmployeeDAO aDAO=(MySQLEmployeeDAO)factory.getMySQLDAO(MySQLDAOType.EMPLOYEE);
		
		// TODO Auto-generated method stub
		return null;
	}

}
