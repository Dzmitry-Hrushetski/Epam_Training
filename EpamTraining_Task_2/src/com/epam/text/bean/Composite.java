/**
 * 
 */
package com.epam.text.bean;

import java.util.LinkedList;
import java.util.List;

import com.epam.text.logic.IComponent;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Composite implements IComponent {
	private TypeText typeText;
	private String text;
	private List<IComponent> components =new LinkedList<IComponent>();

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
	 * @see com.epam.text.logic.IComponent#parseText()
	 */
	@Override
	public void parseText() {
		// TODO Auto-generated method stub

	}

}
