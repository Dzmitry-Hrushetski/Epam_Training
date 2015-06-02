/**
 * 
 */
package com.epam.text.logic;

import java.util.regex.Matcher;

import org.apache.log4j.Logger;

import com.epam.text.bean.Composite;
import com.epam.text.bean.Leaf;
import com.epam.text.bean.TypeText;
import com.epam.text.regex.TextRegex;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class TextParser {
	private static final Logger LOG = Logger.getLogger(TextParser.class);
	private static final String EMPTY_STRING="";
	private static final String LOG_DEBUG_ERROR_TEXT="Error of analysis of a line - %s";
	private static final String LOG_DEBUG_ERROR_TYPE="Wrong text type - %s";
	
	public IComponent createCompositeText(String text){
		IComponent head=new Composite(TypeText.TEXT);
		
		parseText(head,text);
		
		return head;
	}
	
	private void parseText(IComponent component, String text){
		TextRegex patternInstance=TextRegex.getTextRegexInstance();
		Matcher matcher=null;
		Matcher matcherGroup=null;
		IComponent newComponent=null;
		String findElement=null;
		
		TypeText typeText=component.getTypeText();
		
		switch(typeText) {
		case TEXT:	
			matcherGroup=patternInstance.getPattern(TypeText.SENTENCE_OR_LISTING).matcher(text);
			
			while (matcherGroup.find()) {
				findElement=matcherGroup.group();
				matcher=patternInstance.getPattern(TypeText.SENTENCE).matcher(findElement);
				if(matcher.matches()){
					newComponent=new Composite(TypeText.SENTENCE);
					component.add(newComponent);
					newComponent.parseText(findElement);
				}else {
					newComponent=new Leaf(TypeText.LISTING,findElement);
					component.add(newComponent);
				}
			}
			break;
			
		case SENTENCE:
			matcherGroup=patternInstance.getPattern(TypeText.WORD_OR_PUNKTUATION_MARK).matcher(text);
			
			while (matcherGroup.find()) {
				findElement=matcherGroup.group();
				matcher=patternInstance.getPattern(TypeText.WORD).matcher(findElement);
				
				if(matcher.matches()){
					newComponent=new Leaf(TypeText.WORD,findElement);
					component.add(newComponent);
					text=matcher.replaceFirst(EMPTY_STRING);
				}
				
				matcher=patternInstance.getPattern(TypeText.PUNKTUATION_MARK).matcher(findElement);
				
				if(matcher.matches()){
					newComponent=new Leaf(TypeText.PUNKTUATION_MARK,findElement);
					component.add(newComponent);
				}else {
					LOG.debug(String.format(LOG_DEBUG_ERROR_TEXT, findElement));
				}
			}
			break;	
		default:
			LOG.debug(String.format(LOG_DEBUG_ERROR_TYPE, findElement));
		}
	}
}
