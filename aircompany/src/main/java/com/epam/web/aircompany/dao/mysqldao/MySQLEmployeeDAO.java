/**
 * 
 */
package com.epam.web.aircompany.dao.mysqldao;

import java.sql.Connection;
import java.util.List;

import com.epam.web.aircompany.bean.Employee;
import com.epam.web.aircompany.dao.AbstractDAO;
import com.epam.web.aircompany.dao.DAOException;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class MySQLEmployeeDAO extends AbstractDAO<Employee> {

	/**
	 * @param connection
	 */
	public MySQLEmployeeDAO(Connection connection) {
		super(connection);
	}

	public Employee findEmployeeByLogin(String login) throws DAOException {
		return null;
	}
	
	
	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.AbstractDAO#findAll()
	 */
	@Override
	public List<Employee> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.AbstractDAO#findEntityByID(int)
	 */
	@Override
	public Employee findEntityByID(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.AbstractDAO#addNewEntity(com.epam.web.aircompany.bean.Entity)
	 */
	@Override
	public boolean addNewEntity(Employee entity) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.AbstractDAO#updateEntity(com.epam.web.aircompany.bean.Entity, int)
	 */
	@Override
	public boolean updateEntity(Employee entity, int id) throws DAOException {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Error. This operation is not supported!");
		return false;
	}

}
