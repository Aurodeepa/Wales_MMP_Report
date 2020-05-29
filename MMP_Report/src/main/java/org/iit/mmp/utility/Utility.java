package org.iit.mmp.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Utility {

	public static String getFutureDate(int days,String pattern)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);

		Date d = cal.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(d);
		return date;
	}
	public static String getFutureDate(int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);

		Date d = cal.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		String date = sdf.format(d);
		return date;
	}

	public String[][] readXls(String filepath) throws IOException
	{
		String[][] str = new String[10][10];

		HSSFRow row;
		//FileInputStream fis = new FileInputStream(new File("C:\\Users\\vikib\\Desktop\\Selenium\\MyDataSheet.xls"));
		FileInputStream fis = new FileInputStream(new File(filepath));

		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet spreadsheet = workbook.getSheetAt(0);
		/* Getting number of rows and columns*/
		int rowCount = spreadsheet.getPhysicalNumberOfRows();
		Iterator<Row> rowIterator = spreadsheet.iterator();
		System.out.println("Rows ->" + rowCount);
		row = (HSSFRow) rowIterator.next();
		int colCount = row.getPhysicalNumberOfCells();
		System.out.println("Col-->" + colCount);


		str = new String[rowCount][colCount];
		for(int i=0;i<rowCount;i++)
		{
			row = spreadsheet.getRow(i);
			for(int j=0;j< colCount;j++)
			{
				String cellText = row.getCell(j).toString();
				System.out.print(cellText + "\t\t" ); //[0][0],[0][1]/[1][0],[1][1]/[2][0],[2][1]
				str[i][j] = cellText;
			}

			System.out.println();

		}

		fis.close();

		return str;
	}

	public String[][] readXlsx(String filePath) throws IOException
	{
		String[][] str = new String[10][10];

		XSSFRow row;
		FileInputStream fis = new FileInputStream(new File(filePath));

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet   spreadsheet = workbook.getSheetAt(0);
		/* getting Rows and columns */
		int rowCount = spreadsheet.getPhysicalNumberOfRows();
		Iterator<Row> rowIterator = spreadsheet.iterator();
		System.out.println("Rows ->" + rowCount);
		row = (XSSFRow) rowIterator.next();
		int colCount = row.getPhysicalNumberOfCells();
		System.out.println("Columns ->" + colCount);

		str = new String[rowCount][colCount];
		for(int i=0;i<rowCount;i++)
		{
			row = spreadsheet.getRow(i);
			for(int j=0;j< colCount;j++)
			{
				String cellText = row.getCell(j).toString();
				System.out.print(cellText + "\t\t" ); 
				str[i][j] = cellText;
			}

			System.out.println();

		}

		fis.close();

		return str;
	}

	public static String generateRandom(int n,int range)
	{
		String str = "";
		for(int j = 0 ; j < n;j++)
		{
			str = str+ 9;	 
		}

		return (Integer.parseInt(str) + new Random().nextInt(range)+"");
	}
}