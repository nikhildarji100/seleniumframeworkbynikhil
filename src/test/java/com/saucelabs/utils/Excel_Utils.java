package com.saucelabs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utils {

    public static String getInputdata(String sheetName, String key) {
        String value = null;
        String path = System.getProperty("user.dir") + "/testdata/Input_Data.xlsx";

        try (FileInputStream file = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            DataFormatter formatter = new DataFormatter(); // <<< KEY LINE

            for (Row row : sheet) {
                Cell keyCell = row.getCell(0);
                if (keyCell == null) continue;

                String keyText = formatter.formatCellValue(keyCell).trim(); // <<< KEY LINE

                if (keyText.equalsIgnoreCase(key.trim())) {
                    Cell valueCell = row.getCell(1);
                    value = (valueCell != null) ? formatter.formatCellValue(valueCell).trim() : null;
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
