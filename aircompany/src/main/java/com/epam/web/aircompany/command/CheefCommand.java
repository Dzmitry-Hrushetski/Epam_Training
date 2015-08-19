/**
 * 
 */
package com.epam.web.aircompany.command;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.epam.web.aircompany.bean.Employee;
import com.epam.web.aircompany.connection.ConnectionPool;
import com.epam.web.aircompany.dao.DaoException;
import com.epam.web.aircompany.dao.IDao;
import com.epam.web.aircompany.dao.IEmployeeDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class CheefCommand implements ICommand {
	private static final String URL_CHEEF = "cheef";
	private static final String PARAM_EMPLOYEE_LIST = "employee_list";
	private static final String PARAM_POSITION_LIST = "position_list";
	private static final String PARAM_OPERATION = "operation";
	private static final String PARAM_EMPLOYEE = "employee";
	private static final String PARAM_POSITION = "position";

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest, com.epam.web.aircompany.connection.ConnectionPool, com.epam.web.aircompany.dao.IDao)
	 */
	@Override
	public String execute(HttpServletRequest request, ConnectionPool connectionPool, IDao databaseDao) {
		//String url = URL_BOUNDLE.getString(URL_CHEEF);
		Connection connection = connectionPool.getConnection();
		String operation = request.getParameter(PARAM_OPERATION);
		
		String language = request.getParameter("locale");
		
		/*if(operation == null || operation.isEmpty()) {
			
		}*/
		switch(operation) {
		case PARAM_POSITION:
			String position = request.getParameter(PARAM_POSITION);
			int positionId = Integer.parseInt(position);
			IEmployeeDao iEmployee = databaseDao.getIEmployeeDao(connection);
			
			try {
				List<Employee> employeeList = iEmployee.findEmployeeByPositionId(positionId);
				request.setAttribute(PARAM_EMPLOYEE_LIST, employeeList);
				request.setAttribute(PARAM_POSITION, position);
				
			} catch (DaoException e) {
				
				
			} finally {
				connectionPool.releaseConnection(connection);
			}
			
			break;
			
		case PARAM_EMPLOYEE:
			break;
			
		default: 
				break;
		}
		
		
		
		return URL_BOUNDLE.getString(URL_CHEEF);
	}

}
