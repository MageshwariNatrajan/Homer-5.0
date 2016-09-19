package com.homer.po;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.homer.dao.DataColumn;
import com.homer.dao.InstanceContainer;

/**
 * This class is used to search for the SKU details by various search criteria
 * and validates the search input. If search inputs are valid then the search
 * retrieves the results and if it fails then the error message is displayed.
 * 
 * @author MXN8002
 *
 */

public class SearchSkuByMerchLocOptions extends
PageBase<SearchSkuByMerchLocOptions> {

	private static final By CADENCE_CLEARANCE_TAB = By
			.linkText("Clearance Cadence Change");
	private static final By SMR_ID = By.id("txtSmrCadenceInput");
	private static final By SEARCH_BUTTON = By.id("searchCadenceChange");

	private static final By LOADING_IMG_DIV = By.id("cboxOverlay");

	private static final By MERCH_HIERARCHY_SUB_DEPT_SELECT_BOX = By
			.id("selectMerchHierDeptForCadenceChange");
	private static final By MERCH_HIERARCHY_CLASS_SELECT_BOX = By
			.id("selectMerchHierClassForCadenceChange");
	private static final By MERCH_HIERARCHY_SUB_CLASS_SELECT_DROPDOWN = By
			.xpath("//*[@id='merchHierSearchDiv']/div[3]/div[2]/button");
	private static final By MERCH_HIERARCHY_SUB_SUBCLASS_SELECT_DROPDOWN = By
			.xpath("//*[@id='merchHierSearchDiv']/div[4]/div[2]/button");
	private static final By MERCH_HIERARCHY_BYO_SELECT_DROPDOWN = By
			.xpath("//*[@id='locHierSearchDiv']/div[1]/div[2]/button");
	private static final By MERCH_HIERARCHY_MARKET_SELECT_DROPDOWN = By
			.xpath("//*[@id='locHierSearchDiv']/div[2]/div[2]/button");

	private static final By MERCH_HIERARCHY_SKU_TEXT = By
			.id("textAreaSKUListForCadenceChange");

	private static final By LOC_HIERARCHY_STORE_TEXT = By
			.id("textAreaStoreListForCadenceChange");
	private static final By ALERT_OK_BUTTON = By
			.xpath("//button[@type='button']/span[.='Ok']");

	private static final String SELECT_ALL = "selectAll";
	private static final By SELECT_ALL_CHECK = By.name(SELECT_ALL);

	private static final By SELECT_ALL_BYO = By
			.xpath("//*[@id='locHierSearchDiv']/div[1]/div[2]/div/ul/li[1]/label");

	private static Logger logger = Logger
			.getLogger(SearchSkuByMerchLocOptions.class);

	public SearchSkuByMerchLocOptions(InstanceContainer ic) {
		super(ic);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method is used to load the clear cadence screen by clicking on the
	 * tab.
	 */

	public void loadClearCadenceScreen() throws Exception {
		logger.info("SearchSkuByMerchLocOptions::loadClearCadenceScreen() starts-->");
		try {

			// Maximizing the window after login
			wh.driver.manage().window().maximize();
			wh.waitUntilDisappear(LOADING_IMG_DIV);
			Thread.sleep(1500);

			// Waiting for the cadence clearance tab to be loaded
			wh.waitForElementPresent(CADENCE_CLEARANCE_TAB);

			// Clicking the cadence clearance tab
			wh.clickElement(CADENCE_CLEARANCE_TAB);

			wh.waitUntilDisappear(LOADING_IMG_DIV);
			wh.waitForElementPresent(SMR_ID);
			// Clearing the SMR ID field
			wh.clearElement(SMR_ID);

			wh.waitUntilDisappear(LOADING_IMG_DIV);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("SearchSkuByMerchLocOptions::loadClearCadenceScreen() ends-->");
	}

	/**
	 * This method is used to search the SKU details based on the search
	 * criteria. ie Merch Hierarchy options or Location Hierarchy options or
	 * both
	 */

	public boolean searchForSKUStore(boolean merchOptions, boolean locOptions) {
		logger.info("SearchSkuByMerchLocOptions::searchForSKUStore() starts-->");
		boolean searchCritFlag = false;

		if (merchOptions) {
			// search by merch hierarchy options
			searchCritFlag = searchSKUByMerchHierOptions();
		}
		if (locOptions) {
			// search by location hierarchy options
			searchCritFlag = searchSKUByLocHierOptions();
		}
		logger.info("SearchSkuByMerchLocOptions::searchForSKUStore() ends-->");
		return searchCritFlag;
	}

	/**
	 * This method is used to search the SKU details based on the search
	 * criteria. ie entering the text fields of SMR id, SKU and Store
	 */

	public void searchBySmrSkuStoreField(String searchInput, By filedName)
			throws Exception {
		logger.info("SearchSkuByMerchLocOptions::searchBySmrSkuStoreField() starts-->");
		try {
			searchInput = searchInput.substring(0, searchInput.indexOf("."));

			// Clearing the SMR ID / SKU / Store field
			wh.clearElement(filedName);

			// Keying the SMR ID / SKU / store value
			wh.sendKeys(filedName, searchInput);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("SearchSkuByMerchLocOptions::searchBySmrSkuStoreField() ends-->");

	}

	/**
	 * This method is used to process the given search criteria by clicking on
	 * the search button.
	 */
	public void processSearchCriteriaForCoCadence() {
		logger.info("SearchSkuByMerchLocOptions::processSearchCriteriaForCoCadence() starts-->");
		try {

			wh.waitUntilDisappear(LOADING_IMG_DIV);
			Thread.sleep(500);
			// Perform the search
			wh.clickElement(SEARCH_BUTTON);

			wh.waitUntilDisappear(LOADING_IMG_DIV);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("SearchSkuByMerchLocOptions::processSearchCriteriaForCoCadence() ends-->");
	}

	/**
	 * This method is used to click on the Ok button when the error message is
	 * displayed for invalid search inputs.
	 */

	public void searchCriteriaErrMsgAccept() {
		logger.info("SearchSkuByMerchLocOptions::searchCriteriaErrMsgAccept() starts-->");
		try {

			// Search failed for invalid search criteria
			wh.clickElement(ALERT_OK_BUTTON);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("SearchSkuByMerchLocOptions::searchCriteriaErrMsgAccept() ends-->");
	}

	/**
	 * This method is used to search the SKU based on Merch hierarchy search
	 * options and validates the search inputs. If inputs are valid then true is
	 * returned otherwise false is returned.
	 */

	public boolean searchSKUByMerchHierOptions() {
		logger.info("SearchSkuByMerchLocOptions::searchSKUByMerchHierOptions() starts-->");
		boolean searchMerchOptFlag = false;
		try {
			String smrIdValue = dataTable.getData(DataColumn.SMRID);
			String subDept = dataTable.getData(DataColumn.SUB_DEPARTMENT);
			String dept = dataTable.getData(DataColumn.DEPT);
			String subClass = dataTable.getData(DataColumn.SUB_CLASS);
			String subSubClass = dataTable.getData(DataColumn.SUB_SUB_CLASS);

			String skuNumberSrchInput = dataTable.getData(DataColumn.SKU_TEXT);

			if (!skuNumberSrchInput.isEmpty()) {

				// Keying the SMR ID value
				searchBySmrSkuStoreField(skuNumberSrchInput,
						MERCH_HIERARCHY_SKU_TEXT);
			}

			if (!smrIdValue.isEmpty()) {

				// Keying the SKU number value
				searchBySmrSkuStoreField(smrIdValue, SMR_ID);

			}

			// If both sub dept and dept input options are empty
			if (subDept.isEmpty() && dept.isEmpty()) {

				searchMerchOptFlag = true;

			} else {

				if (!subDept.isEmpty() || !dept.isEmpty()) {
					// Validates sub dept and class options
					searchMerchOptFlag = validateSearchBySubDeptOptions(
							subDept, dept);

					if (searchMerchOptFlag) {
						// Validates sub class and sub sub class options
						searchMerchOptFlag = validateSearchBySubClassOptions(
								subClass, subSubClass);
					}
				}
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		logger.info("SearchSkuByMerchLocOptions::searchSKUByMerchHierOptions() ends-->");
		return searchMerchOptFlag;

	}

	/**
	 * This method is used to validate the sub dept and class options and
	 * selects the options in the corresponding select boxes. If inputs are
	 * valid then true is returned otherwise false is returned.
	 */

	public boolean validateSearchBySubDeptOptions(String subDeptOption,
			String deptOption) {
		logger.info("SearchSkuByMerchLocOptions::validateSearchBySubDeptOptions() starts-->");
		boolean searchSubDeptFlag = false;
		if (!subDeptOption.isEmpty() && !deptOption.isEmpty()) {

			searchSKUBySubDeptClassOptions(MERCH_HIERARCHY_SUB_DEPT_SELECT_BOX,
					subDeptOption);
			searchSKUBySubDeptClassOptions(MERCH_HIERARCHY_CLASS_SELECT_BOX,
					deptOption);
			searchSubDeptFlag = true;

		} else if (!subDeptOption.isEmpty() && deptOption.isEmpty()) {
			// If dept option is empty but sub dept is non empty results in
			// invalid search
			searchSubDeptFlag = false;
		}
		logger.info("SearchSkuByMerchLocOptions::validateSearchBySubDeptOptions() ends-->");
		return searchSubDeptFlag;
	}

	/**
	 * This method is used to validate the subclass and subsubclass options and
	 * selects the options in the corresponding select boxes. If inputs are
	 * valid then true is returned otherwise false is returned.
	 */

	public boolean validateSearchBySubClassOptions(String subClassOption,
			String subSubClassOption) {
		logger.info("SearchSkuByMerchLocOptions::validateSearchBySubClassOptions() starts-->");
		boolean searchSubClassFlag = false;
		try {

			if (subClassOption.isEmpty() && !subSubClassOption.isEmpty()) {
				// If sub class is empty but sub sub class is non empty results
				// in
				// invalid search
				searchSubClassFlag = false;
			} else if (!subClassOption.isEmpty()
					|| !subSubClassOption.isEmpty()) {

				searchSKUBySelectCheckOptions(
						MERCH_HIERARCHY_SUB_CLASS_SELECT_DROPDOWN,
						subClassOption);
				if (!subSubClassOption.isEmpty()) {
					searchSKUBySelectCheckOptions(
							MERCH_HIERARCHY_SUB_SUBCLASS_SELECT_DROPDOWN,
							subSubClassOption);
				}
				searchSubClassFlag = true;

			} else if (subClassOption.isEmpty()) {

				// Unchecking default All Selected when there is no subclass
				// option
				wh.clickElement(MERCH_HIERARCHY_SUB_CLASS_SELECT_DROPDOWN);
				Thread.sleep(1000);

				selectDeselctCheckOptions(SELECT_ALL_CHECK, false, false);
				searchSubClassFlag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("SearchSkuByMerchLocOptions::validateSearchBySubClassOptions() ends-->");
		return searchSubClassFlag;
	}

	/**
	 * This method is used to click the select drop down and the options gets
	 * rolled down. And the corresponding input option is selected.
	 * 
	 */

	public void searchSKUBySelectCheckOptions(By selectDroprDownID,
			String selectCheckBoxOption) {
		logger.info("SearchSkuByMerchLocOptions::searchSKUBySelectCheckOptions() starts-->");
		try {

			wh.clickElement(selectDroprDownID);

			Thread.sleep(1000);
			boolean firstSelectCheckDropDown = false;
			if (MERCH_HIERARCHY_BYO_SELECT_DROPDOWN.equals(selectDroprDownID)) {
				WebElement byoDrowDown = driver
						.findElement(MERCH_HIERARCHY_BYO_SELECT_DROPDOWN);
				firstSelectCheckDropDown = true;
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].scrollIntoView();", byoDrowDown);

			}
			selectCheckOptionFromDropDown(selectCheckBoxOption,
					firstSelectCheckDropDown);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("SearchSkuByMerchLocOptions::searchSKUBySelectCheckOptions() ends-->");
	}

	/**
	 * This method is used to select the search input option in the multi select
	 * options box. If Select All is the input then the select all check box is
	 * clicked.Otherwise the specific search option check box is selected.
	 */

	public void selectCheckOptionFromDropDown(String selectOption,
			boolean firstSelectCheckDropDown) {
		logger.info("SearchSkuByMerchLocOptions::selectCheckOptionFromDropDown() starts-->");
		By targetOptionLocator = null;

		if (SELECT_ALL.equalsIgnoreCase(selectOption)) {
			if (firstSelectCheckDropDown) {
				selectDeselctCheckOptions(SELECT_ALL_BYO, true,
						firstSelectCheckDropDown);
			} else {
				selectDeselctCheckOptions(SELECT_ALL_CHECK, true,
						firstSelectCheckDropDown);
			}
		} else {

			// For any specific search option ,Select All button has to be
			// unchecked and only the corresponding select check box option
			// should be checked.
			targetOptionLocator = By.cssSelector("input[type=checkbox][value='"
					+ selectOption + "']");
			selectDeselctCheckOptions(SELECT_ALL_CHECK, false,
					firstSelectCheckDropDown);
			selectDeselctCheckOptions(targetOptionLocator, true,
					firstSelectCheckDropDown);
		}
		logger.info("SearchSkuByMerchLocOptions::selectCheckOptionFromDropDown() ends-->");
	}

	/**
	 * This method is used to select or deselect the given select option in the
	 * select drop down box based on the input param flag.
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void selectDeselctCheckOptions(By selectOptionLocator,
			boolean checkSelectAllFlag, boolean firstSelectCheckDropDown) {
		logger.info("SearchSkuByMerchLocOptions::selectDeselctCheckOptions() starts-->");
		try {
			Thread.sleep(1000);

			WebElement option = driver.findElement(selectOptionLocator);

			Thread.sleep(1000);

			if (firstSelectCheckDropDown) {

				if (checkSelectAllFlag) {
					wh.clickElement(option);
				}

			} else {
				if (checkSelectAllFlag) {

					if (!(option.isSelected())) {
						option.click();
					}
				} else {
					if (option.isSelected()) {
						option.click();
					}
				}
			}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("SearchSkuByMerchLocOptions::selectDeselctCheckOptions() ends-->");
	}

	/**
	 * This method is used to search for SKU based on Location hierarchy options
	 * and validates the search inputs. If search inputs are valid the true
	 * value is returned otherwise false value is returned.
	 * 
	 */

	public boolean searchSKUByLocHierOptions() {
		logger.info("SearchSkuByMerchLocOptions::searchSKUByLocHierOptions() starts-->");
		boolean searchLocOptFlag = false;
		try {
			String byoInput = dataTable.getData(DataColumn.BYO);
			String marketInput = dataTable.getData(DataColumn.MARKET);
			String storeInput = dataTable.getData(DataColumn.STORE_TEXT);

			if (!storeInput.isEmpty()) {

				searchBySmrSkuStoreField(storeInput, LOC_HIERARCHY_STORE_TEXT);
				searchLocOptFlag = true;
			}

			if (!byoInput.isEmpty() || !marketInput.isEmpty()) {
				// Validates the Location hierarchy options
				searchLocOptFlag = validateSearchSKUByLocHierOptions(byoInput,
						marketInput);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("SearchSkuByMerchLocOptions::searchSKUByLocHierOptions() ends-->");
		return searchLocOptFlag;

	}

	/**
	 * This method is used to validate Location hierarchy options - BYO and
	 * market options If search inputs are valid the true value is returned
	 * otherwise false value is returned.
	 * 
	 */

	public boolean validateSearchSKUByLocHierOptions(String byoInputOption,
			String marketInputOption) {
		logger.info("SearchSkuByMerchLocOptions::validateSearchSKUByLocHierOptions() starts-->");
		boolean searchLocHierFlag = false;
		try {

			if (byoInputOption.isEmpty() && !marketInputOption.isEmpty()) {
				// If BYO option is empty but the market option is non empty
				// results
				// in invalid search.
				searchLocHierFlag = false;
			} else if (!byoInputOption.isEmpty()
					|| !marketInputOption.isEmpty()) {
				searchSKUBySelectCheckOptions(
						MERCH_HIERARCHY_BYO_SELECT_DROPDOWN, byoInputOption);

				if (!marketInputOption.isEmpty()) {
					searchSKUBySelectCheckOptions(
							MERCH_HIERARCHY_MARKET_SELECT_DROPDOWN,
							marketInputOption);

				} else {
					// Unchecking default All Selected when there is no market
					// option
					wh.clickElement(MERCH_HIERARCHY_MARKET_SELECT_DROPDOWN);
					Thread.sleep(1000);
					selectDeselctCheckOptions(SELECT_ALL_CHECK, false, false);
				}
				searchLocHierFlag = true;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("SearchSkuByMerchLocOptions::validateSearchSKUByLocHierOptions() ends-->");
		return searchLocHierFlag;
	}

	/**
	 * This method is used to select the input option from the select drop down.
	 */

	public void searchSKUBySubDeptClassOptions(By selectBoxId,
			String subDeptOption) {
		logger.info("SearchSkuByMerchLocOptions::searchSKUBySubDeptClassOptions() starts-->");
		try {

			wh.clickElement(selectBoxId);
			wh.selectValue(selectBoxId, subDeptOption);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("SearchSkuByMerchLocOptions::searchSKUBySubDeptClassOptions() ends-->");
	}

}
