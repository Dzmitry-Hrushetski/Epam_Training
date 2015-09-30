/**
 * 
 */
package com.railway.runner;

import com.railway.beans2.Route;
import com.railway.logic.ComplexFindImpl;
import com.railway.logic.Database;
import com.railway.logic.IRoutes;
import com.railway.logic.SimpleFindImpl;



/**
 * @author Dzmitry Hrushetski
 *
 */
public class Runner {

	public static void main(String[] args) {
		
		Database db = new Database();
		IRoutes logic1 = new SimpleFindImpl();
		IRoutes logic2 = new ComplexFindImpl();
		
		Route r1 = logic1.findRoute("Minsk", "Adler", db);
		Route r2 = logic2.findRoute("Minsk", "Adler", db);
		
		// logic1.calculate(r1);
		logic2.calculate(r1);
		// r1 , r2
		// obj = calculate(r1)
		// obj = calculate(r2)
		System.out.println(logic1.findRoute("Minsk", "Adler", db));
		System.out.println(logic2.findRoute("Minsk", "Adler", db));

	}
	

	
	
	
	
	

}
