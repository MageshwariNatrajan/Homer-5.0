package com.homer.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * DataSource class used for JUnit testing to get a connection to the database.
 * 
 * @author ehn9a5m
 */
public class BasicDataSource implements DataSource {

	private PrintWriter logWriter = null;
	private int loginTimeout = 0;

	private final String username;
	private final String password;
	private final String url;
	private final String drivers;
	public static final Logger logger = Logger.getLogger(BasicDataSource.class);
	
	public BasicDataSource(String url,String drivers ,String username, String password) {
		this.url = url;
		this.drivers = drivers;
		this.username = username;
		this.password = password;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.DataSource#getConnection()
	 */
	public Connection getConnection() throws SQLException {

		return getConnection("", "");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.DataSource#getConnection(java.lang.String,
	 * java.lang.String)
	 */
	
	public Connection getConnection(String arg0, String arg1)
			throws SQLException {

		Connection connection = null;

		try {
			// Load the JDBC driver
			Class.forName(drivers);

			// Create a connection to the database
			connection = DriverManager.getConnection(url,
					username, password);
			return connection;

		} catch (ClassNotFoundException e) {
			logger.info("Class not found Error"+e);
		} catch (SQLException e) {
			logger.info("SQL Error"+e);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.DataSource#getLogWriter()
	 */
	
	public PrintWriter getLogWriter() throws SQLException {

		if (logWriter == null) {

			logWriter = new PrintWriter(System.out);
			return logWriter;

		} else {

			return logWriter;

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.DataSource#getLoginTimeout()
	 */
	public int getLoginTimeout() throws SQLException {

		return loginTimeout;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.DataSource#setLogWriter(java.io.PrintWriter)
	 */
	
	public void setLogWriter(PrintWriter logWriter) throws SQLException {

		this.logWriter = logWriter;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sql.DataSource#setLoginTimeout(int)
	 */
	public void setLoginTimeout(int loginTimeout) throws SQLException {
		this.loginTimeout = loginTimeout;

	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}
//@Override
	public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}



}
