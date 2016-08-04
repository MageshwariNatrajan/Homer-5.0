package com.homer.po;

import java.io.File;
import java.io.FileFilter;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.homer.dao.CommonData;
import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;
import com.homer.helper.DataTable;
import com.homer.reports.Report;
import com.homer.resuablecomponents.ReusableComponents;
import com.homer.resuablecomponents.WebDriverHelper;

public class PageBase <CHILD extends PageBase<CHILD>>{
	
	protected InstanceContainer ic;
	protected WebDriver driver;
	protected WebDriverHelper wh;
	protected DataTable dataTable;
	protected ReusableComponents rc;
	protected Report report;
	protected CommonData commonData;
	
	
	protected boolean expectedResult;
	//private boolean isListViewSelected;
	
	//private static final By pageTitle = By.className("page-title");
	
	private static final By searchTxtBox = By.id("headerSearch");
	private static final By searchBtn = By.id("headerSearchButton");
	private static final By verifyPLPPage = By.id("hd_plp");
	private static final By breadCrumbDiv = By.id("breadcrumb");
	
	private static final By signInLink = By.xpath("//div[@id='accountInfo']//a[text()='Sign In']");
	private static final By verifySignInPage = By.id("userLogin");
	private static final By emailTxtBox = By.id("email_id");
	private static final By passwordTxtBox = By.id("password");;	
	private static final By signInBtn = By.id("signIn");
	private static final By verifySignedInUser = By.xpath("//span[@id='navUserName'][contains(text(),'Hello')]");
	protected static final By verifyHomePage = By.className("switches");
	
	public static final Logger logger = Logger.getLogger(PageBase.class);
	
	public PageBase(InstanceContainer ic) {
		
		this.ic = ic;
		this.driver = ic.driver;
		this.wh = ic.wh;
		this.rc = ic.rc;
		this.dataTable = ic.dataTable;
		this.report = ic.report;
		this.commonData = ic.commonData;
	}
	
	/**
	  * Method to search keyword
	  * @return
	  * @throws Exception
	  */
	public PLPPage searchKeyword(String keyword) throws Exception {
		
		wh.clickElement(searchTxtBox);
		wh.sendKeys(searchTxtBox, keyword);
		wh.clickElement(searchBtn);
		
		expectedResult = (wh.isElementPresent(verifyPLPPage, 7)	&& wh.getText(breadCrumbDiv).contains(keyword)) ? true :false;
		
		if(expectedResult) {
			
			report.addReportStep("Search for keyword '"+keyword+"'", 
					"Search PLP page for '"+keyword+"' is displayed", 
					StepResult.PASS);
			
		} else  {
			
			report.addReportStep("Search for keyword '"+keyword+"'", 
					"Search PLP page for '"+keyword+"' is not displayed", 
					StepResult.PASS);
		}
		
		return new PLPPage(ic);		
	}
	
	/**
	 * Method to enter SKU 
	 * @param sku
	 * @return
	 * @throws Exception
	 */
	public PIPPage searchSkuNo(String sku) throws Exception {

		commonData.sku = sku;
		
		wh.sendKeys(searchTxtBox, sku);
		wh.clickElement(searchBtn);
		
		report.addReportStep("Type '" + sku	+ "' in search text box and click on search button",
				"Typed '" + sku	+ "' in search text box and clicked on search button",
				StepResult.PASS);
		
		return new PIPPage(ic);		
	}
	
	/**
	 * Method to sign In User
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public CHILD signInUser(String email, String password) throws Exception {
		
		wh.clickElement(signInLink);

		if (wh.isElementPresentAfterWait(verifySignInPage)) {

			report.addReportStep(
					"Click on 'Sign in' link present on the top right side of the page",
					"Sign In page displayed successfully", StepResult.PASS);
			
			wh.sendKeys(emailTxtBox, email);
			wh.sendKeys(passwordTxtBox, password);
			wh.clickElement(signInBtn);

			if (wh.isElementPresentAfterWait(verifySignedInUser)) {

				report.addReportStep(
						"Enter valid email address and Password and click on the 'Sign in' button.",
						"Site navigated to the homepage after successful login",
						StepResult.PASS);
			} else {

				String stepDesc = "";

				if (!wh.isElementPresentAfterWait(verifySignedInUser)
						&& !wh.isElementPresentAfterWait(verifyHomePage)) {

					stepDesc = "Sign In failed for user and was not redirected to home page";

				} else if (!wh.isElementPresentAfterWait(verifySignedInUser)) {

					stepDesc = "User was not redirected to home page";

				} else {

					stepDesc = "User did not get signed in successfully";
				}

				report.addReportStep(
						"Enter valid email address and Password and click on the 'Sign in' button.",
						stepDesc, StepResult.FAIL);
			}

		} else {
			
			report.addReportStep("Click on Sign In link",
					"Sign In page did not get displayed", StepResult.FAIL);
		}
		
		return (CHILD) this;
	}
	
	/**
	 * This method is used to get the file name from the specified directory
	 * location.
	 */

	public String getFileName(String fileLocation, final String inputFileName) {

		logger.info("ProcessNewCadenceForSkuStore::getFileName() starts-->");
		logger.info("fileLocation--->" + fileLocation);

		String fileName = "";
		File dir = new File(fileLocation);

		// Create a FileFilter and override its accept-method
		FileFilter fileFilter = new FileFilter() {

			public boolean accept(File file) {

				// if the file name starts with CO_Manual_Cadence return true,
				// else false

				if (file.getName().startsWith(inputFileName)) {
					return true;
				}
				return false;
			}
		};

		File[] filesFiltered = dir.listFiles(fileFilter);
		if (!ArrayUtils.isEmpty(filesFiltered)) {
			for (File fileList : filesFiltered) {
				fileName = fileList.toString();
			}
		}
		logger.info("ProcessNewCadenceForSkuStore::getFileName() ends-->");
		return fileName;
	}

	
}
