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
import pageObjects.login;
import resources.base;

public class Login extends base{
	
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
		 		l.getUserName().sendKeys(prop.getProperty("emailId"));
		 		Reporter.log("username entered");
		 		l.getPassword().sendKeys(prop.getProperty("pwd"));
		 		Reporter.log("password entered");
		 		
		 		l.ClickLogin().click();
		 		
		 		Thread.sleep(2000);
		 		getScreenShot("AfterLoginPage");
		 		
		 		
			}


}
