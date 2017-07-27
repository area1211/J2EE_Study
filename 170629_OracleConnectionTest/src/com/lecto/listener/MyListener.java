package com.lecto.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.lecto.db.DBConnection;
import com.lecto.model.EmployeesDAO;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
public class MyListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	DBConnection dbc = ((DBConnection)sce.getServletContext().getAttribute("DBConnection"));
    	dbc.closeConn();
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        ServletContext sc =  sce.getServletContext();
        String url = sc.getInitParameter("OracleURL");
        String driverClassName = sc.getInitParameter("OracleDriverClassName");
        String id = sc.getInitParameter("OracleID");
        String pw = sc.getInitParameter("OraclePW");
        
        DBConnection dbc = new DBConnection(driverClassName, url, id, pw);
        
        sc.setAttribute("DBConnection", dbc);
        sc.setAttribute("DAO", new EmployeesDAO(dbc));
    }
	
}
