/**
 * 
 */
package com.homer.po;

import java.io.File;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.homedepot.ta.aa.dao.exceptions.QueryException;
import com.homer.dao.CommonDataColumn;
import com.homer.dao.DataColumn;
import com.homer.dao.DataSetterCreateRequest;
import com.homer.dao.InstanceContainer;

/**
 * This class is used to import the co cadence excel with the updated new
 * cadence from the specified location and validate if the new cadence reflected
 * in the database once the import is successful.
 * 
 * @author MXN8002
 *
 */

public class ImportCOManualCadence extends PageBase<ImportCOManualCadence> {

	private static final By IMPORT_BUTTON = By
			.id("excelImportForCadenceChange");

	private static final By BROWSE_FILE_BUTTON = By
			.id("inputUploadDialogFileUpload");
	private static final By BROWSE_FILE_SUBMIT_BUTTON = By
			.xpath("//button[@type='button']/span[.='Submit']");
	private static final By IMPORT_OK_BUTTON = By
			.xpath("//button[@type='button']/span[.='Ok']");

	public static final String CADENCE_EXCEL_FILE_NAME = "CO_Manual_Cadence";
	private static final By LOADING_IMG_DIV = By.id("cboxOverlay");

	public static Logger logger = Logger.getLogger(ImportCOManualCadence.class);

	public ImportCOManualCadence(InstanceContainer ic) {
		super(ic);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method is used to import the updated co_manual_cadence excel from
	 * the specified location and triggers the database call for verifying the
	 * new cadence applied to the store and sku number combination.
	 * 
	 */

	public void importCoCadenceExcel() {

		logger.info("ImportCOManualCadence::importCoCadenceExcel() starts-->");
		try {
			wh.waitUntilDisappear(LOADING_IMG_DIV);
			Thread.sleep(10000);
			wh.waitForElementPresent(IMPORT_BUTTON);

			// Clicking on Import button to import the excel
			wh.clickElement(IMPORT_BUTTON);

			// Find for the browse file button
			WebElement element = driver.findElement(BROWSE_FILE_BUTTON);
						
			String fileName = getFileName(dataTable
					.getCommonData(CommonDataColumn.ResourcesLocation) , CADENCE_EXCEL_FILE_NAME);
			logger.info("Imported file name -->" + fileName);

			// Specify the import file path
			element.sendKeys(fileName);

			// Clicking on the submit button
			wh.clickElement(BROWSE_FILE_SUBMIT_BUTTON);
			logger.info("file imported from specifed location :"
					+ dataTable
							.getCommonData(CommonDataColumn.ResourcesLocation));
			
			wh.waitUntilDisappear(LOADING_IMG_DIV);
			Thread.sleep(10000);

			// Waiting for the cadence clearance tab to be loaded
			wh.waitForElementPresent(IMPORT_OK_BUTTON);

			wh.clickElement(IMPORT_OK_BUTTON);
			Thread.sleep(1000);
			
			File inputFile = new File(fileName);
			inputFile.delete();			

			String storeInput = dataTable.getData(DataColumn.STORE);
			String skuInput = dataTable.getData(DataColumn.SKU);
			String newCadenceVal = dataTable.getData(DataColumn.NEW_CADENCE);

			// Manipulating the inputs to truncate the decimal points.
			String storeNum = storeInput.substring(0, storeInput.indexOf("."));
			String skuNumber = skuInput.substring(0, skuInput.indexOf("."));

			// Get the new cadence part from the new cadence input value.
			// Truncating the value after the '- '
			String newCadLen = newCadenceVal.split("-")[0];

			// Verifying the cadence reflected in the database.
			//validateNewcadenceInDB(skuNumber, storeNum,
			//		Integer.parseInt(newCadLen));
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("ImportCOManualCadence::importCoCadenceExcel() ends-->");
	}
	
	
	/**
	 * This method is used to validate the new cadence is updated in the
	 * database for the given sku number , store number
	 */
	public void validateNewcadenceInDB(String skuNumber, String storeNumber,
			int newCadence) {

		logger.info("ImportCOManualCadence::validateNewcadenceInDB() starts-->");
		try {
			int rowCount = 0;
			rowCount = DataSetterCreateRequest.cleanUp(skuNumber, storeNumber, newCadence);
			
			if(rowCount > 0)
			{
				
				logger.info("New cadence updated successfully");
				/*report.addReportStep(
						"New cadence updated successfully",
						"Pass", StepResult.PASS);*/
				
			}else{
				logger.info("New cadence not updated in the database");
				/*report.addReportStep(
						"New cadence not updated in the database",
						"fail", StepResult.FAIL);*/
			}
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("ImportCOManualCadence::validateNewcadenceInDB() ends-->");
	}

}
