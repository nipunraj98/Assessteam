package AssessFlowtestcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.login;
import resources.base;

public class IntegrationWithWrike extends base{
	
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
					driver.manage().deleteAllCookies();
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
		 		String password=formatter.formatCellValue(sheet.getRow(1).getCell(1));
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
			
			public void c_WrikeIntegration() throws IOException, InterruptedException
				{
			 FileInputStream fisexcel= new FileInputStream(src);
		 		workbook= new XSSFWorkbook(fisexcel);
		 		sheet=workbook.getSheet("Wrike");
		 		String email=sheet.getRow(1).getCell(0).getStringCellValue();
		 		String password=formatter.formatCellValue(sheet.getRow(1).getCell(1));
		 		driver.findElement(By.xpath("//*[@id=\"M9\"]")).click();
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"liIntegration\"]/a")).click();
			 	Thread.sleep(2000);
			 	Reporter.log("Integration is being clicked");
			 	Thread.sleep(2000); 
			 	driver.findElement(By.xpath("//*[@id=\"divSearch\"]/div[5]/div[1]/div/a")).click();
			 	Thread.sleep(2000);
			 	Reporter.log("Wrike is being clicked");
			 	driver.findElement(By.xpath("//*[@id=\"ancWrikeConnect\"]")).click();
			 	Reporter.log("ConnectWrike is being clicked");
			 	Thread.sleep(2000);
			 	ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			 	driver.switchTo().window(tabs.get(1));
			 	driver.findElement(By.xpath("//input[@id='login-input-id']")).click();
			 	Thread.sleep(1000);
			 	driver.findElement(By.xpath("//input[@id='login-input-id']")).sendKeys(email);
			 	Thread.sleep(2000);
			 	Reporter.log("Email is being entered for Wrike");
			 	
			 	driver.findElement(By.xpath("//button[@data-application='login-next']")).click();
			 	
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//input[@placeholder='Password']")).click();
			 	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//button[@data-application='login-next']")).click();
			 	Thread.sleep(2000);
			 	Reporter.log("user signed in");
			 	//login-remember
			 	//driver.findElement(By.xpath("//button[@data-application='login-remember']")).click();
			 	Thread.sleep(2000);
			 	driver.switchTo().window(tabs.get(0));
			 	//Thread.sleep(5000);
			 	driver.findElement(By.xpath("//*[@id='btnWrikeImport']")).click();
			 	
			 	
			 	Thread.sleep(2000);
			 	String SuccessMsg=driver.findElement(By.xpath("//div[@id='divWrikePersonsImported']")).getText();
			 	Reporter.log(SuccessMsg);
			 	System.out.println(SuccessMsg);
			 	
			 				 
			 	driver.quit();
			 	
			 	
			 	
}
}
