/**
 * 
 */
package com.epam.text.logic;

import com.epam.text.bean.TypeText;

/**
 * @author Dzmitry Hrushetski
 *
 */
public interface IComponent {
	void add(IComponent component);
	void remove(IComponent component);
	IComponent getElement(int index);
	TypeText getTypeText();
	void print();
}
