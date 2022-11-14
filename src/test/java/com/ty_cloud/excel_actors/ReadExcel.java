package com.ty_cloud.excel_actors;

import com.ty_cloud.utilities.ConfigReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.*;

public class ReadExcel {

    public ReadExcel(String sheetName) {
        this.sheetName = sheetName;
        setSheet();
    }

    public String sheetName;

    String xlsxPath = ConfigReader.getProperty("excelPath");

    XSSFSheet sheet;

    public void setSheet() {
        try {
            FileInputStream file = new FileInputStream(xlsxPath);
            XSSFWorkbook wb = new XSSFWorkbook(file);
            sheet = wb.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Map<Integer, List<String>>> getAllRows() {
        List<Map<Integer, List<String>>> data = new ArrayList<>();

        Iterator<Row> rows = sheet.iterator();
        Map<Integer, List<String>> duMap = new HashMap<>();
        while (rows.hasNext()) {

            List<String> duList = new ArrayList<>();

            Iterator<Cell> cells = rows.next().iterator();

            while (cells.hasNext()) {
                duList.add(cells.next().toString());
            }
            duMap.put(data.size() + 1, duList);
        }
        return data;
    }


    public Map<String, String> getSingleRow(Integer rowNum) {


        List<String> headers = new ArrayList<>();

        for (Cell cell : sheet.getRow(0)) {
            headers.add(cell.toString());
        }


        Map<String, String> data1 = new HashMap<>();

        for (int i = 0; i < headers.size(); i++) {
            data1.put(headers.get(i), sheet.getRow(rowNum).getCell(i).toString());
        }

        return data1;


    }

}
