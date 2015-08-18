/**
 * 
 */
package com.epam.web.aircompany.dao.mysqldao;

import java.sql.Connection;

import com.epam.web.aircompany.dao.IDao;
import com.epam.web.aircompany.dao.IEmployeeDao;
import com.epam.web.aircompany.dao.IPositionDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class MySQLDao implements IDao {

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.IDao#getIEmployeeDao()
	 */
	@Override
	public IEmployeeDao getIEmployeeDao(Connection connection) {
		return new MySQLEmployeeDao(connection);
	}

	@Override
	public IPositionDao getIPositionDao(Connection connection) {
		return new MySQLPositionDao(connection);
	}

}
