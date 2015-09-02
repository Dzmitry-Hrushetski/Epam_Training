package com.epam.aircompany.dao;

import java.util.HashMap;
import java.util.List;

import com.epam.aircompany.bean.Employee;

/**
 * The Interface IEmployeeDao describes own DAO methods for entity Employee.
 *
 * @author Dzmitry Hrushetski
 */
public interface IEmployeeDao extends IBaseDao<Employee>{
	
	/**
	 * Find employee by user name.
	 *
	 * @param userName the user name
	 * @return Employee
	 * @throws DaoException the dao exception
	 */
	public Employee findEmployeeByUserName(String userName) throws DaoException;
	
	/**
	 * Find employee by position id.
	 *
	 * @param positionId the position id
	 * @return List of Employee
	 * @throws DaoException the dao exception
	 */
	public List<Employee> findEmployeeByPositionId(int positionId) throws DaoException;
	
	/**
	 * Delete entity by id.
	 *
	 * @param employeeId the employee id
	 * @return true, if successful
	 * @throws DaoException the dao exception
	 */
	public boolean deleteEntityByID(int employeeId) throws DaoException;
	
	/**
	 * Update entity by id.
	 *
	 * @param employeeId the employee id
	 * @param employeeData HashMap key - String, value - String the employee data
	 * @return true, if successful
	 * @throws DaoException the dao exception
	 */
	public boolean updateEntityByID(int employeeId, HashMap<String, String> employeeData) throws DaoException;
	
	/**
	 * Adds the new entity.
	 *
	 * @param employeeData HashMap key - String, value - String the employee data
	 * @return true, if successful
	 * @throws DaoException the dao exception
	 */
	public boolean addNewEntity(HashMap<String, String> employeeData)throws DaoException;
}
