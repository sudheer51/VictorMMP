package org.iit.healthcare;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Utility {
//	Excel-File
//	XSSFWorkbook
//		XSSFSheet - 0,1,2
//			rows	
//			cols
//			XSSFCell  -(0,0)-> get the contents       
	public static String[][] readXls(String filePath) throws BiffException, IOException{

		File srcFile = new File(filePath);
		Workbook wb = Workbook.getWorkbook(srcFile);
		Sheet sheet = wb.getSheet(0);
		int row = sheet.getRows();
		int col = sheet.getColumns();
		
		String[][] str = new String[row][col];
		
		for (int i=0; i<row; i++){
			for (int j=0;j<col; j++){
				
				Cell cell = sheet.getCell(j, i);
				str[i][j] = cell.getContents().toString();
			}
		}
		
		return str;		
	}
	
	public static String[][] readXlsx(String filePath) throws IOException{
		
		File srcFile = new File(filePath);
		FileInputStream fis = new FileInputStream(srcFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int row = sheet.getLastRowNum()+1;
		int col = 2;
		String[][] str = new String[row][col];
		for (int i=0; i<row; i++){
			str[i][0] = sheet.getRow(i).getCell(0).toString();
			str[i][1] = sheet.getRow(i).getCell(1).toString();
		}
		wb.close();
		return str;		
		
	}
	public static String getFutureDate(int days,String pattern)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(d);
		return date;
	}
	public  static String getFutureDate(int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM/d/YYYY");
		String date = sdf.format(d);
		return date;
	}
	public static int getRandomNumber(int limit)
	{
		Random r1 = new Random();
		int i = r1.nextInt(limit);
		System.out.println(i);
		return i;
		
	}
	public static char getRandomChar()
	{
		 
		Random r1 = new Random();
		int k = 65 + r1.nextInt(26);
		char c2= (char) k;
		System.out.println("Random Upper Case Character::" + c2);		
		return c2;

	}
	public static String getRandomString(int limit)
	{
		String ranAlpha = RandomStringUtils.randomAlphabetic(limit);
		return ranAlpha;
		  
	}
	
	
	/*
	 * Added getRandomZip to generate a random valid 5 digit zip 
	 */
	public static int getRandomZip() {

		Random r = new Random();
		int zip = r.nextInt(100);

		if (zip == 0) 
		{
			zip = zip + 1;
		}

		if (zip < 10)
		{
			zip = zip * 10000;
		}
		else
		{
			zip = zip * 1000;
		}
		return zip;
	}	
	
	/*
	 * Added getRandomInvalidZip() to Generate a random invalid (short or long) zip
	 */ 
	public static int getRandomInvalidZip(String size)
	{
		Random r = new Random();
		int zip = 0;
		
		if(size.contains("short"))
		{
			zip = r.nextInt(10);
			if(zip == 0)
			{
				 zip = zip + 1;
			}
			zip = zip * 100;
		}
		
		if(size.contains("long"))
		{
			zip = r.nextInt(100);
			if(zip == 0)
			{
				 zip = zip + 1;
			}
			zip =  zip * 100000;
		}
		return zip;
	}	
	
}
