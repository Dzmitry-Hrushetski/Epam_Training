/**
 * 
 */
package com.epam.text.logic;

import java.util.regex.Matcher;

import com.epam.text.bean.Leaf;
import com.epam.text.bean.TypeText;
import com.epam.text.regex.TextRegex;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class TextParser {
	private static final String EMPTY_STRING="";
	
	public static void  parseText(IComponent component, String text){
		TypeText typeText=component.getTypeText();
		TextRegex patternInstance=TextRegex.getTextRegexInstance();
		Matcher matcher=null;
		IComponent newComponent=null;
		
		switch(typeText) {
		case TEXT:
			String findListing;
			matcher = patternInstance.getPattern(TypeText.SENTENCE).matcher(text);
			
			while (matcher.find()) {
				findListing=matcher.group();
				newComponent=new Leaf(TypeText.SENTENCE,findListing);
				component.add(newComponent);
	            //text=matcher.replaceFirst(EMPTY_STRING);
			}
			break;
			
		}
		
	}

}
