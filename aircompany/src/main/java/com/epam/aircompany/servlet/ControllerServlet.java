package com.epam.aircompany.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.aircompany.command.CommandEnum;
import com.epam.aircompany.command.ICommand;

/**
 * The Class ControllerServlet is a Servlet implementation class that
 * controls communication between Command interface and JSPs. It calls the
 * proper Command class and then redirects the request to the proper JSP.
 *
 * @author Dzmitry Hrushetski
 */
public class ControllerServlet extends HttpServlet {
	private static final Logger LOG = Logger.getLogger(ControllerServlet.class);
	private static final long serialVersionUID = 1L;
	private static final String PARAM_ACTION = "action";
       
    /**
     * Instantiates a new controller servlet.
     */
    public ControllerServlet() {
        super();
    }

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	public void destroy() {
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	/**
	 * Process request.
	 *
	 * @param HttpServletRequest the request
	 * @param HttpServletResponse the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICommand command = null;
		String action = request.getParameter(PARAM_ACTION);
		
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
		
		/* forwarding the request to a proper JSP */
		request.getRequestDispatcher(url).forward(request, response);
	}
}
