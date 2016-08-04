/**
 * 
 */
package com.homer.po;

import org.openqa.selenium.By;

import com.homer.dao.CommonDataColumn;
import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

/**
 * @author MXN8002
 *
 */
public class LoginPage extends PageBase<LoginPage> {

	private static final By USER_NAME  = By.name("j_username");
	private static final By PASSWORD  = By.name("j_password");
	private static final By SIGN_SUBMIT  = By.id("submit");
	
	public LoginPage(InstanceContainer ic) {
		super(ic);
		// TODO Auto-generated constructor stub
	}
	
	
	public void loginToMyApron(){
		String strUserName = dataTable
				.getCommonData(CommonDataColumn.SignInUser);
		String strPassword = dataTable
				.getCommonData(CommonDataColumn.SignInPassword);
		try {
			wh.sendKeys(USER_NAME, strUserName);
			wh.sendKeys(PASSWORD, strPassword);
			wh.clickElement(SIGN_SUBMIT);
			report.addReportStepWithScreenshots("Login MyApron", "Login to MyApron", StepResult.PASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
