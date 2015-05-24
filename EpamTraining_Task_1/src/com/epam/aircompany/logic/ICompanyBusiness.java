/**
 * 
 */
package com.epam.aircompany.logic;

import com.epam.aircompany.beans.AirCompany;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface ICompanyBusiness {
	
	public int getTotalPassangerPlace(AirCompany company);
	public int getTotalTransportCargoWeight(AirCompany company);
	public int getTotalPassangerCargoWeight(AirCompany company);
	
	/*public int getMaxPassangerPlace(AirCompany company);
	public int getMaxTransportCargoWeight(AirCompany company);
	public int getMaxPassangerCargoWeight(AirCompany company);*/
}
