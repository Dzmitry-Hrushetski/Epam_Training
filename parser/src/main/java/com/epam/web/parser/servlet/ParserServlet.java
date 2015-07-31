/**
 * 
 */
package com.epam.web.parser.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.aircompany.runner.Runner;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class ParserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2615203379383467833L;
	private static final String MAIN_PAGE = "/page/main.jsp";
	private static final String ATTRIBUTE_NAME = "airplanes";
	private static final String PARAMETR_NAME = "typeParser";
	private ServletConfig servletConfig;

	public void init(ServletConfig servletConfig) throws ServletException {
		this.servletConfig = servletConfig;
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.servletConfig.getServletContext().getRequestDispatcher(MAIN_PAGE)
				.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute(ATTRIBUTE_NAME, Runner.webStart(request.getParameter(PARAMETR_NAME)));

		request.getRequestDispatcher(MAIN_PAGE).forward(request, response);
	}
}
