/**
 * 
 */
package com.epam.web.aircompany.dao;

import com.epam.web.aircompany.bean.Employee;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface IEmployeeDao extends IBaseDao<Employee>{
	
	public Employee findEmployeeByUserName(String userName) throws DaoException;

}
