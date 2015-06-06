/**
 * 
 */
package com.epam.text.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;

import com.epam.text.bean.Leaf;
import com.epam.text.bean.TypeText;
import com.epam.text.exception.BusinessException;
import com.epam.text.regex.TextRegex;

/**
 * @author Dzmitry Hrushetski
 * 
 */
public class TextProcessing {
	private static final String NEW_LINE="\n\r";
	private static final String TAB="\t";
	
	
	

	public static void deleteConsonantWordLenght(IComponent component, int wordLenght) {
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
	
	public static StringBuilder sortWord(IComponent component) {
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
		
		char previous=listWords.get(0).charAt(0);
		for(String tempString: listWords) {
			if(previous!=tempString.charAt(0)) {
				ouputResult.append(TAB);
				previous=tempString.charAt(0);
			}
			ouputResult.append(tempString).append(NEW_LINE);
		}
		return ouputResult;
	}
	
	public static void tradeWordPlaces(IComponent component) {
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

				if(newSentence.size()<=2) {
					continue;
				}
				
				for(IComponent tempComponent:newSentence) {
					element.remove(tempComponent);
				}
				
				/*int index=maxIndex;
				while(index!=0) {
					if(TypeText.WORD.equals(newSentence.get(index).getTypeText())) {
						if(index>1) {
							break;
						}else {
							index--;
							continue;
						}
						
					}
					//else {
					//	index--;
					//}
				
				}*/
				IComponent firstElement=newSentence.get(0);
				IComponent lastElement=newSentence.get(maxIndex-1);
				newSentence.remove(firstElement);
				newSentence.remove(lastElement);
				newSentence.add(0, lastElement);
				newSentence.add(maxIndex-1,firstElement);
				
				for(IComponent tempComponent:newSentence) {
					element.add(tempComponent);
				}
				
			}
		}
	}
}
