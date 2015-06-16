/**
 * 
 */
package com.epam.aircompany.parser;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.epam.aircompany.exeption.BusinessExeption;
import com.epam.aircompany.parser.handler.AirCompanyHandler;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class SAXAirCompanyBuilder extends AbstractAirCompanyBuilder {
	private static final Logger LOG = Logger.getLogger(SAXAirCompanyBuilder.class);
	private AirCompanyHandler handler= new AirCompanyHandler();;
	private XMLReader xmlReader;

	public SAXAirCompanyBuilder() throws BusinessExeption {
		super();
		try {
			this.xmlReader = XMLReaderFactory.createXMLReader();
			xmlReader.setContentHandler(handler);
		} catch (SAXException exception) {
			LOG.error("Error SAX parser", exception);
			throw new BusinessExeption("Error SAX parser",exception);
		}
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.parser.AbstractAirCompanyBuilder#buildAirCompany(java.lang.String)
	 */
	@Override
	public void buildAirCompany(String filePath) throws BusinessExeption {
		if(filePath==null || filePath.isEmpty()) {
			throw new BusinessExeption("File name cannot be null or empty");
		}
		try {
			xmlReader.parse(filePath);
		} catch (SAXException exception) {
			LOG.error("Error SAX parser", exception);
			throw new BusinessExeption("Error SAX parser",exception);
		} catch (IOException exception) {
			LOG.error("I/O stream error", exception);
			throw new BusinessExeption("I/O stream error",exception);
		}	
		this.airCompany = handler.getAirCompany(); 
	}
}
