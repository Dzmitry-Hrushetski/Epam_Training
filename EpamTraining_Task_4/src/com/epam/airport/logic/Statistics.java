/**
 * 
 */
package com.epam.airport.logic;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import static com.epam.airport.constant.AirportConstants.*;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class Statistics {
	private static final Logger LOG = Logger.getLogger(Statistics.class);
	private static Statistics instance=null;
	private static ReentrantLock lock = new ReentrantLock();
	private static int threadsCount=0;
	
	private LinkedList<String> waitServiceTime=new LinkedList<String>();
	
	private long totalWorkTime;

	/**
	 * 
	 */
	private Statistics() {
		super();
	}
	
	public static Statistics getInstance() {
		lock.lock();
		try {
			if (instance == null) {
				instance = new Statistics();
			}
		} finally {
			lock.unlock(); 
		}
		return instance;
	}
	
	public void incThreadsCount() {
		lock.lock();
		try {
			if(threadsCount==0) {
				totalWorkTime=System.currentTimeMillis();
			}
			threadsCount++;
		} finally {
			lock.unlock(); 
		}
	}
	
	public void decThreadsCount() {
		lock.lock();
		try {
			threadsCount--;
			if(threadsCount==0) {
				totalWorkTime=System.currentTimeMillis()-totalWorkTime;
				waitServiceTime.add(String.format(STATISTICS_TIME_MESSAGE, totalWorkTime));
				for(String str: waitServiceTime) {
					LOG.info(str);
				}
			}
		} finally {
			lock.unlock(); 
		}
	}
	
	public void addStatisticsData(long waitTime, int ID) {
		lock.lock();
		try {
			 waitServiceTime.add(String.format(STATISTICS_MESSAGE, ID, waitTime));
		} finally {
			lock.unlock(); 
		}
	}
}
