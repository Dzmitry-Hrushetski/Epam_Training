/**
 * 
 */
package com.epam.text.regex;

import java.util.ResourceBundle;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.epam.text.bean.TypeText;

import static com.epam.text.bean.TypeText.SENTENCE;
import static com.epam.text.bean.TypeText.LISTING;
import static com.epam.text.bean.TypeText.WORD;
import static com.epam.text.bean.TypeText.PUNKTUATION_MARK;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class TextRegex {
	private static final Logger LOG = Logger.getLogger(TextRegex.class);
	private static TextRegex instance=null;
	private Pattern patternSentence;
	private Pattern patternListing;
	private Pattern patternWord;
	private Pattern patternPunctuationMark;
	ResourceBundle resource;

	
	private TextRegex() {
		// check exceptions !!!!!
		resource = ResourceBundle.getBundle("resource.regex");
	}
	
	public static TextRegex getTextRegexInstance(){
		if(instance==null) {
			instance = new TextRegex();
		}
		return instance;
	}

	public Pattern getPattern(TypeText typeText){
		Pattern pattern=null;
		switch(typeText) {
		case SENTENCE:
			if(patternSentence==null) {
				LOG.info("Load sentence regex");
				patternSentence=Pattern.compile(resource.getString("sentence"));
			}
			pattern=patternSentence;
			break;
		case LISTING:	
			if(patternListing==null) {
				LOG.info("Load listing regex");
				patternListing=Pattern.compile(resource.getString("listing"));
			}
			pattern=patternListing;
			break;
		case WORD:	
			if(patternWord==null) {
				LOG.info("Load word regex");
				patternWord=Pattern.compile(resource.getString("word"));
			}
			pattern=patternWord;
			break;
		case PUNKTUATION_MARK:	
			if(patternPunctuationMark==null) {
				LOG.info("Load punctuation mark regex");
				patternPunctuationMark=Pattern.compile(resource.getString("punctuation_mark"));
			}
			pattern=patternPunctuationMark;
			break;
		default:
			LOG.error("Icorrect type text");
		}
		return pattern;
	}
}
