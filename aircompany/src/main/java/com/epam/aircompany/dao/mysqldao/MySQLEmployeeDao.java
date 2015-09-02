/**
 * 
 */
package com.epam.aircompany.dao.mysqldao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.aircompany.bean.Employee;
import com.epam.aircompany.bean.Position;
import com.epam.aircompany.dao.AbstractDao;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IEmployeeDao;
import com.epam.aircompany.util.HashPassword;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class MySQLEmployeeDao extends AbstractDao implements IEmployeeDao {
	private static final Logger LOG = Logger.getLogger(MySQLEmployeeDao.class);
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
	private static final String PARAM_FIRST_NAME = "first_name";
	private static final String PARAM_LAST_NAME = "last_name";
	private static final String PARAM_PHONE = "phone";
	private static final String PARAM_ADDRESS = "addres";
	private static final String PARAM_USER_NAME = "user_name";
	private static final String PARAM_PASSWORD = "password";
	private static final String PARAM_START_DATE = "calendar";
	private static final String PARAM_POSITION = "position";
	private static final String FIND_EMPLOYEE_BY_USER_NAME = "SELECT person.user_name, person.password, position.id, position.position_name FROM employee INNER JOIN person ON employee.person_id = person.id INNER JOIN position ON employee.position_id = position.id WHERE person.user_name = ? AND (position.position_name = 'Директор' OR position.position_name = 'Администратор' OR position.position_name = 'Диспетчер') AND employee.disable = 0";
	private static final String FIND_EMPLOYEE_BY_POSITION_ID = "SELECT employee.id, position.id, position.position_name, employee.start_date, person.first_name, person.last_name, person.addres, person.phone, person.user_name, person.password FROM employee INNER JOIN person ON employee.person_id = person.id INNER JOIN position ON employee.position_id = position.id WHERE position.id = ? AND employee.disable = 0";
	private static final String FIND_EMPLOYEE_BY_ID = "SELECT employee.id, position.id, position.position_name, employee.start_date, person.first_name, person.last_name, person.addres, person.phone, person.user_name, person.password FROM employee INNER JOIN person ON employee.person_id = person.id INNER JOIN position ON employee.position_id = position.id WHERE employee.id = ? AND employee.disable = 0";
	private static final String FIND_ALL_EMPLOYEE = "SELECT employee.id, position.id, position.position_name, employee.start_date, person.first_name, person.last_name, person.addres, person.phone, person.user_name, person.password FROM employee INNER JOIN person ON employee.person_id = person.id INNER JOIN position ON employee.position_id = position.id";
	private static final String DELETE_EMPLOYEE = "UPDATE employee INNER JOIN person ON employee.person_id = person.id SET employee.disable = 1, person.disable = 1 WHERE employee.id = ?";
	private static final String UPDATE_EMPLOYEE_BY_ID = "UPDATE employee INNER JOIN person ON employee.person_id = person.id SET employee.start_date = ?, person.first_name = ?, person.last_name = ?, person.addres = ?, person.phone = ?, person.user_name = ?, person.password = ? WHERE employee.id = ?";
	private static final String ADD_PERSON = "INSERT INTO person (first_name, last_name, addres, phone, user_name, password, disable) VALUES (?, ?, ?, ?, ?, ?, 0)";
	private static final String ADD_EMPLOYEE = "INSERT INTO employee (person_id, position_id, start_date, disable) VALUES (LAST_INSERT_ID(), ?, ?, 0)";
		/**
	 * @param connection
	 */
	public MySQLEmployeeDao(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#findAll()
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
	 * @see com.epam.aircompany.dao.IBaseDao#findEntityByID(int)
	 */
	@Override
	public Employee findEntityByID(int id) throws DaoException {
		Employee employee = null;
		PreparedStatement prepStatement = null;
		 		
		try {
			prepStatement = connection.prepareStatement(FIND_EMPLOYEE_BY_ID);
			
			prepStatement.setInt(1,id);
			ResultSet rs = prepStatement.executeQuery();
			while (rs.next()) {
				
				Position position = new Position();
				position.setId(rs.getInt(POSITION_ID));
				position.setPositionName(rs.getString(POSITION_NAME));
				
				employee = new Employee();
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
			}
		} catch (SQLException ex) {
			throw new DaoException("Database error.", ex);
		} finally {
			close(prepStatement);
		}		
		return employee;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#addNewEntity(com.epam.aircompany.bean.Entity)
	 */
	@Override
	public boolean addNewEntity(Employee entity) throws DaoException {
		throw new UnsupportedOperationException("Error. This operation is not supported!");
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IBaseDao#updateEntity(com.epam.aircompany.bean.Entity, int)
	 */
	@Override
	public boolean updateEntity(Employee entity, int id) throws DaoException {
		throw new UnsupportedOperationException("Error. This operation is not supported!");
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
	 * @see com.epam.aircompany.dao.IEmployeeDao#findEmployeeByPositionId(int)
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

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IEmployeeDao#deleteEntityByID(int)
	 */
	@Override
	public boolean deleteEntityByID(int employeeId) throws DaoException {
		PreparedStatement prepStatement = null;
		boolean isOk = false;
		 		
		try {
			prepStatement = connection.prepareStatement(DELETE_EMPLOYEE);
			
			prepStatement.setInt(1,employeeId);
			prepStatement.executeUpdate();
			isOk = true;
			
		} catch (SQLException ex) {
			throw new DaoException("Database error.", ex);
		} finally {
			close(prepStatement);
		}
		return isOk;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IEmployeeDao#updateEntityByID(int, java.util.HashMap)
	 */
	@Override
	public boolean updateEntityByID(int employeeId, HashMap<String, String> employeeData) throws DaoException {
		PreparedStatement prepStatement = null;
		boolean isOk = false;
		 		
		try {
			prepStatement = connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID);
			
			prepStatement.setString(2,employeeData.get(PARAM_FIRST_NAME));
			prepStatement.setString(3,employeeData.get(PARAM_LAST_NAME));
			prepStatement.setString(4,employeeData.get(PARAM_ADDRESS));
			prepStatement.setString(5,employeeData.get(PARAM_PHONE));
			prepStatement.setString(6,employeeData.get(PARAM_USER_NAME));
			prepStatement.setString(7,HashPassword.calculateHashPassword(employeeData.get(PARAM_PASSWORD)));
			prepStatement.setDate(1,Date.valueOf(employeeData.get(PARAM_START_DATE)));		
			prepStatement.setInt(8,employeeId);
			prepStatement.executeUpdate();
			isOk = true;
			
		} catch (SQLException ex) {
			throw new DaoException("Database error.", ex);
		} finally {
			close(prepStatement);
		}
		return isOk;
	}

	@Override
	public boolean addNewEntity(HashMap<String, String> employeeData) throws DaoException {
		boolean isAdded = false;
		PreparedStatement prepStatement = null;

		try {
			connection.setAutoCommit(false);
			
			prepStatement = connection.prepareStatement(ADD_PERSON);
			
			prepStatement.setString(1,employeeData.get(PARAM_FIRST_NAME));
			prepStatement.setString(2,employeeData.get(PARAM_LAST_NAME));
			prepStatement.setString(3,employeeData.get(PARAM_ADDRESS));
			prepStatement.setString(4,employeeData.get(PARAM_PHONE));
			prepStatement.setString(5,employeeData.get(PARAM_USER_NAME));
			prepStatement.setString(6,HashPassword.calculateHashPassword(employeeData.get(PARAM_PASSWORD)));
			prepStatement.executeUpdate();
			
			close(prepStatement);
			
			prepStatement = connection.prepareStatement(ADD_EMPLOYEE);
			prepStatement.setInt(1,Integer.parseInt(employeeData.get(PARAM_POSITION)));
			prepStatement.setDate(2,Date.valueOf(employeeData.get(PARAM_START_DATE)));
			
			prepStatement.executeUpdate();
			
			connection.commit();
			
			isAdded = true;
		} catch (SQLException ex) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				LOG.error("Error in metod addNewEntity, roollback exception", e);
			}
			throw new DaoException("Database error", ex);
		} finally {
			close(prepStatement);
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				LOG.error("Error in metod addNewEntity, setAutoCommit exception", e);
			}
		}
		return isAdded;
	}
}
