package com.epam.aircompany.logic;

import java.util.ArrayList;

import com.epam.aircompany.bean.Crew;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.ICrewDao;
import com.epam.aircompany.pool.ConnectionPoolException;

/**
 * The Class CrewLogic contains various methods that use DAO layer to
 * retrieve information about the Crew(s) from a database.
 *
 *
 * @author Dzmitry Hrushetski
 */
public class CrewLogic extends BaseLogic {

	/**
	 * Instantiates a new crew logic.
	 */
	public CrewLogic() {
	}

	/**
	 * Find Crew by Route id.
	 *
	 * @param id the id of Route
	 * @return Crew
	 * @throws LogicException the logic exception
	 */
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

	/**
	 * Delete Crew by Route id.
	 *
	 * @param id the id of Route
	 * @return true, if successful
	 * @throws LogicException the logic exception
	 */
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

	/**
	 * Save Crew by Route id.
	 *
	 * @param id the id of Route
	 * @param  crewData  ArrayList crewData
	 * @return true, if successful
	 * @throws LogicException the logic exception
	 */
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
