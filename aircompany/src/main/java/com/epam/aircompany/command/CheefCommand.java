/**
 * 
 */
package com.epam.aircompany.command;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.aircompany.bean.Employee;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IDao;
import com.epam.aircompany.dao.IEmployeeDao;
import com.epam.aircompany.logic.EmployeeLogic;
import com.epam.aircompany.logic.LogicException;
import com.epam.aircompany.pool.ConnectionPool;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class CheefCommand implements ICommand {
	private static final Logger LOG = Logger.getLogger(CheefCommand.class);
	private static final String URL_CHEEF = "cheef";
	private static final String PARAM_EMPLOYEE_LIST = "employee_list";
	private static final String PARAM_OPERATION = "operation";
	private static final String PARAM_EMPLOYEE = "employee";
	private static final String PARAM_POSITION = "position";
	private static final String PARAM_EMPLOYEE_ENTITY = "employee_entity";
	private static final String PARAM_EXCEPTION = "exception";
	private static final String PARAM_DELETE = "delete";
	private static final String PARAM_SAVE = "save";
	private static final int FIRST_EMPLOYEE = 0;
	
	private Employee employee;

	/* (non-Javadoc)
	 * @see com.epam.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest, com.epam.aircompany.pool.ConnectionPool, com.epam.aircompany.dao.IDao)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String url = URL_BOUNDLE.getString(URL_CHEEF);
		String operation = request.getParameter(PARAM_OPERATION);
		String param = null;
		
		/*if(operation == null || operation.isEmpty()) {
			
		}*/
		switch(operation) {
		case PARAM_POSITION:
			param = request.getParameter(PARAM_POSITION);
			int positionId = Integer.parseInt(param);
			
			try {
				
				EmployeeLogic employeeLogic = new EmployeeLogic();	
				List<Employee> employeeList = employeeLogic.findEmployeeByPositionId(positionId);
				
				if(!employeeList.isEmpty()) {
					employee = employeeLogic.findEntityByID(employeeList.get(FIRST_EMPLOYEE).getId());
					request.setAttribute(PARAM_EMPLOYEE_ENTITY, employee);
				}
				
				HttpSession session = request.getSession();
				session.setAttribute(PARAM_EMPLOYEE_LIST, employeeList);
				request.setAttribute(PARAM_POSITION, param);
				
			} catch (LogicException e) {
				LOG.error(e);
				request.setAttribute(PARAM_EXCEPTION, e);
				url = URL_BOUNDLE.getString(URL_ERROR);
			} 
			
			break;
			
		case PARAM_EMPLOYEE:
			param = request.getParameter(PARAM_EMPLOYEE);
			int employeeId = Integer.parseInt(param);
			
			try {
				
				EmployeeLogic employeeLogic = new EmployeeLogic();
				employee = employeeLogic.findEntityByID(employeeId);
				
				if(employee != null) {
					request.setAttribute(PARAM_EMPLOYEE_ENTITY, employee);
				}
			
				request.setAttribute(PARAM_EMPLOYEE, param);
				param = request.getParameter(PARAM_POSITION);
				request.setAttribute(PARAM_POSITION, param);
				
			} catch (LogicException e) {
				LOG.error(e);
				request.setAttribute(PARAM_EXCEPTION, e);
				url = URL_BOUNDLE.getString(URL_ERROR);
			} 
			break;
			
		case PARAM_EMPLOYEE_ENTITY:
			param = request.getParameter(PARAM_EMPLOYEE_ENTITY);
			int employeeId = Integer.parseInt(param);
			
			param = request.getParameter(PARAM_DELETE);	
			if(param != null) {
				EmployeeLogic employeeLogic = new EmployeeLogic();
				employee = employeeLogic.deleteEntityByID(employeeId);
			}
			
			param = request.getParameter(PARAM_SAVE);
			
			
			
			break;
		}
		return url;
	}
}
