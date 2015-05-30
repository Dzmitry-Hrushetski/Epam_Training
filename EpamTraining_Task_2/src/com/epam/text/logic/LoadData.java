/**
 * 
 */
package com.epam.text.logic;

import java.io.BufferedReader;
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
		String inputData=null;
		BufferedReader input = null;
		
	    try {
	       input = new BufferedReader(new FileReader(fileName));
	    } catch (FileNotFoundException e) {
	    	LOG.error(e.getMessage());
	    	////??????????????
	    }
	    
	    //int tmp;
	    String tmp;
	    
	    try {
	          /*while ((tmp = input.read()) != -1)
	          inputData.appendInputData((char)tmp);*/
	    	
	    	while ((tmp = input.readLine()) != null)
		          inputData.appendInputData(tmp+"\n");
	    	
	    } catch (IOException e) {
	       e.printStackTrace();
	       return null;
	       
	    } finally{
	    	try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  	
	    }
		
		return inputData;
	}

}
