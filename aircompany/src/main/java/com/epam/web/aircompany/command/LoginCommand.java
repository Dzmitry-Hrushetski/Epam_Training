/**
 * 
 */
package com.epam.web.aircompany.command;

import java.sql.Connection;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.web.aircompany.bean.Employee;
import com.epam.web.aircompany.connection.ConnectionPool;
import com.epam.web.aircompany.dao.DaoException;
import com.epam.web.aircompany.dao.IDao;
import com.epam.web.aircompany.dao.IEmployeeDao;
import com.epam.web.aircompany.logic.Validator;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class LoginCommand implements ICommand {
	private static final Logger LOG = Logger.getLogger(LoginCommand.class);
	private static final String PARAM_USER_NAME = "user_name";
	private static final String PARAM_PASSWORD = "password";
	private static final String PARAM_LANGUAGE = "locale";

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request, ConnectionPool connectionPool, IDao databaseDao) {
		Connection connection = connectionPool.getConnection();		
		IEmployeeDao iEmployee = databaseDao.getIEmployeeDao(connection);
		String userName = request.getParameter(PARAM_USER_NAME);
		String password = request.getParameter(PARAM_PASSWORD);
		String language = request.getParameter(PARAM_LANGUAGE);
		
			
		try {
			if(Validator.validateUserName(userName) && Validator.validatePassword(password)) {
				Employee employee = iEmployee.findEmployeeByUserName(userName);
				if(password.equals(employee.getPassword())) {
					
				}
			} else {
				
			}
			
			request.setAttribute(PARAM_USER_NAME, userName);
			request.setAttribute("is_fault", "Bab login");
			
		} catch (DaoException e) {
			
		} finally {
			connectionPool.releaseConnection(connection);
		}
		
		// TODO Auto-generated method stub
		return null;
	}

}
