/**
 * 
 */
package com.epam.aircompany.command;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.aircompany.bean.Airplane;
import com.epam.aircompany.bean.Airport;
import com.epam.aircompany.bean.Employee;
import com.epam.aircompany.bean.Route;
import com.epam.aircompany.logic.AirplaneLogic;
import com.epam.aircompany.logic.AirportLogic;
import com.epam.aircompany.logic.RouteLogic;
import com.epam.aircompany.logic.EmployeeLogic;
import com.epam.aircompany.logic.LogicException;
import com.epam.aircompany.logic.Validator;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class LoginCommand implements ICommand {
	private static final Logger LOG = Logger.getLogger(LoginCommand.class);
	private static final String PARAM_USER_NAME = "user_name";
	private static final String PARAM_PASSWORD = "password";
	private static final String PARAM_NOT_VALID = "not_valid";
	private static final String PARAM_INCORRECT = "incorrect";
	private static final String PARAM_EMPLOYEE_LIST = "employee_list";
	private static final String PARAM_POSITION_LIST = "position_list";
	private static final String PARAM_ROUTE_LIST = "route_list";
	private static final String PARAM_DEPARTURE_AIRPORT_LIST = "departure_airport_list";
	private static final String PARAM_ARRIVAL_AIRPORT_LIST = "arrival_airport_list";
	private static final String PARAM_AIRPLANE_LIST = "airplane_list";
	private static final String PARAM_EMPLOYEE_ENTITY = "employee_entity";
	private static final String PARAM_ROUTE_ENTITY = "route_entity";
	private static final String PARAM_EXCEPTION = "exception";
	private static final String URL_LOGIN = "login";
	private static final String URL_CHEEF = "cheef";
	private static final String URL_ADMIN = "admin";
	private static final String URL_MANAGER = "manager";
	private static final int CHEEF = 1;
	private static final int ADMIN = 2;
	private static final int MANAGER = 3;
	private static final int FIRST_ENTITY = 0;
	
	
	private Employee employee;
	
	/* (non-Javadoc)
	 * @see com.epam.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String url = URL_BOUNDLE.getString(URL_LOGIN);
		String userName = request.getParameter(PARAM_USER_NAME);
		String password = request.getParameter(PARAM_PASSWORD);
		
		
		
		try {
			if(Validator.validateUserName(userName) && Validator.validatePassword(password)) {
				
				EmployeeLogic employeeLogic = new EmployeeLogic();
				employee = employeeLogic.findEmployeeByUserName(userName);
				
				if(employee!= null && password.equals(employee.getPassword())) {
					
					url = findURL(request, employee);
					
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
		} catch (LogicException e) {
			LOG.error(e);
			request.setAttribute(PARAM_EXCEPTION, e);
			url = URL_BOUNDLE.getString(URL_ERROR);
		} 
		return url;
	}

	private String findURL(HttpServletRequest request, Employee employee) throws LogicException {
		String url=null;
		HttpSession session=null;
		
		switch(employee.getPosition().getId()) {
		case CHEEF:
			
			EmployeeLogic employeeLogic = new EmployeeLogic();
			HashMap<String, Object> rezultMap = employeeLogic.generateEmployeeJspData(employee);
			request.setAttribute(PARAM_EMPLOYEE_ENTITY, rezultMap.get(PARAM_EMPLOYEE_ENTITY));
			session = request.getSession();
			session.setAttribute(PARAM_EMPLOYEE_LIST, rezultMap.get(PARAM_EMPLOYEE_LIST));
			session.setAttribute(PARAM_POSITION_LIST, rezultMap.get(PARAM_POSITION_LIST));
			
			url = URL_BOUNDLE.getString(URL_CHEEF);
			break;
			
		case ADMIN:
			
			RouteLogic routeLogic = new RouteLogic();
			List<Route> routeList = routeLogic.findAllRoute();
			
			AirportLogic airportLogic = new AirportLogic();
			List<Airport> airportList = airportLogic.findAllAirport();
			
			AirplaneLogic airplaneLogic = new AirplaneLogic();
			List<Airplane> airplaneList = airplaneLogic.findAllAirport();
			
			session = request.getSession();
			session.setAttribute(PARAM_ROUTE_LIST, routeList);
			session.setAttribute(PARAM_DEPARTURE_AIRPORT_LIST, airportList);
			session.setAttribute(PARAM_ARRIVAL_AIRPORT_LIST, airportList);
			session.setAttribute(PARAM_AIRPLANE_LIST, airplaneList);
			
			if (!routeList.isEmpty()) {
				Route route = routeLogic.findRouteByID(routeList.get(FIRST_ENTITY).getId());
				request.setAttribute(PARAM_ROUTE_ENTITY, route);
			}
					
			url = URL_BOUNDLE.getString(URL_ADMIN);
			break;
			
		case MANAGER:
			url = URL_BOUNDLE.getString(URL_MANAGER);
			break;
		}
		return url;
	}
}
