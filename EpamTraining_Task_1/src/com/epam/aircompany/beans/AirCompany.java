/**
 * 
 */
package com.epam.aircompany.beans;

import java.util.Set;
import java.util.TreeSet;

import com.epam.aircompany.exeptions.LogicalExeptions;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class AirCompany {
	private static final String COMPANY_STRING_1="The %s has no airplanes.";
	private static final String COMPANY_STRING_2="The %s has %d airplanes.";
	private String companyName;
	private Set<Airplane> airplanes;
	
	
	public AirCompany(String companyName) throws LogicalExeptions {
		super();
		if(companyName!=null && !companyName.isEmpty()){
			this.companyName = companyName;
		} else{
			throw new LogicalExeptions("Incorrect companyName");
		}
		
		//airplanes= new HashSet<Airplane>();
		airplanes= new TreeSet<Airplane>();
	}

		
	public boolean add(Airplane e) {
		return airplanes.add(e);
	}


	public Set<Airplane> getAirplanes() {
		return airplanes;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) throws LogicalExeptions {
		
		if(companyName!=null && !companyName.isEmpty()){
			this.companyName = companyName;
		} else{
			throw new LogicalExeptions("Incorrect companyName");
		}
	}


	@Override
	public String toString() {
		
		return airplanes.isEmpty()? String.format(COMPANY_STRING_1, companyName) : String.format(COMPANY_STRING_2, companyName, airplanes.size());
	}
}
