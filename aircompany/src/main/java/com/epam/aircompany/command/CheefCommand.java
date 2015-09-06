package com.epam.aircompany.command;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.aircompany.bean.Employee;
import com.epam.aircompany.logic.EmployeeLogic;
import com.epam.aircompany.logic.LogicException;
import com.epam.aircompany.util.Validator;

/**
 * The Сlass CheefCommand processes commands from the JSP page of the director on which control of lists of employees is made.
 *
 * @author Dzmitry Hrushetski
 */
public class CheefCommand implements ICommand {
	private static final Logger LOG = Logger.getLogger(CheefCommand.class);
	private static final int FIRST_EMPLOYEE = 0;
	private static final String URL_CHEEF = "cheef";
	private static final String URL_NEW = "create_new_employee";
	private static final String PARAM_EMPLOYEE_LIST = "employee_list";
	private static final String PARAM_OPERATION = "operation";
	private static final String PARAM_EMPLOYEE = "employee";
	private static final String PARAM_POSITION = "position";
	private static final String PARAM_EMPLOYEE_ENTITY = "employee_entity";
	private static final String PARAM_EXCEPTION = "exception";
	private static final String PARAM_DELETE = "delete";
	private static final String PARAM_CREATE_NEW = "create_new";
	private static final String PARAM_DELETE_STATE = "delete_state";
	private static final String PARAM_SAVE_STATE = "save_state";
	private static final String PARAM_BAD_DATA = "bad_data";
	private static final String PARAM_SAVE = "save";
	private static final String PARAM_FIRST_NAME = "first_name";
	private static final String PARAM_LAST_NAME = "last_name";
	private static final String PARAM_PHONE = "phone";
	private static final String PARAM_ADDRESS = "addres";
	private static final String PARAM_USER_NAME = "user_name";
	private static final String PARAM_PASSWORD = "password";
	private static final String PARAM_START_DATE = "calendar";
	
	private Employee employee;

	/* (non-Javadoc)
	 * @see com.epam.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String url = URL_BOUNDLE.getString(URL_CHEEF);
		String operation = request.getParameter(PARAM_OPERATION);
		int employeeId = 0;
		int positionId = 0;
		boolean isOk = false;
		String param = null;
		
		switch(operation) {
		case PARAM_POSITION:
			param = request.getParameter(PARAM_POSITION);
			positionId = Integer.parseInt(param);
			
			try {
				
				EmployeeLogic employeeLogic = new EmployeeLogic();	
				List<Employee> employeeList = employeeLogic.findEmployeeByPositionId(positionId);
				
				if(!employeeList.isEmpty()) {
					employee = employeeList.get(FIRST_EMPLOYEE);
					request.setAttribute(PARAM_EMPLOYEE_ENTITY, employee);
				}
				
				HttpSession session = request.getSession();
				session.setAttribute(PARAM_EMPLOYEE_LIST, employeeList);
				request.setAttribute(PARAM_POSITION, param);
				
			} catch (LogicException e) {
				LOG.error(e);
				request.setAttribute(PARAM_EXCEPTION, e);
				url = URL_BOUNDLE.getString(URL_ERROR_PAGE);
			} 
			
			break;
			
		case PARAM_EMPLOYEE:
			param = request.getParameter(PARAM_EMPLOYEE);
			employeeId = Integer.parseInt(param);
			
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
				url = URL_BOUNDLE.getString(URL_ERROR_PAGE);
			} 
			break;
			
		case PARAM_EMPLOYEE_ENTITY:
			param = request.getParameter(PARAM_EMPLOYEE_ENTITY);
			employeeId = Integer.parseInt(param);
			param = request.getParameter(PARAM_POSITION);
			positionId = Integer.parseInt(param);
			
			try {
				param = request.getParameter(PARAM_DELETE);
				if (param != null) {
					EmployeeLogic employeeLogic = new EmployeeLogic();
					isOk = employeeLogic.deleteEntityByID(employeeId);
					request.setAttribute(PARAM_DELETE_STATE, isOk);

					employeeLogic = new EmployeeLogic();
					List<Employee> employeeList = employeeLogic.findEmployeeByPositionId(positionId);

					if (!employeeList.isEmpty()) {
						employee = employeeList.get(FIRST_EMPLOYEE);
						request.setAttribute(PARAM_EMPLOYEE_ENTITY, employee);
					}

					HttpSession session = request.getSession();
					session.setAttribute(PARAM_EMPLOYEE_LIST, employeeList);

					param = request.getParameter(PARAM_POSITION);
					request.setAttribute(PARAM_POSITION, param);
				}

				param = request.getParameter(PARAM_SAVE);
				if (param != null) {
					HashMap<String, String> employeeData = new HashMap<String, String>();
					
					param = request.getParameter(PARAM_FIRST_NAME);
					employeeData.put(PARAM_FIRST_NAME, param);
					param = request.getParameter(PARAM_LAST_NAME);
					employeeData.put(PARAM_LAST_NAME, param);
					param = request.getParameter(PARAM_PHONE);
					employeeData.put(PARAM_PHONE, param);
					param = request.getParameter(PARAM_ADDRESS);
					employeeData.put(PARAM_ADDRESS, param);
					param = request.getParameter(PARAM_USER_NAME);
					employeeData.put(PARAM_USER_NAME, param);
					param = request.getParameter(PARAM_PASSWORD);
					employeeData.put(PARAM_PASSWORD, param);
					param = request.getParameter(PARAM_START_DATE);
					employeeData.put(PARAM_START_DATE, param);
					
					isOk = Validator.validateEmployeeData(employeeData);
					if(isOk) {
						EmployeeLogic employeeLogic = new EmployeeLogic();
						isOk = employeeLogic.updateEntityByID(employeeId, employeeData);
						request.setAttribute(PARAM_SAVE_STATE, isOk);

						employeeLogic = new EmployeeLogic();
						employee = employeeLogic.findEntityByID(employeeId);

						if (employee != null) {
							request.setAttribute(PARAM_EMPLOYEE_ENTITY, employee);
						}	
					} else {
						request.setAttribute(PARAM_BAD_DATA, true);
						
						param = request.getParameter(PARAM_FIRST_NAME);
						request.setAttribute(PARAM_FIRST_NAME, param);
						param = request.getParameter(PARAM_LAST_NAME);
						request.setAttribute(PARAM_LAST_NAME, param);
						param = request.getParameter(PARAM_PHONE);
						request.setAttribute(PARAM_PHONE, param);
						param = request.getParameter(PARAM_ADDRESS);
						request.setAttribute(PARAM_ADDRESS, param);
						param = request.getParameter(PARAM_USER_NAME);
						request.setAttribute(PARAM_USER_NAME, param);
						param = request.getParameter(PARAM_PASSWORD);
						request.setAttribute(PARAM_PASSWORD, param);
						param = request.getParameter(PARAM_START_DATE);
						request.setAttribute(PARAM_START_DATE, param);
					}
					
					param = request.getParameter(PARAM_EMPLOYEE);
					request.setAttribute(PARAM_EMPLOYEE, param);
					param = request.getParameter(PARAM_POSITION);
					request.setAttribute(PARAM_POSITION, param);
				}
			} catch (LogicException e) {
				LOG.error(e);
				request.setAttribute(PARAM_EXCEPTION, e);
				url = URL_BOUNDLE.getString(URL_ERROR_PAGE);
			}
			break;
			
		case PARAM_CREATE_NEW:
			param = request.getParameter(PARAM_POSITION);
			request.setAttribute(PARAM_POSITION, param);
			url = URL_BOUNDLE.getString(URL_NEW);
			break;
		}
		return url;
	}
}
