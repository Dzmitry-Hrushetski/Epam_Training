package com.epam.aircompany.logic;

import com.epam.aircompany.bean.CompositionCrew;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.ICompositionCrewDao;
import com.epam.aircompany.pool.ConnectionPoolException;

/**
 * The Class CompositionCrewLogic contains various methods that use DAO layer to
 * retrieve information about the CompositionCrew(s) from a database.
 *
 * @author Dzmitry Hrushetski
 */
public class CompositionCrewLogic extends BaseLogic {

	/**
	 * Instantiates a new composition crew logic.
	 */
	public CompositionCrewLogic() {
	}

	/**
	 * Find CompositionCrew by AirplaneType id.
	 *
	 * @param id the id of AirplaneType
	 * @return CompositionCrew
	 * @throws LogicException the logic exception
	 */
	public CompositionCrew findEntityByAirplaneTypeId(int id) throws LogicException {
		CompositionCrew compCrew = null;
		
		try {	
			connection = connectionPool.getConnection();
			ICompositionCrewDao iCompCrewDao = databaseDao.createICompositionCrewDao(connection);
			compCrew = iCompCrewDao.findEntityByAirplaneTypeId(id);		
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}	
		return compCrew;
	}
}
