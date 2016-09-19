package com.homer.dao;

public enum ConnectionConstants {
	DB2(
			"com.ibm.db2.jcc.DB2Driver",
			"jdbc:db2://ibdynpx0.sysplex.homedepot.com:5122/NP1",
			"QA1MM67",
			"67MM1AQ"
		),
	ORACLE(
			"oracle.jdbc.OracleDriver",
			"jdbc:oracle:thin:@//pnpmm77z.homedepot.com:1521/dad19ss_rw_mexd_01",
			"MEXDAP01",
			"rjw9gc5x"
		);

	private final String drivers;
	private final String url;
	private final String userid;
	private final String password;
	
	private ConnectionConstants(String drivers,String url,String userid,String password){
		this.drivers = drivers;
		this.url = url;
		this.userid = userid;
		this.password = password;
	}
	
	
	public String url(){
		return this.url;
	}
	public String drivers(){
		return this.drivers;
	}
	public String userid(){
		return this.userid;
	}
	public String password(){
		return this.password;
	}
}