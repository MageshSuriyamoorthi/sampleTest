package com.atmecs.helper;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This method is used to read excel files
 * 
 * @author magesh.suriyamoorthi
 *
 */

public class ReadExcelFile {

	public int rowIndex = 0;
	public int columnIndex = -1;
	public FileInputStream fileInputStream;
	public File file;
	public Workbook workBook;
	public Sheet sheet = null;
	public Row row = null;
	public Cell cell = null;
	public String cellValue;
	public String testDataFiles;

	/**
	 * this method is used to get column index
	 * 
	 * @param row
	 * @param columnName
	 * @return
	 */
	public int getColIndex(Row row, String columnName) {
		for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {
			if (row.getCell(colIndex).getStringCellValue().equals(columnName.trim())) {
				columnIndex = colIndex;
				break;
			}
		}
		return columnIndex;
	}

	/**
	 * this method is used to get row index
	 * 
	 * @param testcase
	 * @return
	 */
	public int getRowIndex(String testcase) {
		for (Row row : sheet)
			for (Cell cell : row)
				if (cell.getCellType() == CellType.STRING) {
					if (cell.getRichStringCellValue().getString().trim().equals(testcase)) {
						rowIndex = row.getRowNum();
						break;
					}
					break;
				}
		return rowIndex;
	}

	/**
	 * this constructor is used to get file
	 * 
	 * @param testDataFile
	 */
	public ReadExcelFile(String testDataFile) {
		this.testDataFiles = testDataFile;
		workBook = getFile(testDataFiles);

	}

	public Workbook getFile(String filename) {
		file = new File(filename);
		try {
			fileInputStream = new FileInputStream(file);
			workBook = new XSSFWorkbook(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workBook;
	}

	public Row getInitialRowInaSheet(String sheetName) {
		int index = workBook.getSheetIndex(sheetName);
		sheet = workBook.getSheetAt(index);
		row = sheet.getRow(0);

		return row;
	}

	public String getData(/* String fileName, */ String sheetName, String columnName, String testcase) {
		// workBook = getFile(fileName);

		row = getInitialRowInaSheet(sheetName);

		columnIndex = getColIndex(row, columnName);
		rowIndex = getRowIndex(testcase);

		row = sheet.getRow(rowIndex);
		cell = row.getCell(columnIndex);

		cellValue = cell./*getNumericCellValue();*/getStringCellValue();

		try {
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellValue;
	}

	/*
	 * public static void main(String[] args) { //String filenameOne = "";
	 * ReadExcelFile excelFile = new ReadExcelFile(
	 * "C:\\\\Users\\\\magesh.suriyamoorthi\\\\Desktop\\\\assessmenttestcase.xlsx");
	 * 
	 * double file = excelFile.getData( filenameOne, "Sheet1", "BookingId",
	 * "TC001"); System.out.println(file); }
	 */
}
