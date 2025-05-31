package com.saucelabs.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utils {
	
	public static String getInputdata(String sheetName, String key){
		String value = null ;
		try (FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/testdata/Input_Data.xlsx");
		         XSSFWorkbook workbook = new XSSFWorkbook(file)) {

		        XSSFSheet sheet = workbook.getSheet(sheetName);
		        for (Row row : sheet) {
		            Cell keyCell = row.getCell(0);
		            if (keyCell != null && keyCell.getCellType() == CellType.STRING
		                    && keyCell.getStringCellValue().equalsIgnoreCase(key)) {
		                Cell valueCell = row.getCell(1);
		                if (valueCell != null) {
		                    value = valueCell.toString();
		                }
		                break;
		            }
		        }
		    } catch (IOException e) {
		        e.printStackTrace(); 
		    }
		    return value;

}}
