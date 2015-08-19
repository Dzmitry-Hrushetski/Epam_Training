/**
 * 
 */
package com.epam.web.aircompany.dao;

import java.util.List;

import com.epam.web.aircompany.bean.Employee;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface IEmployeeDao extends IBaseDao<Employee>{
	
	public Employee findEmployeeByUserName(String userName) throws DaoException;
	public List<Employee> findEmployeeByPositionId(int positionId) throws DaoException;

}
