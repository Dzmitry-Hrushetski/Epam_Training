/**
 * 
 */
package com.epam.web.aircompany.command;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import com.epam.web.aircompany.connection.ConnectionPool;
import com.epam.web.aircompany.dao.IDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface ICommand {
	ResourceBundle URL_BOUNDLE = ResourceBundle.getBundle("jsp_URL");
	
	/**
	 * Method is called by a a Servlet (Controller) in order to process the
	 * request and redirect it to a chosen JSP.
	 * 
	 * @param request
	 *            javax.servlet.http.HttpServletRequest
	 * @return The URL of the JSP to which the request is forwarded.
	 */
	String execute(HttpServletRequest request, ConnectionPool connectionPool, IDao databaseDao);

}
