/**
 * 
 */
package com.epam.aircompany.dao.mysqldao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.aircompany.bean.Airport;
import com.epam.aircompany.bean.City;
import com.epam.aircompany.dao.AbstractDao;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IAirportDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class MySQLAirportDao extends AbstractDao implements IAirportDao {
	private static final String AIRPORT_NAME = "airport.airport_name";
	private static final String AIRPORT_ID = "airport.id";
	private static final String AIRPORT_IATA = "airport.iata_code";
	private static final String AIRPORT_ICAO = "airport.icao_code";
	private static final String CITY_ID = "city.id";
	private static final String CITY_NAME = "city.city_name";
	private static final String FIND_ALL_AIRPORT = "SELECT airport.*, city.* FROM airport INNER JOIN city ON airport.city_id = city.id";

	/**
	 * @param connection
	 */
	public MySQLAirportDao(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#findAll()
	 */
	@Override
	public List<Airport> findAll() throws DaoException {
		List<Airport> airportList = new ArrayList<Airport>();
		Statement statement = null;
		Airport airport = null;
		City city = null;
		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(FIND_ALL_AIRPORT);
			while (rs.next()) {
				
				city = new City();
				city.setId(rs.getInt(CITY_ID));
				city.setCityName(rs.getString(CITY_NAME));
				
				airport = new Airport();
				airport.setCity(city);
				airport.setId(rs.getInt(AIRPORT_ID));
				airport.setAirportName(rs.getString(AIRPORT_NAME));
				airport.setIataCode(rs.getString(AIRPORT_IATA));
				airport.setIcaoCode(rs.getString(AIRPORT_ICAO));
				
				airportList.add(airport);
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error.", ex);
		} finally {
			close(statement);
		}
		return airportList;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#findEntityByID(int)
	 */
	@Override
	public Airport findEntityByID(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#addNewEntity(com.epam.aircompany.bean.Entity)
	 */
	@Override
	public boolean addNewEntity(Airport entity) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#updateEntity(com.epam.aircompany.bean.Entity, int)
	 */
	@Override
	public boolean updateEntity(Airport entity, int id) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

}
