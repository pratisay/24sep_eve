package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.InvalidElementStateException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	 public static WebDriver driver ;
		public static void captureScreenshot (WebDriver driver , String methodName) throws IOException
		{   
		   
			TakesScreenshot t = (TakesScreenshot) driver ;
			
			DateTimeFormatter DTF = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
			LocalDateTime DT = LocalDateTime.now();
			
			File source = t.getScreenshotAs(OutputType.FILE);
			File destination = new File ("C:\\Users\\rsc\\Pictures\\pratik\\Test " + methodName + DTF.format (DT) + ".jpg");
			FileHandler.copy(source, destination);
		
			
	    }
		 
		
		public static String fetchDataFromExcel (String sheetName , int row , int cell) throws EncryptedDocumentException, IOException
		{
			String path = "C:\\Users\\rsc\\OneDrive\\Test.xlsx";
			
			InputStream file = new FileInputStream (path);
			
			Sheet sheet = WorkbookFactory.create (file).getSheet(sheetName);
			
			String s ;
			
			try 
			{
				s = sheet.getRow(row).getCell(cell).getStringCellValue ();
			}
			catch (IllegalStateException e)
			{
				double data = sheet.getRow(row).getCell(cell).getNumericCellValue();
			    long data_n = (long) data ;
			    s = Long.toString(data_n);
		    }
        return s ;
		}
	
}