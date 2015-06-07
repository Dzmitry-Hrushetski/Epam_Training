/**
 * 
 */
package com.epam.text.logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.epam.text.exception.BusinessException;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class SaveData {
	private static final Logger LOG = Logger.getLogger(SaveData.class);
	
	public static void saveDataToFile(String fileName,StringBuilder data) throws BusinessException{
		
		BufferedWriter fileOutput = null;
		
		if(fileName==null || fileName.isEmpty()) {
			LOG.error("File name cannot be null or empty");
			throw new BusinessException("File name cannot be null or empty");
		}
		
		if(data==null) {
			LOG.error("Input data cannot be null");
			throw new BusinessException("Input data cannot be null");
		}
		
	    try {
	    	fileOutput = new BufferedWriter(new FileWriter(fileName));
	    	fileOutput.write(data.toString());	  
	    } catch (IOException e) {
	    	LOG.error(e.getMessage());
	    	throw new BusinessException(e.getMessage());
	    } finally {
	    	try {
				if(fileOutput!=null) {
					fileOutput.close();
				}
			} catch (IOException e) {
				LOG.error(e.getMessage());
				throw new BusinessException(e.getMessage());
			}  	
	    }
	    LOG.info("Data are successfully saved");
	}
}
