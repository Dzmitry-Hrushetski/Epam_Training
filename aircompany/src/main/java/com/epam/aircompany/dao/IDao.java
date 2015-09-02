package com.epam.aircompany.dao;

import java.sql.Connection;

/**
 * The Interface IDao describes methods of creation of interfaces of implementation of DAO for each entity type.
 *
 * @author Dzmitry Hrushetski
 */
public interface IDao {
	
	/**
	 * Creates the IEmployeeDao.
	 *
	 * @param Connection the connection
	 * @return IEmployeeDao
	 */
	public IEmployeeDao createIEmployeeDao(Connection connection);
	
	/**
	 * Creates the IPositionDao.
	 *
	 * @param Connection the connection
	 * @return IPositionDao
	 */
	public IPositionDao createIPositionDao(Connection connection);
	
	/**
	 * Creates the IAirportDao.
	 *
	 * @param Connection the connection
	 * @return IAirportDao
	 */
	public IAirportDao createIAirportDao(Connection connection);
	
	/**
	 * Creates the IAirplaneDao.
	 *
	 * @param Connection the connection
	 * @return IAirplaneDao
	 */
	public IAirplaneDao createIAirplaneDao(Connection connection);
	
	/**
	 * Creates the IRouteDao.
	 *
	 * @param Connection the connection
	 * @return IRouteDao
	 */
	public IRouteDao createIRouteDao(Connection connection);
	
	/**
	 * Creates the ICompositionCrewDao.
	 *
	 * @param Connection the connection
	 * @return ICompositionCrewDao
	 */
	public ICompositionCrewDao createICompositionCrewDao(Connection connection);
	
	/**
	 * Creates the ICrewDao.
	 *
	 * @param Connection the connection
	 * @return ICrewDao
	 */
	public ICrewDao createICrewDao(Connection connection);
}
