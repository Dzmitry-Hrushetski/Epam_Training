/**
 * 
 */
package com.epam.web.aircompany.command;

import java.sql.Connection;
import java.util.List;

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
	private static final String PARAM_NOT_VALID = "not_valid";
	private static final String PARAM_INCORRECT = "incorrect";
	private static final String PARAM_EMPLOYEE_LIST = "employee_list";
	private static final String URL_LOGIN = "login";
	private static final String URL_CHEEF = "cheef";
	private static final String URL_ADMIN = "admin";
	private static final String URL_MANAGER = "manager";
	private static final int CHEEF = 1;
	private static final int ADMIN = 2;
	private static final int MANAGER = 3;
	
	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request, ConnectionPool connectionPool, IDao databaseDao) {
		String url = COMMAND_BOUNDLE.getString(URL_LOGIN);
		Connection connection = connectionPool.getConnection();		
		IEmployeeDao iEmployee = databaseDao.getIEmployeeDao(connection);
		String userName = request.getParameter(PARAM_USER_NAME);
		String password = request.getParameter(PARAM_PASSWORD);
		String language = request.getParameter(PARAM_LANGUAGE);
		
			
		try {
			if(Validator.validateUserName(userName) && Validator.validatePassword(password)) {
				Employee employee = iEmployee.findEmployeeByUserName(userName);
				if(employee!= null && password.equals(employee.getPassword())) {
					HttpSession session = request.getSession();
					session.setAttribute(PARAM_LANGUAGE, language);
					
					url = findURL(employee);
					preparationJspData(request, iEmployee, employee);
					
				} else {
					request.setAttribute(PARAM_USER_NAME, userName);
					request.setAttribute(PARAM_INCORRECT, true);
					LOG.info("The user with such email doesn't exist or the password wrong.");
				}
			} else {
				request.setAttribute(PARAM_USER_NAME, userName);
				request.setAttribute(PARAM_NOT_VALID, true);
				LOG.info("Login or password not valid.");
			}
		} catch (DaoException e) {
			
		} finally {
			connectionPool.releaseConnection(connection);
		}
		return url;
	}

	/**
	 * @param request
	 * @param iEmployee 
	 * @param employee
	 * @throws DaoException 
	 */
	private void preparationJspData(HttpServletRequest request, IEmployeeDao iEmployee, Employee employee) throws DaoException {
		List<Employee> employeeList=null;
		
		switch(employee.getPosition().getId()) {
		case CHEEF:
			employeeList = iEmployee.findAll();
			request.setAttribute(PARAM_EMPLOYEE_LIST, employeeList);
			break;
		case ADMIN:
			
			break;
		case MANAGER:
			
			break;
		}
		
	}

	private String findURL(Employee employee) {
		String url=null;
		
		switch(employee.getPosition().getId()) {
		case CHEEF:
			url = COMMAND_BOUNDLE.getString(URL_CHEEF);
			break;
		case ADMIN:
			url = COMMAND_BOUNDLE.getString(URL_ADMIN);
			break;
		case MANAGER:
			url = COMMAND_BOUNDLE.getString(URL_MANAGER);
			break;
		}
		return url;
	}
}
