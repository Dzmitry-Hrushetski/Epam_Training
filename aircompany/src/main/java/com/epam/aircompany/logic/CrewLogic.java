/**
 * 
 */
package com.epam.aircompany.logic;

import java.util.ArrayList;

import com.epam.aircompany.bean.Crew;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.ICrewDao;
import com.epam.aircompany.pool.ConnectionPoolException;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class CrewLogic extends BaseLogic {

	/**
	 * 
	 */
	public CrewLogic() {
	}

	public Crew findEntityByRouteId(int id) throws LogicException {
		Crew crew = null;
		
		try {	
			connection = connectionPool.getConnection();
			ICrewDao iCrewDao = databaseDao.createICrewDao(connection);
			crew = iCrewDao.findEntityByRouteId(id);		
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}	
		return crew;
	}

	public boolean deleteCrewByRouteId(int id) throws LogicException {
		boolean isOk = false;
		try {	
			connection = connectionPool.getConnection();
			ICrewDao iCrewDao = databaseDao.createICrewDao(connection);
			isOk = iCrewDao.deleteCrewByRouteId(id);		
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}	
		return isOk;
	}

	public boolean saveCrewByRouteId(int id, ArrayList<String> crewData) throws LogicException {
		boolean isOk = false;
		try {	
			connection = connectionPool.getConnection();
			ICrewDao iCrewDao = databaseDao.createICrewDao(connection);
			isOk = iCrewDao.saveCrewByRouteId(id, crewData);		
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}	
		return isOk;
	}
}
