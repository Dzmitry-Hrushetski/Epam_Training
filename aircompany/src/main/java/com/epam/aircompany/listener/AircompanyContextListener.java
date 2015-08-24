package com.epam.aircompany.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.epam.aircompany.dao.factory.DaoFactoryType;
import com.epam.aircompany.dao.factory.DatabaseFactory;
import com.epam.aircompany.pool.ConnectionPool;

import static com.epam.aircompany.constant.Constants.*;

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
    	ServletContext context = arg0.getServletContext();
    	//ConnectionPool pool = (ConnectionPool)context.getAttribute(CONNECTION_POOL);
    	LOG.info("Close Pool");
    	ConnectionPool.getInstance().closeAllConnections();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	ServletContext context = arg0.getServletContext();
    	//context.setAttribute(CONNECTION_POOL, ConnectionPool.getInstance());
    	//context.setAttribute(I_DAO, DatabaseFactory.getInstance().getDatabaseDao(DaoFactoryType.MYSQL));
    	ConnectionPool.getInstance();
    	LOG.info("Create Pool");
    }
	
}
