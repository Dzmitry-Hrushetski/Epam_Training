/**
 * 
 */
package com.epam.aircompany.parser;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.epam.aircompany.parser.handler.AirCompanyHandler;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class SAXAirCompanyBuilder extends AbstractAirCompanyBuilder {
	private static final Logger LOG = Logger.getLogger(SAXAirCompanyBuilder.class);
	private AirCompanyHandler handler= new AirCompanyHandler();;
	private XMLReader xmlReader;

	public SAXAirCompanyBuilder() {
		super();
		try {
			this.xmlReader = XMLReaderFactory.createXMLReader();
			xmlReader.setContentHandler(handler);
		} catch (SAXException exception) {
			LOG.error("Error SAX parser", exception);
		}
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.parser.AbstractAirCompanyBuilder#buildAirCompany(java.lang.String)
	 */
	@Override
	public void buildAirCompany(String filePath) {
		try {
			xmlReader.parse(filePath);
		} catch (SAXException exception) {
			LOG.error("SAX parser error", exception);
		} catch (IOException exception) {
			LOG.error("I/O stream error", exception);
		}
		
		this.airCompany = handler.getAirCompany(); 
	}
}
