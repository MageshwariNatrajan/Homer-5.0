/**
 * 
 */
package com.homer.po;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.homer.dao.InstanceContainer;

/**
 * This class is used to export search results of sku details in the co cadence
 * excel sheet.
 * 
 * @author MXN8002
 *
 */
public class ExportCOManualCadence extends PageBase<ExportCOManualCadence> {

	private static final By EXPORT_BUTTON = By
			.id("excelUploadForCadenceChange");
	private static final By LOADING_IMG_DIV = By.id("cboxOverlay");
	
	public static Logger logger = Logger.getLogger(ExportCOManualCadence.class);

	public ExportCOManualCadence(InstanceContainer ic) {
		super(ic);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method is used to export search results of sku details in the co
	 * cadence excel sheet by clicking on Export button.
	 *
	 */
	public void exportSKUDetailsInCoCadenceExcel() {

		logger.info("ExportCOManualCadence::exportSKUDetailsInCoCadenceExcel() starts-->");
		// Export the excel file from the search SKU results
		try {
			
			wh.waitUntilDisappear(LOADING_IMG_DIV);
			Thread.sleep(500);
			// Clicking the export button.
			wh.clickElement(EXPORT_BUTTON);
			Thread.sleep(40000);
		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("ExportCOManualCadence::exportSKUDetailsInCoCadenceExcel() ends-->");
	}

}
