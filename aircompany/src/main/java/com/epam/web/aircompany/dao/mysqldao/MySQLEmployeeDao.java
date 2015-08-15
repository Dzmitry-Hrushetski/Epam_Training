/**
 * 
 */
package com.epam.web.aircompany.dao.mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.web.aircompany.bean.Employee;
import com.epam.web.aircompany.bean.Position;
import com.epam.web.aircompany.dao.AbstractDao;
import com.epam.web.aircompany.dao.DaoException;
import com.epam.web.aircompany.dao.IEmployeeDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class MySQLEmployeeDao extends AbstractDao implements IEmployeeDao {
	private static final String USER_NAME = "person.user_name";
	private static final String POSITION_NAME = "position.position_name";
	private static final String PASSWORD = "person.password";
	private static final String FIND_EMPLOYEE_BY_USER_NAME = "SELECT person.user_name, person.password, position.position_name FROM employee INNER JOIN person ON employee.person_id = person.id INNER JOIN position ON employee.position_id = position.id WHERE person.user_name = ? AND (position.position_name = 'Директор' OR position.position_name = 'Администратор' OR position.position_name = 'Диспетчер') AND employee.disable = 0";

	/**
	 * @param connection
	 */
	public MySQLEmployeeDao(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.IBaseDao#findAll()
	 */
	@Override
	public List<Employee> findAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.IBaseDao#findEntityByID(int)
	 */
	@Override
	public Employee findEntityByID(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.IBaseDao#addNewEntity(com.epam.web.aircompany.bean.Entity)
	 */
	@Override
	public boolean addNewEntity(Employee entity) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.IBaseDao#updateEntity(com.epam.web.aircompany.bean.Entity, int)
	 */
	@Override
	public boolean updateEntity(Employee entity, int id) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee findEmployeeByUserName(String userName) throws DaoException {
		PreparedStatement prepStatement = null;
		Employee employee = null;
		Position position = null;
 		
		try {
			prepStatement = connection.prepareStatement(FIND_EMPLOYEE_BY_USER_NAME);
			prepStatement.setString(1, userName);
			ResultSet rs = prepStatement.executeQuery();
			while (rs.next()) {
				/* creating a new Employee and initializing its fields */
				position = new Position();
				position.setPositionName(rs.getString(POSITION_NAME));
				
				employee = new Employee();
				employee.setPosition(position);
				employee.setUserName(rs.getString(USER_NAME));
				employee.setPassword(rs.getString(PASSWORD));
				
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error", ex);
		} finally {
			close(prepStatement);
		}
		return employee;
	}
}
