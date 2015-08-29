/**
 * 
 */
package com.epam.aircompany.logic;

import java.util.ArrayList;

import com.epam.aircompany.bean.Crew;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IBaseDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface ICrewDao extends IBaseDao<Crew> {

	Crew findEntityByRouteId(int id)  throws DaoException;

	boolean deleteCrewByRouteId(int id) throws DaoException;

	boolean saveCrewByRouteId(int id, ArrayList<String> crewData) throws DaoException;

}
