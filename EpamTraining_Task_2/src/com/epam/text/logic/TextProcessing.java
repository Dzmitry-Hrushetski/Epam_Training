/**
 * 
 */
package com.epam.text.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;

import org.apache.log4j.Logger;

import com.epam.text.bean.Leaf;
import com.epam.text.bean.TypeText;
import com.epam.text.exception.BusinessException;
import com.epam.text.regex.TextRegex;

/**
 * @author Dzmitry Hrushetski
 * 
 */
public class TextProcessing {
	private static final Logger LOG = Logger.getLogger(TextProcessing.class);
	private static final String NEW_LINE="\n\r";
	private static final String TAB="\t";
	private static final int START_INDEX=0;
	private static final int MIN_SENTENCE_ELEMENT=1;
	private static final int MIN_WORD_IN_SENTENCE=2;
	private static final int MIN_WORD_LENGHT=1;
	
	public static void deleteConsonantWordLenght(IComponent component, int wordLenght) throws BusinessException {
		if(component==null) {
			LOG.error("Input composite cannot be null");
			throw new BusinessException("Input composite cannot be null");
		}
		if(wordLenght<MIN_WORD_LENGHT) {
			LOG.error("The word length shall be at least one character");
			throw new BusinessException("The word length shall be at least one character");
		}
		
		Iterator<IComponent> sentenceIterator=component.getIterator();
		TextRegex patternInstance=TextRegex.getTextRegexInstance();
		
		while(sentenceIterator.hasNext()) {
			IComponent element = sentenceIterator.next();
			if (TypeText.SENTENCE.equals(element.getTypeText())) {
				Iterator<IComponent> elementIterator=element.getIterator();
				while(elementIterator.hasNext()) {
					Leaf word = (Leaf) elementIterator.next();
					if (TypeText.WORD.equals(word.getTypeText())) {
						String text=word.getText();
						Matcher matcher=patternInstance.getPattern(TypeText.CONSONANT).matcher(text.toLowerCase());
						if(wordLenght==text.length()) {
							if(matcher.matches()) {
								element.remove(word);
								elementIterator=element.getIterator();
							}
						}
					}
				}
			}
		}
	}
	
	public static StringBuilder sortWord(IComponent component) throws BusinessException {
		if(component==null) {
			LOG.error("Input composite cannot be null");
			throw new BusinessException("Input composite cannot be null");
		}
		
		StringBuilder ouputResult=new StringBuilder();
		List<String> listWords=new ArrayList<String>();
		Iterator<IComponent> sentenceIterator=component.getIterator();
		
		while(sentenceIterator.hasNext()) {
			IComponent element = sentenceIterator.next();
			if (TypeText.SENTENCE.equals(element.getTypeText())) {
				Iterator<IComponent> elementIterator=element.getIterator();
				while(elementIterator.hasNext()) {
					Leaf word = (Leaf) elementIterator.next();
					if (TypeText.WORD.equals(word.getTypeText())) {
						listWords.add(word.getText());
					}
				}
			}
		}
		
		Collections.sort(listWords);
		
		char previous=listWords.get(START_INDEX).charAt(START_INDEX);
		for(String tempString: listWords) {
			if(previous!=tempString.charAt(START_INDEX)) {
				ouputResult.append(TAB);
				previous=tempString.charAt(START_INDEX);
			}
			ouputResult.append(tempString).append(NEW_LINE);
		}
		return ouputResult;
	}
	
	public static void tradeWordPlaces(IComponent component) throws BusinessException {
		if(component==null) {
			LOG.error("Input composite cannot be null");
			throw new BusinessException("Input composite cannot be null");
		}
		
		Iterator<IComponent> sentenceIterator=component.getIterator();
				
		while(sentenceIterator.hasNext()) {
			IComponent element = sentenceIterator.next();
			if (TypeText.SENTENCE.equals(element.getTypeText())) {
				List<IComponent> newSentence=new LinkedList<IComponent>();
				Iterator<IComponent> elementIterator=element.getIterator();
				int maxIndex=-1;
				
				while(elementIterator.hasNext()) {
					maxIndex++;
					newSentence.add(elementIterator.next());
				}

				if(newSentence.size()<=MIN_SENTENCE_ELEMENT) {
					continue;
				}
				
				if(TypeText.PUNKTUATION_MARK.equals(newSentence.get(maxIndex).getTypeText())) {
					if(newSentence.size()==MIN_WORD_IN_SENTENCE) {
						continue;
					}
					maxIndex--;
				}
				
				for(IComponent tempComponent:newSentence) {
					element.remove(tempComponent);
				}
				
				IComponent firstElement=newSentence.get(START_INDEX);
				IComponent lastElement=newSentence.get(maxIndex);
				newSentence.remove(firstElement);
				newSentence.remove(lastElement);
				newSentence.add(START_INDEX, lastElement);
				newSentence.add(maxIndex,firstElement);
				
				for(IComponent tempComponent:newSentence) {
					element.add(tempComponent);
				}
			}
		}
	}
}
