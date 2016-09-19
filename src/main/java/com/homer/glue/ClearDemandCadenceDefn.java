package com.homer.glue;

import com.homer.dao.DataClass;
import com.homer.dao.Then;
import com.homer.po.ExportCOManualCadence;
import com.homer.po.ImportCOManualCadence;
import com.homer.po.ProcessNewCadenceForSkuStore;
import com.homer.po.SearchSkuByMerchLocOptions;

/**
 * This class is used to define the test scenarios for searching the SKU details
 * by various search criteria and then process the exported excel for updating
 * the new cadence length against the selected SKU , store number
 * combination.Once the updated excel is imported then the database call is
 * triggered for verifying the new cadence gets reflected for the store and SKU.
 * 
 * @author MXN8002
 *
 */

public class ClearDemandCadenceDefn extends BaseStepDefn {

	private SearchSkuByMerchLocOptions searchSKUCriteriaPage;
	private ImportCOManualCadence importCOManualCadence;
	private ExportCOManualCadence exportCOManualCadence;
	private ProcessNewCadenceForSkuStore processNewCadenceForSkuStore;

	public ClearDemandCadenceDefn(DataClass data) {
		super(data);

		searchSKUCriteriaPage = new SearchSkuByMerchLocOptions(ic);
		importCOManualCadence = new ImportCOManualCadence(ic);
		exportCOManualCadence = new ExportCOManualCadence(ic);
		processNewCadenceForSkuStore = new ProcessNewCadenceForSkuStore(ic);
		// TODO Auto-generated constructor stub
	}

	@Then("^search SKU store details by SMR Id and process cadence$")
	public void searchSKUStoreBySMRId() throws Throwable {

		searchSKUForProcessingNewCadence(true, false);

	}

	@Then("^search SKU store details by SKU and process cadence$")
	public void searchSKUStoreBySKU() throws Throwable {

		searchSKUForProcessingNewCadence(true, false);
	}

	@Then("^search SKU store details by Store and process cadence$")
	public void searchSKUStoreByStore() throws Throwable {

		searchSKUForProcessingNewCadence(false, true);

	}

	@Then("^search SKU store details by sub dept and class and process cadence$")
	public void searchSKUStoreBySubDeptAndClass() throws Throwable {

		searchSKUForProcessingNewCadence(true, false);
	}

	@Then("^search SKU store details by sub dept , class and subclass and process cadence$")
	public void searchSKUStoreBySubDeptClassAndSubClass() throws Throwable {

		searchSKUForProcessingNewCadence(true, false);
	}

	@Then("^search SKU store details by sub dept ,class,subclass and sub subclass and process cadence$")
	public void searchSKUStoreBySubDeptClassSubClassAndSubSubClass()
			throws Throwable {

		searchSKUForProcessingNewCadence(true, false);
	}

	@Then("^search SKU store details by sub dept ,class,subclass ,sub subclass and SKU and process cadence$")
	public void searchSKUStoreBySubDeptClassSubClassSubSubClassAndSKU()
			throws Throwable {

		searchSKUForProcessingNewCadence(true, false);
	}

	@Then("^search SKU store details by SMR Id and SKU and process cadence$")
	public void searchSKUStoreBySMRIdAndSKU() throws Throwable {

		searchSKUForProcessingNewCadence(true, false);
	}

	@Then("^search SKU store details by SKU and BYO and process cadence$")
	public void searchSKUStoreBySKUAndBYO() throws Throwable {

		searchSKUForProcessingNewCadence(true, true);
	}

	@Then("^search SKU store details by SKU ,BYO and Store and process cadence$")
	public void searchSKUStoreBySKUBYOAndStore() throws Throwable {

		searchSKUForProcessingNewCadence(true, true);
	}

	@Then("^search SKU store details by SKU ,BYO and market and process cadence$")
	public void searchSKUStoreBySKUBYOAndMarket() throws Throwable {

		searchSKUForProcessingNewCadence(true, true);
	}

	@Then("^search SKU store details by SKU ,BYO , market and Store and process cadence$")
	public void searchSKUStoreBySKUBYOMarketAndStore() throws Throwable {

		searchSKUForProcessingNewCadence(true, true);
	}

	@Then("^search SKU store details by sub dept and class ,BYO , market and process cadence$")
	public void searchSKUStoreBySubDeptClassBYOAndMarket() throws Throwable {

		searchSKUForProcessingNewCadence(true, true);
	}

	@Then("^search SKU store details by sub dept and class ,Sub class ,BYO , market and process cadence$")
	public void searchSKUStoreBySubDeptClassSubClassBYOAndMarket()
			throws Throwable {

		searchSKUForProcessingNewCadence(true, true);
	}

	@Then("^search SKU store details by sub dept and class ,BYO , market and Store and process cadence$")
	public void searchSKUStoreBySubDeptClassBYOMarketAndStore()
			throws Throwable {

		searchSKUForProcessingNewCadence(true, true);
	}

	@Then("^search SKU store details by sub dept,class and store and process cadence$")
	public void searchSKUStoreBySubDeptClassAndStore() throws Throwable {

		searchSKUForProcessingNewCadence(true, true);
	}

	@Then("^search SKU store details by SKU and Store and process cadence$")
	public void searchSKUStoreBySKUAndStore() throws Throwable {

		searchSKUForProcessingNewCadence(true, true);
	}

	/**
	 * This method is used to search the SKU details by various search criteria
	 * and then exports the information in excel.Then the excel is processed for
	 * updating the new cadence length for the selected SKU and store. After
	 * that the updated excel is imported from the specified file location.
	 * 
	 */

	public void searchSKUForProcessingNewCadence(boolean merchOptions,
			boolean locOptions) throws Throwable {
		Thread.sleep(500);
		// Loads the clear cadence tab
		getSearchSKUCriteriaPage().loadClearCadenceScreen();

		// Validates the search inputs for the SKU based on specified search
		// criteria
		boolean searchFlag = getSearchSKUCriteriaPage().searchForSKUStore(
				merchOptions, locOptions);

		// Triggers the search
		getSearchSKUCriteriaPage().processSearchCriteriaForCoCadence();
		
		
		if (searchFlag) {
			// If search is successful , then export the excel
			getExportCOManualCadence().exportSKUDetailsInCoCadenceExcel();
			
			// Process the new cadence length insertion for the selected SKU and
			// store
			getProcessNewCadenceForSkuStore()
					.processCoCadenceExcelForNewCadence();
		
			// Imports the updated excel from the file location
			getImportCOManualCadence().importCoCadenceExcel();
			
		} else {

			// If search is invalid , then the error message is displayed.
			getSearchSKUCriteriaPage().searchCriteriaErrMsgAccept();
		}

	}

	/**
	 * @return the searchSKUCriteriaPage
	 */
	public SearchSkuByMerchLocOptions getSearchSKUCriteriaPage() {
		return searchSKUCriteriaPage;
	}

	/**
	 * @param searchSKUCriteriaPage
	 *            the searchSKUCriteriaPage to set
	 */
	public void setSearchSKUCriteriaPage(
			SearchSkuByMerchLocOptions searchSKUCriteriaPage) {
		this.searchSKUCriteriaPage = searchSKUCriteriaPage;
	}

	/**
	 * @return the importCOManualCadence
	 */
	public ImportCOManualCadence getImportCOManualCadence() {
		return importCOManualCadence;
	}

	/**
	 * @param importCOManualCadence
	 *            the importCOManualCadence to set
	 */
	public void setImportCOManualCadence(
			ImportCOManualCadence importCOManualCadence) {
		this.importCOManualCadence = importCOManualCadence;
	}

	/**
	 * @return the exportCOManualCadence
	 */
	public ExportCOManualCadence getExportCOManualCadence() {
		return exportCOManualCadence;
	}

	/**
	 * @param exportCOManualCadence
	 *            the exportCOManualCadence to set
	 */
	public void setExportCOManualCadence(
			ExportCOManualCadence exportCOManualCadence) {
		this.exportCOManualCadence = exportCOManualCadence;
	}

	/**
	 * @return the processNewCadenceForSkuStore
	 */
	public ProcessNewCadenceForSkuStore getProcessNewCadenceForSkuStore() {
		return processNewCadenceForSkuStore;
	}

	/**
	 * @param processNewCadenceForSkuStore
	 *            the processNewCadenceForSkuStore to set
	 */
	public void setProcessNewCadenceForSkuStore(
			ProcessNewCadenceForSkuStore processNewCadenceForSkuStore) {
		this.processNewCadenceForSkuStore = processNewCadenceForSkuStore;
	}

}
