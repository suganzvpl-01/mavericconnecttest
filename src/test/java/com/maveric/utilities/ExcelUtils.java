package com.maveric.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.record.chart.DataFormatRecord;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static XSSFSheet getSheetLevel(String fileNamewithPath, String sheetName) throws IOException
	{
		FileInputStream fileIn= new FileInputStream(fileNamewithPath);
		XSSFWorkbook book=new XSSFWorkbook(fileIn);
		XSSFSheet sheet=book.getSheet(sheetName);
		return sheet;	
	}
	public static XSSFRow getRowLevel(String fileNamewithPath,String sheetName,int rowNumber) throws IOException
	{
		XSSFSheet sheet=ExcelUtils.getSheetLevel(fileNamewithPath, sheetName);
					
		int rowsCount=sheet.getPhysicalNumberOfRows();
		System.out.println(rowsCount);
		XSSFRow row=sheet.getRow(rowNumber);
		return row;		
	}
	public static String getCellvalueAsString(String fileNamewithPath,String sheetName,int rowNumber, int cellNo ) throws IOException
	{
		XSSFRow row=ExcelUtils.getRowLevel(fileNamewithPath, sheetName,rowNumber );
		XSSFCell cell = row.getCell(cellNo);
		DataFormatter format= new DataFormatter();
		String value = format.formatCellValue(cell);
		return value;		
	}
	public static Object[][] getSheetAsObjectForDataProvider(String fileNamewithPath,String sheetName) throws IOException{
		XSSFSheet sheet=ExcelUtils.getSheetLevel(fileNamewithPath, sheetName);
		int rowCount=sheet.getPhysicalNumberOfRows();
		XSSFRow row =sheet.getRow(0);
		int cellCount=row.getPhysicalNumberOfCells();
		
		Object[][] temp=new Object[rowCount-1][cellCount];
		
		
		for (int i = 1;i<rowCount;i++)
		{
			for(int j=0;j<sheet.getRow(0).getPhysicalNumberOfCells();j++) {
				//System.out.println(i+" "+j);
				XSSFCell cell = sheet.getRow(i).getCell(j);
				DataFormatter format=new DataFormatter();
				String value = format.formatCellValue(cell);
				//System.out.println(value);
				temp[i-1][j]=value;				
			}
			
		}
		return temp;
	}
	
//getcolumnaslist

}
