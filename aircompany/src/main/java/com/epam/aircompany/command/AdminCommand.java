/**
 * 
 */
package com.epam.aircompany.command;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.aircompany.bean.Route;
import com.epam.aircompany.logic.LogicException;
import com.epam.aircompany.logic.RouteLogic;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class AdminCommand implements ICommand {
	private static final Logger LOG = Logger.getLogger(AdminCommand.class);
	private static final String URL_ADMIN = "admin";
	private static final int FIRST_ROUTE = 0;
	private static final String PARAM_OPERATION = "operation";
	private static final String PARAM_EXCEPTION = "exception";
	private static final String PARAM_ROUTE = "route";
	private static final String PARAM_ROUTE_ENTITY = "route_entity";
	private static final String PARAM_DELETE = "delete";
	private static final String PARAM_CREATE_NEW = "create_new";
	private static final String PARAM_DELETE_STATE = "delete_state";
	private static final String PARAM_SAVE_STATE = "save_state";
	private static final String PARAM_BAD_DATA = "bad_data";
	private static final String PARAM_SAVE = "save";
	private static final String PARAM_ROUTE_LIST = "route_list";
	private static final String PARAM_DEPARTURE_AIRPORT = "departure_airport";
	private static final String PARAM_ARRIVAL_AIRPORT = "arrival_airport";
	private static final String PARAM_AIRPLANE = "airplane";
	private static final String PARAM_ROUTE_NUMBER = "route_number";
	private static final String PARAM_DEPARTURE_TIME = "departure_time";
	private static final String PARAM_ARRIVAL_TIME = "arrival_time";
	
	private Route route;
	
	/* (non-Javadoc)
	 * @see com.epam.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String url = URL_BOUNDLE.getString(URL_ADMIN);
		String operation = request.getParameter(PARAM_OPERATION);
		RouteLogic routeLogic = new RouteLogic();
		String param = null;
		boolean isOk = false;
		int routeId = 0;
		
		switch(operation) {
		case PARAM_ROUTE:
			param = request.getParameter(PARAM_ROUTE);
			request.setAttribute(PARAM_ROUTE, param);
			routeId = Integer.parseInt(param);
			
			try {
				//RouteLogic routeLogic = new RouteLogic();
				route = routeLogic.findRouteByID(routeId);
				request.setAttribute(PARAM_ROUTE_ENTITY, route);
			} catch (LogicException e) {
				LOG.error(e);
				request.setAttribute(PARAM_EXCEPTION, e);
				url = URL_BOUNDLE.getString(URL_ERROR);
			}	
			break;
		case PARAM_ROUTE_ENTITY:
			param = request.getParameter(PARAM_ROUTE);
			request.setAttribute(PARAM_ROUTE, param);
			
			param = request.getParameter(PARAM_ROUTE_ENTITY);
			routeId = Integer.parseInt(param);
			
			try {
				param = request.getParameter(PARAM_DELETE);
				if (param != null) {
					//RouteLogic routeLogic = new RouteLogic();
					isOk = routeLogic.deleteRouteByID(routeId);
					request.setAttribute(PARAM_DELETE_STATE, isOk);
				}
				
				param = request.getParameter(PARAM_SAVE);
				if (param != null) {
					HashMap<String, String> routeData = new HashMap<String, String>();
					
					param = request.getParameter(PARAM_DEPARTURE_AIRPORT);
					routeData.put(PARAM_DEPARTURE_AIRPORT, param);
					param = request.getParameter(PARAM_ARRIVAL_AIRPORT);
					routeData.put(PARAM_ARRIVAL_AIRPORT, param);
					param = request.getParameter(PARAM_AIRPLANE);
					routeData.put(PARAM_AIRPLANE, param);
					param = request.getParameter(PARAM_ROUTE_NUMBER);
					routeData.put(PARAM_ROUTE_NUMBER, param);
					param = request.getParameter(PARAM_DEPARTURE_TIME);
					routeData.put(PARAM_DEPARTURE_TIME, param);
					param = request.getParameter(PARAM_ARRIVAL_TIME);
					routeData.put(PARAM_ARRIVAL_TIME, param);
					
					isOk = routeLogic.updateRouteByID(routeId,routeData);
					request.setAttribute(PARAM_SAVE_STATE, isOk);
				}
				
				//RouteLogic routeLogic = new RouteLogic();
				List<Route> routeList = routeLogic.findAllRoute();
							
				HttpSession session = request.getSession();
				session.setAttribute(PARAM_ROUTE_LIST, routeList);
								
				if (!routeList.isEmpty()) {
					route = routeLogic.findRouteByID(routeList.get(FIRST_ROUTE).getId());
					request.setAttribute(PARAM_ROUTE_ENTITY, route);
				}
				
			} catch (LogicException e) {
				LOG.error(e);
				request.setAttribute(PARAM_EXCEPTION, e);
				url = URL_BOUNDLE.getString(URL_ERROR);
			}	
			break;
		}
		return url;
	}

}
