package com.epam.aircompany.command;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;


/**
 * Interface ICommand is an interface that will be implemented by all
 * Command classes that process data received from JSPs. It contains just one
 * method that will be invoked by a Servlet (Controller) in order to process the
 * request and redirect it to a chosen JSP.
 * 
 * @author Dzmitry Hrushetski
 *
 */
public interface ICommand {
	String URL_ERROR_PAGE = "error500";
	String BOUNDLE_NAME = "jsp_URL";
	ResourceBundle URL_BOUNDLE = ResourceBundle.getBundle(BOUNDLE_NAME);
	
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
