package com.demoqa.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ReadExcelFile {
    public FileInputStream fi=null;
    public HSSFWorkbook wb =null;
    public HSSFSheet sheet =null;
    public HSSFRow row=null;
    public HSSFCell cell=null;

    public  ArrayList<ArrayList<String>> readData() {
        ArrayList<ArrayList<String>> al=new ArrayList<ArrayList<String>>();
        try {
            String filePath = "C:\\Users\\USER\\IdeaProjects\\SeleniumAutomation\\src\\main\\resources\\InputData.xls";
            fi = new FileInputStream(filePath);
            HSSFWorkbook wb=new HSSFWorkbook(fi);
            HSSFSheet sheet= wb.getSheet("InputData");
            int rows=sheet.getPhysicalNumberOfRows();
            System.out.println(rows);
            al.clear();
            for(int i=1;i<rows;i++){
                ArrayList<String> li=new ArrayList<String>();
               row=sheet.getRow(i);
               int cells=row.getPhysicalNumberOfCells();
              // System.out.println("number of cells in row "+i+" "+cells);
               for(int j=0;j<row.getPhysicalNumberOfCells();j++){
                 cell=row.getCell(j);
                 li.add(cell.getStringCellValue());
               }
               al.add(li);
              // li.clear();

            }
        }
        catch(IOException e){
           e.printStackTrace();
        }
        finally{
            try{
                fi.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
       return al;
    }
}
