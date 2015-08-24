/**
 * 
 */
package com.epam.aircompany.command;

import javax.servlet.http.HttpServletRequest;

import com.epam.aircompany.dao.IDao;
import com.epam.aircompany.pool.ConnectionPool;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class CreateNewEmployee implements ICommand {
	private static final String URL_CREATE_NEW = "create_new_employee";

	/* (non-Javadoc)
	 * @see com.epam.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest, com.epam.aircompany.pool.ConnectionPool, com.epam.aircompany.dao.IDao)
	 */
	@Override
	public String execute(HttpServletRequest request, ConnectionPool connectionPool, IDao databaseDao) {
		String url = URL_BOUNDLE.getString(URL_CREATE_NEW);
		
		return url;
	}

}
