/**
 * 
 */
package com.homer.po;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.homer.dao.CommonDataColumn;
import com.homer.dao.DataColumn;
import com.homer.dao.InstanceContainer;

/**
 * This class is used to process the co cadence excel for inserting new cadence
 * value.
 * 
 * @author MXN8002
 *
 */

public class ProcessNewCadenceForSkuStore extends
		PageBase<ProcessNewCadenceForSkuStore> {

	public static Logger logger = Logger
			.getLogger(ProcessNewCadenceForSkuStore.class);

	public static final String CADENCE_EXCEL_FILE_NAME = "CO_Manual_Cadence";
	public static final String DATA_DESIGN_SHEET = "DataDesign";

	public ProcessNewCadenceForSkuStore(InstanceContainer ic) {
		super(ic);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method is used to update the new cadence value in the excel for the
	 * input store and sku number.
	 */

	public void processCoCadenceExcelForNewCadence() {

		logger.info("ProcessNewCadenceForSkuStore::processCoCadenceExcelForNewCadence() starts-->");
		try {

			// Process the excel downloaded by updating the new cadence
			// Fetch the store , sku number and the new cadence from the input
			// excel file
			String storeInput = dataTable.getData(DataColumn.STORE);
			String skuInput = dataTable.getData(DataColumn.SKU);
			String newCadenceVal = dataTable.getData(DataColumn.NEW_CADENCE);

			// Manipulating the inputs to truncate the decimal points.
			String storeNum = storeInput.substring(0, storeInput.indexOf("."));
			String skuNumber = skuInput.substring(0, skuInput.indexOf("."));

			// Get the new cadence part from the new cadence input value.
			// Truncating the value after the '- '
			String newCadLen = newCadenceVal.split("-")[0];
			logger.info("NewCadLength  -->" + newCadLen + "Store number -->"
					+ storeNum + "Sku Number" + skuNumber);
			Thread.sleep(8000);
			insertNewCadenceForStore(storeNum, skuNumber, newCadenceVal);
			
			Thread.sleep(2000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("ProcessNewCadenceForSkuStore::processCoCadenceExcelForNewCadence() ends-->");

	}

	/**
	 * This method is used to update the new cadence value in the excel for the
	 * input store and sku number.
	 */

	public void insertNewCadenceForStore(String storeNum, String skuNumber,
			String newCadenceVal) throws Exception {

		logger.info("ProcessNewCadenceForSkuStore::insertNewCadenceForStore() starts-->");

		// Opening the downloaded file for updating the new cadence value.

		String fileName = getFileName(
				dataTable.getCommonData(CommonDataColumn.ResourcesLocation),
				CADENCE_EXCEL_FILE_NAME);
		logger.info("Exported file name -->" + fileName);
		

		if (!fileName.isEmpty()) {
			
			File inputFile = new File(fileName.trim());

			FileInputStream excelFileToRead = new FileInputStream(inputFile);
			
			XSSFWorkbook manualCadenceBook = new XSSFWorkbook(excelFileToRead);
			
			XSSFSheet dataDesignSheet = manualCadenceBook
					.getSheet(DATA_DESIGN_SHEET);
			
			// Iterating through the rows in the downloaded excel file
			Iterator<Row> rowIterator = dataDesignSheet.iterator();
			
			while (rowIterator.hasNext()) {

				// For each row, iterate through all the columns
				Row row = rowIterator.next();
				Cell skuNumberCell = row.getCell(4);
				Cell storeNumberCell = row.getCell(9);

				String skuNumberInfo = skuNumberCell.getStringCellValue();
				String storeNumberInfo = storeNumberCell.getStringCellValue();

				// Identifying the rows which has the given sku number and store
				if (storeNum.equalsIgnoreCase(storeNumberInfo)
						&& skuNumber.equalsIgnoreCase(skuNumberInfo)) {
					// logger.info("matching row -->" + row.getRowNum());

					// Setting the new cadence value for the matching sku number
					// and
					// store inputs
					
					Cell newCadenceCell = row.createCell(24);
					newCadenceCell.setCellValue(newCadenceVal);
					logger.info("New cadence value inserted as-->"
							+ newCadenceVal);
					
				}

			}
			
			excelFileToRead.close();

			// Writing the excel with the updated information in to the disk.
			FileOutputStream fileOut = new FileOutputStream(inputFile);

			// write this workbook to an Outputstream.
			manualCadenceBook.write(fileOut);
			fileOut.flush();

			// Closing the file output stream
			fileOut.close();

			// closing the excel workbook
			manualCadenceBook.close();
		} else {
			logger.error("Error in processing the input excel for applying new cadence-->");
			
		}
		
		logger.info("ProcessNewCadenceForSkuStore::insertNewCadenceForStore() ends-->");
	}

}
