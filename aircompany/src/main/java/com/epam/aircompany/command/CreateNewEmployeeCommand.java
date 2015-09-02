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
 * The Сlass CreateNewEmployeeCommand processes commands from the JSP page of the director on which adding of new employees is made.
 *
 * @author Dzmitry Hrushetski
 */
public class CreateNewEmployeeCommand implements ICommand {
	private static final Logger LOG = Logger.getLogger(CreateNewEmployeeCommand.class);
	private static final String URL_CREATE_NEW = "create_new_employee";
	private static final String URL_CHEEF = "cheef";
	private static final int FIRST_EMPLOYEE = 0;
	private static final String PARAM_EMPLOYEE_LIST = "employee_list";
	private static final String PARAM_OPERATION = "operation";
	private static final String PARAM_EMPLOYEE = "employee";
	private static final String PARAM_POSITION = "position";
	private static final String PARAM_EMPLOYEE_ENTITY = "employee_entity";
	private static final String PARAM_EXCEPTION = "exception";
	private static final String PARAM_SAVE_STATE = "save_state";
	private static final String PARAM_BAD_DATA = "bad_data";
	private static final String PARAM_SAVE = "save";
	private static final String PARAM_BACK = "back";
	private static final String PARAM_FIRST_NAME = "first_name";
	private static final String PARAM_LAST_NAME = "last_name";
	private static final String PARAM_PHONE = "phone";
	private static final String PARAM_ADDRESS = "addres";
	private static final String PARAM_USER_NAME = "user_name";
	private static final String PARAM_PASSWORD = "password";
	private static final String PARAM_START_DATE = "calendar";
	private static final String PARAM_POSITION_LIST = "position_list";
	
	private Employee employee;

	/* (non-Javadoc)
	 * @see com.epam.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String url = URL_BOUNDLE.getString(URL_CREATE_NEW);
		String operation = request.getParameter(PARAM_OPERATION);
		HttpSession session = null;
		int positionId = 0;
		boolean isOk = false;
		String param = null;
		
		switch(operation) {
		case PARAM_POSITION:
			param = request.getParameter(PARAM_POSITION);
			request.setAttribute(PARAM_POSITION, param);
			break;
			
		case PARAM_BACK:		
			try {
				
				EmployeeLogic employeeLogic = new EmployeeLogic();
				HashMap<String, Object> rezultMap = employeeLogic.generateEmployeeJspData(employee);
				request.setAttribute(PARAM_EMPLOYEE_ENTITY, rezultMap.get(PARAM_EMPLOYEE_ENTITY));
				session = request.getSession();
				session.setAttribute(PARAM_EMPLOYEE_LIST, rezultMap.get(PARAM_EMPLOYEE_LIST));
				session.setAttribute(PARAM_POSITION_LIST, rezultMap.get(PARAM_POSITION_LIST));
				
			} catch (LogicException e) {
				LOG.error(e);
				request.setAttribute(PARAM_EXCEPTION, e);
				url = URL_BOUNDLE.getString(URL_ERROR_PAGE);
			} 
			url = URL_BOUNDLE.getString(URL_CHEEF);
			break;
			
		case PARAM_EMPLOYEE_ENTITY:
			param = request.getParameter(PARAM_POSITION);
			positionId = Integer.parseInt(param);
			
			try {
				param = request.getParameter(PARAM_BACK);
				if (param != null) {
					EmployeeLogic employeeLogic = new EmployeeLogic();
					List<Employee> employeeList = employeeLogic.findEmployeeByPositionId(positionId);

					if (!employeeList.isEmpty()) {
						employee = employeeList.get(FIRST_EMPLOYEE);
						request.setAttribute(PARAM_EMPLOYEE_ENTITY, employee);
					}

					session = request.getSession();
					session.setAttribute(PARAM_EMPLOYEE_LIST, employeeList);

					param = request.getParameter(PARAM_POSITION);
					request.setAttribute(PARAM_POSITION, param);
					
					url = URL_BOUNDLE.getString(URL_CHEEF);
				}

				param = request.getParameter(PARAM_SAVE);
				if (param != null) {
					HashMap<String, String> employeeData = new HashMap<String, String>();
					String userName = request.getParameter(PARAM_USER_NAME);
					String password = request.getParameter(PARAM_PASSWORD);
					String phone = request.getParameter(PARAM_PHONE);
					String startDate = request.getParameter(PARAM_START_DATE);
					
					isOk = Validator.validateEmployeeData(userName, password, phone, startDate);
					if(isOk) {
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
						param = request.getParameter(PARAM_POSITION);
						employeeData.put(PARAM_POSITION, param);

						EmployeeLogic employeeLogic = new EmployeeLogic();
						isOk = employeeLogic.addNewEntity(employeeData);
						request.setAttribute(PARAM_SAVE_STATE, isOk);
					} else {
						request.setAttribute(PARAM_BAD_DATA, isOk);
						
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
		}
		return url;
	}
}
