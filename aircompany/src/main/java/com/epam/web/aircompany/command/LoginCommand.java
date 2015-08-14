/**
 * 
 */
package com.epam.web.aircompany.command;

import javax.servlet.http.HttpServletRequest;

import com.epam.web.aircompany.dao.IDao;
import com.epam.web.aircompany.dao.IEmployeeDao;
import com.epam.web.aircompany.dao.factory.DaoFactoryType;
import com.epam.web.aircompany.dao.factory.DatabaseFactory;
import com.epam.web.aircompany.dao.mysqldao.MySQLEmployeeDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class LoginCommand implements ICommand {

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.command.ICommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		
		IDao daoMySQL = DatabaseFactory.getInstance().getDatabaseDao(DaoFactoryType.MYSQL); 
		
		IEmployeeDao employee = daoMySQL.getIEmployeeDao(null);
		
		// TODO Auto-generated method stub
		return null;
	}

}
