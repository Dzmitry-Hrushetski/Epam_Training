/**
 * 
 */
package com.epam.text.logic;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class LoadData {
	private static final Logger LOG = Logger.getLogger(LoadData.class);
	private static final String UTF_8="UTF-8";
		
	public static String loadDataFromFile(String fileName) throws BusinessException {
		String inputString=null;
		BufferedInputStream fileInput=null;
		
		if(fileName==null || fileName.isEmpty()) {
			throw new BusinessException("File name cannot be null or empty");
		}
	    try {
	    	fileInput=new BufferedInputStream(new FileInputStream(fileName));
	       
	    	int fileLenght=fileInput.available();
	    	
	    	if(fileLenght==0) {
	    		throw new BusinessException("File is empty");
	    	}
	    	
	    	byte[] inputData=new byte[fileLenght];
	    	
	    	fileInput.read(inputData);
	    	inputString=new String(inputData,UTF_8);
	    } catch (IOException e) {
	    	throw new BusinessException(e.getMessage(),e);
	    } finally{
	    	try {
	    		if(fileInput!=null) {
	    			fileInput.close();
	    		}
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}  	
	    }
	    LOG.info("Data are successfully loaded");
		return inputString;
	}
}
