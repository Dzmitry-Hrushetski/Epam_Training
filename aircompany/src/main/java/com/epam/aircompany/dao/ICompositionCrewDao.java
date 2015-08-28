/**
 * 
 */
package com.epam.aircompany.dao;

import com.epam.aircompany.bean.CompositionCrew;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface ICompositionCrewDao extends IBaseDao<CompositionCrew> {
	CompositionCrew findEntityByAirplaneTypeId(int id) throws DaoException;

}
