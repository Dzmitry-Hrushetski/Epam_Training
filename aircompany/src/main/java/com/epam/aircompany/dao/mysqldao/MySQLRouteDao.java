/**
 * 
 */
package com.epam.aircompany.dao.mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.epam.aircompany.bean.Airplane;
import com.epam.aircompany.bean.Airport;
import com.epam.aircompany.bean.Route;
import com.epam.aircompany.dao.AbstractDao;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IAirplaneDao;
import com.epam.aircompany.dao.IAirportDao;
import com.epam.aircompany.dao.IDao;
import com.epam.aircompany.dao.IRouteDao;
import com.epam.aircompany.dao.factory.DaoFactoryType;
import com.epam.aircompany.dao.factory.DatabaseFactory;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class MySQLRouteDao extends AbstractDao implements IRouteDao {
	private static final String ROUTE_ID = "route.id";
	private static final String ROUTE_NUMBER = "route.route_number";
	private static final String ROUTE_DEPARTURE_TIME = "route.departure_time";
	private static final String ROUTE_ARRIVAL_TIME = "route.arrival_time";
	private static final String DEPARTURE_AIRPORT_ID = "route.departure_airport_id";
	private static final String ARRIVAL_AIRPORT_ID = "route.arrival_airport_id";
	private static final String AIRPLANE_ID = "route.airplane_id";
	private static final String FIND_ALL_ROUTE = "SELECT route.* FROM route WHERE route.disable = 0";
	private static final String FIND_ROUTE_BY_ID = "SELECT route.* FROM route WHERE route.id = ? AND route.disable = 0";
	
	private IDao databaseDao = DatabaseFactory.getInstance().getDatabaseDao(DaoFactoryType.MYSQL);
	
	private Route route;
	private Airport airport;
	private Airplane airplane;
	private GregorianCalendar calendar;
	
	/**
	 * @param connection
	 */
	public MySQLRouteDao(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#findAll()
	 */
	@Override
	public List<Route> findAll() throws DaoException {
		List<Route> routeList = new ArrayList<Route>();
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(FIND_ALL_ROUTE);
			while (rs.next()) {
				
				route = new Route();
				route.setId(rs.getInt(ROUTE_ID));
				route.setRouteNumber(rs.getString(ROUTE_NUMBER));
				
				calendar = new GregorianCalendar();
				Timestamp time = rs.getTimestamp(ROUTE_DEPARTURE_TIME);
				calendar.setTimeInMillis(time.getTime());
				route.setDeparture(calendar);
				
				calendar = new GregorianCalendar();
				time = rs.getTimestamp(ROUTE_ARRIVAL_TIME);
				calendar.setTimeInMillis(time.getTime());
				route.setDeparture(calendar);
				
				IAirportDao iAirport = databaseDao.createIAirportDao(connection);
				airport = iAirport.findEntityByID(rs.getInt(DEPARTURE_AIRPORT_ID));
				route.setDepartureAirport(airport);
				airport = iAirport.findEntityByID(rs.getInt(ARRIVAL_AIRPORT_ID));
				route.setArrivalAirport(airport);
				
				IAirplaneDao iAirplane = databaseDao.createIAirplaneDao(connection);
				airplane = iAirplane.findEntityByID(rs.getInt(AIRPLANE_ID));
				route.setAirplane(airplane);
				
				
				routeList.add(route);
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error.", ex);
		} finally {
			close(statement);
		}
		return routeList;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#findEntityByID(int)
	 */
	@Override
	public Route findEntityByID(int id) throws DaoException {
		PreparedStatement prepStatement = null;
		 		
		try {
			prepStatement = connection.prepareStatement(FIND_ROUTE_BY_ID);
			
			prepStatement.setInt(1,id);
			ResultSet rs = prepStatement.executeQuery();
			while (rs.next()) {
				
				route = new Route();
				route.setId(rs.getInt(ROUTE_ID));
				route.setRouteNumber(rs.getString(ROUTE_NUMBER));
				
				calendar = new GregorianCalendar();
				Timestamp time = rs.getTimestamp(ROUTE_DEPARTURE_TIME);
				calendar.setTimeInMillis(time.getTime());
				route.setDeparture(calendar);
				
				calendar = new GregorianCalendar();
				time = rs.getTimestamp(ROUTE_ARRIVAL_TIME);
				calendar.setTimeInMillis(time.getTime());
				route.setArrival(calendar);
				
				IAirportDao iAirport = databaseDao.createIAirportDao(connection);
				airport = iAirport.findEntityByID(rs.getInt(DEPARTURE_AIRPORT_ID));
				route.setDepartureAirport(airport);
				airport = iAirport.findEntityByID(rs.getInt(ARRIVAL_AIRPORT_ID));
				route.setArrivalAirport(airport);
				
				IAirplaneDao iAirplane = databaseDao.createIAirplaneDao(connection);
				airplane = iAirplane.findEntityByID(rs.getInt(AIRPLANE_ID));
				route.setAirplane(airplane);
				
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error.", ex);
		} finally {
			close(prepStatement);
		}
		return route;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#addNewEntity(com.epam.aircompany.bean.Entity)
	 */
	@Override
	public boolean addNewEntity(Route entity) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#updateEntity(com.epam.aircompany.bean.Entity, int)
	 */
	@Override
	public boolean updateEntity(Route entity, int id) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

}
