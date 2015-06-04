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
	private static final String LOG_DEBUG_ERROR_TEXT="Error of analysis of a line - %s, %s";
	private static final String LOG_DEBUG_ERROR_TYPE="Wrong text type - %s";
	private TextRegex patternInstance;
	
	
	public TextParser() {
		super();
		patternInstance=TextRegex.getTextRegexInstance();
	}

	public IComponent createCompositeText(String text) {
		if(text==null || text.isEmpty()) {
			return null;
		}
		
		IComponent head=new Composite(TypeText.TEXT);
		parseText(head,text);
		
		return head;
	}
	
	private void parseText(IComponent component, String text) {
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
					parseText(newComponent,findElement);
					continue;			
				}
				
				matcher=patternInstance.getPattern(TypeText.LISTING).matcher(findElement);
				
				if(matcher.matches()) {			
					newComponent=new Leaf(TypeText.LISTING,findElement);
					component.add(newComponent);
					continue;
				}
				
				LOG.debug(String.format(LOG_DEBUG_ERROR_TEXT, findElement, typeText));			
			}
			break;
			
		case SENTENCE:
			matcherGroup=patternInstance.getPattern(TypeText.WORD_OR_PUNKTUATION_MARK).matcher(text);
			
			while (matcherGroup.find()) {
				findElement=matcherGroup.group();
							
				matcher=patternInstance.getPattern(TypeText.WORD).matcher(findElement);
				
				if(matcher.matches()) {
					newComponent=new Leaf(TypeText.WORD,findElement);
					component.add(newComponent);
					continue;
				}
				
				matcher=patternInstance.getPattern(TypeText.PUNKTUATION_MARK).matcher(findElement);
				
				if(matcher.matches()) {
					newComponent=new Leaf(TypeText.PUNKTUATION_MARK,findElement);
					component.add(newComponent);
					continue;
				}
				
				LOG.debug(String.format(LOG_DEBUG_ERROR_TEXT, findElement, typeText));				
			}
			break;	
		default:
			LOG.debug(String.format(LOG_DEBUG_ERROR_TYPE, findElement));
		}
	}
}
