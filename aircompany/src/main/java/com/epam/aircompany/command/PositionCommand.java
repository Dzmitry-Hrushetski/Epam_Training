/**
 * 
 */
package com.epam.aircompany.command;

import javax.servlet.http.HttpServletRequest;

import com.epam.aircompany.dao.IDao;
import com.epam.aircompany.dao.IEmployeeDao;
import com.epam.aircompany.dao.IPositionDao;
import com.epam.aircompany.pool.ConnectionPool;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class PositionCommand implements ICommand {
	private static final String URL_CHEEF = "cheef";
	private static final String PARAM_EMPLOYEE_LIST = "employee_list";
	private static final String PARAM_POSITION_LIST = "position_list";
	private static final String PARAM_POSITION = "position";

	/* (non-Javadoc)
	 * @see com.epam.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest, com.epam.aircompany.pool.ConnectionPool, com.epam.aircompany.dao.IDao)
	 */
	@Override
	public String execute(HttpServletRequest request, ConnectionPool connectionPool, IDao databaseDao) {
		
		String url = URL_BOUNDLE.getString(URL_CHEEF);
		/*IEmployeeDao iEmployee = (IEmployeeDao) request.getAttribute(PARAM_EMPLOYEE_LIST);
		IPositionDao iPosition = (IPositionDao) request.getAttribute(PARAM_POSITION_LIST);
		int position = (int) request.getAttribute(PARAM_POSITION);
		
		request.setAttribute(PARAM_EMPLOYEE_LIST, iEmployee);
		request.setAttribute(PARAM_POSITION_LIST, iPosition);
		request.setAttribute(PARAM_POSITION, position);*/
		
		return url;
	}

}
