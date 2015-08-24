/**
 * 
 */
package com.epam.aircompany.dao;

import java.sql.Connection;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface IDao {
	
	public IEmployeeDao createIEmployeeDao(Connection connection);
	public IPositionDao createIPositionDao(Connection connection);

}
