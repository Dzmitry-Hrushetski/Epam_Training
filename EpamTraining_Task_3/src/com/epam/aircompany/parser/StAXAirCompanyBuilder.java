/**
 * 
 */
package com.epam.aircompany.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.log4j.Logger;

import com.epam.aircompany.bean.AirCompany;
import com.epam.aircompany.bean.PassangerAirplane;
import com.epam.aircompany.bean.TransportAirplane;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class StAXAirCompanyBuilder extends AbstractAirCompanyBuilder {
	private static final Logger LOG = Logger.getLogger(StAXAirCompanyBuilder.class);
	private static final String PASSANGER_AIRPLANE="passanger-airplane";
	private static final String TRANSPORT_AIRPLANE="transport-airplane";
	private static final String COMPANY_NAME="company-name";
	private XMLInputFactory inputFactory;
	private PassangerAirplane passangerAirplane;
	private TransportAirplane transportAirplane;
	

	/**
	 * 
	 */
	public StAXAirCompanyBuilder() {
		super();
		this.inputFactory = XMLInputFactory.newInstance();
	}


	/* (non-Javadoc)
	 * @see com.epam.aircompany.parser.AbstractAirCompanyBuilder#buildAirCompany(java.lang.String)
	 */
	@Override
	public void buildAirCompany(String filePath) {
		XMLStreamReader reader = null;
		String elementName;
		
		try (FileInputStream inputStream = new FileInputStream(new File(filePath))) {
			reader = inputFactory.createXMLStreamReader(inputStream);
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					elementName = reader.getLocalName();
					switch (elementName) {
					case COMPANY_NAME:
						airCompany.setCompanyName(getXMLText(reader).trim());
						break;
					case PASSANGER_AIRPLANE:
						//passangerAirplane=buildPassangerAirplane(reader);
						airCompany.add(passangerAirplane);
						break;
					case TRANSPORT_AIRPLANE:
						//transportAirplane=buildTransportAirplane(reader);
						airCompany.add(transportAirplane);
						break;
					default:
						break;
					}
				}
			}
		} catch (XMLStreamException exception) {
			LOG.error("StAX parser error!", exception);
		} catch (FileNotFoundException exception) {
			LOG.error("File '" + filePath + "' not found!", exception);
		} catch (IOException exception) {
			LOG.error("Unable to close the file!", exception);
		}

	}
	
	private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
		String text = null;
		if (reader.hasNext()) {
			reader.next();
			text = reader.getText();
		}
		return text;
	}

}
