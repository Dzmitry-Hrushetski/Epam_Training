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
	
	private static final String OUTPUT_STRING_1="Total passanger place - %d and cargo weight - %d\n\n";
	private static final String OUTPUT_STRING_2="The list of airplanes sorted by flying range:\n";
	private static final String OUTPUT_STRING_3="The list of airplanes fuelUsage:\n";
	private static final String OUTPUT_STRING_4="Airplanes not found\n";
	private static final String OUTPUT_STRING_5="\n";
	
	public static void saveFile(String fileName, int totalPlace, int totalCargo, Set<Airplane> airplanes, Set<Airplane> findAirplanes){
		
		BufferedWriter output = null;
		
		try {
	       output = new BufferedWriter(new FileWriter(fileName));
	    } catch (IOException e ) {
	    	LOG.error(e.getMessage());
	       return;
	    }
	    	    
	    try {
	    	
	    	  output.write(String.format(OUTPUT_STRING_1, totalPlace, totalCargo));
	    	  output.write(OUTPUT_STRING_2);	    	
	    	  for(Airplane tmp: airplanes){
	    		  output.write(tmp.toString());
	    		  output.write(OUTPUT_STRING_5);
	    	  }
	    	  
	    	  output.write(OUTPUT_STRING_5);
	    	  	    	  
	    	  if(findAirplanes.isEmpty()){
	    		  output.write(OUTPUT_STRING_4);
	    	  }else{
	    		  output.write(OUTPUT_STRING_3);
	    		  for(Airplane tmp: findAirplanes){
		    		  output.write(tmp.toString());
		    		  output.write("\n");
		    	  }
	    	  }
	    } catch (IOException e) {
	    	LOG.error(e.getMessage());
	    } finally{
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
