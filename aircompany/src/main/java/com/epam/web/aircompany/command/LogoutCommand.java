/**
 * 
 */
package com.epam.web.aircompany.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.epam.web.aircompany.connection.ConnectionPool;
import com.epam.web.aircompany.dao.IDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class LogoutCommand implements ICommand {
	private static final String URL_LOGIN = "login";

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest, com.epam.web.aircompany.connection.ConnectionPool, com.epam.web.aircompany.dao.IDao)
	 */
	@Override
	public String execute(HttpServletRequest request, ConnectionPool connectionPool, IDao databaseDao) {
		String url = URL_BOUNDLE.getString(URL_LOGIN);
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		return url;
	}

}
