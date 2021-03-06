/**
 * 
 */
package com.epam.aircompany.logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.aircompany.bean.Airplane;
import com.epam.aircompany.exeption.BusinessExeption;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class CompanyOutputData {
	private static final Logger LOG = Logger.getLogger(CompanyOutputData.class);
	private static final String MESSAGE_TOTAL_PLACE="Total passanger place - %d and cargo weight - %d\n\n";
	private static final String MESSAGE_SORT_FLY_RANGE="The list of airplanes sorted by flying range:\n";
	private static final String MESSAGE_FUEL_USAGE="The list of airplanes fuelUsage:\n";
	private static final String MESSAGE_STRING_FUEL_USAGE=", fuel usage %d\n";
	private static final String MESSAGE_NOT_FOUND="Airplanes not found\n";
	private static final String NEW_LINE="\n";
	
	public static void saveFile(String fileName, int totalPlace, int totalCargo, Set<Airplane> airplanes, Set<Airplane> findAirplanes) throws BusinessExeption{
		BufferedWriter output = null;
		
		if(fileName==null || fileName.isEmpty() || airplanes==null || findAirplanes==null) {
			throw new BusinessExeption("Incorrect argumens in metod saveFile");
		}
			    
	    try {
	    	  output = new BufferedWriter(new FileWriter(fileName));
	    	
	       	  output.write(String.format(MESSAGE_TOTAL_PLACE, totalPlace, totalCargo));
	       	  
	       	  if(!airplanes.isEmpty()){
	       		  output.write(MESSAGE_SORT_FLY_RANGE);	    	
		    	  for(Airplane tmp: airplanes){
		    		  output.write(tmp.toString());
		    		  output.write(NEW_LINE);
		    	  }  
	       	  }else {
	       		  output.write(MESSAGE_NOT_FOUND);
	       	  }
	    	  	    	  
	    	  output.write(NEW_LINE);
	    	  	    	  
	    	  if(!findAirplanes.isEmpty()){
	    		  output.write(MESSAGE_FUEL_USAGE);
	    		  for(Airplane tmp: findAirplanes){
		    		  output.write(tmp.toString());
		    		  output.write(String.format(MESSAGE_STRING_FUEL_USAGE, tmp.getFuelUsage()));
		    	  }
	    	  }else {
	    		  output.write(MESSAGE_NOT_FOUND);  
	    	  }
	    	 
	    } catch (IOException e) {
	    	throw new BusinessExeption("IO error",e);
	    } finally {
	    	try {
				if(output!=null){
					output.close();
				}
			} catch (IOException e) {
				LOG.error("Error close file",e);
			}  	
	    }
	    LOG.info("Data are saved correctly");
	}
}
