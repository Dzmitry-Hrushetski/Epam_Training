package com.epam.web.aircompany.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.epam.web.aircompany.connection.ConnectionPool;
import com.epam.web.aircompany.dao.factory.DaoFactoryType;
import com.epam.web.aircompany.dao.factory.DatabaseFactory;

import static com.epam.web.aircompany.constant.Constants.*;

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
    	ConnectionPool pool = (ConnectionPool)context.getAttribute(CONNECTION_POOL);
    	LOG.info("Close Pool");
    	pool.closeAllConnections();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	ServletContext context = arg0.getServletContext();
    	context.setAttribute(CONNECTION_POOL, ConnectionPool.getInstance());
    	context.setAttribute(I_DAO, DatabaseFactory.getInstance().getDatabaseDao(DaoFactoryType.MYSQL));	
    	LOG.info("Create Pool");
    }
	
}
