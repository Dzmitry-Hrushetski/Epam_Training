package com.epam.web.aircompany.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.web.aircompany.command.ICommand;
import com.epam.web.aircompany.command.CommandEnum;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	/**
	 * Processes the request
	 * 
	 * @param request
	 *            javax.servlet.http.HttpServletRequest
	 * @param response
	 *            javax.servlet.http.HttpServletResponse
	 * @throws ServletException
	 *             When a Servlet exception of some sort has occurred
	 * @throws IOException
	 *             When an I/O exception of some sort has occurred
	 */
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
				
		String action = request.getParameter("action");
		ICommand command = CommandEnum.valueOf(action.toUpperCase()).getCommand();
		
		//CommandEnum.valueOf(action.toUpperCase());
		
		//ICommand command = CommandFactory.getInstance().getCommand(request);
		String url = command.execute(request);
		/* putting the reconstructed ControllerServlet URL into request */
		request.setAttribute("base", request.getRequestURL().toString());
		/* forwarding the request to a proper JSP */
		//request.getRequestDispatcher(url).forward(request, response);
		request.getRequestDispatcher("/jsp/login/login.jsp").forward(request, response);
	}
}
