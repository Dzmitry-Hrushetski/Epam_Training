/**
 * 
 */
package com.epam.text.logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		FileInputStream fileInput=null;
		
		if(fileName==null || fileName.isEmpty()) {
			LOG.error("Incorrect file name");
			return inputString;
		}
	    try {
	    	fileInput=new FileInputStream(fileName);
	       
	    	int fileLenght=fileInput.available();
	    	byte[] inputData=new byte[fileLenght];
	    	
	    	fileInput.read(inputData);
	    	inputString=new String(inputData);
	    } catch (IOException e) {
	    	LOG.error(e.getMessage());    
	    } finally{
	    	try {
				fileInput.close();
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}  	
	    }	
		return inputString;
	}
}
