/**
 * 
 */
package com.epam.aircompany.logic;

import java.util.List;

import com.epam.aircompany.bean.Airport;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IAirportDao;
import com.epam.aircompany.pool.ConnectionPoolException;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class AirportLogic extends BaseLogic {

	/**
	 * 
	 */
	public AirportLogic() {
	}

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
