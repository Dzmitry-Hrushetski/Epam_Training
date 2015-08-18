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
public class LanguageCommand implements ICommand {
	private static final String PARAM_LANGUAGE = "locale";
	private static final String URL_LOGIN = "login";

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest, com.epam.web.aircompany.connection.ConnectionPool, com.epam.web.aircompany.dao.IDao)
	 */
	@Override
	public String execute(HttpServletRequest request, ConnectionPool connectionPool, IDao databaseDao) {
		String language = request.getParameter(PARAM_LANGUAGE);
		HttpSession session = request.getSession();
		session.setAttribute(PARAM_LANGUAGE, language);
		return URL_BOUNDLE.getString(URL_LOGIN);
	}

}
