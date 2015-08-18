/**
 * 
 */
package com.epam.web.aircompany.dao.mysqldao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.epam.web.aircompany.bean.Position;
import com.epam.web.aircompany.dao.AbstractDao;
import com.epam.web.aircompany.dao.DaoException;
import com.epam.web.aircompany.dao.IPositionDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class MySQLPositionDao extends AbstractDao implements IPositionDao {
	private static final String POSITION_NAME = "position.position_name";
	private static final String POSITION_ID = "position.id";
	private static final String FIND_ALL_POSITION = "SELECT * FROM position";
	
	/**
	 * @param connection
	 */
	public MySQLPositionDao(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.IBaseDao#findAll()
	 */
	@Override
	public List<Position> findAll() throws DaoException {
		List<Position> positionList = new ArrayList<Position>();
		Statement statement = null;
		Position position = null;
		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(FIND_ALL_POSITION);
			while (rs.next()) {
				position = new Position();
				position.setId(rs.getInt(POSITION_ID));
				position.setPositionName(rs.getString(POSITION_NAME));
				
				positionList.add(position);
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error.", ex);
		} finally {
			close(statement);
		}
		return positionList;
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.IBaseDao#findEntityByID(int)
	 */
	@Override
	public Position findEntityByID(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.IBaseDao#addNewEntity(com.epam.web.aircompany.bean.Entity)
	 */
	@Override
	public boolean addNewEntity(Position entity) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.IBaseDao#updateEntity(com.epam.web.aircompany.bean.Entity, int)
	 */
	@Override
	public boolean updateEntity(Position entity, int id) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

}
