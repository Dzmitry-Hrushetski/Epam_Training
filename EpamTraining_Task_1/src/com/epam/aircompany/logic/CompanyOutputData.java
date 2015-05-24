/**
 * 
 */
package com.epam.aircompany.logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.aircompany.beans.Airplane;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class CompanyOutputData {
	
	public static Logger LOG = Logger.getLogger(CompanyOutputData.class);
	
	private static final String OUTPUT_STRING_1="Total passanger place - %d and cargo weight - %d\n";
	private static final String OUTPUT_STRING_2="The list of airplanes sorted by flying range:\n";
	
	public static void saveFile(String fileName, int totalPlace, int totalCargo, Set<Airplane> airplanes){
		
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
	    		  output.write("\n");
	    	  }   	
	    } catch (IOException e) {
	    	LOG.error(e.getMessage());
	       return;
	       
	    } finally{
	    	try {
				output.close();
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}  	
	    }
	}
}
