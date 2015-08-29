/**
 * 
 */
package com.epam.aircompany.dao.mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.epam.aircompany.bean.CompositionCrew;
import com.epam.aircompany.bean.Crew;
import com.epam.aircompany.bean.Employee;
import com.epam.aircompany.dao.AbstractDao;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IDao;
import com.epam.aircompany.dao.IEmployeeDao;
import com.epam.aircompany.dao.factory.DaoFactoryType;
import com.epam.aircompany.dao.factory.DatabaseFactory;
import com.epam.aircompany.logic.ICrewDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class MySQLCrewDao extends AbstractDao implements ICrewDao {
	private static final String FIND_BY_ROUTE_ID = "SELECT crew.employee_id FROM crew WHERE crew.route_id = ? AND crew.disable = 0";
	private static final String EMPLOYEE_ID = "employee_id";
	private static final String QUANTITY = "quantity";
	
	private IDao databaseDao = DatabaseFactory.getInstance().getDatabaseDao(DaoFactoryType.MYSQL);

	/**
	 * @param connection
	 */
	public MySQLCrewDao(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#findAll()
	 */
	@Override
	public List<Crew> findAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#findEntityByID(int)
	 */
	@Override
	public Crew findEntityByID(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#addNewEntity(com.epam.aircompany.bean.Entity)
	 */
	@Override
	public boolean addNewEntity(Crew entity) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#updateEntity(com.epam.aircompany.bean.Entity, int)
	 */
	@Override
	public boolean updateEntity(Crew entity, int id) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.logic.ICrewDao#findEntityByRouteId(int)
	 */
	@Override
	public Crew findEntityByRouteId(int id) throws DaoException {
		Crew crew = null;
		PreparedStatement prepStatement = null;
		ArrayList<Employee> empList = new ArrayList<Employee>();
		 		
		try {
			prepStatement = connection.prepareStatement(FIND_BY_ROUTE_ID);
			
			prepStatement.setInt(1,id);
			ResultSet rs = prepStatement.executeQuery();
			
			while (rs.next()) {
				
				IEmployeeDao iEmployee = databaseDao.createIEmployeeDao(connection);
				Employee employee = iEmployee.findEntityByID(rs.getInt(EMPLOYEE_ID));
				empList.add(employee);
			}
			if(!empList.isEmpty()) {
				crew = new Crew();
				crew.setCrew(empList);
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error.", ex);
		} finally {
			close(prepStatement);
		}
		return crew;
	}

}
