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
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.login;
import resources.base;

public class continuousFeedback extends base {
	
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
				
					getScreenShot("Homepage");
					
				}
		 
		 @Test(priority=1)
			
			public void b_LoginAssess() throws IOException, InterruptedException
				{
			 FileInputStream fisexcel= new FileInputStream(src);
		 		workbook= new XSSFWorkbook(fisexcel);
		 		sheet=workbook.getSheet("SendOutEvaluation");
		 		String email=sheet.getRow(1).getCell(0).getStringCellValue();
		 		String password=sheet.getRow(1).getCell(1).getStringCellValue();
			 		login l=new login(driver);
			 		l.getUserName().sendKeys(email);
			 		Reporter.log("username entered");
			 		l.getPassword().sendKeys(password);
			 		Reporter.log("password entered");
			 		
			 		l.ClickLogin().click();
			 		
			 		Thread.sleep(2000);
			 		getScreenShot("AfterLoginPage");
			 		
			 		
				}
		 
		 @Test(priority=2)
			
			public void c_ContinuousFeedbackPage() throws IOException, InterruptedException
				{
			 	FileInputStream fisexcel= new FileInputStream(src);
		 		workbook= new XSSFWorkbook(fisexcel);
		 		sheet=workbook.getSheet("ContinuousFeedback");
		 		String personName=sheet.getRow(1).getCell(0).getStringCellValue();
		 		//String password=sheet.getRow(1).getCell(1).getStringCellValue(); 
		 		
		 		Thread.sleep(2000);
		 		
		 		//WebElement ContinuousFeedBack=driver.findElement(By.xpath("//a[@id='ancContinuousFeedback']"));
		 		driver.findElement(By.xpath("//a[@id='ancContinuousFeedback']")).click();
		 		//clickElement(driver,ContinuousFeedBack);
		 		Reporter.log("Continuous FeedBack button is being Clicked");
		 		
		 		Thread.sleep(2000);
		 		
		 		driver.findElement(By.xpath("//*[@id=\"txtSrc\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"txtSrc\"]")).sendKeys(personName);
		 		
		 		driver.findElement(By.xpath("//*[@id=\"btnSearch\"]")).click();
		 		
		 		driver.findElement(By.xpath("//*[@id=\"divSearch\"]/div[2]/div/div/div[3]/div[3]/div/div/div[2]/div[4]/a")).click();//clicking on evaluate button
		 	
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//*[@id=\"tblResultAreasList\"]/tbody/tr/td[3]/div/label[1]")).click();//marking it as yes
		 		////*[@id="tblResultAreasList"]/tbody/tr/td[3]/div/label[1]
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//*[@id=\"btnAddPerson\"]")).click();
		 		
		 		Thread.sleep(2000);
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
			 Reporter.log("Evaluation for person is being started");
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//*[@id=\"anch_7\"]/i")).click();
			 Thread.sleep(2000);
			 //driver.findElement(By.xpath("//*[@id=\"anch_9\"]/i")).click();
			 
			 Thread.sleep(2000);
			 //Thread.sleep(4000);
			 /*driver.findElement(By.xpath("//*[@id=\"anch_9\"]/i")).click();
			 Thread.sleep(4000);
			 driver.findElement(By.xpath("//*[@id=\"anch_9\"]/i")).click();
			 
			 Thread.sleep(4000);
			 driver.findElement(By.xpath("//*[@id=\"btnSubmitEvaluation\"]")).click();
			 
			 Thread.sleep(3000);*/
			 
			 //getScreenShot("EvaluationComplete");
			 //driver.close();
			 
			 driver.quit();
			 
	}
		 
		 
}
