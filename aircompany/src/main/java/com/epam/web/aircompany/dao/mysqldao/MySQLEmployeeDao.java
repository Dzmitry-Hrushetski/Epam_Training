/**
 * 
 */
package com.epam.web.aircompany.dao.mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
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
	private static final String ID = "employee.id";
	private static final String START_DATE = "employee.start_date";
	private static final String FIRST_NAME = "person.first_name";
	private static final String LAST_NAME = "person.last_name";
	private static final String ADDRES = "person.addres";
	private static final String PHONE = "person.phone";
	private static final String USER_NAME = "person.user_name";
	private static final String PASSWORD = "person.password";
	private static final String POSITION_NAME = "position.position_name";
	private static final String POSITION_ID = "position.id";
	private static final String FIND_EMPLOYEE_BY_USER_NAME = "SELECT person.user_name, person.password, position.id, position.position_name FROM employee INNER JOIN person ON employee.person_id = person.id INNER JOIN position ON employee.position_id = position.id WHERE person.user_name = ? AND (position.position_name = 'Директор' OR position.position_name = 'Администратор' OR position.position_name = 'Диспетчер') AND employee.disable = 0";
	private static final String FIND_EMPLOYEE_BY_POSITION_ID = "SELECT employee.id, position.id, position.position_name, employee.start_date, person.first_name, person.last_name, person.addres, person.phone, person.user_name, person.password FROM employee INNER JOIN person ON employee.person_id = person.id INNER JOIN position ON employee.position_id = position.id WHERE person.id = ? AND employee.disable = 0";
	private static final String FIND_ALL_EMPLOYEE = "SELECT employee.id, position.id, position.position_name, employee.start_date, person.first_name, person.last_name, person.addres, person.phone, person.user_name, person.password FROM employee INNER JOIN person ON employee.person_id = person.id INNER JOIN position ON employee.position_id = position.id";

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
		List<Employee> employeeList = new ArrayList<Employee>();
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(FIND_ALL_EMPLOYEE);
			while (rs.next()) {
				/* creating a new Employee and initializing its fields */
				Position position = new Position();
				position.setId(rs.getInt(POSITION_ID));
				position.setPositionName(rs.getString(POSITION_NAME));
				
				Employee employee = new Employee();
				employee.setId(rs.getInt(ID));
				employee.setPosition(position);
				
				GregorianCalendar startDate = new GregorianCalendar();
				startDate.setTime(rs.getDate(START_DATE));
				employee.setStartDate(startDate);
				
				employee.setFirstName(rs.getString(FIRST_NAME));
				employee.setLastName(rs.getString(LAST_NAME));
				employee.setAddres(rs.getString(ADDRES));
				employee.setPhone(rs.getString(PHONE));
				employee.setUserName(rs.getString(USER_NAME));
				employee.setPassword(rs.getString(PASSWORD));
				
				employeeList.add(employee);
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error.", ex);
		} finally {
			close(statement);
		}
		return employeeList;
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
				position.setId(rs.getInt(POSITION_ID));
				position.setPositionName(rs.getString(POSITION_NAME));
				
				employee = new Employee();
				employee.setPosition(position);
				employee.setUserName(rs.getString(USER_NAME));
				employee.setPassword(rs.getString(PASSWORD));
				
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error.", ex);
		} finally {
			close(prepStatement);
		}
		return employee;
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.IEmployeeDao#findEmployeeByPositionId(int)
	 */
	@Override
	public List<Employee> findEmployeeByPositionId(int positionId) throws DaoException {
		List<Employee> employeeList = new ArrayList<Employee>();
		PreparedStatement prepStatement = null;
		 		
		try {
			prepStatement = connection.prepareStatement(FIND_EMPLOYEE_BY_POSITION_ID);
			
			prepStatement.setInt(1,positionId);
			ResultSet rs = prepStatement.executeQuery();
			while (rs.next()) {
				
				Position position = new Position();
				position.setId(rs.getInt(POSITION_ID));
				position.setPositionName(rs.getString(POSITION_NAME));
				
				Employee employee = new Employee();
				employee.setId(rs.getInt(ID));
				employee.setPosition(position);
				
				GregorianCalendar startDate = new GregorianCalendar();
				startDate.setTime(rs.getDate(START_DATE));
				employee.setStartDate(startDate);
				
				employee.setFirstName(rs.getString(FIRST_NAME));
				employee.setLastName(rs.getString(LAST_NAME));
				employee.setAddres(rs.getString(ADDRES));
				employee.setPhone(rs.getString(PHONE));
				employee.setUserName(rs.getString(USER_NAME));
				employee.setPassword(rs.getString(PASSWORD));
				
				employeeList.add(employee);
				
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error.", ex);
		} finally {
			close(prepStatement);
		}
		
		return employeeList;
	}
}
