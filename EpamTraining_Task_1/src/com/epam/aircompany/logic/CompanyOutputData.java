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

/**
 * @author Dzmitry Hrushetski
 *
 */
public class CompanyOutputData {
	private static final Logger LOG = Logger.getLogger(CompanyOutputData.class);
	private static final String MESSAGE_TOTAL_PLACE="Total passanger place - %d and cargo weight - %d\n\n";
	private static final String MESSAGE_SORT_FLY_RANGE="The list of airplanes sorted by flying range:\n";
	private static final String MESSAGE_FUEL_USAGE="The list of airplanes fuelUsage:\n";
	private static final String MESSAGE_NOT_FOUND="Airplanes not found\n";
	private static final String NEW_LINE="\n";
	
	public static boolean saveFile(String fileName, int totalPlace, int totalCargo, Set<Airplane> airplanes, Set<Airplane> findAirplanes){
		BufferedWriter output = null;
		boolean rezult=false;
		
		if(fileName==null || fileName.isEmpty()){
			return rezult;
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
		    		  output.write(NEW_LINE);
		    	  }
	    	  }else {
	    		  output.write(MESSAGE_NOT_FOUND);  
	    	  }
	    	  rezult=true;
	    } catch (IOException e) {
	    	LOG.error(e.getMessage());
	    } finally {
	    	try {
				if(output!=null){
					output.close();
				}
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}  	
	    }
	    return rezult;
	}
}
