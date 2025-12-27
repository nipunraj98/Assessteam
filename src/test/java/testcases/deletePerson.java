package testcases;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Addperson;
import pageObjects.deleteperson;
import pageObjects.login;
import resources.base;


public class deletePerson extends base {
	static XSSFWorkbook workbook;
    static XSSFSheet worksheet;
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
				driver.manage().deleteAllCookies();
				Reporter.log("HomePage Navigation done");
			
				getScreenShot("Homepage");
				
			}
	 @Test(priority=1)
		
		public void b_LoginAssess() throws IOException, InterruptedException
			{
		 		login l=new login(driver);
		 		l.getUserName().sendKeys("");
		 		Reporter.log("username entered");
		 		l.getPassword().sendKeys(prop.getProperty("pwd"));
		 		Reporter.log("password entered");
		 		
		 		l.ClickLogin().click();
		 		
		 		Thread.sleep(2000);
		 		getScreenShot("AfterLoginPage");
		 		Reporter.log("User is successfully login");
		 		
		 		
			}
	 @Test(priority=2)
	 public void c_DeletePerson() throws InterruptedException
	 {
		 int loop=9;
		 Addperson AP= new Addperson(driver);
		 deleteperson DP= new deleteperson(driver);
	 		Thread.sleep(4000);
	 		AP.getperson().click();//clicking Person tab
	 		
	 		Thread.sleep(2000);
	 		Reporter.log("The Persons tab is clicked");
	 		getScreenShot("PersonTab");
	 		Thread.sleep(2000);
	 		for(int i=0;i<loop;i++)
	 		{
	 			DP.getediticon().click();
	 			Thread.sleep(2000);
	 			
	 			clickElement(driver, DP.getdelete());
	 			Thread.sleep(3000);
	 			getScreenShot("delete person");
	 			
	 			DP.getconfirmdelete().click();
	 			System.out.println(" no of deleted person:" +(i+1));
	 			Reporter.log(" no of deleted person:" +(i+1));
	 			Thread.sleep(2000);
	 			getScreenShot("AfterDeletion");
	 			
	 			
	 		}
	 }
	
	

}
