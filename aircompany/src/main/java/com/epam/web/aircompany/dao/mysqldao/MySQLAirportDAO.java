/**
 * 
 */
package com.epam.web.aircompany.dao.mysqldao;

import java.sql.Connection;
import java.util.List;

import com.epam.web.aircompany.bean.Airport;
import com.epam.web.aircompany.dao.AbstractDAO;
import com.epam.web.aircompany.dao.DAOException;
import com.epam.web.aircompany.dao.IDAO;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class MySQLAirportDAO extends AbstractDAO implements IDAO<Airport> {

	/**
	 * @param connection
	 */
	public MySQLAirportDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Airport> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airport findEntityByID(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addNewEntity(Airport entity) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEntity(Airport entity, int id) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

}
