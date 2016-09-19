package com.homer.po;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.homer.dao.CommonDataColumn;
import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;
public class HomePage extends PageBase<HomePage> {
	
	static By betaWebServerBtn = By.xpath("//button[@id='button1'][contains(text(),'Beta Webservers')]");
	static By testWebServerBtn = By.xpath("//button[@id='button1'][contains(text(),'Test Webserver')]");
	
	static final By SearchTxtBox = By.id("searchFocus");
	static final By SearchBtn = By.id("searchButton");
	 
	 public HomePage(InstanceContainer ic) {
		 super(ic);        	     
	 }
	 
	 /**
	  * Method to open Home Page
	  * @throws Exception
	  */
	 public void open() throws Exception {
		 
		// rc.getXMLResponse("http://cpliqa9u.homedepot.com:1219/ProductAPI/v1/price?itemId=205092878");
		 String envUrl = dataTable
					.getCommonData(CommonDataColumn.EnvironmentUrl);

			try {

				driver.manage().deleteAllCookies();
				driver.get(dataTable.getCommonData("EnvironmentUrl"));
				
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				wh.handleAlert();
			}

			if (envUrl.contains("usebeta") || envUrl.contains("testpage")) {

				if (envUrl.contains("usebeta")) {

					wh.clickElement(betaWebServerBtn);

				} else {

					try {

						wh.clickElement(testWebServerBtn);

					} catch (Exception ex) {

						System.out.println(ex.getMessage());
					}
				}

				if (wh.isAlertPresent()) {

					wh.handleAlert();
				}

				final String thisWindow = driver.getWindowHandle();

				String newWindow = new WebDriverWait(driver, 30)
						.until(new ExpectedCondition<String>() {
							public String apply(WebDriver d) {
								Set<String> handles = d.getWindowHandles();
								handles.remove(thisWindow);
								return handles.size() > 0 ? handles.iterator()
										.next() : null;
							}
						});

				driver.close();
				driver.switchTo().window(newWindow);
				driver.manage().window().maximize();
			}	
		
		driver.manage().window().maximize();
		expectedResult =  wh.isElementPresent(verifyHomePage, 1) ||rc.getAnalyticsValue("pageName").equalsIgnoreCase("HomePage") ? true : false;
		
		if(expectedResult) {
			
			report.addReportStep("Open Home Depot page" , 
					"Open Home Depot page is displayed successfully", 
					StepResult.PASS);
		} else {
			
			report.addReportStep("Open Home Depot page" , 
					"Open Home Depot page is not displayed successfully", 
					StepResult.FAIL);
		}
	 }	 
}
