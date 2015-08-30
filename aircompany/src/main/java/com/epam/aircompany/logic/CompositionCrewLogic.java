/**
 * 
 */
package com.epam.aircompany.logic;

import com.epam.aircompany.bean.CompositionCrew;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.ICompositionCrewDao;
import com.epam.aircompany.pool.ConnectionPoolException;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class CompositionCrewLogic extends BaseLogic {

	/**
	 * 
	 */
	public CompositionCrewLogic() {
	}

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
