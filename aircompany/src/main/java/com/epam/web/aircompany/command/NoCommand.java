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
public class NoCommand implements ICommand {

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request, ConnectionPool connectionPool, IDao databaseDao) {
		// TODO Auto-generated method stub
		return "/jsp/cheef/cheef.jsp";
	}

}
