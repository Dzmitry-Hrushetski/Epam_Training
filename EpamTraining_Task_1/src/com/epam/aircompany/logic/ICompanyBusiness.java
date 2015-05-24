/**
 * 
 */
package com.epam.aircompany.logic;

import com.epam.aircompany.beans.AirCompany;
import com.epam.aircompany.exeptions.BusinessExeptions;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface ICompanyBusiness {
	
	public int getTotalPassangerPlace(AirCompany company) throws BusinessExeptions;
	public int getTotalTransportCargoWeight(AirCompany company) throws BusinessExeptions;
	public int getTotalPassangerCargoWeight(AirCompany company) throws BusinessExeptions;
	
	/*public int getMaxPassangerPlace(AirCompany company);
	public int getMaxTransportCargoWeight(AirCompany company);
	public int getMaxPassangerCargoWeight(AirCompany company);*/
}
