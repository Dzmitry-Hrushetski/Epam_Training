/**
 * 
 */
package com.epam.text.bean;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;

import com.epam.text.logic.IComponent;
import com.epam.text.regex.TextRegex;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Composite implements IComponent {
	private static final String EMPTY_STRING="";
	private TypeText typeText;
	private String text;
	private List<IComponent> components =new LinkedList<IComponent>();

	
	/**
	 * @param typeText
	 */
	public Composite(TypeText typeText) {
		super();
		this.typeText = typeText;
	}

	/**
	 * @param typeText
	 * @param composite
	 */
	public Composite(TypeText typeText, String text) {
		super();
		this.typeText = typeText;
		this.text = text;
	}

	public String getText() {
		return text;
	}


	/* (non-Javadoc)
	 * @see com.epam.text.logic.IComponent#add(com.epam.text.logic.IComponent)
	 */
	@Override
	public void add(IComponent component) {
		components.add(component);
	}

	/* (non-Javadoc)
	 * @see com.epam.text.logic.IComponent#remove(com.epam.text.logic.IComponent)
	 */
	@Override
	public void remove(IComponent component) {
		components.remove(component);
	}

	/* (non-Javadoc)
	 * @see com.epam.text.logic.IComponent#getElement(int)
	 */
	@Override
	public IComponent getElement(int index) {
		return components.get(index);
	}
	
	/* (non-Javadoc)
	 * @see com.epam.text.logic.IComponent#getTypeText()
	 */
	@Override
	public TypeText getTypeText() {
		return typeText;
	}
	
	/* (non-Javadoc)
	 * @see com.epam.text.logic.IComponent#print()
	 */
	@Override
	public void print() {
		for(IComponent c:components){
			c.print();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.epam.text.logic.IComponent#parseText()
	 */
	@Override
	public void parseText(String text) {
		TextRegex patternInstance=TextRegex.getTextRegexInstance();
		Matcher matcher=null;
		Matcher matcherGroup=null;
		IComponent newComponent=null;
		String findElement=null;
		
		switch(typeText) {
		case TEXT:	
			matcherGroup=patternInstance.getPattern(TypeText.SENTENCE_OR_LISTING).matcher(text);
			
			while (matcherGroup.find()) {
				findElement=matcherGroup.group();
				matcher=patternInstance.getPattern(TypeText.SENTENCE).matcher(findElement);
				if(matcher.matches()){
					newComponent=new Composite(TypeText.SENTENCE);
					add(newComponent);
					newComponent.parseText(findElement);
				}else {
					newComponent=new Leaf(TypeText.LISTING,findElement);
					add(newComponent);
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
