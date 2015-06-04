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
	private List<IComponent> components =new LinkedList<IComponent>();

	
	/**
	 * @param typeText
	 */
	public Composite(TypeText typeText) {
		super();
		this.typeText = typeText;
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
	 * @see com.epam.text.logic.IComponent#RestoreComposit(java.lang.StringBuilder)
	 */
	@Override
	public StringBuilder recoverComposit(StringBuilder data) {
		for(IComponent component:components){
			data=component.recoverComposit(data);
		}
		return data;
	}
}
