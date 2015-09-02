package com.epam.aircompany.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.epam.aircompany.pool.ConnectionPool;
import com.epam.aircompany.util.HashPassword;

/**
 * Application Lifecycle Listener implementation class PoolManagerListener
 *
 */
public class PoolManagerListener implements ServletContextListener {
	private static final Logger LOG = Logger.getLogger(PoolManagerListener.class);
	
    /**
     * Default constructor. 
     */
    public PoolManagerListener() {
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
    	
    /*	
    	String str1 = HashPassword.calculateHashPassword("director");
    	String str2 = HashPassword.calculateHashPassword("globus");
    	String str3 = HashPassword.calculateHashPassword("123456");
    	String str4 = HashPassword.calculateHashPassword("administrator");
    	String str5 = HashPassword.calculateHashPassword("manager");
    	*/
    	//ConnectionPool.getInstance();
    	//LOG.info("Create Pool");
    }
}
