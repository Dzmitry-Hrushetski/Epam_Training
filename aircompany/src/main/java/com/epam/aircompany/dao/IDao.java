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
	 * @param connection the Connection
	 * @return IEmployeeDao
	 */
	public IEmployeeDao createIEmployeeDao(Connection connection);
	
	/**
	 * Creates the IPositionDao.
	 *
	 * @param connection the Connection
	 * @return IPositionDao
	 */
	public IPositionDao createIPositionDao(Connection connection);
	
	/**
	 * Creates the IAirportDao.
	 *
	 * @param connection the Connection
	 * @return IAirportDao
	 */
	public IAirportDao createIAirportDao(Connection connection);
	
	/**
	 * Creates the IAirplaneDao.
	 *
	 * @param connection the Connection
	 * @return IAirplaneDao
	 */
	public IAirplaneDao createIAirplaneDao(Connection connection);
	
	/**
	 * Creates the IRouteDao.
	 *
	 * @param connection the Connection
	 * @return IRouteDao
	 */
	public IRouteDao createIRouteDao(Connection connection);
	
	/**
	 * Creates the ICompositionCrewDao.
	 *
	 * @param connection the Connection
	 * @return ICompositionCrewDao
	 */
	public ICompositionCrewDao createICompositionCrewDao(Connection connection);
	
	/**
	 * Creates the ICrewDao.
	 *
	 * @param connection the Connection
	 * @return ICrewDao
	 */
	public ICrewDao createICrewDao(Connection connection);
}
