/**
 * 
 */
package com.epam.aircompany.runner;

import org.apache.log4j.Logger;

import com.epam.aircompany.beans.AirCompany;
import com.epam.aircompany.creator.CompanyCreator;
import com.epam.aircompany.logic.CompanyBusiness;
import com.epam.aircompany.logic.CompanyOutputData;
import com.epam.aircompany.logic.ICompanyBusiness;


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
		creator.generateHardCoreCompanyPark();
		
		LOG.info("To count the total capacity and loading capacity");
		AirCompany company=creator.getCompany();
		ICompanyBusiness companyBusiness=new CompanyBusiness();
				
		int totalPlace=companyBusiness.getTotalPassangerPlace(company);
		int totalCargo=companyBusiness.getTotalPassangerCargoWeight(company);
		totalCargo+=companyBusiness.getTotalTransportCargoWeight(company);
		
		LOG.info("Save data to file");
		CompanyOutputData.saveFile("result.txt", totalPlace, totalCargo, company.getAirplanes());
		
		LOG.info("Job finish");
		
	}

}
