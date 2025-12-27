

package AssessFlowtestcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.login;
import resources.base;

public class DeleteCompany extends base {
	
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
		 		sheet=workbook.getSheet("delete");
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
			
			public void c_delete() throws IOException, InterruptedException
				{
			 	
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//*[@id=\"M9\"]")).click();
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//*[@id=\"liBillingReceipts\"]/a")).click();
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//*[@id=\"divSearch\"]/form/div[2]/div[2]/div/div/div/a")).click();
		 		Reporter.log("delete button is being clicked");
		 		
		 		Thread.sleep(2000);
		 		//getScreenShot("deletePOPUP");
		 		
		 		driver.findElement(By.xpath("//*[@id=\"divDeleteMyAccount\"]/div[2]/a")).click();
		 		Reporter.log("company is being deleted and navigated to sign up page");
		 		
		 		//getScreenShot("delete");
		 		
		 		//driver.close();
		 		
		 		Thread.sleep(2000);
		 		driver.get("https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/");
				 Reporter.log("Gmail is being opened");
				 FileInputStream fisexcel= new FileInputStream(src);
			 		workbook= new XSSFWorkbook(fisexcel);
			 		sheet=workbook.getSheet("SignUp");
			 		
			 		//driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a")).click();
			 		
			 		
			 		String emailId=sheet.getRow(1).getCell(6).getStringCellValue();
			 		String pwd=sheet.getRow(1).getCell(7).getStringCellValue();
			 		Thread.sleep(2000);
			 		
			 		
			 		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).click();
			 		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(emailId);
			 		
			 		 
			 		
			 		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
			 		
			 		Thread.sleep(2000);
			 		
			 		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).click();
			 		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(pwd);
			 		Reporter.log("email ID and password is being provided");
			 		Thread.sleep(2000);
			 		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();
			 		Thread.sleep(2000);
			 		
			 		driver.findElement(By.xpath("//span[@role='checkbox']")).click();
			 		Thread.sleep(2000);
			 		driver.findElement(By.xpath("//div[@data-tooltip='Delete']")).click();
			 		Thread.sleep(2000);
			 		
			 		
		 		
		 		driver.quit();
		 		
		 				 				 				 				 		 		 				
	

}
}
