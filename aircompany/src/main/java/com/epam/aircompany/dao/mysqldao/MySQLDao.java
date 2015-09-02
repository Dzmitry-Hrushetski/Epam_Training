package com.epam.aircompany.dao.mysqldao;

import java.sql.Connection;

import com.epam.aircompany.dao.IAirplaneDao;
import com.epam.aircompany.dao.IAirportDao;
import com.epam.aircompany.dao.ICompositionCrewDao;
import com.epam.aircompany.dao.ICrewDao;
import com.epam.aircompany.dao.IDao;
import com.epam.aircompany.dao.IEmployeeDao;
import com.epam.aircompany.dao.IPositionDao;
import com.epam.aircompany.dao.IRouteDao;

/**
 * The Class MySQLDao describes interface IDAO for MySQL database.
 *
 * @author Dzmitry Hrushetski
 */
public class MySQLDao implements IDao {

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IDao#getIEmployeeDao()
	 */
	@Override
	public IEmployeeDao createIEmployeeDao(Connection connection) {
		return new MySQLEmployeeDao(connection);
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IDao#createIPositionDao(java.sql.Connection)
	 */
	@Override
	public IPositionDao createIPositionDao(Connection connection) {
		return new MySQLPositionDao(connection);
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IDao#createIAirportDao(java.sql.Connection)
	 */
	@Override
	public IAirportDao createIAirportDao(Connection connection) {
		return new MySQLAirportDao(connection);
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IDao#createIAirplaneDao(java.sql.Connection)
	 */
	@Override
	public IAirplaneDao createIAirplaneDao(Connection connection) {
		return new MySQLAirplaneDao(connection);
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IDao#createIRouteDao(java.sql.Connection)
	 */
	@Override
	public IRouteDao createIRouteDao(Connection connection) {
		return new MySQLRouteDao(connection);
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IDao#createICompositionCrewDao(java.sql.Connection)
	 */
	@Override
	public ICompositionCrewDao createICompositionCrewDao(Connection connection) {
		return new MySQLCompositionCrewDao(connection);
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IDao#createICrewDao(java.sql.Connection)
	 */
	@Override
	public ICrewDao createICrewDao(Connection connection) {
		return new MySQLCrewDao(connection);
	}
}
