package com.epam.aircompany.dao.mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.aircompany.bean.Airplane;
import com.epam.aircompany.bean.AirplaneType;
import com.epam.aircompany.dao.AbstractDao;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IAirplaneDao;

/**
 * The Class MySQLAirplaneDao realizes MySQL DAO for entity Airplane.
 *
 * @author Dzmitry Hrushetski
 */
public class MySQLAirplaneDao extends AbstractDao implements IAirplaneDao {
	private static final String AIRPLANE_ID = "airplane.id";
	private static final String AIRPLANE_BOARD_NUMBER = "airplane.board_number";
	private static final String AIRPLANE_TYPE_ID = "airplane_type.id";
	private static final String MODEL_NAME = "airplane_type.model_name";
	private static final String FIND_ALL_AIRPLANE = "SELECT airplane.*, airplane_type.* FROM airplane INNER JOIN airplane_type ON airplane.airplane_type_id = airplane_type.id";
	private static final String FIND_AIRPLANE_BY_ID = "SELECT airplane.*, airplane_type.* FROM airplane INNER JOIN airplane_type ON airplane.airplane_type_id = airplane_type.id WHERE airplane.id = ?";

	/**
	 * Instantiates a new MySQLAirplaneDao.
	 *
	 * @param connection the connection
	 */
	public MySQLAirplaneDao(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#findAll()
	 */
	@Override
	public List<Airplane> findAll() throws DaoException {
		List<Airplane> airplaneList = new ArrayList<Airplane>();
		Statement statement = null;
		Airplane airplane = null;
		AirplaneType airplaneType = null;
		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(FIND_ALL_AIRPLANE);
			while (rs.next()) {
				
				airplaneType = new AirplaneType();
				airplaneType.setId(rs.getInt(AIRPLANE_TYPE_ID));
				airplaneType.setModelName(rs.getString(MODEL_NAME));
				
				airplane = new Airplane();
				airplane.setAirplaneType(airplaneType);
				airplane.setId(rs.getInt(AIRPLANE_ID));
				airplane.setBoardNumber(rs.getString(AIRPLANE_BOARD_NUMBER));
				
				airplaneList.add(airplane);
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error.", ex);
		} finally {
			close(statement);
		}
		return airplaneList;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#findEntityByID(int)
	 */
	@Override
	public Airplane findEntityByID(int id) throws DaoException {
		Airplane airplane = null;
		AirplaneType airplaneType = null;
		PreparedStatement prepStatement = null;
		 		
		try {
			prepStatement = connection.prepareStatement(FIND_AIRPLANE_BY_ID);
			
			prepStatement.setInt(1,id);
			ResultSet rs = prepStatement.executeQuery();
			while (rs.next()) {
				
				airplaneType = new AirplaneType();
				airplaneType.setId(rs.getInt(AIRPLANE_TYPE_ID));
				airplaneType.setModelName(rs.getString(MODEL_NAME));
				
				airplane = new Airplane();
				airplane.setAirplaneType(airplaneType);
				airplane.setId(rs.getInt(AIRPLANE_ID));
				airplane.setBoardNumber(rs.getString(AIRPLANE_BOARD_NUMBER));	
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error.", ex);
		} finally {
			close(prepStatement);
		}
		return airplane;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#addNewEntity(com.epam.aircompany.bean.Entity)
	 */
	@Override
	public boolean addNewEntity(Airplane entity) throws DaoException {
		throw new UnsupportedOperationException("Error. This operation is not supported!");
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#updateEntity(com.epam.aircompany.bean.Entity, int)
	 */
	@Override
	public boolean updateEntity(Airplane entity, int id) throws DaoException {
		throw new UnsupportedOperationException("Error. This operation is not supported!");
	}
}
