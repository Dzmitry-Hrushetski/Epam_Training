/**
 * 
 */
package com.epam.aircompany.dao.mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.epam.aircompany.bean.CompositionCrew;
import com.epam.aircompany.dao.AbstractDao;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.ICompositionCrewDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class MySQLCompositionCrewDao extends AbstractDao implements ICompositionCrewDao {
	private static final String FIND_BY_AIRPLANE_TYPR_ID = "SELECT composition_crew.* FROM composition_crew WHERE composition_crew.airplane_type_id = ?";
	private static final String POSITION_ID = "position_id";
	private static final String QUANTITY = "quantity";

	/**
	 * @param connection
	 */
	public MySQLCompositionCrewDao(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#findAll()
	 */
	@Override
	public List<CompositionCrew> findAll() throws DaoException {
		throw new UnsupportedOperationException("Error. This operation is not supported!");
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#findEntityByID(int)
	 */
	@Override
	public CompositionCrew findEntityByID(int id) throws DaoException {
		throw new UnsupportedOperationException("Error. This operation is not supported!");
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#addNewEntity(com.epam.aircompany.bean.Entity)
	 */
	@Override
	public boolean addNewEntity(CompositionCrew entity) throws DaoException {
		throw new UnsupportedOperationException("Error. This operation is not supported!");
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#updateEntity(com.epam.aircompany.bean.Entity, int)
	 */
	@Override
	public boolean updateEntity(CompositionCrew entity, int id)	throws DaoException {
		throw new UnsupportedOperationException("Error. This operation is not supported!");
	}

	@Override
	public CompositionCrew findEntityByAirplaneTypeId(int id) throws DaoException {
		CompositionCrew compCrew = null;
		PreparedStatement prepStatement = null;
		HashMap<Integer,Integer> compMap = new HashMap<Integer,Integer>();
		 		
		try {
			prepStatement = connection.prepareStatement(FIND_BY_AIRPLANE_TYPR_ID);
			
			prepStatement.setInt(1,id);
			ResultSet rs = prepStatement.executeQuery();
			
			while (rs.next()) {
				compMap.put(rs.getInt(POSITION_ID), rs.getInt(QUANTITY));
			}
			
			compCrew = new CompositionCrew();
			compCrew.setCrew(compMap);
		} catch (SQLException ex) {
			throw new DaoException("Database error.", ex);
		} finally {
			close(prepStatement);
		}
		return compCrew;
	}
}
