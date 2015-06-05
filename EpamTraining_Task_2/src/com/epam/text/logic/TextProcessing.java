/**
 * 
 */
package com.epam.text.logic;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.epam.text.bean.TypeText;
import com.epam.text.exception.BusinessException;

/**
 * @author Dzmitry Hrushetski
 * 
 */
public class TextProcessing {
	private static final String NEW_LINE="\n\r";
	
	
	public static StringBuilder sortSentenceByWordLenght(IComponent component) {
		int countWord=0;
		StringBuilder ouputResult=new StringBuilder();
		IComponent currentSentence=null;
		IComponent currentWord=null;
		Map<Integer,IComponent> sentenceInstance=new TreeMap<Integer,IComponent>();
		//Iterator<IComponent> sentenceIterator=component.getIterator();
		
		try {
			int sentenceIndex=0;
			while(true){
				currentSentence=component.getElement(sentenceIndex);
				if(TypeText.SENTENCE==currentSentence.getTypeText()) {
					try {
						int wordIndex=0;
						countWord=0;
						while(true){
							currentWord=currentSentence.getElement(wordIndex);
							if(TypeText.WORD==currentWord.getTypeText()) {
								countWord++;
							}
							wordIndex++;
						}	
					} catch (IndexOutOfBoundsException e) {
						sentenceInstance.put(countWord, currentSentence);
					}
				}		
				sentenceIndex++;
			}	
		} catch (IndexOutOfBoundsException e) {
				
		}	
		
		// вот тут и происходит сбой
		Set set = sentenceInstance.entrySet();
        Iterator iterator = set.iterator();
        IComponent tmpComponent;
        while(iterator.hasNext()) {
        	 Map.Entry temp = (Map.Entry)iterator.next();
             tmpComponent=(IComponent)temp.getValue();
             ouputResult.append(tmpComponent.recoverComposit(new StringBuilder()));
             ouputResult.append(NEW_LINE);
        }
		return ouputResult;
	}

	public static StringBuilder deleteWordLenght(IComponent component) {
		int countWord=0;
		StringBuilder ouputResult=new StringBuilder();
		IComponent currentSentence=null;
		IComponent currentWord=null;
		Map<Integer,IComponent> sentenceInstance=new TreeMap<Integer,IComponent>();
		//Iterator<IComponent> sentenceIterator=component.getIterator();
		
		try {
			int sentenceIndex=0;
			while(true){
				currentSentence=component.getElement(sentenceIndex);
				if(TypeText.SENTENCE==currentSentence.getTypeText()) {
					try {
						int wordIndex=0;
						countWord=0;
						while(true){
							currentWord=currentSentence.getElement(wordIndex);
							if(TypeText.WORD==currentWord.getTypeText()) {
								countWord++;
							}
							wordIndex++;
						}	
					} catch (IndexOutOfBoundsException e) {
						sentenceInstance.put(countWord, currentSentence);
					}
				}		
				sentenceIndex++;
			}	
		} catch (IndexOutOfBoundsException e) {
				
		}	
		
		// вот тут и происходит сбой
		Set set = sentenceInstance.entrySet();
        Iterator iterator = set.iterator();
        IComponent tmpComponent;
        while(iterator.hasNext()) {
             Map.Entry temp = (Map.Entry)iterator.next();
             tmpComponent=(IComponent)temp.getValue();
             StringBuilder vv;
             vv=tmpComponent.recoverComposit(new StringBuilder());
             ouputResult.append(vv);
             ouputResult.append(NEW_LINE);
        }
		return ouputResult;
	}
}
