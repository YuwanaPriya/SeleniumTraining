package org.Pojo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void lanchBrowser() 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
	}

	public static void windowmaximize()
	{
		driver.manage().window().maximize();

	}

	public static void lanuchurl(String url) 
	{
		driver.get(url);
	}

	public static String pageTitle()
	{
		String title = driver.getTitle();
		return title;
	}

	public static String pageurl() 
	{
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	public static void passText(String txt, WebElement ele)
	{
		ele.sendKeys(txt);
	}

	public static void CloseEntireBrowser()
	{
		driver.quit();
	}

	

	public static void clickBtn(WebElement ele)
	{

		ele.click();

	}

	public static void screenSchot(String ImgName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location+imagename.png");
		FileUtils.copyFile(image,f);

	}

	public static Actions a;

	public static void moveTheCursor(WebElement targetWebElement)
	{
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();
	}

	public static void dragDrop(WebElement dragWebElement, WebElement dropElement) 
	{
		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropElement).perform();

	}

	public static JavascriptExecutor js;

	public static void scrollThePage(WebElement tarWebEle) 
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tarWebEle);
	}

	public static void scroll(WebElement element)
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0],scrollIntoView(false)", element);
	}

	public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException
	{
		File f = new File("excellocation.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mysheet = wb.getSheet("Data");
		Row r = mysheet.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int cellType = c.getCellType();

		String value = "";
		if (cellType == 1) 
		{
			String value2 = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c))
		{
			Date dd = c.getDateCellValue();
			SimpleDateFormat S = new SimpleDateFormat(value);
			String value1 = S.format(dd);
		} else 
		{
			double d = c.getNumericCellValue();
			long l = (long) d;
			String valueOf = String.valueOf(l);

		}

	}

	public static void createNewExcelFile(int rowNum,int cellNum,String newData) throws IOException
	    {
	    	 File f=new File("C:\\Users\\priyanka\\eclipse-workspace\\MavenInstallation\\Excel\\newfile.xlsx");
	    	 Workbook w=new XSSFWorkbook();
	    	 Sheet newsheet=w.createSheet("Data");
	    	 Row newRow=newsheet.createRow(rowNum);
	    	 Cell newcell=newRow.createCell(cellNum);
	    	 newcell.setCellValue(newData);
	    	 FileOutputStream fos=new FileOutputStream(f);
	    	 w.write(fos);
	    	 
	    }

	public static void createCell(int getRow,int crecell,String newData) throws IOException
       {
	 File f=new File("C:\\Users\\priyanka\\eclipse-workspace\\MavenInstallation\\Excel\\newfile.xlsx");
	 FileInputStream fis=new FileInputStream(f);
	 Workbook wb=new XSSFWorkbook(fis);
	 Sheet s=wb.getSheet("Data");
	 Row r=s.getRow(getRow);
	 Cell c=r.createCell(crecell);
	 c.setCellValue(newData);
	 FileOutputStream fos=new FileOutputStream(f);
	 wb.write(fos);
       
       }

public static void createRow(int creRow,int crecell,String newData) throws IOException
{
File f=new File("C:\\Users\\priyanka\\eclipse-workspace\\MavenInstallation\\Excel\\newfile.xlsx");
FileInputStream fis=new FileInputStream(f);
Workbook wb=new XSSFWorkbook(fis);
Sheet s=wb.getSheet("Data");
Row r=s.createRow(creRow);
Cell c=r.createCell(crecell);
c.setCellValue(newData);
FileOutputStream fos=new FileOutputStream(f);
wb.write(fos);

}

public static void updateDataToParticularCell(int getTheRow,int getThecell,String exisitingData,String WriteNewData) throws IOException
{
File f=new File("C:\\Users\\priyanka\\eclipse-workspace\\MavenInstallation\\Excel\\newfile.xlsx");
FileInputStream fis=new FileInputStream(f);
Workbook wb=new XSSFWorkbook(fis);
Sheet s=wb.getSheet("Data");
Row r=s.getRow(getTheRow);
Cell c=r.getCell(getThecell);
String str=c.getStringCellValue();
if (str.equals(exisitingData)) 
{
	c.setCellValue(WriteNewData);
	
	
}
	 FileOutputStream fos=new FileOutputStream(f) ;  
	}



}



