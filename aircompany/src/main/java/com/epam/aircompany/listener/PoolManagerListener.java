package com.epam.aircompany.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.epam.aircompany.pool.ConnectionPool;

/**
 * The listener interface for receiving poolManager events.
 * The class that is interested in processing a poolManager
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's addPoolManagerListener method. When
 * the poolManager event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class PoolManagerListener implements ServletContextListener {
	private static final Logger LOG = Logger.getLogger(PoolManagerListener.class);
	
    /**
     * Instantiates a new pool manager listener.
     */
    public PoolManagerListener() {
    }

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	LOG.info("Close Pool");
    	ConnectionPool.getInstance().closeAllConnections();
    }

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	//ConnectionPool.getInstance();
    	//LOG.info("Create Pool");
    }
}
