package com.homer.po;

import org.openqa.selenium.By;

import com.homer.dao.CommonDataColumn;
import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;


public class Login extends PageBase<Login> {
	static final By userName = By.name("j_username");
	static final By password = By.name("j_password");
	static final By login = By.id("submit");

	public Login(InstanceContainer ic) {
		super(ic);
	}

	public void open() throws Exception {
		try {
			driver.manage().deleteAllCookies();
			driver.get(dataTable.getCommonData(CommonDataColumn.EnvironmentUrl));

		} catch (Exception ex) {
			wh.handleAlert();
		}

	}

	// Set user name in textbox
	public void setUserName(String strUserName) throws Exception {
		wh.sendKeys(userName, strUserName);

	}

	// Set password in password textbox
	public void setPassword(String strPassword) throws Exception {
		wh.sendKeys(password, strPassword);
	}

	// Click on login button
	public void clickLogin() throws Exception {
		wh.clickElement(login);
	}

	/**
	 * This POM method will be exposed in test case to login in the application
	 * 
	 * @param strUserName
	 * @param strPasword
	 * @return
	 * @throws Exception
	 */
	public void loginToAppl() throws Exception {
		// driver.navigate().refresh();
		String strUserName = dataTable
				.getCommonData(CommonDataColumn.SignInUser);
		String strPassword = dataTable
				.getCommonData(CommonDataColumn.SignInPassword);
		// Fill user name
		this.setUserName(strUserName);
		// Fill password
		this.setPassword(strPassword);

		// Click Login button
		//this.clickLogin();

		/*
		// Check if we have gone o the next page
		String message = driver.getTitle();
		
		if (message.equalsIgnoreCase("Clearance Optimization Maintenance")) {

			report.addReportStep(String.format(
					"Loggin in with User id %s and Password %s", strUserName,
					strPassword), "Login Successful", StepResult.PASS);
		} else {
			report.addReportStep(String.format(
					"Loggin in with User id %s and Password %s", strUserName,
					strPassword), "Login Failed", StepResult.FAIL);
		}
		
		return message;
		*/

	}
}
