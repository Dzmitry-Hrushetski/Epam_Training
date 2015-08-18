/**
 * 
 */
package com.epam.web.aircompany.dao;

import java.sql.Connection;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface IDao {
	
	public IEmployeeDao getIEmployeeDao(Connection connection);
	public IPositionDao getIPositionDao(Connection connection);

}
