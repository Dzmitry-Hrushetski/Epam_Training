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
		
	public static String loadDataFromFile(String fileName){
		String inputString=null;
		BufferedInputStream fileInput=null;
		
		if(fileName==null || fileName.isEmpty()) {
			LOG.error("Incorrect file name");
			return inputString;
		}
	    try {
	    	fileInput=new BufferedInputStream(new FileInputStream(fileName));
	       
	    	int fileLenght=fileInput.available();
	    	byte[] inputData=new byte[fileLenght];
	    	
	    	fileInput.read(inputData);
	    	inputString=new String(inputData,"UTF-8");
	    } catch (IOException e) {
	    	LOG.error(e.getMessage());    
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
