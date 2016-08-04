/**
 * 
 */
package com.homer.executionclasses;

import com.homer.dao.BaseExecutionClass;
import com.homer.dao.DataColumn;
import com.homer.dao.InstanceContainer;
import com.homer.model.TestCase;
import com.homer.po.HomePage;
import com.homer.po.LoginPage;
import com.homer.po.MyApronHomePage;
import com.homer.resuablecomponents.ReusableComponents;
import com.homer.resuablecomponents.WebDriverHelper;

/**
 * @author MXN8002
 *
 */
public class LoginAppNonBDD extends BaseExecutionClass {
	
	ReusableComponents rc;
	WebDriverHelper wh;
	InstanceContainer ic;
	HomePage homePage;
	TestCase testCase;



public LoginAppNonBDD(TestCase currentTestCase) throws Exception {
	super(currentTestCase);

	this.testCase = currentTestCase;
	wh = new WebDriverHelper(driver, report, dataTable,
			currentTestCase.browser);
	
	rc = new ReusableComponents(driver, report, wh, dataTable);
	
	ic = new InstanceContainer(driver, report, dataTable, wh, rc);
}	

/**
 *Method to search keyword
 * @throws Exception
 */
public void searchKeyword() throws Exception {
	
	System.out.println("Test case name " +testCase.testCaseName);
	System.out.println("Report folder name " +testCase.reportFolder);
	System.out.println("Screenshot folder name "+testCase.almScreenShotPath);
	
	homePage = new HomePage(ic);
	
	homePage.open();
	homePage.searchKeyword(dataTable.getData(DataColumn.Keyword));
}

public void test_LoginToMyApron() throws Exception {
	
	System.out.println("Non BDD execution Test search1");
	MyApronHomePage myApronHome = new MyApronHomePage(ic);
	myApronHome.launchMyApron();
	myApronHome.clickLogin();
	
	LoginPage login = new LoginPage(ic);
	login.loginToMyApron();
}
}
