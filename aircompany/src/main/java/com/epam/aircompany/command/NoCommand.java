/**
 * 
 */
package com.epam.aircompany.command;

import javax.servlet.http.HttpServletRequest;

import com.epam.aircompany.dao.IDao;
import com.epam.aircompany.pool.ConnectionPool;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class NoCommand implements ICommand {

	/* (non-Javadoc)
	 * @see com.epam.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "/index.jsp";
	}

}
