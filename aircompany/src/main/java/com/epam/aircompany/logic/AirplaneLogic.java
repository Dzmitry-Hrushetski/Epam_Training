/**
 * 
 */
package com.epam.aircompany.logic;

import java.util.List;

import com.epam.aircompany.bean.Airplane;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IAirplaneDao;
import com.epam.aircompany.pool.ConnectionPoolException;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class AirplaneLogic extends BaseLogic {

	/**
	 * 
	 */
	public AirplaneLogic() {
	}

	public List<Airplane> findAllAirport() throws LogicException {
		List<Airplane> airplaneList = null;
		
		try {
			connection = connectionPool.getConnection();
			IAirplaneDao iAirplane = databaseDao.createIAirplaneDao(connection);
			airplaneList = iAirplane.findAll();
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}
		return airplaneList;
	}
}
