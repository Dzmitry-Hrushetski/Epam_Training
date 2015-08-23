/**
 * 
 */
package com.epam.web.aircompany.command;

import javax.servlet.http.HttpServletRequest;

import com.epam.web.aircompany.connection.ConnectionPool;
import com.epam.web.aircompany.dao.IDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class CreateNewEmployee implements ICommand {
	private static final String URL_CREATE_NEW = "create_new_employee";

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest, com.epam.web.aircompany.connection.ConnectionPool, com.epam.web.aircompany.dao.IDao)
	 */
	@Override
	public String execute(HttpServletRequest request, ConnectionPool connectionPool, IDao databaseDao) {
		String url = URL_BOUNDLE.getString(URL_CREATE_NEW);
		
		return url;
	}

}
