package com.epam.aircompany.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.aircompany.command.CommandEnum;
import com.epam.aircompany.command.ICommand;
import com.epam.aircompany.dao.IDao;
import com.epam.aircompany.pool.ConnectionPool;

import static com.epam.aircompany.constant.Constants.*;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final Logger LOG = Logger.getLogger(ControllerServlet.class);
	private static final long serialVersionUID = 1L;
	private static final String BASE = "base";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
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
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICommand command = null;
		/*ConnectionPool connectionPool = null;
		IDao dataBaseDao = null;
		
		ServletContext context = request.getSession().getServletContext();
		connectionPool = (ConnectionPool)context.getAttribute(CONNECTION_POOL);
		dataBaseDao = (IDao)context.getAttribute(I_DAO);*/
				
		String action = request.getParameter("action");
		
		if(action == null || action.isEmpty()) {
			command = CommandEnum.NO_COMMAND.getCommand();
 		} else {
 			try {
 				command = CommandEnum.valueOf(action.toUpperCase()).getCommand();
 			} catch (IllegalArgumentException ex) {
 				LOG.error("Illegal 'action' parametr in JSP.");
 				command = CommandEnum.NO_COMMAND.getCommand();
 			}
 		}
		
		String url = command.execute(request);
		
		/* putting the reconstructed ControllerServlet URL into request */
		request.setAttribute(BASE, request.getRequestURL().toString());
		
		/* forwarding the request to a proper JSP */
		request.getRequestDispatcher(url).forward(request, response);
	}
}
