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
	
	private String fileName;
	
		
	
	public static void saveFile(String fileName, int[] totalCapasity, Set<Airplane> airplanes){
		
		BufferedWriter output = null;
		
		try {
	       output = new BufferedWriter(new FileWriter(fileName));
	    } catch (IOException e ) {
	    	LOG.error(e.getMessage());
	       return;
	    }
	    	    
	    try {
	    	
	    	  output.write("Total passanger place - "+ totalCapasity[0] + " and cargo weight - " + totalCapasity[1] +"\n");
	    	  output.write("The list of airplanes sorted by flying range:\n");	    	
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
