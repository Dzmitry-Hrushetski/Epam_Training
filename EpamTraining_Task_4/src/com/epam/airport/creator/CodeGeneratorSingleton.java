/**
 * 
 */
package com.epam.airport.creator;

import java.util.concurrent.locks.ReentrantLock;



/**
 * @author Dzmitry Hrushetski
 *
 */
public class CodeGeneratorSingleton {
	private static CodeGeneratorSingleton instance=null;
	private static ReentrantLock lock = new ReentrantLock();
	
	private int airplaneCount;
	private int terminalCount;
	private int ladderCount;
	
	/**
	 * 
	 */
	private CodeGeneratorSingleton() {
		super();
	}
	
	public static CodeGeneratorSingleton getInstance() {
		lock.lock();
		try {
			if (instance == null) {
				instance = new CodeGeneratorSingleton();
			}
		} finally {
			lock.unlock(); 
		}
		return instance;
	}
	
	public int nextAirplaneNumber() {
		return ++airplaneCount;
	}

	public int nextTerminalNumber() {
		return ++terminalCount;
	}
	
	public int nextLadderNumber() {
		return ++ladderCount;
	}
}
