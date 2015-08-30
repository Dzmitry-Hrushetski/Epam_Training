/**
 * 
 */
package com.epam.aircompany.dao;

import java.util.HashMap;

import com.epam.aircompany.bean.Route;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface IRouteDao extends IBaseDao<Route> {

	boolean deleteRouteByID(int routeId) throws DaoException;
	boolean updateRouteByID(int routeId, HashMap<String, String> routeData) throws DaoException;
	boolean addNewRoute(HashMap<String, String> routeData) throws DaoException;

}
