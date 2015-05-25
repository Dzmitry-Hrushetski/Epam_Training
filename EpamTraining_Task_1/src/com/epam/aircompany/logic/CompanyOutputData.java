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
	public static final Logger LOG = Logger.getLogger(CompanyOutputData.class);
	private static final String MESSAGE_1="Total passanger place - %d and cargo weight - %d\n\n";
	private static final String MESSAGE_2="The list of airplanes sorted by flying range:\n";
	private static final String MESSAGE_3="The list of airplanes fuelUsage:\n";
	private static final String MESSAGE_4="Airplanes not found\n";
	private static final String NEW_LINE="\n";
	
	public static void saveFile(String fileName, int totalPlace, int totalCargo, Set<Airplane> airplanes, Set<Airplane> findAirplanes){
		BufferedWriter output = null;
		
		try {
	       output = new BufferedWriter(new FileWriter(fileName));
	    } catch (IOException e ) {
	    	LOG.error(e.getMessage());
	       return;
	    }
	    	    
	    try {
	       	  output.write(String.format(MESSAGE_1, totalPlace, totalCargo));
	    	  output.write(MESSAGE_2);	    	
	    	  for(Airplane tmp: airplanes){
	    		  output.write(tmp.toString());
	    		  output.write(NEW_LINE);
	    	  }
	    	  
	    	  output.write(NEW_LINE);
	    	  	    	  
	    	  if(findAirplanes.isEmpty()){
	    		  output.write(MESSAGE_4);
	    	  }else {
	    		  output.write(MESSAGE_3);
	    		  for(Airplane tmp: findAirplanes){
		    		  output.write(tmp.toString());
		    		  output.write(NEW_LINE);
		    	  }
	    	  }
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
	}
}
