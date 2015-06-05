/**
 * 
 */
package com.epam.text.runner;

import org.apache.log4j.Logger;

import com.epam.text.exception.BusinessException;
import com.epam.text.logic.IComponent;
import com.epam.text.logic.LoadData;
import com.epam.text.logic.SaveData;
import com.epam.text.logic.TextParser;
import com.epam.text.logic.TextProcessing;


/**
 * @author Dzmitry Hrushetski
 * 
 */
public class Runner {
	private static final Logger LOG = Logger.getLogger(Runner.class);
	private static final String INPUT_FILE_NAME="InputData\\input.txt";
	//private static final String INPUT_FILE_NAME="InputData\\test.txt";
	private static final String COMPOSITE_FILE_NAME="OutputData\\composite.txt";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Start");
						
		try {
			String inputText = LoadData.loadDataFromFile(INPUT_FILE_NAME);
			
			TextParser parser=new TextParser();
			IComponent compositeText=parser.createCompositeText(inputText);
			
			SaveData.saveCompositeToFile(COMPOSITE_FILE_NAME, compositeText.recoverComposit(new StringBuilder()));
			
			SaveData.saveCompositeToFile("OutputData\\task1.txt", TextProcessing.sortSentenceByWordLenght(compositeText));
			//TextProcessing.sortSentenceByWordLenght(compositeText);
			
		} catch (BusinessException e) {
			LOG.error(e.getMessage());
		}	
	}
}
