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
import com.epam.aircompany.bean.CompositionCrew;
import com.epam.aircompany.bean.Crew;
import com.epam.aircompany.bean.Employee;
import com.epam.aircompany.bean.Route;
import com.epam.aircompany.logic.AirplaneLogic;
import com.epam.aircompany.logic.AirportLogic;
import com.epam.aircompany.logic.CompositionCrewLogic;
import com.epam.aircompany.logic.CrewLogic;
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
	private static final int FIRST_PILOT_ID = 4;
	private static final int CO_PILOT_ID = 5;
	private static final int ENGINEER_ID = 6;
	private static final int NAVIGATOR_ID = 7;
	private static final int STEWARD_ID = 8;
	private static final String PARAM_FIRST_PILOT_LIST = "first_pilot_list";
	private static final String PARAM_CO_PILOT_LIST = "co_pilot_list";
	private static final String PARAM_ENGINEER_LIST = "engineer_list";
	private static final String PARAM_NAVIGATOR_LIST = "navigator_list";
	private static final String PARAM_STEWARD_LIST = "steward_list";
	private static final String PARAM_CO_PILOT_PRES = "co_pilot_present";
	private static final String PARAM_ENGINEER_PRES = "engineer_present";
	private static final String PARAM_NAVIGATOR_PRES = "navigator_present";
	private static final String PARAM_STEWARD_PRES = "steward_present";
	private static final String PARAM_COMP_CREW = "comp_crew";
	private static final String PARAM_ROUTE_EMPTY = "route_list_empty";
	private static final String PARAM_CREW = "crew";
	
	
	
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
		RouteLogic routeLogic = null;
		List<Route> routeList = null;
		EmployeeLogic employeeLogic = null;
		
		switch(employee.getPosition().getId()) {
		case CHEEF:
			
			employeeLogic = new EmployeeLogic();
			HashMap<String, Object> rezultMap = employeeLogic.generateEmployeeJspData(employee);
			request.setAttribute(PARAM_EMPLOYEE_ENTITY, rezultMap.get(PARAM_EMPLOYEE_ENTITY));
			session = request.getSession();
			session.setAttribute(PARAM_EMPLOYEE_LIST, rezultMap.get(PARAM_EMPLOYEE_LIST));
			session.setAttribute(PARAM_POSITION_LIST, rezultMap.get(PARAM_POSITION_LIST));
			
			url = URL_BOUNDLE.getString(URL_CHEEF);
			break;
			
		case ADMIN:
			
			routeLogic = new RouteLogic();
			routeList = routeLogic.findAllRoute();
			
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
				Route route = routeList.get(FIRST_ENTITY);
				request.setAttribute(PARAM_ROUTE_ENTITY, route);
			}
					
			url = URL_BOUNDLE.getString(URL_ADMIN);
			break;
			
		case MANAGER:
			
			routeLogic = new RouteLogic();
			routeList = routeLogic.findAllRoute();
			
			if (!routeList.isEmpty()) {
				Route route = routeList.get(FIRST_ENTITY);
				request.setAttribute(PARAM_ROUTE_ENTITY, route);
				
				CompositionCrewLogic compCrewLogic = new CompositionCrewLogic();
				CompositionCrew compCrew = compCrewLogic.findEntityByAirplaneTypeId(route.getAirplane().getAirplaneType().getId());
				
				CrewLogic crewLogic = new CrewLogic();
				Crew crew = crewLogic.findEntityByRouteId(route.getId());
				
				employeeLogic = new EmployeeLogic();
				List<Employee> firstPilotList = employeeLogic.findEmployeeByPositionId(FIRST_PILOT_ID);
				List<Employee> coPilotList = employeeLogic.findEmployeeByPositionId(CO_PILOT_ID);
				List<Employee> engineerList = employeeLogic.findEmployeeByPositionId(ENGINEER_ID);
				List<Employee> navigatorList = employeeLogic.findEmployeeByPositionId(NAVIGATOR_ID);
				List<Employee> stewardList = employeeLogic.findEmployeeByPositionId(STEWARD_ID);
				
				if(compCrew.getCrew().containsKey(CO_PILOT_ID)) {
					request.setAttribute(PARAM_CO_PILOT_PRES, compCrew.getCrew().get(CO_PILOT_ID));
				}
				if(compCrew.getCrew().containsKey(ENGINEER_ID)) {
					request.setAttribute(PARAM_ENGINEER_PRES, compCrew.getCrew().get(ENGINEER_ID));
				}
				if(compCrew.getCrew().containsKey(NAVIGATOR_ID)) {
					request.setAttribute(PARAM_NAVIGATOR_PRES, compCrew.getCrew().get(NAVIGATOR_ID));
				}
				if(compCrew.getCrew().containsKey(STEWARD_ID)) {
					request.setAttribute(PARAM_STEWARD_PRES, compCrew.getCrew().get(STEWARD_ID));
				}
				
				session = request.getSession();
				session.setAttribute(PARAM_ROUTE_LIST, routeList);
				session.setAttribute(PARAM_FIRST_PILOT_LIST, firstPilotList);
				session.setAttribute(PARAM_CO_PILOT_LIST, coPilotList);
				session.setAttribute(PARAM_ENGINEER_LIST, engineerList);
				session.setAttribute(PARAM_NAVIGATOR_LIST, navigatorList);
				session.setAttribute(PARAM_STEWARD_LIST, stewardList);
				session.setAttribute(PARAM_COMP_CREW, compCrew);
				
				if(crew!=null) {
					request.setAttribute(PARAM_CREW, crew);
				}
					
			} else {
				request.setAttribute(PARAM_ROUTE_EMPTY, true);
			}
			
			
			url = URL_BOUNDLE.getString(URL_MANAGER);
			break;
		}
		return url;
	}
}
