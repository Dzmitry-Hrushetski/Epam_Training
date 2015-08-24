/**
 * 
 */
package com.epam.web.aircompany.command;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	private static final String PARAM_OPERATION = "operation";
	private static final String PARAM_EMPLOYEE = "employee";
	private static final String PARAM_POSITION = "position";
	private static final String PARAM_EMPLOYEE_ENTITY = "employee_entity";
	private static final int FIRST_EMPLOYEE = 0;
	
	Employee employee;

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest, com.epam.web.aircompany.connection.ConnectionPool, com.epam.web.aircompany.dao.IDao)
	 */
	@Override
	public String execute(HttpServletRequest request, ConnectionPool connectionPool, IDao databaseDao) {
		//String url = URL_BOUNDLE.getString(URL_CHEEF);
		Connection connection = connectionPool.getConnection();
		String operation = request.getParameter(PARAM_OPERATION);
		IEmployeeDao iEmployee = databaseDao.getIEmployeeDao(connection);
		String param = null;
		
		/*if(operation == null || operation.isEmpty()) {
			
		}*/
		switch(operation) {
		case PARAM_POSITION:
			param = request.getParameter(PARAM_POSITION);
			int positionId = Integer.parseInt(param);
			
			try {
				List<Employee> employeeList = iEmployee.findEmployeeByPositionId(positionId);
				
				if(!employeeList.isEmpty()) {
					employee = iEmployee.findEntityByID(employeeList.get(FIRST_EMPLOYEE).getId());
					request.setAttribute(PARAM_EMPLOYEE_ENTITY, employee);
				}
				
				HttpSession session = request.getSession();
				session.setAttribute(PARAM_EMPLOYEE_LIST, employeeList);
				request.setAttribute(PARAM_POSITION, param);
				
			} catch (DaoException e) {
				
				
			} finally {
				connectionPool.releaseConnection(connection);
			}
			
			break;
			
		case PARAM_EMPLOYEE:
			param = request.getParameter(PARAM_EMPLOYEE);
			int employeeId = Integer.parseInt(param);
			
			try {
				
				employee = iEmployee.findEntityByID(employeeId);
				
				if(employee != null) {
					request.setAttribute(PARAM_EMPLOYEE_ENTITY, employee);
				}
			
				request.setAttribute(PARAM_EMPLOYEE, param);
				param = request.getParameter(PARAM_POSITION);
				request.setAttribute(PARAM_POSITION, param);
				
			} catch (DaoException e) {
				
				
			} finally {
				connectionPool.releaseConnection(connection);
			}
			break;
			
		case PARAM_EMPLOYEE_ENTITY:
			param = request.getParameter("save");
			param = request.getParameter("delete");	
			param = request.getParameter(PARAM_EMPLOYEE_ENTITY);
			
			break;
			
		default: 
				break;
		}
		return URL_BOUNDLE.getString(URL_CHEEF);
	}

}
