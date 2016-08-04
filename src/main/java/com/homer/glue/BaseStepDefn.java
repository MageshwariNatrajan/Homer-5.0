package com.homer.glue;

import org.openqa.selenium.WebDriver;

import com.homer.dao.CommonData;
import com.homer.dao.DataClass;
import com.homer.dao.ExecutionSession;
import com.homer.dao.InstanceContainer;
import com.homer.helper.DataTable;
import com.homer.helper.HelperClass;
import com.homer.po.APIDemo;
import com.homer.po.CheckoutSignInPage;
import com.homer.po.HomePage;
import com.homer.po.PIPPage;
import com.homer.po.PLPPage;
import com.homer.po.PaymentPage;
import com.homer.po.ShippingPage;
import com.homer.po.ShoppingCartPage;
import com.homer.po.ThankYouPage;
import com.homer.reports.Report;
import com.homer.resuablecomponents.ReportUtil;
import com.homer.resuablecomponents.ReusableComponents;
import com.homer.resuablecomponents.WebDriverHelper;

public class BaseStepDefn {
	
	protected Report report;
	protected DataTable dataTable;
	
	protected WebDriverHelper wh;
	protected DataClass data;
	
	protected WebDriver driver;
	protected ReusableComponents rc;
	protected InstanceContainer ic;
	
	protected HomePage homePage;
	protected PLPPage plpPage;
	protected PIPPage pipPage;
	protected ShoppingCartPage shoppingCartPage;
	protected CheckoutSignInPage checkoutSignInPage;
	protected ShippingPage shippingPage;
	protected PaymentPage paymentPage;
	protected ThankYouPage thankYouPage;
	
	CommonData commonData;
	protected WebDriver newWebDriver;
	protected String testTxt;
	
	
	protected ReportUtil rptUtil;
	
	protected APIDemo apiDemo;
	
	public BaseStepDefn(DataClass data) {
		
		
		this.data = data;
		this.driver = data.driver;
		this.report = data.report;
		this.dataTable = data.dataTable;		
		this.commonData = (CommonData)data.commonData;
		
		
		wh = new WebDriverHelper(driver, report, dataTable);
		rc = new ReusableComponents(driver, report, wh, dataTable, data);
		
		ic = new InstanceContainer(driver, report,dataTable, wh, rc,commonData);
		
		
		
		if(HelperClass.baseModel.plainFramework) {
			
			if(data.tools!=null) {
				
				driver = (WebDriver)data.tools;
				
				rptUtil = new ReportUtil(driver,report, data);
			} else {
			
				rptUtil = new ReportUtil(report, data);	
			}			
		}
		
		
		/*if(data.tools!=null) {
			
			System.out.println(data.tools.toString());		
			
			HashMap<String, Object> mapObj = (HashMap<String, Object>) data.tools;
			
			newWebDriver = (WebDriver) mapObj.get("FFDriver");
			testTxt = (String) mapObj.get("TxtMsg");			
		}*/
		
		
		homePage = new HomePage(ic);
		plpPage = new PLPPage(ic);
		pipPage = new PIPPage(ic);
		shoppingCartPage = new ShoppingCartPage(ic);
		checkoutSignInPage = new CheckoutSignInPage(ic);
		shippingPage = new ShippingPage(ic);
		paymentPage = new PaymentPage(ic);
		thankYouPage = new ThankYouPage(ic);
		apiDemo=new APIDemo(ic);
	}
	
	// Please do not add any step definition implementation methods in this class
}
