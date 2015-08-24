/**
 * 
 */
package com.epam.aircompany.dao.mysqldao;

import java.sql.Connection;

import com.epam.aircompany.dao.IDao;
import com.epam.aircompany.dao.IEmployeeDao;
import com.epam.aircompany.dao.IPositionDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class MySQLDao implements IDao {

	/* (non-Javadoc)
	 * @see com.epam.aircompany.dao.IDao#getIEmployeeDao()
	 */
	@Override
	public IEmployeeDao createIEmployeeDao(Connection connection) {
		return new MySQLEmployeeDao(connection);
	}

	@Override
	public IPositionDao createIPositionDao(Connection connection) {
		return new MySQLPositionDao(connection);
	}

}
