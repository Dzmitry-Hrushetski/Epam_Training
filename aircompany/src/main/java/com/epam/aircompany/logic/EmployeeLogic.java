/**
 * 
 */
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
 * @author Dzmitry Hrushetski
 *
 */
public class EmployeeLogic extends BaseLogic {
	private static final String PARAM_EMPLOYEE_LIST = "employee_list";
	private static final String PARAM_POSITION_LIST = "position_list";
	private static final String PARAM_EMPLOYEE_ENTITY = "employee_entity";
	private static final int CHEEF = 1;
	private static final int ADMIN = 2;
	private static final int MANAGER = 3;
	private static final int FIRST_EMPLOYEE = 0;
	
	
	/**
	 * 
	 */
	public EmployeeLogic() {
		super();
	}

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
	 * @param employee
	 * @throws LogicException 
	 */
	public HashMap<String, Object> generateEmployeeJspData(Employee employee) throws LogicException {
		
		HashMap<String,Object> rezultMap = new HashMap<String,Object>();
		
		switch(employee.getPosition().getId()) {
		case CHEEF:
			try {	
				connection = connectionPool.getConnection();
				IEmployeeDao iEmployee = databaseDao.createIEmployeeDao(connection);
				IPositionDao iPosition = databaseDao.createIPositionDao(connection);
				List<Employee> employeeList = iEmployee.findEmployeeByPositionId(CHEEF);
				List<Position> positionList = iPosition.findAll();
				
				Employee firstEmployee = null;
				
				if(!employeeList.isEmpty()) {
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
			break;
		case ADMIN:
			
			break;
		case MANAGER:
			
			break;
		}
		return rezultMap;
	}

	/**
	 * @param positionId
	 * @return
	 * @throws LogicException 
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
	 * @param id
	 * @return
	 * @throws LogicException 
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
}
