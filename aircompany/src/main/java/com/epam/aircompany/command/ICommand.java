/**
 * 
 */
package com.epam.aircompany.command;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Dzmitry Hrushetski
 *
 */
public interface ICommand {
	String URL_ERROR = "error500";
	ResourceBundle URL_BOUNDLE = ResourceBundle.getBundle("jsp_URL");
	
	/**
	 * Method is called by a a Servlet (Controller) in order to process the
	 * request and redirect it to a chosen JSP.
	 * 
	 * @param request
	 *            javax.servlet.http.HttpServletRequest
	 * @return The URL of the JSP to which the request is forwarded.
	 */
	String execute(HttpServletRequest request);
}
