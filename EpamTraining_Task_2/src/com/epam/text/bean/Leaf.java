/**
 * 
 */
package com.epam.text.bean;

import com.epam.text.logic.IComponent;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Leaf implements IComponent {
	private TypeText typeText;
	private String text;
	
	/**
	 * @param typeText
	 * @param leaf
	 */
	public Leaf(TypeText typeText, String text) {
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
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see com.epam.text.logic.IComponent#remove(com.epam.text.logic.IComponent)
	 */
	@Override
	public void remove(IComponent component) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see com.epam.text.logic.IComponent#getElement(int)
	 */
	@Override
	public IComponent getElement(int index) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see com.epam.text.logic.IComponent#getTypeText()
	 */
	@Override
	public TypeText getTypeText() {
		return typeText;
	}
	
	/* (non-Javadoc)
	 * @see com.epam.text.logic.IComponent#RecoverComposit(java.lang.StringBuilder)
	 */
	@Override
	public StringBuilder RecoverComposit(StringBuilder data) {
		data.append(getText()).append(SPACE);
		return data;
	}

	/* (non-Javadoc)
	 * @see com.epam.text.logic.IComponent#print()
	 */
	@Override
	public void print() {
		System.out.print(this);
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return text+" ";
	}
}
