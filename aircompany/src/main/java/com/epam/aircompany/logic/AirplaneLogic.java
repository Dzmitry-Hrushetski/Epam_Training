package com.epam.aircompany.logic;

import java.util.List;

import com.epam.aircompany.bean.Airplane;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IAirplaneDao;
import com.epam.aircompany.pool.ConnectionPoolException;

/**
 * The Class AirplaneLogic contains various methods that use DAO layer to
 * retrieve information about the Airplane(s) from a database.
 *
 * @author Dzmitry Hrushetski
 */
public class AirplaneLogic extends BaseLogic {

	/**
	 * Instantiates a new airplane logic.
	 */
	public AirplaneLogic() {
	}

	/**
	 * Find all Airplane.
	 *
	 * @return List of Airplane
	 * @throws LogicException the logic exception
	 */
	public List<Airplane> findAllAirplane() throws LogicException {
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
