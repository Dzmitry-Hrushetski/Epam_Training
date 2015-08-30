/**
 * 
 */
package com.epam.aircompany.dao;

import java.util.ArrayList;

import com.epam.aircompany.bean.Crew;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface ICrewDao extends IBaseDao<Crew> {

	Crew findEntityByRouteId(int id)  throws DaoException;
	boolean deleteCrewByRouteId(int id) throws DaoException;
	boolean saveCrewByRouteId(int id, ArrayList<String> crewData) throws DaoException;

}
