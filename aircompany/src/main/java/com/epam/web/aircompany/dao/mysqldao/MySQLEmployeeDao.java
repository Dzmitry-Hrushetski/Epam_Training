/**
 * 
 */
package com.epam.web.aircompany.dao.mysqldao;

import java.sql.Connection;
import java.util.List;

import com.epam.web.aircompany.bean.Employee;
import com.epam.web.aircompany.dao.AbstractDao;
import com.epam.web.aircompany.dao.DAOException;
import com.epam.web.aircompany.dao.IEmployeeDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class MySQLEmployeeDao extends AbstractDao implements IEmployeeDao {

	/**
	 * @param connection
	 */
	public MySQLEmployeeDao(Connection connection) {
		super(connection);
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.IBaseDao#findAll()
	 */
	@Override
	public List<Employee> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.IBaseDao#findEntityByID(int)
	 */
	@Override
	public Employee findEntityByID(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.IBaseDao#addNewEntity(com.epam.web.aircompany.bean.Entity)
	 */
	@Override
	public boolean addNewEntity(Employee entity) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.epam.web.aircompany.dao.IBaseDao#updateEntity(com.epam.web.aircompany.bean.Entity, int)
	 */
	@Override
	public boolean updateEntity(Employee entity, int id) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
}
