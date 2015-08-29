/**
 * 
 */
package com.epam.aircompany.dao.mysqldao;

import java.sql.Connection;

import com.epam.aircompany.dao.IAirplaneDao;
import com.epam.aircompany.dao.IAirportDao;
import com.epam.aircompany.dao.ICompositionCrewDao;
import com.epam.aircompany.dao.IDao;
import com.epam.aircompany.dao.IEmployeeDao;
import com.epam.aircompany.dao.IPositionDao;
import com.epam.aircompany.dao.IRouteDao;
import com.epam.aircompany.logic.ICrewDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class MySQLDao implements IDao {

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IDao#getIEmployeeDao()
	 */
	@Override
	public IEmployeeDao createIEmployeeDao(Connection connection) {
		return new MySQLEmployeeDao(connection);
	}

	@Override
	public IPositionDao createIPositionDao(Connection connection) {
		return new MySQLPositionDao(connection);
	}

	@Override
	public IAirportDao createIAirportDao(Connection connection) {
		return new MySQLAirportDao(connection);
	}

	@Override
	public IAirplaneDao createIAirplaneDao(Connection connection) {
		return new MySQLAirplaneDao(connection);
	}

	@Override
	public IRouteDao createIRouteDao(Connection connection) {
		return new MySQLRouteDao(connection);
	}

	@Override
	public ICompositionCrewDao createICompositionCrewDao(Connection connection) {
		return new MySQLCompositionCrewDao(connection);
	}

	@Override
	public ICrewDao createICrewDao(Connection connection) {
		return new MySQLCrewDao(connection);
	}

}
