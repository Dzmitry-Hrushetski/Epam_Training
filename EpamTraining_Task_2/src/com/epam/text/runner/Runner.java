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
	private static final String COMPOSITE_FILE_NAME="OutputData\\composite.txt";
	private static final String SORT_WORD_FILE_NAME="OutputData\\sort_word.txt";
	private static final String DELETE_WORD_FILE_NAME="OutputData\\delete_word.txt";
	private static final String TRADE_WORD_PLASE_FILE_NAME="OutputData\\trade_word_places.txt";
	private static final int WORD_LENGHT=3;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Start");
						
		try {
			String inputText = LoadData.loadDataFromFile(INPUT_FILE_NAME);
			
			TextParser parser=new TextParser();
			IComponent compositeText=parser.createCompositeText(inputText);
			
			SaveData.saveDataToFile(COMPOSITE_FILE_NAME, compositeText.recoverComposit(new StringBuilder()));
			
			SaveData.saveDataToFile(SORT_WORD_FILE_NAME, TextProcessing.sortWord(compositeText));
			
			TextProcessing.tradeWordPlaces(compositeText);
			SaveData.saveDataToFile(TRADE_WORD_PLASE_FILE_NAME, compositeText.recoverComposit(new StringBuilder()));
			
			TextProcessing.deleteConsonantWordLenght(compositeText, WORD_LENGHT);
			SaveData.saveDataToFile(DELETE_WORD_FILE_NAME, compositeText.recoverComposit(new StringBuilder()));
			
			LOG.info("Job finish");
		} catch (BusinessException e) {
			LOG.error(e.getMessage());
		}	
	}
}
