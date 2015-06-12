/**
 * 
 */
package com.epam.aircompany.parser;

import com.epam.aircompany.bean.AirCompany;


/**
 * @author Dzmitry Hrushetski
 *
 */
public abstract class AbstractAirCompanyBuilder {
	protected AirCompany airCompany;

	public AbstractAirCompanyBuilder() {
		this.airCompany = new AirCompany();
	}

	public AirCompany getAirCompany() {
		return airCompany;
	}

	public abstract void buildAirCompany(String filePath);
}
