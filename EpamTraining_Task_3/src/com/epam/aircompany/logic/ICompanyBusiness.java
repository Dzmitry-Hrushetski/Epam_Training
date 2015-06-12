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
	public int calculateTotalPassangerPlace(AirCompany company) throws BusinessExeption;
	public int calculateTotalTransportCargoWeight(AirCompany company) throws BusinessExeption;
	public int calculateTotalPassangerCargoWeight(AirCompany company) throws BusinessExeption;
	public Set<Airplane> findAirplaneFuelUsageRange(AirCompany company, int minFuelUsage, int maxFuelUsage) throws BusinessExeption;
}
