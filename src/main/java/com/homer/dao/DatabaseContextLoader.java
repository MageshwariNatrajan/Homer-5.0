package com.homer.dao;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public final class DatabaseContextLoader {
	
	private static DatabaseContextLoader contextSingleton;
	public DatabaseContextLoader() {
		// Constructor
	}
	
	public static synchronized DatabaseContextLoader getInstance() throws NamingException 
	{
		if(contextSingleton == null)
		{
			contextSingleton = new DatabaseContextLoader();
			DatabaseContextLoader.getInitialContext();
		}
		return contextSingleton;
	}
	
public static void getInitialContext() throws NamingException{
	
	// Create initial context
	System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
			"org.apache.naming.java.javaURLContextFactory");
	System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
	InitialContext ic = new InitialContext();

	ic.createSubcontext("java:");
	ic.createSubcontext("java:comp");
	ic.createSubcontext("java:comp/env");
	ic.createSubcontext("java:comp/env/jdbc");

	// Construct DataSource
	BasicDataSource daoDS = new BasicDataSource(ConnectionConstants.DB2.url(),ConnectionConstants.DB2.drivers()
			,ConnectionConstants.DB2.userid(),ConnectionConstants.DB2.password());

	// Bind DataSource to JNDI name
	ic.bind("java:comp/env/jdbc/DB2Z.PR1.001", daoDS);
	
}
}
