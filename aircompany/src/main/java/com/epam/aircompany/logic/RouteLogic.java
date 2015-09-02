package com.epam.aircompany.logic;

import java.util.HashMap;
import java.util.List;

import com.epam.aircompany.bean.Route;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IRouteDao;
import com.epam.aircompany.pool.ConnectionPoolException;

/**
 * The Class RouteLogic contains various methods that use DAO layer to
 * retrieve information about the Route(s) from a database.
 *
 * @author Dzmitry Hrushetski
 */
public class RouteLogic extends BaseLogic {

	/**
	 * Instantiates a new route logic.
	 */
	public RouteLogic() {
	}
	
	/**
	 * Find all Route.
	 *
	 * @return List<Route>
	 * @throws LogicException the logic exception
	 */
	public List<Route> findAllRoute() throws LogicException {
		List<Route> routeList = null;
		
		try {
			connection = connectionPool.getConnection();
			IRouteDao iRoute = databaseDao.createIRouteDao(connection);
			routeList = iRoute.findAll();
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}
		return routeList;
	}

	/**
	 * Find Route by id.
	 *
	 * @param id the Route id
	 * @return Route
	 * @throws LogicException the logic exception
	 */
	public Route findRouteByID(int id) throws LogicException {
		Route route = null;
		
		try {	
			
			connection = connectionPool.getConnection();
			IRouteDao iRoute = databaseDao.createIRouteDao(connection);
			route = iRoute.findEntityByID(id);
			
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}	
		return route;
	}

	/**
	 * Delete Route by id.
	 *
	 * @param routeId the Route id
	 * @return true, if successful
	 * @throws LogicException the logic exception
	 */
	public boolean deleteRouteByID(int routeId) throws LogicException {
		boolean isOk = false;
		
		try {	
			
			connection = connectionPool.getConnection();
			IRouteDao iRoute = databaseDao.createIRouteDao(connection);
			isOk = iRoute.deleteRouteByID(routeId);
			
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}	
		return isOk;
	}

	/**
	 * Update Route by id.
	 *
	 * @param routeId the route id
	 * @param HashMap<String, String> the route data
	 * @return true, if successful
	 * @throws LogicException the logic exception
	 */
	public boolean updateRouteByID(int routeId, HashMap<String, String> routeData) throws LogicException {
		boolean isOk = false;
		
		try {	
			
			connection = connectionPool.getConnection();
			IRouteDao iRoute = databaseDao.createIRouteDao(connection);
			isOk = iRoute.updateRouteByID(routeId, routeData);
			
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}	
		return isOk;
	}

	/**
	 * Adds the new Route.
	 *
	 * @param HashMap<String, String> the route data
	 * @return true, if successful
	 * @throws LogicException the logic exception
	 */
	public boolean addNewRoute(HashMap<String, String> routeData) throws LogicException {
		boolean isOk = false;
		
		try {	
			
			connection = connectionPool.getConnection();
			IRouteDao iRoute = databaseDao.createIRouteDao(connection);
			isOk = iRoute.addNewRoute(routeData);
			
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}	
		return isOk;
	}
}
