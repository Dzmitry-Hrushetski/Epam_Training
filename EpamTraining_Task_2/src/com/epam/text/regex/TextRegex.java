/**
 * 
 */
package com.epam.text.regex;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.epam.text.bean.TypeText;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class TextRegex {
	private static final Logger LOG = Logger.getLogger(TextRegex.class);
	private static final String LOG_MESSAGE="Load %s regex";
	private static final String RESOURCE_NAME="resource.regex";
	private static TextRegex instance;
	private Map<TypeText,Pattern> patternMap=new HashMap<TypeText,Pattern>();
	private ResourceBundle resource;

	
	private TextRegex() {
		// check exceptions !!!!!
		resource = ResourceBundle.getBundle(RESOURCE_NAME);
	}
	
	public static TextRegex getTextRegexInstance(){
		if(instance==null) {
			instance = new TextRegex();
		}
		return instance;
	}

	public Pattern getPattern(TypeText typeText){
		Pattern pattern=null;
		
		
		if(patternMap.containsKey(typeText)) {
			pattern=patternMap.get(typeText);
		}else {
			LOG.info(String.format(LOG_MESSAGE, typeText));
			pattern=Pattern.compile(resource.getString(typeText.toString()));
			patternMap.put(typeText,pattern);
		}
		return pattern;
	}
}
