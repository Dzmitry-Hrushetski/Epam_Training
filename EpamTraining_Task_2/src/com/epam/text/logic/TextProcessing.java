/**
 * 
 */
package com.epam.text.logic;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.epam.text.bean.TypeText;
import com.epam.text.exception.BusinessException;

/**
 * @author Dzmitry Hrushetski
 * 
 */
public class TextProcessing {
	private static final String NEW_LINE="/n";
	
	
	public StringBuilder sortSentenceByWordLenght(IComponent component) {
		int countWord=0;
		StringBuilder ouputResult=null;
		IComponent current=null; 
		Map<Integer,IComponent> sentenceInstance=new TreeMap<Integer,IComponent>();
		//Iterator<IComponent> sentenceIterator=component.getIterator();
		
		try {
			int sentenceIndex=0;
			while(true){
				current=component.getElement(sentenceIndex);
				if(TypeText.SENTENCE==current.getTypeText()) {
					try {
						int wordIndex=0;
						countWord=0;
						while(true){
							current=component.getElement(wordIndex);
							if(TypeText.WORD==current.getTypeText()) {
								countWord++;
							}
							wordIndex++;
						}	
					} catch (IndexOutOfBoundsException e) {
						sentenceInstance.put(countWord, current);
					}
				}		
				sentenceIndex++;
			}	
		} catch (IndexOutOfBoundsException e) {
			
			Set<>
			while(sentenceInstance.)ouputResult=ouputResult.
		}	
		
		return ouputResult;
	}

}
