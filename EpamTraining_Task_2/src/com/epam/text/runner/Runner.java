/**
 * 
 */
package com.epam.text.runner;

import org.apache.log4j.Logger;

import com.epam.text.bean.Composite;
import com.epam.text.bean.TypeText;
import com.epam.text.logic.IComponent;
import com.epam.text.logic.LoadData;
import com.epam.text.logic.TextParser;
import com.epam.text.regex.TextRegex;


/**
 * @author Dzmitry Hrushetski
 * 
 */
public class Runner {
	private static final Logger LOG = Logger.getLogger(Runner.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Start");
		/*TextRegex rg=TextRegex.getTextRegexInstance();
		rg.getPattern(TypeText.LISTING);
		rg.getPattern(TypeText.SENTENCE);
		rg.getPattern(TypeText.WORD);*/
		
		String text=LoadData.loadDataFromFile("InputData\\input.txt");
		IComponent client=new Composite(TypeText.TEXT);
		client.parseText(text);
		//TextParser.parseText(client, text);
		
	}

}
