package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static String getCellData(String filePath, String sheetName, int rowNumber, int cellNumber) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in the file.");
            }

            Row row = sheet.getRow(rowNumber);
            if (row == null) {
                throw new IllegalArgumentException("Row " + rowNumber + " does not exist in the sheet.");
            }

            Cell cell = row.getCell(cellNumber);
            if (cell == null) {
                throw new IllegalArgumentException("Cell is empty at row " + rowNumber + ", column " + cellNumber);
            }

            return cell.getStringCellValue();

        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file: " + e.getMessage(), e);
        }
    }
}