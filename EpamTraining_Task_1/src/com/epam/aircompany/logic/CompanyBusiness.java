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
public class CompanyBusiness {
	private AirCompany company;
	
	
	public static int[] getTotalCapasity(AirCompany company)
	{
		Set<Airplane> airplanes=null;
		int[] totalCapasity={0,0};
		
		airplanes=company.getAirplanes();
		for(Airplane tmp: airplanes){
			if(tmp instanceof PassangerAirplane){
				totalCapasity[0]+=((PassangerAirplane) tmp).getBusinessPlace()+((PassangerAirplane) tmp).getEconomPlace();
				totalCapasity[1]+=((PassangerAirplane) tmp).getMaxBaggageWeight();
				
			} else{
				if(tmp instanceof TransportAirplane){
					totalCapasity[1]+=((TransportAirplane) tmp).getMaxCargoWeight();
				}
			}
		}
		
		return totalCapasity;
	}
	
	
	
	
}
