/**
 * 
 */
package com.epam.aircompany.logic;

import java.util.Set;

import com.epam.aircompany.beans.AirCompany;
import com.epam.aircompany.beans.Airplane;
import com.epam.aircompany.beans.PassangerAirplane;
import com.epam.aircompany.beans.TransportAirplane;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class CompanyBusiness implements ICompanyBusiness{
		
	
	/* (non-Javadoc)
	 * @see com.epam.aircompany.logic.ICompanyBusiness#getTotalPassangerPlace(com.epam.aircompany.beans.AirCompany)
	 */
	@Override
	public int getTotalPassangerPlace(AirCompany company) {
		int totalPlace=0;
		
		if(company==null) return -1;
		
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
	public int getTotalTransportCargoWeight(AirCompany company) {
		int totalCargoWeigh=0;
		
		if(company==null) return -1;
		
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
	public int getTotalPassangerCargoWeight(AirCompany company) {
		int totalCargoWeigh=0;
		
		if(company==null) return -1;
		
		Set<Airplane> airplanes=company.getAirplanes();
		for(Airplane tmp: airplanes){
			if(tmp instanceof PassangerAirplane){
				totalCargoWeigh+=((PassangerAirplane) tmp).getMaxBaggageWeight();
			}
		}
		
		return totalCargoWeigh;
	}
}
