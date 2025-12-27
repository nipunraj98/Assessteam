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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.login;
import resources.base;

public class IntegrationWithBaseCamp extends base {
	
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
					
				}
		 
		/* @Test(priority=1)
			
			public void b_BaseCampLogin() throws IOException, InterruptedException
				{
			 FileInputStream fisexcel= new FileInputStream(src);
		 		workbook= new XSSFWorkbook(fisexcel);
		 		sheet=workbook.getSheet("BaseCamp");
		 		String email=sheet.getRow(1).getCell(0).getStringCellValue();
		 		String password=sheet.getRow(1).getCell(1).getStringCellValue();
			 	
		 		driver.findElement(By.xpath("//*[@id=\"username\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(email);
		 		
		 		Reporter.log("Username is being entered");
		 		Thread.sleep(3000);
		 		driver.findElement(By.xpath("//button[@data-role='next_button']")).click();
		 		Thread.sleep(3000);
		 		driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		 		
		 		Reporter.log("Password is being entered");
		 		
		 		Thread.sleep(2000);
		 		
		 		driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/form[2]/button[2]")).click();
		 		Thread.sleep(3000);
		 		
		 		Reporter.log("login successful into basecamp");
		 		
				}*/
		 
		 @Test(priority=2)
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
		 public void c_IntegrationBaseCamp() throws IOException, InterruptedException
			{
			 FileInputStream fisexcel= new FileInputStream(src);
		 		workbook= new XSSFWorkbook(fisexcel);
		 		sheet=workbook.getSheet("BaseCamp");
		 		String email=sheet.getRow(1).getCell(0).getStringCellValue();
		 		String password=sheet.getRow(1).getCell(1).getStringCellValue();
		 		driver.findElement(By.xpath("//li[@id='liSettings']/a")).click();
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"liIntegration\"]/a")).click();
			 	Thread.sleep(2000);
			 	Reporter.log("Integration is being clicked");
			 	driver.findElement(By.xpath("//*[@id=\"divSearch\"]/div[4]/div[2]/div/a")).click();
			 	Thread.sleep(2000);
			 	Reporter.log("Basecamp integration is being clicked");
			 	driver.findElement(By.xpath("//*[@id=\"ancBasecamp\"]")).click();
			 	Reporter.log("Authorization page is being opened");
			 	Thread.sleep(2000);
			 	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			 	driver.switchTo().window(tabs.get(1)); 
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//input[@id='username']")).click();
			 	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//button[@name='button']")).click();
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@type='submit']")).click();
			 	
			 	Thread.sleep(2000);
			 	
			 	driver.findElement(By.xpath("//button[@type='submit']")).click();
			 	Reporter.log("integration is successful");
			 	Thread.sleep(2000);
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(2000);
				String importMsg= driver.findElement(By.xpath("//*[@id=\"divAuthorizeDone\"]/div/div/p")).getText();
				System.out.println(importMsg);
				
				Reporter.log(importMsg);
				
				Reporter.log("Basecamp integration is being completed");
				Thread.sleep(2000);
				driver.quit();
			}
}
