/**
 * 
 */
package com.epam.aircompany.runner;

import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.aircompany.beans.AirCompany;
import com.epam.aircompany.beans.Airplane;
import com.epam.aircompany.creator.CompanyCreator;
import com.epam.aircompany.logic.CompanyBusiness;
import com.epam.aircompany.logic.CompanyOutputData;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class Runner {

	public static Logger LOG = Logger.getLogger(Runner.class);
	
	private static final String COMPANY_NAME="TransExpress";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LOG.info("Create new air company");
		CompanyCreator creator = new CompanyCreator(COMPANY_NAME);
					
		LOG.info("Create airplanes in the company");
		creator.generateHardCoreCpompanyPark();
		
		LOG.info("To count the total capacity and loading capacity");
		AirCompany company=creator.getCompany();
		int[] totalCapasity=null;
		
		totalCapasity=CompanyBusiness.getTotalCapasity(company);
		System.out.println(totalCapasity[0]+"  "+totalCapasity[1]);
		//CompanyBusiness.getTotalCapasity(company);
		
		LOG.info("Save data to file");
		CompanyOutputData.saveFile("result.txt", totalCapasity, company.getAirplanes());
		
		//Delete !!!!!!!!!!!!
		
		/*Set<Airplane> airplanes=creator.getCompany().getAirplanes();
		
		System.out.println(creator.getCompany());
		for(Airplane a: airplanes){
			System.out.println(a);
		}*/
	}

}
