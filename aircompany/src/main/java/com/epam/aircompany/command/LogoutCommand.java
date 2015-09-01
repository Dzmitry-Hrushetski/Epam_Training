package com.epam.aircompany.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * The Class LogoutCommand processes commands from all JSP pages and executes completion of session of the user.
 *
 * @author Dzmitry Hrushetski
 */
public class LogoutCommand implements ICommand {
	private static final String URL_LOGIN = "login";

	/* (non-Javadoc)
	 * @see com.epam.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String url = URL_BOUNDLE.getString(URL_LOGIN);
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		return url;
	}
}
