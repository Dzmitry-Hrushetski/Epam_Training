/**
 * 
 */
package com.epam.aircompany.dao;

import java.sql.Connection;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface IDao {
	
	public IEmployeeDao createIEmployeeDao(Connection connection);
	public IPositionDao createIPositionDao(Connection connection);
	public IAirportDao createIAirportDao(Connection connection);
	public IAirplaneDao createIAirplaneDao(Connection connection);
	public IRouteDao createIRouteDao(Connection connection);
	public ICompositionCrewDao createICompositionCrewDao(Connection connection);

}