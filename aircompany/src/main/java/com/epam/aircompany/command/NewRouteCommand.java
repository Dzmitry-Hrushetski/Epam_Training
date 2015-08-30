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
import com.epam.aircompany.bean.Route;
import com.epam.aircompany.logic.AirplaneLogic;
import com.epam.aircompany.logic.AirportLogic;
import com.epam.aircompany.logic.LogicException;
import com.epam.aircompany.logic.RouteLogic;
import com.epam.aircompany.logic.Validator;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class NewRouteCommand implements ICommand {
	private static final Logger LOG = Logger.getLogger(NewRouteCommand.class);
	private static final String URL_ADMIN = "admin";
	private static final String URL_NEW = "create_new_route";
	private static final int FIRST_ROUTE = 0;
	private static final String PARAM_OPERATION = "operation";
	private static final String PARAM_EXCEPTION = "exception";
	private static final String PARAM_ROUTE_ENTITY = "route_entity";
	private static final String PARAM_NEW_ROUTE_ENTITY = "new_route_entity";
	private static final String PARAM_SAVE_STATE = "save_state";
	private static final String PARAM_BACK = "back";
	private static final String PARAM_BAD_DATA = "bad_data";
	private static final String PARAM_ROUTE_LIST = "route_list";
	private static final String PARAM_DEPARTURE_AIRPORT = "departure_airport";
	private static final String PARAM_ARRIVAL_AIRPORT = "arrival_airport";
	private static final String PARAM_AIRPLANE = "airplane";
	private static final String PARAM_ROUTE_NUMBER = "route_number";
	private static final String PARAM_DEPARTURE_TIME = "departure_time";
	private static final String PARAM_ARRIVAL_TIME = "arrival_time";
	private static final String PARAM_DEPARTURE_AIRPORT_LIST = "departure_airport_list";
	private static final String PARAM_ARRIVAL_AIRPORT_LIST = "arrival_airport_list";
	private static final String PARAM_AIRPLANE_LIST = "airplane_list";

	/**
	 * 
	 */
	public NewRouteCommand() {
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String url = URL_BOUNDLE.getString(URL_NEW);
		String operation = request.getParameter(PARAM_OPERATION);
		RouteLogic routeLogic = new RouteLogic();
		String param = null;
		boolean isOk = false;
		
		switch (operation) {
		case PARAM_NEW_ROUTE_ENTITY:
			String departureTime = request.getParameter(PARAM_DEPARTURE_TIME);
			String arrivalTime = request.getParameter(PARAM_ARRIVAL_TIME);
			
			if (Validator.validateDateTimeFormat(departureTime) == true && Validator.validateDateTimeFormat(arrivalTime) == true) {
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
				try {
					isOk = routeLogic.addNewRoute(routeData);
					request.setAttribute(PARAM_SAVE_STATE, isOk);
				} catch (LogicException e) {
					LOG.error(e);
					request.setAttribute(PARAM_EXCEPTION, e);
					url = URL_BOUNDLE.getString(URL_ERROR);
				}
			} else {
				request.setAttribute(PARAM_BAD_DATA, true);
			}
			break;
		case PARAM_BACK:
			try {
				List<Route> routeList = routeLogic.findAllRoute();

				AirportLogic airportLogic = new AirportLogic();
				List<Airport> airportList = airportLogic.findAllAirport();

				AirplaneLogic airplaneLogic = new AirplaneLogic();
				List<Airplane> airplaneList = airplaneLogic.findAllAirport();

				HttpSession session = request.getSession();
				session.setAttribute(PARAM_ROUTE_LIST, routeList);
				session.setAttribute(PARAM_DEPARTURE_AIRPORT_LIST, airportList);
				session.setAttribute(PARAM_ARRIVAL_AIRPORT_LIST, airportList);
				session.setAttribute(PARAM_AIRPLANE_LIST, airplaneList);

				if (!routeList.isEmpty()) {
					Route route = routeList.get(FIRST_ROUTE);
					request.setAttribute(PARAM_ROUTE_ENTITY, route);
				}
			} catch (LogicException e) {
				LOG.error(e);
				request.setAttribute(PARAM_EXCEPTION, e);
				url = URL_BOUNDLE.getString(URL_ERROR);
			}
			url = URL_BOUNDLE.getString(URL_ADMIN);
			break;
		}
		return url;
	}
}
