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

public class MyApronHomePage extends PageBase<MyApronHomePage>{

	private static final By LOGIN_NOW_BTN  = By.xpath("//*[contains(@class,'logInNowButton')]");
	
	public MyApronHomePage(InstanceContainer ic) {
		super(ic);
		// TODO Auto-generated constructor stub
	}

	public void launchMyApron(){
		String URL=	dataTable.getCommonData(CommonDataColumn.MYApron);
			driver.manage().deleteAllCookies();
			driver.get(URL);
		}
	
	public void clickLogin(){
		try {
			wh.clickElement(LOGIN_NOW_BTN);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
