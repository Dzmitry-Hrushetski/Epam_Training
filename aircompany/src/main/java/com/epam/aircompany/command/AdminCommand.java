/**
 * 
 */
package com.epam.aircompany.command;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class AdminCommand implements ICommand {
	private static final String URL_ADMIN = "admin";
	private static final int FIRST_ROUTE = 0;
	private static final String PARAM_OPERATION = "operation";
	private static final String PARAM_ROUTE = "route";

	/* (non-Javadoc)
	 * @see com.epam.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String url = URL_BOUNDLE.getString(URL_ADMIN);
		
		String operation = request.getParameter(PARAM_OPERATION);
		switch(operation) {
		case PARAM_ROUTE:
			break;
		}
		
		return url;
	}

}
