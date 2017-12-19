package com.fngame.farm.util;

import com.fngame.farm.configer.Actor;
import com.fngame.farm.manager.ConfigManager;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class XlsReader {
    private static XlsReader instance;

    public static XlsReader getInstance() {
        if (instance == null) instance = new XlsReader();
        return instance;
    }

    private static Logger logger = LoggerFactory.getLogger(XlsReader.class);

    public static void read(Class<T> t, File file) throws IOException {


        Field[] fields = t.getFields();
        ConfigManager.getInstance().getloader(t);
        HSSFWorkbook wb = null;


        wb = new HSSFWorkbook(new FileInputStream(file));

        //Excel工作表
        HSSFSheet sheet = wb.getSheetAt(0);
        //表头那一行
        HSSFRow titleRow = sheet.getRow(0);

        HSSFCell cell = null;
        for (int i = 0; i < titleRow.getLastCellNum(); i++) {
            cell = titleRow.getCell(i);


        }

    }

    public List<T> parseXls(List list, Class<T> t, File file) throws Exception {
        Field[] fields = t.getFields();
        Object obj = null;
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet sheet = wb.getSheetAt(0);
        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            obj = t.newInstance();
            XSSFRow row1 = sheet.getRow(0);
            XSSFRow row = sheet.getRow(i);
            if (row == null) continue;
            for (int j = 0; j < row.getLastCellNum(); j++) {
                XSSFCell cell = row1.getCell(j);
                String key = cell.getStringCellValue();
                Field field = t.getField(key);
                switch (field.getName()) {
                    case "class java.lang.String":
                        String value = cell.getStringCellValue();
                        field.set(obj, value);

                        break;
                    case "class java.lang.Integer":
                        Integer value1 = (int) cell.getNumericCellValue();
                        field.set(obj, value1);
                        break;
                    case "boolean":
                        boolean booleanCellValue = cell.getBooleanCellValue();
                        field.set(obj, booleanCellValue);
                        break;
                    default:
                        break;
                }

            }
            list.add(obj);
        }
        return list;
    }


    public void loaderAll(HashMap<String, ArrayList> map) {
        String path = "src/main/resources/config/%s.xlsx";

        String Classes = "com.fngame.farm.configer.%s";
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            i++;
            System.out.println(i);
            String next = (String) iterator.next();
            ArrayList list = map.get(next);
            File file = new File(String.format(path, next));
            try {
                Class aClass = Class.forName(String.format(Classes, next));
                if (i == 20) {
                    System.out.println("d");
                }
                if (file.exists()) {
                    this.parseXls(list, aClass, file);
                    System.out.println("chegns++++++++++++");
                } else {
                    logger.error("配置表不存在：" + next);
                }
            } catch (ClassNotFoundException e) {
                System.out.println(Actor.class);
                logger.error("反射失败", e);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


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
