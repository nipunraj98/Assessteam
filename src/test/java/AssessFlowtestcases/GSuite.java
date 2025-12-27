package AssessFlowtestcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.Addperson;
import pageObjects.login;
import resources.base;

public class GSuite extends base{
	
	  File src=new File("C:\\Users\\pulse.tester\\Documents\\AssessTeam\\TestData.xlsx");
	  
		
		static XSSFWorkbook workbook;
	    static XSSFSheet sheet;
	    XSSFCell cell;
	    public static DataFormatter formatter= new DataFormatter();
	    int loop=1;
		
		 @Test(priority=0)
			
			public void a_HomepageNavigation() throws IOException
				{
					
					
					driver=InitializeBrowser();
					Reporter.log("The browser is being opened");
					System.out.println("browser");
					driver.get(prop.getProperty("url"));
					Reporter.log(prop.getProperty("url"));
					Reporter.log("Url is being hit");
					driver.manage().window().maximize();
					//driver.manage().deleteAllCookies();
					Reporter.log("HomePage Navigation done");
				
					//getScreenShot("Homepage");
					
				}
		@Test(priority=1)
			
			public void b_LoginAssess() throws IOException, InterruptedException
				{
			 FileInputStream fisexcel= new FileInputStream(src);
		 		workbook= new XSSFWorkbook(fisexcel);
		 		sheet=workbook.getSheet("ADDPersonManually");
		 		String email=sheet.getRow(1).getCell(0).getStringCellValue();
		 		String password=sheet.getRow(1).getCell(1).getStringCellValue();
			 		login l=new login(driver);
			 		l.getUserName().sendKeys(email);
			 		Reporter.log("username entered");
			 		l.getPassword().sendKeys(password);
			 		Reporter.log("password entered");
			 		
			 		l.ClickLogin().click();
			 		
			 		Thread.sleep(2000);
			 		//getScreenShot("AfterLoginPage");
			 		
			 		
				}
		 @Test(priority=2)
			
			public void c_GSuiteIntegration() throws IOException, InterruptedException
				{
			 FileInputStream fisexcel= new FileInputStream(src);
		 		workbook= new XSSFWorkbook(fisexcel);
		 		sheet=workbook.getSheet("GSuite");
		 		String email=sheet.getRow(1).getCell(0).getStringCellValue();
		 		String password=sheet.getRow(1).getCell(1).getStringCellValue();
		 		driver.findElement(By.xpath("//*[@id=\"M9\"]")).click();
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"liIntegration\"]/a")).click();
			 	Thread.sleep(2000);
			 	Reporter.log("Integration is being clicked");
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"divSearch\"]/div[4]/div[3]/div/a")).click();
			 	Reporter.log("Gsuite is being clicked");
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"ancGSuiteConnect\"]")).click();
			 	Thread.sleep(2000);
			 	Thread.sleep(2000);
			 	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			 	driver.switchTo().window(tabs.get(1));//switched to gmail 
			 	Thread.sleep(2000);
			 	Reporter.log("Gmail is being opened");
			 	driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).click();
			 	driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(email);
			 	Thread.sleep(2000);
			 	Reporter.log("email has been entered for gmail");
			 	driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).click();
			 	driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(password);
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();
			 	Thread.sleep(2000);
			 	driver.switchTo().window(tabs.get(0));
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"chkAllGSuitePerson\"]")).click();//chkAllGSuitePerson
			 	Thread.sleep(2000);
			 	String firstpart="//*[@id=\"tblPersonList\"]/tbody/tr[";
			 	String secondpart="]/td[1]/div/span/input";
			 	for(int i=1; i<6; i++)
			 	{
			 		String finalPart=firstpart + i + secondpart;
			 		driver.findElement(By.xpath(finalPart)).click();
			 		Thread.sleep(1000);
			 	}
			 	Reporter.log("Top 5 results have been selected");
			 	clickElement(driver,driver.findElement(By.xpath("//*[@id=\"btnGSuiteImport\"]")));
			 	Thread.sleep(2000);
			 	String Message= driver.findElement(By.xpath("//*[@id=\"divGSuitePersonsImported\"]")).getText();
			 	Reporter.log("The message after clicking Import" +Message);
			 	
			 	driver.quit();
				}
}
