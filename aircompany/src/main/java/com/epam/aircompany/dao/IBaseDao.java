package com.epam.aircompany.dao;

import java.util.List;

import com.epam.aircompany.bean.Entity;

/**
 * The interface IBaseDao describes the general DAO methods for all Entity
 * 
 * @author Dzmitry Hrushetski
 *
 */
public interface IBaseDao<T extends Entity> {
	
	/**
	 * Returns the list of type T Entity objects available in the application. The information is extracted
	 * from a database/data source.
	 * 
	 * @return The list of type T Entity objects
	 * 
	 * @throws DaoException
	 *             If a database access/handling error occurs.
	 */
	public List<T> findAll() throws DaoException;

	/**
	 * Returns an object of type T Entity with the given ID. The information is extracted from a
	 * database/data source.
	 * 
	 * @param id
	 *            The id of the Entity
	 *            
	 * @return Type T Entity object
	 * 
	 * @throws DaoException
	 *             If a database access/handling error occurs.
	 */
	public T findEntityByID(int id) throws DaoException;

	/**
	 * Adds new object of type T Entity to the database/data source.
	 * 
	 * @param entity
	 *            new type T Entity object
	 * @return true if the object is successfully added and
	 *         false otherwise
	 * @throws DaoException
	 *             If a database access/handling error occurs.
	 */
	public boolean addNewEntity(T entity) throws DaoException;

	/**
	 * Updates the data of type T Entity object in the database/data source.
	 * 
	 * @param entity
	 *            new type T Entity object
	 * @param id
	 *            the ID of type T Entity object to be updated
	 * @return true if the object's data is successfully updated and
	 *         false otherwise
	 * @throws DaoException
	 *             If a database access/handling error occurs.
	 */
	public boolean updateEntity(T entity, int id) throws DaoException;
}
