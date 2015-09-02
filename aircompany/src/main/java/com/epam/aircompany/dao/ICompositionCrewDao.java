package com.epam.aircompany.dao;

import com.epam.aircompany.bean.CompositionCrew;

/**
 * The Interface ICompositionCrewDao describes own DAO methods for entity CompositionCrew.
 *
 * @author Dzmitry Hrushetski
 */
public interface ICompositionCrewDao extends IBaseDao<CompositionCrew> {
	
	/**
	 * Find entity by AirplaneType id.
	 *
	 * @param id the AirplaneType ID
	 * @return CompositionCrew
	 * @throws DaoException the dao exception
	 */
	CompositionCrew findEntityByAirplaneTypeId(int id) throws DaoException;
}
