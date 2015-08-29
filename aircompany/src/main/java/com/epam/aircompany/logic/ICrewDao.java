/**
 * 
 */
package com.epam.aircompany.logic;

import com.epam.aircompany.bean.Crew;
import com.epam.aircompany.dao.DaoException;
import com.epam.aircompany.dao.IBaseDao;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface ICrewDao extends IBaseDao<Crew> {

	Crew findEntityByRouteId(int id)  throws DaoException;

}
