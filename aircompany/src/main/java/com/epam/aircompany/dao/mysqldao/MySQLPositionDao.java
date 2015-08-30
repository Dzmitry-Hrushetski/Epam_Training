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

import com.epam.aircompany.bean.Position;
import com.epam.aircompany.dao.AbstractDao;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IPositionDao;

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
	 * @see com.epam.aircompany.dao.IBaseDao#findAll()
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
	 * @see com.epam.aircompany.dao.IBaseDao#findEntityByID(int)
	 */
	@Override
	public Position findEntityByID(int id) throws DaoException {
		throw new UnsupportedOperationException("Error. This operation is not supported!");
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#addNewEntity(com.epam.aircompany.bean.Entity)
	 */
	@Override
	public boolean addNewEntity(Position entity) throws DaoException {
		throw new UnsupportedOperationException("Error. This operation is not supported!");
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#updateEntity(com.epam.aircompany.bean.Entity, int)
	 */
	@Override
	public boolean updateEntity(Position entity, int id) throws DaoException {
		throw new UnsupportedOperationException("Error. This operation is not supported!");
	}
}
