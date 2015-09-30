/**
 * 
 */
package com.railway.logic;

import com.railway.beans2.Route;

/**
 * @author Aleh_Litvinau
 */
public interface IRoutes {
	
	
	public Route findRoute(String from, String to, Database db);
	public Object calculate(Route tmp);

}
