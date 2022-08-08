package com.buffalocart.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {
    public String readSingleData(int i, int j,String sheetName) {
        String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx";
        FileInputStream inputStream=null;
        try {
            inputStream = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb=null;
        try {
            wb = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = wb.getSheet(sheetName);
        Row r = sheet.getRow(i);
        Cell c = r.getCell(j);
        DataFormatter formatter = new DataFormatter();
        String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
        return value;
    }
}