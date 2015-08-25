/**
 * 
 */
package com.epam.aircompany.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class LanguageCommand implements ICommand {
	private static final String PARAM_LANGUAGE = "sel_lang";
	private static final String LOCALE = "locale";
	private static final String URL_LOGIN = "login";

	/* (non-Javadoc)
	 * @see com.epam.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest, com.epam.aircompany.pool.ConnectionPool, com.epam.aircompany.dao.IDao)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String language = request.getParameter(PARAM_LANGUAGE);
		HttpSession session = request.getSession();
		session.setAttribute(LOCALE, language);
		return URL_BOUNDLE.getString(URL_LOGIN);
	}

}
