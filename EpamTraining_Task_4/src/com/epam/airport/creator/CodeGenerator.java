/**
 * 
 */
package com.epam.airport.creator;

import java.util.concurrent.locks.ReentrantLock;



/**
 * @author Dzmitry Hrushetski
 *
 */
public class CodeGenerator {
	private static CodeGenerator instance=null;
	private static ReentrantLock lock = new ReentrantLock();
	
	private static int airplaneCount;
	private static int terminalCount;
	private static int ladderCount;
	
	/**
	 * 
	 */
	private CodeGenerator() {
		super();
	}
	
	public static CodeGenerator getInstance() {
		lock.lock();
		try {
			if (instance == null) {
				instance = new CodeGenerator();
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
