/**
 * 
 */
package com.epam.aircompany.logic;

import java.util.ArrayList;
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
public class AdminLogic extends BaseLogic {

	/**
	 * 
	 */
	public AdminLogic() {
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
}
