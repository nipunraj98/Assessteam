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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.login;
import resources.base;

public class ZohoIntegration extends base{
	
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
			
			public void c_ZohoIntegration() throws IOException, InterruptedException
				{
			 driver.findElement(By.xpath("//*[@id=\"M9\"]")).click();
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"liIntegration\"]/a")).click();
			 	Thread.sleep(2000);
			 	Reporter.log("Integration is being clicked");
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"divSearch\"]/div[4]/div[4]/div/a")).click();
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//a[@id='ancZohoOauth']")).click();	 		
		 		ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
		 		driver.switchTo().window(tabs1.get(1));
		 		Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"login_id\"]")).sendKeys("selenium@pulsesolutions.net");
			 	driver.findElement(By.xpath("//*[@id=\"nextbtn\"]")).click();
			 	Thread.sleep(2000); 
			 	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("DRftgyhu@12");
			 	driver.findElement(By.xpath("//*[@id=\"nextbtn\"]")).click();
			 	Thread.sleep(2000);
			 	
			 	Thread.sleep(2000);
			 	//driver.findElement(By.xpath("//*[@id=\"Approve_Reject\"]/button[1]")).click();
			 	handleAlert();
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//button[@class='btn']")).click();
			 	driver.switchTo().window(tabs1.get(0));
			 	//driver.findElement(By.xpath("//button[@class='update_profile']")).click();
			 	Thread.sleep(2000);
			 	driver.findElement(By.xpath("//*[@id=\"btnAuthorizeBasecampClassic\"]")).click();
			 	Thread.sleep(2000);
			 	String successMsg=driver.findElement(By.xpath("//*[@id=\"divBasecampHeader\"]/div/div/h4[2]")).getText();
			 	Assert.assertEquals("Zoho connected", successMsg);
			 	System.out.println(successMsg);
			 
			 
				}

}
