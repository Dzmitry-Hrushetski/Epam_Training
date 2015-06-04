/**
 * 
 */
package com.epam.text.logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class SaveData {
	private static final Logger LOG = Logger.getLogger(SaveData.class);
	
	public static void saveCompositeToFile(String fileName,StringBuilder data){
		
		BufferedWriter fileOutput = null;
		
		if(fileName==null || fileName.isEmpty()) {
			LOG.error("Incorrect file name");
			return;
		}
		
	    try {
	    	fileOutput = new BufferedWriter(new FileWriter(fileName));
	    	fileOutput.write(data.toString());	  
	    } catch (IOException e) {
	    	LOG.error(e.getMessage());
	    } finally {
	    	try {
				if(fileOutput!=null) {
					fileOutput.close();
				}
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}  	
	    }
	    LOG.info("Composite are successfully saved");
	}
}
