package AssessFlowtestcases;

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
		 driver.get("https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/");
		 Thread.sleep(2000);
		 Reporter.log("Gmail is being opened");
		 FileInputStream fisexcel= new FileInputStream(src);
	 		workbook= new XSSFWorkbook(fisexcel);
	 		sheet=workbook.getSheet("CompleteEvaluation");
	 		
	 		//driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a")).click();
	 		
	 		
	 		String emailId=sheet.getRow(1).getCell(0).getStringCellValue();
	 		String pwd=sheet.getRow(1).getCell(1).getStringCellValue();
	 		Thread.sleep(2000);
	 		
	 		
	 		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).click();
	 		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(emailId);
	 		
	 		 
	 		
	 		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
	 		
	 		Thread.sleep(2000);
	 		
	 		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).click();
	 		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(pwd);
	 		Reporter.log("email ID and password is being provided");
	 		
	 		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();
	 		Thread.sleep(2000);
	 		Reporter.log("User Logged In");
	 		getScreenShot("Gmail logged in");
	 		
	 		
	 		
		}
	 
	 @Test(priority=2)
		
		public void c_AssessMailClick() throws IOException, InterruptedException
		{
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//tr[@jscontroller='ZdOxDb']")).click();
		 Thread.sleep(2000);
		 
		 Reporter.log("mail from AssessTeam is being clicked");
		 //getScreenShot("AssessTeam Mail");
		 //driver.findElement(By.xpath("//*[@id=\":pv\"]")).click();
		 Thread.sleep(2000);
		// driver.findElement(By.xpath("//*[@id=\":oa\"]/div[1]/p/a")).click();
		 
		 ////*[@id=":nc"]/div[1]/p/a
		 driver.findElement(By.xpath("//div[@data-tooltip='Show trimmed content']/img")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(" //a[contains(text(),'Click here to start ')]  ")).click();
		 ////*[@id="wait"]
		 Reporter.log("link for verifying the mail id is being clicked");
		 Set<String>windows= driver.getWindowHandles();
			Iterator<String> wnew= windows.iterator();
			String ParentId= wnew.next();
		
			Thread.sleep(2000);
			String ChildId= wnew.next();
			//String ChildId2= wnew.next();
		
			driver.switchTo().window(ChildId);
			Thread.sleep(2000);
			getScreenShot("verifying mail");
			driver.findElement(By.xpath("//*[@id=\"ancSurveySubmission\"]")).click();
			Reporter.log("Survey start button is being clicked");
			
			

}
	 
	 @Test(priority=3)
		
		public void d_Evaluation() throws IOException, InterruptedException
		{
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id=\"anch_7\"]/i")).click();
		 Thread.sleep(2000);
		// driver.findElement(By.xpath("//*[@id=\"anch_9\"]/i")).click();
		 Thread.sleep(2000);
		 /*driver.findElement(By.xpath("//*[@id=\"anch_9\"]/i")).click();
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//*[@id=\"anch_9\"]/i")).click();
		 
		 Thread.sleep(4000);*/
		 driver.findElement(By.xpath("//*[@id=\"btnSubmitEvaluation\"]")).click();
		 
		 Thread.sleep(2000);
		 
		 getScreenShot("EvaluationComplete");
		 driver.quit();
		 
}
}
