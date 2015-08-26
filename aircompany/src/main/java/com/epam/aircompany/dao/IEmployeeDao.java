/**
 * 
 */
package com.epam.aircompany.dao;

import java.util.HashMap;
import java.util.List;

import com.epam.aircompany.bean.Employee;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface IEmployeeDao extends IBaseDao<Employee>{
	
	public Employee findEmployeeByUserName(String userName) throws DaoException;
	public List<Employee> findEmployeeByPositionId(int positionId) throws DaoException;
	/**
	 * @param employeeId
	 * @return
	 */
	public boolean deleteEntityByID(int employeeId) throws DaoException;
	/**
	 * @param employeeId
	 * @param employeeData
	 * @return
	 */
	public boolean updateEntityByID(int employeeId, HashMap<String, String> employeeData) throws DaoException;
	public boolean addNewEntity(HashMap<String, String> employeeData)throws DaoException;

}
