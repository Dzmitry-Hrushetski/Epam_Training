/**
 * 
 */
package com.epam.aircompany.logic;

import java.util.Set;

import com.epam.aircompany.beans.AirCompany;
import com.epam.aircompany.beans.Airplane;
import com.epam.aircompany.beans.PassangerAirplane;
import com.epam.aircompany.beans.TransportAirplane;
import com.epam.aircompany.exeptions.BusinessExeptions;
import com.epam.aircompany.exeptions.LogicalExeptions;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class CompanyBusiness implements ICompanyBusiness{
		
	
	/* (non-Javadoc)
	 * @see com.epam.aircompany.logic.ICompanyBusiness#getTotalPassangerPlace(com.epam.aircompany.beans.AirCompany)
	 */
	@Override
	public int getTotalPassangerPlace(AirCompany company) throws BusinessExeptions {
		int totalPlace=0;
		
		if(company==null) throw new BusinessExeptions("company is null");
		
		Set<Airplane> airplanes=company.getAirplanes();
		for(Airplane tmp: airplanes){
			if(tmp instanceof PassangerAirplane){
				totalPlace+=((PassangerAirplane) tmp).getBusinessPlace()+((PassangerAirplane) tmp).getEconomPlace();
			} 
		}
		return totalPlace;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.logic.ICompanyBusiness#getTotalTransportCargoWeight(com.epam.aircompany.beans.AirCompany)
	 */
	@Override
	public int getTotalTransportCargoWeight(AirCompany company) throws BusinessExeptions {
		int totalCargoWeigh=0;
		
		if(company==null) throw new BusinessExeptions("company is null");
		
		Set<Airplane> airplanes=company.getAirplanes();
		for(Airplane tmp: airplanes){
			if(tmp instanceof TransportAirplane){
				totalCargoWeigh+=((TransportAirplane) tmp).getMaxCargoWeight();
			}
		}
		
		return totalCargoWeigh;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.logic.ICompanyBusiness#getTotalPassangerCargoWeight(com.epam.aircompany.beans.AirCompany)
	 */
	@Override
	public int getTotalPassangerCargoWeight(AirCompany company) throws BusinessExeptions {
		int totalCargoWeigh=0;
		
		if(company==null) throw new BusinessExeptions("company is null");
		
		Set<Airplane> airplanes=company.getAirplanes();
		for(Airplane tmp: airplanes){
			if(tmp instanceof PassangerAirplane){
				totalCargoWeigh+=((PassangerAirplane) tmp).getMaxBaggageWeight();
			}
		}
		
		return totalCargoWeigh;
	}
}
