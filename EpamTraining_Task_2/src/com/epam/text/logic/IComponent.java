/**
 * 
 */
package com.epam.text.logic;

import java.util.Iterator;

import com.epam.text.bean.TypeText;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface IComponent {
	public static final String SPACE=" ";
	
	void add(IComponent component);
	void remove(IComponent component);
	IComponent getElement(int index);
	Iterator<IComponent> getIterator();
	TypeText getTypeText();
	StringBuilder recoverComposit(StringBuilder data);
}
