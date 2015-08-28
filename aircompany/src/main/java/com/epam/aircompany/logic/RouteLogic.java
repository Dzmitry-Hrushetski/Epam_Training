/**
 * 
 */
package com.epam.aircompany.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.epam.aircompany.bean.Employee;
import com.epam.aircompany.bean.Route;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IEmployeeDao;
import com.epam.aircompany.dao.IRouteDao;
import com.epam.aircompany.pool.ConnectionPoolException;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class RouteLogic extends BaseLogic {

	/**
	 * 
	 */
	public RouteLogic() {
	}
	
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
