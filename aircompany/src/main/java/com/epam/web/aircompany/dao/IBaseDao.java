/**
 * 
 */
package com.epam.web.aircompany.dao;

import java.util.List;

import com.epam.web.aircompany.bean.Entity;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface IBaseDao<T extends Entity> {
	
	/**
	 * Returns the list of type T Entity objects (T can be a Member, Project,
	 * Issue, etc.) available in the application. The information is extracted
	 * from a database/data source.
	 * 
	 * @return The list of type T Entity objects (Members, Projects, Builds,
	 *         etc.)
	 * @throws DAOException
	 *             If a database access/handling error occurs.
	 */
	public List<T> findAll() throws DAOException;

	/**
	 * Returns an object of type T Entity (T can be a Member, Project, Issue,
	 * etc.) with the given ID. The information is extracted from a
	 * database/data source.
	 * 
	 * @param id
	 *            The id of the Entity (Member, Project, Build, etc.)
	 * @return Type T Entity object (Member, Project, Build, etc.)
	 * @throws DAOException
	 *             If a database access/handling error occurs.
	 */
	public T findEntityByID(int id) throws DAOException;

	/**
	 * Adds new object of type T Entity (T can be a Member, Project, Issue,
	 * etc.) to the database/data source.
	 * 
	 * @param entity
	 *            new type T Entity object (Member, Project, Build, etc.)
	 * @return {@code true} if the object is successfully added and
	 *         {@code false} otherwise
	 * @throws DAOException
	 *             If a database access/handling error occurs.
	 */
	public boolean addNewEntity(T entity) throws DAOException;

	/**
	 * Updates the data of type T Entity object (T can be a Member, Project,
	 * Issue, etc.) in the database/data source.
	 * 
	 * @param entity
	 *            new type T Entity object (Member, Project, Build, etc.)
	 * @param id
	 *            the ID of type T Entity object to be updated
	 * @return {@code true} if the object's data is successfully updated and
	 *         {@code false} otherwise
	 * @throws DAOException
	 *             If a database access/handling error occurs.
	 */
	public boolean updateEntity(T entity, int id) throws DAOException;
}
