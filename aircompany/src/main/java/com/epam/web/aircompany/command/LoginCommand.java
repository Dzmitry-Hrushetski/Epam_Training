/**
 * 
 */
package com.epam.web.aircompany.command;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.epam.web.aircompany.connection.ConnectionPool;
import com.epam.web.aircompany.dao.DaoException;
import com.epam.web.aircompany.dao.IDao;
import com.epam.web.aircompany.dao.IEmployeeDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class LoginCommand implements ICommand {
	
	private static final Logger LOG = Logger.getLogger(LoginCommand.class);

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request, ConnectionPool connectionPool, IDao databaseDao) {
		Connection connection = connectionPool.getConnection();
				
		IEmployeeDao employee = databaseDao.getIEmployeeDao(connection);
		try {
			employee.findEmployeeByUserName("director");
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connectionPool.releaseConnection(connection);
		}
		
		// TODO Auto-generated method stub
		return null;
	}

}
