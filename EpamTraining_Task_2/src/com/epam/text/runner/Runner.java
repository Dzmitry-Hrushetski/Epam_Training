/**
 * 
 */
package com.epam.text.runner;

import org.apache.log4j.Logger;

import com.epam.text.bean.Composite;
import com.epam.text.bean.Leaf;
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
	private static final String FILE_NAME="InputData\\input.txt";
	
	//String d="(?m)(~[\\w\\s (){}\u005b\u005d/,:;!'-.>=+\u0022]*~\\r)";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Start");
		/*TextRegex rg=TextRegex.getTextRegexInstance();
		rg.getPattern(TypeText.LISTING);
		rg.getPattern(TypeText.SENTENCE);
		rg.getPattern(TypeText.WORD);*/
		LOG.info("Load data from file");
		String inputText=LoadData.loadDataFromFile(FILE_NAME);
		TextParser parser=new TextParser();
		IComponent compositeText=parser.createCompositeText(inputText);
		compositeText.print();
		
		/*
		IComponent clientT=new Composite(TypeText.TEXT);
		IComponent clientS1=new Composite(TypeText.SENTENCE);
		IComponent clientS2=new Composite(TypeText.SENTENCE);
		IComponent clientS3=new Composite(TypeText.SENTENCE);
		
		IComponent clientW1=new Leaf(TypeText.WORD,"111");
		IComponent clientW2=new Leaf(TypeText.WORD,"222");
		IComponent clientW3=new Leaf(TypeText.WORD,"333");
		IComponent clientW4=new Leaf(TypeText.WORD,"444");
		IComponent clientW5=new Leaf(TypeText.WORD,"555");
		IComponent clientW6=new Leaf(TypeText.WORD,"666");
		
		IComponent clientP1=new Leaf(TypeText.PUNKTUATION_MARK,".");
		IComponent clientP2=new Leaf(TypeText.PUNKTUATION_MARK,",");
		IComponent clientP3=new Leaf(TypeText.PUNKTUATION_MARK,":");
				
		IComponent clientL1=new Leaf(TypeText.LISTING,"void name { }");
		IComponent clientL2=new Leaf(TypeText.LISTING,"class Name { }");
		
		clientT.add(clientS1);
		clientT.add(clientL1);
		clientT.add(clientS2);
		clientT.add(clientL2);
		clientT.add(clientS3);
		
		clientS1.add(clientW1);
		clientS1.add(clientW2);
		clientS1.add(clientP1);
		
		clientS2.add(clientW1);
		clientS2.add(clientW4);
		clientS2.add(clientP2);
		clientS2.add(clientW5);
		
		clientS3.add(clientW1);
		clientS3.add(clientW2);
		clientS3.add(clientW3);
		clientS3.add(clientP3);
		clientS3.add(clientW6);
		
		clientT.print();
		//client.parseText(text);*/
		//TextParser.parseText(client, text);
		
	}

}
