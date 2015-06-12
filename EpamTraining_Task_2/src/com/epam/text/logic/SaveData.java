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
	
	public static void saveDataToFile(String fileName,StringBuilder data) throws BusinessException{
		
		BufferedWriter fileOutput = null;
		
		if(fileName==null || fileName.isEmpty()) {
			throw new BusinessException("File name cannot be null or empty");
		}
		
		if(data==null) {
			throw new BusinessException("Input data cannot be null");
		}
		
	    try {
	    	fileOutput = new BufferedWriter(new FileWriter(fileName));
	    	fileOutput.write(data.toString());	  
	    } catch (IOException e) {
	    	throw new BusinessException(e.getMessage(),e);
	    } finally {
	    	try {
				if(fileOutput!=null) {
					fileOutput.close();
				}
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}  	
	    }
	    LOG.info("Data are successfully saved");
	}
}
