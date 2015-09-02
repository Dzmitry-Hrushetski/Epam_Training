package com.epam.aircompany.dao;

import java.util.HashMap;

import com.epam.aircompany.bean.Route;

/**
 * The Interface IRouteDao describes own DAO methods for entity Route.
 *
 * @author Dzmitry Hrushetski
 */
public interface IRouteDao extends IBaseDao<Route> {

	/**
	 * Delete route by id.
	 *
	 * @param routeId the route id
	 * @return true, if successful
	 * @throws DaoException the dao exception
	 */
	boolean deleteRouteByID(int routeId) throws DaoException;
	
	/**
	 * Update route by id.
	 *
	 * @param routeId the route id
	 * @param routeData HashMap key - String, value - String the route data
	 * @return true, if successful
	 * @throws DaoException the dao exception
	 */
	boolean updateRouteByID(int routeId, HashMap<String, String> routeData) throws DaoException;
	
	/**
	 * Adds the new route.
	 *
	 * @param routeData HashMap key - String, value - String the route data
	 * @return true, if successful
	 * @throws DaoException the dao exception
	 */
	boolean addNewRoute(HashMap<String, String> routeData) throws DaoException;
}
