/**
 * 
 */
package com.epam.web.aircompany.dao.mysqldao;

import java.sql.Connection;

import com.epam.web.aircompany.dao.IDao;
import com.epam.web.aircompany.dao.IEmployeeDao;

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

}
