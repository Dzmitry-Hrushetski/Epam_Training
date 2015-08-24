/**
 * 
 */
package com.epam.aircompany.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.epam.aircompany.dao.IDao;
import com.epam.aircompany.pool.ConnectionPool;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class LogoutCommand implements ICommand {
	private static final String URL_LOGIN = "login";

	/* (non-Javadoc)
	 * @see com.epam.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest, com.epam.aircompany.pool.ConnectionPool, com.epam.aircompany.dao.IDao)
	 */
	@Override
	public String execute(HttpServletRequest request, ConnectionPool connectionPool, IDao databaseDao) {
		String url = URL_BOUNDLE.getString(URL_LOGIN);
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		return url;
	}

}
