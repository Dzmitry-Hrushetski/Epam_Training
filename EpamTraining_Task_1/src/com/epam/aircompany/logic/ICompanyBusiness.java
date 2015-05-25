/**
 * 
 */
package com.epam.aircompany.logic;

import java.util.Set;

import com.epam.aircompany.bean.AirCompany;
import com.epam.aircompany.bean.Airplane;
import com.epam.aircompany.exeption.BusinessExeption;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface ICompanyBusiness {
	
	public int getTotalPassangerPlace(AirCompany company) throws BusinessExeption;
	public int getTotalTransportCargoWeight(AirCompany company) throws BusinessExeption;
	public int getTotalPassangerCargoWeight(AirCompany company) throws BusinessExeption;
	public Set<Airplane> findAirplaneFuelUsageRange(AirCompany company, int minFuelUsage, int maxFuelUsage) throws BusinessExeption;
	
	/*public int getMaxPassangerPlace(AirCompany company);
	public int getMaxTransportCargoWeight(AirCompany company);
	public int getMaxPassangerCargoWeight(AirCompany company);*/
}
