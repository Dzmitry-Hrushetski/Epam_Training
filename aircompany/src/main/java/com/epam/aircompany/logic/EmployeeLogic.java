package com.epam.aircompany.logic;

import java.util.HashMap;
import java.util.List;

import com.epam.aircompany.bean.Employee;
import com.epam.aircompany.bean.Position;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IEmployeeDao;
import com.epam.aircompany.dao.IPositionDao;
import com.epam.aircompany.pool.ConnectionPoolException;

/**
 * The Class EmployeeLogic contains various methods that use DAO layer to
 * retrieve information about the Employee(s) from a database.
 *
 * @author Dzmitry Hrushetski
 */
public class EmployeeLogic extends BaseLogic {
	private static final String PARAM_EMPLOYEE_LIST = "employee_list";
	private static final String PARAM_POSITION_LIST = "position_list";
	private static final String PARAM_EMPLOYEE_ENTITY = "employee_entity";
	private static final int CHEEF = 1;
	private static final int FIRST_EMPLOYEE = 0;
	
	
	/**
	 * Instantiates a new employee logic.
	 */
	public EmployeeLogic() {
		super();
	}

	/**
	 * Find Employee by user name.
	 *
	 * @param userName the user name
	 * @return Employee
	 * @throws LogicException the logic exception
	 */
	public Employee findEmployeeByUserName(String userName) throws LogicException {
		Employee employee = null;
		
		try {
			
			connection = connectionPool.getConnection();
			IEmployeeDao iEmployee = databaseDao.createIEmployeeDao(connection);
			employee = iEmployee.findEmployeeByUserName(userName);
			
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}
		return employee;
	}

	/**
	 * Prepares data for operation on the page of the director.
	 *
	 * @param Employee 
	 * @return HashMap<String, Object>
	 * @throws LogicException the logic exception
	 */
	public HashMap<String, Object> generateEmployeeJspData(Employee employee) throws LogicException {

		HashMap<String, Object> rezultMap = new HashMap<String, Object>();

		try {
			connection = connectionPool.getConnection();
			IEmployeeDao iEmployee = databaseDao.createIEmployeeDao(connection);
			IPositionDao iPosition = databaseDao.createIPositionDao(connection);
			List<Employee> employeeList = iEmployee.findEmployeeByPositionId(CHEEF);
			List<Position> positionList = iPosition.findAll();

			Employee firstEmployee = null;

			if (!employeeList.isEmpty()) {
				firstEmployee = iEmployee.findEntityByID(employeeList.get(FIRST_EMPLOYEE).getId());
				rezultMap.put(PARAM_EMPLOYEE_ENTITY, firstEmployee);
			}

			rezultMap.put(PARAM_EMPLOYEE_LIST, employeeList);
			rezultMap.put(PARAM_POSITION_LIST, positionList);

		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e);
		} finally {
			connectionPool.releaseConnection(connection);
		}
		return rezultMap;
	}

	/**
	 * Find Employee by position id.
	 *
	 * @param positionId the position id
	 * @return List<Employee>
	 * @throws LogicException the logic exception
	 */
	public List<Employee> findEmployeeByPositionId(int positionId) throws LogicException {
		List<Employee> employeeList = null;
		
		try {	
			
			connection = connectionPool.getConnection();
			IEmployeeDao iEmployee = databaseDao.createIEmployeeDao(connection);
			employeeList = iEmployee.findEmployeeByPositionId(positionId);
			
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}	
		return employeeList;
	}

	/**
	 * Find Employee by id.
	 *
	 * @param id the employee id
	 * @return Employee
	 * @throws LogicException the logic exception
	 */
	public Employee findEntityByID(int id) throws LogicException {
		Employee employee = null;
		
		try {	
			
			connection = connectionPool.getConnection();
			IEmployeeDao iEmployee = databaseDao.createIEmployeeDao(connection);
			employee = iEmployee.findEntityByID(id);
			
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}	
		return employee;
	}

	/**
	 * Delete Employee by id.
	 *
	 * @param employeeId the employee id
	 * @return true, if successful
	 * @throws LogicException the logic exception
	 */
	public boolean deleteEntityByID(int employeeId) throws LogicException {
		boolean isOk = false;
		
		try {	
			
			connection = connectionPool.getConnection();
			IEmployeeDao iEmployee = databaseDao.createIEmployeeDao(connection);
			isOk = iEmployee.deleteEntityByID(employeeId);
			
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}	
		return isOk;
	}

	/**
	 * Update Employee by id.
	 *
	 * @param employeeId the employee id
	 * @param HashMap<String,String> the employee data
	 * @return true, if successful
	 * @throws LogicException the logic exception
	 */
	public boolean updateEntityByID(int employeeId, HashMap<String,String> employeeData) throws LogicException {
		boolean isOk = false;
		
		try {	
			
			connection = connectionPool.getConnection();
			IEmployeeDao iEmployee = databaseDao.createIEmployeeDao(connection);
			isOk = iEmployee.updateEntityByID(employeeId, employeeData);
			
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}	
		return isOk;
	}

	/**
	 * Adds the new Employee.
	 *
	 * @param HashMap<String, String> the employee data
	 * @return true, if successful
	 * @throws LogicException the logic exception
	 */
	public boolean addNewEntity(HashMap<String, String> employeeData) throws LogicException {
		boolean isOk = false;
		
		try {	
			
			connection = connectionPool.getConnection();
			IEmployeeDao iEmployee = databaseDao.createIEmployeeDao(connection);
			isOk = iEmployee.addNewEntity(employeeData);
			
		} catch (ConnectionPoolException | DaoException e) {
			throw new LogicException(e); 
		} finally {
			connectionPool.releaseConnection(connection);
		}	
		return isOk;
	}
}
