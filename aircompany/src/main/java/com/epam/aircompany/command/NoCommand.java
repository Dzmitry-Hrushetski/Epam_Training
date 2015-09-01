package com.epam.aircompany.command;

import javax.servlet.http.HttpServletRequest;


/**
 * The Class NoCommand processes origin of an unknown command from the JSP page and executes transition to an application homepage.
 *
 * @author Dzmitry Hrushetski
 */
public class NoCommand implements ICommand {
	private static final String URL_INDEX = "/index.jsp";

	/* (non-Javadoc)
	 * @see com.epam.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return URL_INDEX;
	}

}
