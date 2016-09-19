package com.homer.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.homer.enums.EnumClass.StepResult;
import com.homer.helper.HelperClass;
import com.homer.po.PageBase;
import com.homer.reports.Report;

public class GenericUtil {
	
	public static final String uiPackageName = "com.homer.uistore.";
	public static  Class<?> pipClass;
	public static Logger logger = Logger.getLogger(GenericUtil.class);
	
	public GenericUtil(){
		//constructor
	}
	
	/**
	 * Method to set PIP UI Class
	 * @throws Exception
	 */
	public static void setPIPUIClass() throws Exception {
		
		String pipUIClass = uiPackageName + HelperClass.readRunConfigProperties("PIPUI");
		
		try {
		
			pipClass = Class.forName(pipUIClass);
			
		} catch (Exception ex) {
		
			logger.info("Error "+ex);
		}		
	}
	
	/**
	 * Method to get PIP Locator
	 * @param locatorName
	 * @return
	 */
	public static String getPIPLoactor(String locatorName) {
		
		String locator = "";
		
		try {
			
			locator = pipClass.getField(locatorName).get(null).toString();
			
		} catch (Exception ex) {
			
			logger.info("Error "+ex);
		}
		
		return locator;
	}

	/**
	 * Method to get PIP Locator
	 * @param locatorName
	 * @return
	 */
	public static By getPIPLoactorBy(String locatorName) {
		
		By locatorBy = null;
		
		try {
			
			locatorBy = (By) pipClass.getField(locatorName).get(null);
			
		} catch (Exception ex) {
			
			logger.info("Error "+ex);
		}
		
		return locatorBy;
	}
	
	/**
	 * Method to set AUT Map
	 */
	public static void setAUTSwitch() {
		
		if(HelperClass.readRunConfigProperties("AUTSwitch").equalsIgnoreCase("true")) {
		
			List<String> lstAUTSwitch =	HelperClass.getAUTSwitch();
			
			HashMap<String, Boolean> autSwitchMap = null;
			
			if(lstAUTSwitch.size() > 0) {
				
				autSwitchMap = new HashMap<String, Boolean>();
				
				for (String autSwitch : lstAUTSwitch) {
					
					if(autSwitch.equalsIgnoreCase("Certona")) {
						
						autSwitchMap.put(autSwitch, true);
					} else {
					
						autSwitchMap.put(autSwitch, false);
					}
				}
				
			}
					
			HelperClass.setAUTMAp(autSwitchMap);
		}
	}
	
public static void printConsoleError(WebDriver driver, Report report) {
		
		String errorConsole = HelperClass.readRunConfigProperties("ErrorConsole");
		if(errorConsole.contains("True")){
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
        	
        	if (entry.getLevel().equals(Level.SEVERE)){
        		report.addReportStep(
        				"CONSOLE ERROR DETECTED",
        				"ERROR : "+new Date(entry.getTimestamp()) +" "+entry.getMessage(), StepResult.WARNING);
        	}  
        	
        }
       
        }
	}
}
