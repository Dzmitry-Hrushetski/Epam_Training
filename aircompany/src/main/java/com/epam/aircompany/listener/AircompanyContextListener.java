package com.epam.aircompany.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.epam.aircompany.pool.ConnectionPool;

/**
 * Application Lifecycle Listener implementation class AircompanyContextListener
 *
 */
public class AircompanyContextListener implements ServletContextListener {
	private static final Logger LOG = Logger.getLogger(AircompanyContextListener.class);
	
    /**
     * Default constructor. 
     */
    public AircompanyContextListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	LOG.info("Close Pool");
    	ConnectionPool.getInstance().closeAllConnections();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	//ConnectionPool.getInstance();
    	//LOG.info("Create Pool");
    }
}
