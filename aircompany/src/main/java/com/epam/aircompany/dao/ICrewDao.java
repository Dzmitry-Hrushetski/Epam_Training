package com.epam.aircompany.dao;

import java.util.ArrayList;

import com.epam.aircompany.bean.Crew;

/**
 * The Interface ICrewDao describes own DAO methods for entity Crew.
 *
 * @author Dzmitry Hrushetski
 */
public interface ICrewDao extends IBaseDao<Crew> {

	/**
	 * Find entity by route id.
	 *
	 * @param id the id
	 * @return Crew
	 * @throws DaoException the dao exception
	 */
	Crew findEntityByRouteId(int id)  throws DaoException;
	
	/**
	 * Delete crew by route id.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws DaoException the dao exception
	 */
	boolean deleteCrewByRouteId(int id) throws DaoException;
	
	/**
	 * Save crew by route id.
	 *
	 * @param id the id
	 * @param crewData the crew data
	 * @return true, if successful
	 * @throws DaoException the dao exception
	 */
	boolean saveCrewByRouteId(int id, ArrayList<String> crewData) throws DaoException;
}
