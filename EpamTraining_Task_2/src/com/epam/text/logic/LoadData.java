/**
 * 
 */
package com.epam.text.logic;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.epam.text.exception.BusinessException;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class LoadData {
	private static final Logger LOG = Logger.getLogger(LoadData.class);
	private static final String STRING_FORMAT="UTF-8";
		
	public static String loadDataFromFile(String fileName) throws BusinessException {
		String inputString=null;
		BufferedInputStream fileInput=null;
		
		if(fileName==null || fileName.isEmpty()) {
			LOG.error("Incorrect file name");
			throw new BusinessException("Incorrect file name");
		}
	    try {
	    	fileInput=new BufferedInputStream(new FileInputStream(fileName));
	       
	    	int fileLenght=fileInput.available();
	    	
	    	if(fileLenght==0) {
	    		LOG.error("File is empty");
	    		throw new BusinessException("File is empty");
	    	}
	    	
	    	byte[] inputData=new byte[fileLenght];
	    	
	    	fileInput.read(inputData);
	    	inputString=new String(inputData,STRING_FORMAT);
	    } catch (IOException e) {
	    	LOG.error(e.getMessage());
	    	throw new BusinessException(e.getMessage());
	    } finally{
	    	try {
	    		if(fileInput!=null) {
	    			fileInput.close();
	    		}
			} catch (IOException e) {
				LOG.error(e.getMessage());
				throw new BusinessException(e.getMessage());
			}  	
	    }
	    LOG.info("Data are successfully loaded");
		return inputString;
	}
}
