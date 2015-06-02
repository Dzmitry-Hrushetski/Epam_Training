/**
 * 
 */
package com.epam.text.logic;

import java.util.regex.Matcher;

import com.epam.text.bean.Composite;
import com.epam.text.bean.Leaf;
import com.epam.text.bean.TypeText;
import com.epam.text.regex.TextRegex;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class TextParser {
	private static final String EMPTY_STRING="";
	
	public static IComponent  parseText(TypeText typeText, String text){
		TextRegex patternInstance=TextRegex.getTextRegexInstance();
		Matcher matcher=null;
		Matcher matcherGroup=null;
		IComponent newComponent=null;
		String findElement=null;
		
		switch(typeText) {
		case TEXT:	
			IComponent head=new Composite(TypeText.TEXT);
			
			matcherGroup=patternInstance.getPattern(TypeText.SENTENCE_OR_LISTING).matcher(text);
			
			while (matcherGroup.find()) {
				findElement=matcherGroup.group();
				matcher=patternInstance.getPattern(TypeText.SENTENCE).matcher(findElement);
				if(matcher.matches()){
					newComponent=new Composite(TypeText.SENTENCE);
					head.add(newComponent);
					newComponent.parseText(findElement);
				}else {
					newComponent=new Leaf(TypeText.LISTING,findElement);
					head.add(newComponent);
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
					add(newComponent);
					text=matcher.replaceFirst(EMPTY_STRING);
				}
				
				matcher=patternInstance.getPattern(TypeText.PUNKTUATION_MARK).matcher(findElement);
				
				if(matcher.matches()){
					newComponent=new Leaf(TypeText.PUNKTUATION_MARK,findElement);
					add(newComponent);
				}else {
					//log error
				}
			}
			break;	
		default:
			// error
		}
		
	}

}
