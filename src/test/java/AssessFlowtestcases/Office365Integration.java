
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

public class Office365Integration extends base{
	
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
			
			public void c_Office365Integration() throws IOException, InterruptedException
				{
			 FileInputStream fisexcel= new FileInputStream(src);
		 		workbook= new XSSFWorkbook(fisexcel);
		 		sheet=workbook.getSheet("Office365");
		 		String email=sheet.getRow(1).getCell(0).getStringCellValue();
		 		String password=sheet.getRow(1).getCell(1).getStringCellValue();
		 		driver.findElement(By.xpath("//li[@id='liSettings']/a")).click();
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"liIntegration\"]/a")).click();
			 	Thread.sleep(2000);
			 	Reporter.log("Integration is being clicked");
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"divSearch\"]/div[5]/div[2]/div/a")).click();
			 	Reporter.log("Office 365 is being clicked");
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"ancOffice365Connect\"]")).click();
			 	Reporter.log("Connect office 365 is being clicked ");
			 	Thread.sleep(2000);
			 	Reporter.log("Redirected to Gmail");
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//input[@type='email']")).click();
			 	Reporter.log("Email Id has been entered");
			 	driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//input[@type='submit']")).click();
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//input[@type='password']")).click();
			 	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//input[@type='submit']")).click();
			 	Thread.sleep(2000);
			 	Reporter.log("login is successful");
			 	driver.findElement(By.xpath("//input[@type='submit']")).click();
			 	Reporter.log("Clicked on Accept Tab");
			 	Thread.sleep(2000);
			 	Reporter.log("Redirected to Office365 Integration Page");
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"chkAllGSuitePerson\"]")).click();
			 	Thread.sleep(20000);
			 	driver.findElement(By.xpath("//*[@id=\"chkAllGSuitePerson\"]")).click();
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
			 
			 	//WebElement import=driver.findElement(By.xpath("//*[@id=\"btnGSuiteImport\"]"));
			 	clickElement(driver,driver.findElement(By.xpath("//*[@id=\"btnGSuiteImport\"]")));
			 	Thread.sleep(5000);
			 	String Message= driver.findElement(By.xpath("//*[@id=\"divGSuitePersonsImported\"]")).getText();
			 	Reporter.log("The message after clicking Import" +Message);
			 	driver.quit();
			 	}
			 	
			 	
			 	
			 	
				}

