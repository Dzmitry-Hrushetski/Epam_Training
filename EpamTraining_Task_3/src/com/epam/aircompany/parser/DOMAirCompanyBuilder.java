/**
 * 
 */
package com.epam.aircompany.parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.aircompany.bean.AirplaneModelName;
import com.epam.aircompany.bean.PassangerAirplane;
import com.epam.aircompany.bean.TransportAirplane;
import com.epam.aircompany.parser.enumeration.AirplaneEnum;




import static com.epam.aircompany.parser.constant.ParserConstant.*;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class DOMAirCompanyBuilder extends AbstractAirCompanyBuilder {
	private static final Logger LOG=Logger.getLogger(DOMAirCompanyBuilder.class);
	private static final String NAME_SPASE_PREFIX="tns:";
	private DocumentBuilder documentBuilder;

	//Airplane fields
	private AirplaneModelName modelName;
	private int boardNumber;
	private int flyingRange;
	private int capacityFuelTank;
	private int fuelUsage;
	private int maxLoadCapacity;
	//PassangerAirplane fields
	private int economPlace;
	private int businessPlace;
	private int maxBaggagePlace;
	private int maxBaggageWeight;
	private int curBaggagePlace;
	private int curBaggageWeight;
	//TransportAirplane fields
	private int cargoLong;
	private int cargoWidth;
	private int cargoHeight;
	private int maxCargoWeight;
	private int curCargoWeight;
	private int cargoHatchWidth;
	private int cargoHatchHeight;	
	
	/**
	 * 
	 */
	public DOMAirCompanyBuilder() {
		super();
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		try {
			this.documentBuilder=factory.newDocumentBuilder();
		} catch (ParserConfigurationException exception) {
			LOG.error("Error configuration parser", exception);
		}
	}

	
	/*public void buildAirCompany(String filePath) {
		  try{
		   //File fXmlFile = new File("c://staff.xml");
		   File fXmlFile = new File(filePath);
		   DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		   Document doc = dBuilder.parse(fXmlFile);
		  
		   //optional, but recommended
		   //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		   //doc.getDocumentElement().normalize();
		  
		   System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		  
		   NodeList nList = doc.getElementsByTagName("tns:company-name");
		   System.out.println("----------------------------");
		    
		   for (int temp = 0; temp < nList.getLength(); temp++) {
		   
		    Node nNode = nList.item(temp);
		    System.out.println("\nCurrent Element :" + nNode.getNodeName()+nNode.getTextContent());
		    
		   }
		  }catch(Exception err){
		   LOG.error(err);
		  }
		  
		 }*/
	
	
	
	
	
	
	/* (non-Javadoc)
	 * @see com.epam.aircompany.parser.AbstractAirCompanyBuilder#buildAirCompany(java.lang.String)
	 */
	@Override
	public void buildAirCompany(String filePath) {
		Document document;//,root;
		try {
			document=documentBuilder.parse(new File(filePath));
			//document.getDocumentElement().normalize();
			Element root=document.getDocumentElement();		
			
			NodeList companyName=root.getElementsByTagName(NAME_SPASE_PREFIX+COMPANY_NAME);
			NodeList passangerAirplaneList=root.getElementsByTagName(NAME_SPASE_PREFIX+PASSANGER_AIRPLANE);
			NodeList transportAirplaneList=root.getElementsByTagName(NAME_SPASE_PREFIX+TRANSPORT_AIRPLANE);

			Element name=(Element)companyName.item(0);
			airCompany.setCompanyName(name.getTextContent().trim());
						
			for (int i=0;i<passangerAirplaneList.getLength();i++) {
				Element passangerAirplaneElement=(Element) passangerAirplaneList.item(i);
				PassangerAirplane passangerAirplane = buildPassangerAirplane(passangerAirplaneElement);
				airCompany.add(passangerAirplane);
			}
			
			for (int i=0;i<transportAirplaneList.getLength();i++) {
				Element transportAirplaneElement=(Element) transportAirplaneList.item(i);
				TransportAirplane transportAirplane=buildTransportAirplane(transportAirplaneElement);
				airCompany.add(transportAirplane);
			}
		} catch (SAXException exception) {
			LOG.error("Document parsing error", exception);
		} catch (IOException exception) {
			LOG.error("I/O error", exception);
		}
	}
	
	private PassangerAirplane buildPassangerAirplane(Element passangerAirplaneElement) {
		boardNumber=Integer.parseInt(passangerAirplaneElement.getAttribute(ID).substring(1));
		modelName=AirplaneModelName.valueOf(getElementTextContent(passangerAirplaneElement,AirplaneEnum.MODEL_NAME.getValue()));
		flyingRange=Integer.parseInt(getElementTextContent(passangerAirplaneElement,AirplaneEnum.FLYING_RANGE.getValue()));
		capacityFuelTank=Integer.parseInt(getElementTextContent(passangerAirplaneElement,AirplaneEnum.CAPACITY_FUEL_TANK.getValue()));
		fuelUsage=Integer.parseInt(getElementTextContent(passangerAirplaneElement,AirplaneEnum.FUEL_USAGE.getValue()));
		maxLoadCapacity=Integer.parseInt(getElementTextContent(passangerAirplaneElement,AirplaneEnum.MAX_LOAD_CAPACITY.getValue()));
		economPlace=Integer.parseInt(getElementTextContent(passangerAirplaneElement,AirplaneEnum.ECONOM_PLACE.getValue()));
		businessPlace=Integer.parseInt(getElementTextContent(passangerAirplaneElement,AirplaneEnum.BUSINESS_PLACE.getValue()));
		maxBaggagePlace=Integer.parseInt(getElementTextContent(passangerAirplaneElement,AirplaneEnum.MAX_BAGGAGE_PLACE.getValue()));
		maxBaggageWeight=Integer.parseInt(getElementTextContent(passangerAirplaneElement,AirplaneEnum.MAX_BAGGAGE_WEIGHT.getValue()));
		curBaggagePlace=Integer.parseInt(getElementTextContent(passangerAirplaneElement,AirplaneEnum.CUR_BAGGAGE_PLACE.getValue()));
		curBaggageWeight=Integer.parseInt(getElementTextContent(passangerAirplaneElement,AirplaneEnum.CUR_BAGGAGE_WEIGHT.getValue()));
		
		PassangerAirplane passangerAirplane=new PassangerAirplane(modelName,boardNumber,flyingRange,capacityFuelTank,maxLoadCapacity,maxBaggagePlace,maxBaggageWeight);
		passangerAirplane.setFuelUsage(fuelUsage);
		passangerAirplane.setEconomPlace(economPlace);
		passangerAirplane.setBusinessPlace(businessPlace);
		passangerAirplane.setCurBaggagePlace(curBaggagePlace);
		passangerAirplane.setCurBaggageWeight(curBaggageWeight);
		return passangerAirplane;
	}
	
	private TransportAirplane buildTransportAirplane(Element transportAirplaneElement) {
		boardNumber=Integer.parseInt(transportAirplaneElement.getAttribute(ID).substring(1));
		modelName=AirplaneModelName.valueOf(getElementTextContent(transportAirplaneElement,AirplaneEnum.MODEL_NAME.getValue()));
		flyingRange=Integer.parseInt(getElementTextContent(transportAirplaneElement,AirplaneEnum.FLYING_RANGE.getValue()));
		capacityFuelTank=Integer.parseInt(getElementTextContent(transportAirplaneElement,AirplaneEnum.CAPACITY_FUEL_TANK.getValue()));
		fuelUsage=Integer.parseInt(getElementTextContent(transportAirplaneElement,AirplaneEnum.FUEL_USAGE.getValue()));
		maxLoadCapacity=Integer.parseInt(getElementTextContent(transportAirplaneElement,AirplaneEnum.MAX_LOAD_CAPACITY.getValue()));
		cargoLong=Integer.parseInt(getElementTextContent(transportAirplaneElement,AirplaneEnum.CARGO_LONG.getValue()));
		cargoWidth=Integer.parseInt(getElementTextContent(transportAirplaneElement,AirplaneEnum.CARGO_WIDTH.getValue()));
		cargoHeight=Integer.parseInt(getElementTextContent(transportAirplaneElement,AirplaneEnum.CARGO_HEIGHT.getValue()));	
		maxCargoWeight=Integer.parseInt(getElementTextContent(transportAirplaneElement,AirplaneEnum.MAX_CARGO_WEIGHT.getValue()));
		curCargoWeight=Integer.parseInt(getElementTextContent(transportAirplaneElement,AirplaneEnum.CUR_CARGO_WEIGHT.getValue()));
		cargoHatchWidth=Integer.parseInt(getElementTextContent(transportAirplaneElement,AirplaneEnum.CARGO_HATCH_WIDTH.getValue()));
		cargoHatchHeight=Integer.parseInt(getElementTextContent(transportAirplaneElement,AirplaneEnum.CARGO_HATCH_HEIGHT.getValue()));
		
		TransportAirplane transportAirplane=new TransportAirplane(modelName,boardNumber,flyingRange,capacityFuelTank,maxLoadCapacity,cargoLong,cargoWidth,cargoHeight,maxCargoWeight,cargoHatchWidth,cargoHatchHeight);
		transportAirplane.setFuelUsage(fuelUsage);
		transportAirplane.setCurCargoWeight(curCargoWeight);
		return transportAirplane;	
	}
		
	private String getElementTextContent(Element element, String elementName) {
		NodeList nList = element.getElementsByTagName(elementName);
		Node node = nList.item(0);
		String text = node.getTextContent();
		return text;
	}

}
