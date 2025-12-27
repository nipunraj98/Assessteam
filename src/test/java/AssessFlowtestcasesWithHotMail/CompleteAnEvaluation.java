package AssessFlowtestcasesWithHotMail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import resources.base;

public class CompleteAnEvaluation extends base {
	
	 File src=new File("C:\\Users\\pulse.tester\\Documents\\AssessTeam\\TestDataWithHotmail.xlsx");
	  
		
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
					//driver.get(prop.getProperty("url"));
					//Reporter.log(prop.getProperty("url"));
					//Reporter.log("Url is being hit");
					driver.manage().window().maximize();
					//driver.manage().deleteAllCookies();
					//Reporter.log("HomePage Navigation done");
				
					//getScreenShot("Homepage");
					
				}

	 @Test(priority=1)
		
		public void b_mailClick() throws IOException, InterruptedException
		{
		 driver.get("https://outlook.live.com");
		 Reporter.log("Hotmail is being opened");
		 Thread.sleep(7000);
		
		 FileInputStream fisexcel= new FileInputStream(src);
	 		workbook= new XSSFWorkbook(fisexcel);
	 		sheet=workbook.getSheet("CompleteEvaluation");
	 		
	 		//driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a")).click();
	 		
	 		
	 		String emailId=sheet.getRow(1).getCell(0).getStringCellValue();
	 		String pwd=sheet.getRow(1).getCell(1).getStringCellValue();
	 		Thread.sleep(8000);
	 		
	 		
driver.findElement(By.xpath("/html/body/section/div/div/div[2]/a[2]")).click();
	 		
	 		Reporter.log("Sign in is being clicked");
	 		
	 		
	 		driver.findElement(By.xpath("//*[@id=\"i0116\"]")).click();
	 		driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys(emailId);
	 		
	 		 
	 		
	 		driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
	 		
	 		Thread.sleep(2000);
	 		
	 		driver.findElement(By.xpath("//*[@id=\"i0118\"]")).click();
	 		driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys(pwd);
	 		Reporter.log("email ID and password is being provided");
	 		
	 		driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
	 		Thread.sleep(4000);
	 		Reporter.log("User Logged In");
	 		
	 		
		}
	 
	 @Test(priority=2)
		
		public void c_AssessMailClick() throws IOException, InterruptedException
		{
		 Thread.sleep(4000);
		 
		 Thread.sleep(4000);
		 
			driver.findElement(By.xpath("//div[@class='BVgxayg_IGpXi5g7S77GK']/div/div")).click();//BVgxayg_IGpXi5g7S77GK
			Thread.sleep(2000);
			
			
			 Thread.sleep(2000);
			 
			 Reporter.log("mail from AssessTeam is being clicked");
		 Thread.sleep(4000);
	
		 driver.findElement(By.xpath("//div[@class='wide-content-host']/div/div[2]/div/div/div/div/div/a")).click();
		 ////*[@id="wait"]
		 Reporter.log("link for verifying the mail id is being clicked");
		 Set<String>windows= driver.getWindowHandles();
			Iterator<String> wnew= windows.iterator();
			String ParentId= wnew.next();
		
			Thread.sleep(20000);
			String ChildId= wnew.next();
			//String ChildId2= wnew.next();
		
			driver.switchTo().window(ChildId);
			Thread.sleep(10000);
			getScreenShot("verifying mail");
			driver.findElement(By.xpath("//*[@id=\"ancSurveySubmission\"]")).click();
			Reporter.log("Survey start button is being clicked");
			
			

}
	 
	 @Test(priority=3)
		
		public void d_Evaluation() throws IOException, InterruptedException
		{
		 Thread.sleep(20000);
		 driver.findElement(By.xpath("//*[@id=\"anch_9\"]/i")).click();
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//*[@id=\"anch_9\"]/i")).click();
		 
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//*[@id=\"btnSubmitEvaluation\"]")).click();
		 
		 Thread.sleep(3000);
		 
		 getScreenShot("EvaluationComplete");
		 driver.quit();
		 
}
}
