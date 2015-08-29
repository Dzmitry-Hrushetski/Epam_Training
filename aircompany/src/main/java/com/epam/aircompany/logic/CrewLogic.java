/**
 * 
 */
package com.epam.aircompany.logic;

import com.epam.aircompany.bean.CompositionCrew;
import com.epam.aircompany.bean.Crew;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.ICompositionCrewDao;
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
}
