/**
 * 
 */
package com.epam.aircompany.runner;

import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.aircompany.bean.AirCompany;
import com.epam.aircompany.bean.Airplane;
import com.epam.aircompany.creator.CompanyCreator;
import com.epam.aircompany.exeption.BusinessExeption;
import com.epam.aircompany.logic.CompanyBusiness;
import com.epam.aircompany.logic.CompanyOutputData;
import com.epam.aircompany.logic.ICompanyBusiness;
import com.epam.aircompany.parser.AbstractAirCompanyBuilder;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Runner {
	private static final Logger LOG = Logger.getLogger(Runner.class);
	private static final String COMPANY_NAME="TransExpress";
	private static final int MIN_FUEL_USAGE=14;
	private static final int MAX_FUEL_USAGE=25;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Create company and airplanes in the company");
		//AirCompany company=CompanyCreator.generateHardCoreCompany(COMPANY_NAME);
		
		
		
		LOG.info("To count the total capacity and loading capacity, search of the plane in fuel consumption.");
		ICompanyBusiness companyBusiness=new CompanyBusiness();
				
		int totalPlace=0;
		int totalCargo=0;
		Set<Airplane> findAirplanes=null;
		
		try {
			totalPlace = companyBusiness.calculateTotalPassangerPlace(company);
			totalCargo = companyBusiness.calculateTotalPassangerCargoWeight(company);
			totalCargo+=companyBusiness.calculateTotalTransportCargoWeight(company);
			findAirplanes=companyBusiness.findAirplaneFuelUsageRange(company,MIN_FUEL_USAGE,MAX_FUEL_USAGE);
		} catch (BusinessExeption e) {
			LOG.error(e.getMessage());
		}
		
		LOG.info("Save data to file");
		if(CompanyOutputData.saveFile("result.txt", totalPlace, totalCargo, company.getAirplanes(),findAirplanes)){
			LOG.info("Data are saved correctly");
		}else {
			LOG.error("Data are saved incorrectly");
		}
		
		LOG.info("Job finish");	
	}
}
