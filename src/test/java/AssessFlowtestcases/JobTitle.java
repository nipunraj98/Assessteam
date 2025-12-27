package AssessFlowtestcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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

public class JobTitle  extends base{
	
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
			 		//getScreenShot("AfterLoginPage");
			 		
			 		
				}
		 @Test(priority=2)
			
			public void c_JobTitleEnabled() throws IOException, InterruptedException
				{
			 FileInputStream fisexcel= new FileInputStream(src);
		 		workbook= new XSSFWorkbook(fisexcel);
		 		sheet=workbook.getSheet("SendOutEvaluation");
		 		//formatter.formatCellValue(cell);
		 		String JobTitle=sheet.getRow(1).getCell(2).getStringCellValue();
		 		String ResultArea=sheet.getRow(1).getCell(3).getStringCellValue();
		 		
		 		
		 		driver.findElement(By.xpath("//*[@id=\"liDesignations\"]/a")).click();//
		 		Thread.sleep(2000);
		 		
		 		Reporter.log("Job Title page is being opened");
		 		//getScreenShot("JOBTitle Page");
		 		driver.findElement(By.xpath("//*[@id=\"txtSearchKeyword\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"txtSearchKeyword\"]")).sendKeys(JobTitle);
		 		driver.findElement(By.xpath("//*[@id=\"divSearch\"]/div[2]/div/div/div[3]/div[1]/div/div/button")).click();
		 		
		 		Thread.sleep(2000);
		 		
		 		driver.findElement(By.xpath("(//*[@id='tdAction'])[5]/a[1]")).click();
		 		
		 		Thread.sleep(2000);
		 		Reporter.log("job title serachPage");
		 		
		 		driver.findElement(By.xpath("//*[@id=\"frmEditJobTitle\"]/div/div/div[3]/div[4]/div/div/div/div/label[1]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"frmEditJobTitle\"]/div/div/div[3]/div[6]/div/div/div/div/label[1]")).click();
		 		
		 		driver.findElement(By.xpath("//*[@id=\"frmEditJobTitle\"]/div/div/div[3]/div[8]/div/div/div/div/label[1]")).click();
		 		
		 		driver.findElement(By.xpath("//*[@id=\"select2-chosen-1\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"s2id_autogen1_search\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"s2id_autogen1_search\"]")).sendKeys(ResultArea);
		 		Reporter.log("Result area is being added" +ResultArea);
		 		
		 		Thread.sleep(3000);
		 		
		 		driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
		 		
		 		Thread.sleep(2000);
		 		
		 		WebElement Include=driver.findElement(By.xpath("//*[@id=\"frmEditJobTitle\"]/div/div/div[3]/div[10]/div/div/h4/div/span/button"));
		 		clickElement(driver,Include);		 		
		 		Thread.sleep(2000);
		 		//getScreenShot("JOBTitle PageEnabled");
		 		
		 		driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]")).click();
		 		Reporter.log("Job Title page is being Saved after enabling it");
		 		Thread.sleep(2000);
		 		
		 		driver.quit();

				}
		 
		
		 

}
