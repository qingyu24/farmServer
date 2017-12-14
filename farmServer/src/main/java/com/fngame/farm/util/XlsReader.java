package com.fngame.farm.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XlsReader {
    public static void read() {
        File file = new File("src/main/java/com/fngame/farm/configer/MahJongConfig.xls");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HSSFWorkbook wb = null;
        try {

            wb = new HSSFWorkbook(new FileInputStream(file));
        } catch (IOException e) {


        }

        //Excel工作表
        HSSFSheet sheet = wb.getSheetAt(0);

        //表头那一行
        HSSFRow titleRow = sheet.getRow(0);
        System.out.println(titleRow.getLastCellNum());
        HSSFCell cell = null;
        for (int i = 0; i < titleRow.getLastCellNum(); i++) {
            cell = titleRow.getCell(i);
            System.out.println("public String " + cell.getStringCellValue() + ";");
        }

    }

    private static String getStringCellValue(HSSFCell cell) {
        String strCell = "";
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                strCell = String.valueOf(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                strCell = "";
                break;
            default:
                strCell = "";
                break;
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        if (cell == null) {
            return "";
        }
        return strCell;
    }


}
