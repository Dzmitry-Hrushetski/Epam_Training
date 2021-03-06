/**
 * 
 */
package com.epam.aircompany.runner;

import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.aircompany.bean.AirCompany;
import com.epam.aircompany.bean.Airplane;
import com.epam.aircompany.creator.AirCompanyBuilder;
import com.epam.aircompany.creator.CompanyCreator;
import com.epam.aircompany.exeption.BusinessExeption;
import com.epam.aircompany.logic.CompanyBusiness;
import com.epam.aircompany.logic.CompanyOutputData;
import com.epam.aircompany.logic.ICompanyBusiness;
import com.epam.aircompany.parser.AbstractAirCompanyBuilder;
import com.epam.aircompany.parser.ParserType;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Runner {
	private static final Logger LOG = Logger.getLogger(Runner.class);
	private static final int MIN_FUEL_USAGE=14;
	private static final int MAX_FUEL_USAGE=45;
	private static final String INPUT_FILE_PATH="InputData\\aircompany1.xml";
	private static final String OUTPUT_FILE_PATH="result.txt";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int totalPlace=0;
		int totalCargo=0;
		Set<Airplane> findAirplanes=null;
		AirCompany company=null;
		
		LOG.info("Create company and airplanes in the company");
		try {
			AbstractAirCompanyBuilder builder = AirCompanyBuilder.createAirCompanyBuilder(ParserType.DOM);
		
			LOG.info("Parse input XML data file");
			company = CompanyCreator.generateXMLCompany(builder, INPUT_FILE_PATH);
		
			LOG.info("To count the total capacity and loading capacity, search of the plane in fuel consumption.");
			
			ICompanyBusiness companyBusiness=new CompanyBusiness();
					
			totalPlace = companyBusiness.calculateTotalPassangerPlace(company);
			totalCargo = companyBusiness.calculateTotalPassangerCargoWeight(company);
			totalCargo+=companyBusiness.calculateTotalTransportCargoWeight(company);
			findAirplanes=companyBusiness.findAirplaneFuelUsageRange(company,MIN_FUEL_USAGE,MAX_FUEL_USAGE);
			
			LOG.info("Save data to file");
			CompanyOutputData.saveFile(OUTPUT_FILE_PATH, totalPlace, totalCargo, company.getAirplanes(),findAirplanes);
			
			LOG.info("Job finish");
		} catch (BusinessExeption | EnumConstantNotPresentException e) {
			LOG.error(e.getMessage());
		}
	}
}
