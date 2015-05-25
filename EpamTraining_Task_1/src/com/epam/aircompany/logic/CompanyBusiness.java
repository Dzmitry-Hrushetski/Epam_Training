/**
 * 
 */
package com.epam.aircompany.logic;

import java.util.Set;
import java.util.TreeSet;

import com.epam.aircompany.bean.AirCompany;
import com.epam.aircompany.bean.Airplane;
import com.epam.aircompany.bean.PassangerAirplane;
import com.epam.aircompany.bean.TransportAirplane;
import com.epam.aircompany.exeption.BusinessExeption;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class CompanyBusiness implements ICompanyBusiness{
		
	
	/* (non-Javadoc)
	 * @see com.epam.aircompany.logic.ICompanyBusiness#getTotalPassangerPlace(com.epam.aircompany.beans.AirCompany)
	 */
	@Override
	public int calculateTotalPassangerPlace(AirCompany company) throws BusinessExeption {
		int totalPlace=0;
		
		if(company==null){
			throw new BusinessExeption("company instance is null");
		}
		
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
	public int calculateTotalTransportCargoWeight(AirCompany company) throws BusinessExeption {
		int totalCargoWeigh=0;
		
		if(company==null){
			throw new BusinessExeption("company instance is null");
		}
		
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
	public int calculateTotalPassangerCargoWeight(AirCompany company) throws BusinessExeption {
		int totalCargoWeigh=0;
		
		if(company==null){
			throw new BusinessExeption("company instance is null");
		}
		
		Set<Airplane> airplanes=company.getAirplanes();
		for(Airplane tmp: airplanes){
			if(tmp instanceof PassangerAirplane){
				totalCargoWeigh+=((PassangerAirplane) tmp).getMaxBaggageWeight();
			}
		}
		
		return totalCargoWeigh;
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.logic.ICompanyBusiness#findAirplaneFuelUsageRange(com.epam.aircompany.beans.AirCompany, int, int)
	 */
	@Override
	public Set<Airplane> findAirplaneFuelUsageRange(AirCompany company, int minFuelUsage,
			int maxFuelUsage) throws BusinessExeption {
		
		if(company==null){
			throw new BusinessExeption("company instance is null");
		}
		
		if(minFuelUsage<=0 || maxFuelUsage<=0 || maxFuelUsage<minFuelUsage){
			throw new BusinessExeption("minFuelUsage and maxFuelUsage is wrong");
		}
		
		Set<Airplane> findAirplanes = new TreeSet<Airplane>();
		Set<Airplane> airplanes=company.getAirplanes();
		
		for(Airplane tmp: airplanes){
			if(minFuelUsage<=tmp.getFuelUsage() && tmp.getFuelUsage()<=maxFuelUsage){
				findAirplanes.add(tmp);
			}
		}
			
		return findAirplanes;
	}
}
