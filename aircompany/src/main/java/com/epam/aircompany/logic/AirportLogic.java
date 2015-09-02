package com.epam.aircompany.logic;

import java.util.List;

import com.epam.aircompany.bean.Airport;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IAirportDao;
import com.epam.aircompany.pool.ConnectionPoolException;

/**
 * The Class AirportLogic contains various methods that use DAO layer to
 * retrieve information about the Airport(s) from a database.
 *
 * @author Dzmitry Hrushetski
 */
public class AirportLogic extends BaseLogic {

	/**
	 * Instantiates a new airport logic.
	 */
	public AirportLogic() {
	}

	/**
	 * Find all Airport.
	 *
	 * @return List<Airport>
	 * @throws LogicException the logic exception
	 */
	public List<Airport> findAllAirport() throws LogicException {
		List<Airport> airportList = null;
		
		try {
			connection = connectionPool.getConnection();
			IAirportDao iAirport = databaseDao.createIAirportDao(connection);
			airportList = iAirport.findAll();
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}
		return airportList;
	}
}
