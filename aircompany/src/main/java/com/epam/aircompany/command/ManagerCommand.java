/**
 * 
 */
package com.epam.aircompany.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.aircompany.bean.CompositionCrew;
import com.epam.aircompany.bean.Crew;
import com.epam.aircompany.bean.Employee;
import com.epam.aircompany.bean.Route;
import com.epam.aircompany.logic.CompositionCrewLogic;
import com.epam.aircompany.logic.CrewLogic;
import com.epam.aircompany.logic.EmployeeLogic;
import com.epam.aircompany.logic.LogicException;
import com.epam.aircompany.logic.RouteLogic;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class ManagerCommand implements ICommand {
	private static final Logger LOG = Logger.getLogger(ManagerCommand.class);
	private static final String PARAM_OPERATION = "operation";
	private static final String PARAM_ROUTE_LIST = "route_list";
	private static final String PARAM_DEPARTURE_AIRPORT_LIST = "departure_airport_list";
	private static final String PARAM_ARRIVAL_AIRPORT_LIST = "arrival_airport_list";
	private static final String PARAM_AIRPLANE_LIST = "airplane_list";
	private static final String PARAM_EMPLOYEE_ENTITY = "employee_entity";
	private static final String PARAM_CREW_ENTITY = "crew_entity";
	private static final String PARAM_EXCEPTION = "exception";
	private static final String PARAM_ROUTE = "route";
	private static final String PARAM_CREATE_NEW = "create_new";
	private static final String URL_LOGIN = "login";
	private static final String URL_CHEEF = "cheef";
	private static final String URL_ADMIN = "admin";
	private static final String URL_MANAGER = "manager";
	private static final String URL_NEW = "create_new_crew";
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
	private static final String PARAM_CREW = "crew";
	private static final String PARAM_SAVE = "save";
	private static final String PARAM_DELETE = "delete";
	private static final String PARAM_DELETE_STATE = "delete_state";
	private static final String PARAM_SAVE_STATE = "save_state";
	private static final String PARAM_FIRST_PILOT = "first_pilot";
	private static final String PARAM_CO_PILOT = "co_pilot";
	private static final String PARAM_ENGINEER = "engineer";
	private static final String PARAM_NAVIGATOR = "navigator";
	private static final String PARAM_STEWARD = "steward";
	
	
	/**
	 * 
	 */
	public ManagerCommand() {
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String url = URL_BOUNDLE.getString(URL_MANAGER);
		String operation = request.getParameter(PARAM_OPERATION);
		CrewLogic crewLogic = new CrewLogic();
		CompositionCrew compCrew = null;
		HttpSession session=null;
		String param = null;
		boolean isOk = false;
		int routeId = 0;
		
		switch(operation) {
		case PARAM_ROUTE:
			param = request.getParameter(PARAM_ROUTE);
			request.setAttribute(PARAM_ROUTE, param);
			routeId = Integer.parseInt(param);
			
			try {
				RouteLogic routeLogic = new RouteLogic();
				Route route = routeLogic.findRouteByID(routeId);
				request.setAttribute(PARAM_CREW_ENTITY, route);
				
				CompositionCrewLogic compCrewLogic = new CompositionCrewLogic();
				compCrew = compCrewLogic.findEntityByAirplaneTypeId(route.getAirplane().getAirplaneType().getId());
				
				//CrewLogic crewLogic = new CrewLogic();
				Crew crew = crewLogic.findEntityByRouteId(route.getId());
				
				session = request.getSession();
				session.setAttribute(PARAM_COMP_CREW, compCrew);
				
				if(crew!=null) {
					request.setAttribute(PARAM_CREW, crew);
				}
				
				
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
				
				
			} catch (LogicException e) {
				LOG.error(e);
				request.setAttribute(PARAM_EXCEPTION, e);
				url = URL_BOUNDLE.getString(URL_ERROR);
			}	
			break;
		case PARAM_CREW_ENTITY:
			param = request.getParameter(PARAM_ROUTE);
			request.setAttribute(PARAM_ROUTE, param);
			routeId = Integer.parseInt(param);
			
			try {
				param = request.getParameter(PARAM_DELETE);
				if (param != null) {
					isOk = crewLogic.deleteCrewByRouteId(routeId);
					request.setAttribute(PARAM_DELETE_STATE, isOk);
					
					session = request.getSession();
					compCrew = (CompositionCrew) session.getAttribute(PARAM_COMP_CREW);
					
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
				}
				
				param = request.getParameter(PARAM_SAVE);
				if (param != null) {
					ArrayList<String> crewData = new ArrayList<String>();
					
					//param = request.getParameter(PARAM_FIRST_PILOT);
					crewData.add(request.getParameter(PARAM_FIRST_PILOT));
					
					session = request.getSession();
					compCrew = (CompositionCrew) session.getAttribute(PARAM_COMP_CREW);
					
					if(compCrew.getCrew().containsKey(CO_PILOT_ID)) {
						crewData.add(request.getParameter(PARAM_CO_PILOT));
					}
					if(compCrew.getCrew().containsKey(ENGINEER_ID)) {
						crewData.add(request.getParameter(PARAM_ENGINEER));
					}
					if(compCrew.getCrew().containsKey(NAVIGATOR_ID)) {
						crewData.add(request.getParameter(PARAM_NAVIGATOR));
					}
					if(compCrew.getCrew().containsKey(STEWARD_ID)) {
						crewData.addAll(Arrays.asList(request.getParameterValues(PARAM_STEWARD)));
					}
					
					isOk = crewLogic.saveCrewByRouteId(routeId, crewData);
					request.setAttribute(PARAM_SAVE_STATE, isOk);
				}
				
				/*//RouteLogic routeLogic = new RouteLogic();
				List<Route> routeList = routeLogic.findAllRoute();
							
				HttpSession session = request.getSession();
				session.setAttribute(PARAM_ROUTE_LIST, routeList);
								
				if (!routeList.isEmpty()) {
					route = routeLogic.findRouteByID(routeList.get(routeId-1).getId());
					request.setAttribute(PARAM_ROUTE_ENTITY, route);
				}
				*/
				
			} catch (LogicException e) {
				LOG.error(e);
				request.setAttribute(PARAM_EXCEPTION, e);
				url = URL_BOUNDLE.getString(URL_ERROR);
			}	
			break;	
		case PARAM_CREATE_NEW:
			url = URL_BOUNDLE.getString(URL_NEW);
			break;
		}
		return url;
	}

}
