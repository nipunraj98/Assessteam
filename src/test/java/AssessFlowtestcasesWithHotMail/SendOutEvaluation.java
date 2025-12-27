package AssessFlowtestcasesWithHotMail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.login;
import resources.base;

public class SendOutEvaluation extends base{
	
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
		 		
		 		driver.findElement(By.xpath("//*[@id=\"tdAction\"]/a[1]")).click();
		 		
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

				}
		 
		 @Test(priority=3)
			
			public void d_Evaluation() throws IOException, InterruptedException
				{
			 Thread.sleep(4000);
			 FileInputStream fisexcel= new FileInputStream(src);
		 		workbook= new XSSFWorkbook(fisexcel);
		 		sheet=workbook.getSheet("SendOutEvaluation");
		 		//formatter.formatCellValue(cell);
		 		String Title=sheet.getRow(1).getCell(4).getStringCellValue();
		 		//String Senddate=formatter.formatCellValue(sheet.getRow(1).getCell(5));
		 		String StartDate=formatter.formatCellValue(sheet.getRow(1).getCell(6));
		 		String Enddate=formatter.formatCellValue(sheet.getRow(1).getCell(7));
		 		String EvaluationDescription=formatter.formatCellValue(sheet.getRow(1).getCell(8));
		 		String EvaluatePersons=formatter.formatCellValue(sheet.getRow(1).getCell(9));
		 		String SelectEvaluators=formatter.formatCellValue(sheet.getRow(1).getCell(10));
		 		String ResultArea1=formatter.formatCellValue(sheet.getRow(1).getCell(11));
		 		System.out.println(ResultArea1);
		 		
		 		driver.findElement(By.xpath("//*[@id=\"A3\"]")).click();// clicking on evaluation
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//*[@id=\"liEvaluationsList\"]/a")).click();//clicking on evaluation list
		 		Reporter.log("Evaluation page is being opened");
		 		Thread.sleep(5000);
		 		driver.findElement(By.xpath("//*[@id=\"divSearch\"]/div[2]/div/div/div[1]/div[2]/div/a")).click();//clicking on add new evaluation
		 		////*[@id="divSearch"]/div[2]/div/div/div[1]/div[2]/div/a
		 		Thread.sleep(3000);
		 		driver.findElement(By.xpath("//*[@id=\"divSearch\"]/div[2]/div/div/div[1]/div[2]/div/ul/li[3]/a")).click();//clicking on adhoc evaluation
		 		Reporter.log("Adhoc Evaluation page is being opened");
		 		////*[@id="divSearch"]/div[2]/div/div/div[1]/div[2]/div/ul/li[3]/a
		 		driver.findElement(By.xpath("//*[@id=\"txtEvaluationTitle\"]")).click();//clicking on Title
		 		driver.findElement(By.xpath("//*[@id=\"txtEvaluationTitle\"]")).sendKeys(Title);
		 		
		 		
		 		
		 		//driver.findElement(By.xpath("//*[@id=\"txtSendEmailDate\"]")).click();
		 		
		 		//driver.findElement(By.xpath("//*[@id=\"txtSendEmailDate\"]")).sendKeys(Senddate);
		 		
		 		driver.findElement(By.xpath("//*[@id=\"txtPeriodStartDate\"]")).click();
		 		//driver.findElement(By.xpath("/html/body/div[15]/div[1]/table/tbody/tr[2]/td[4]")).click();
		 		//driver.findElement(By.xpath("//*[@id=\"txtPeriodStartDate\"]")).sendKeys(StartDate);
		 		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class=' table-condensed']/tbody/tr[2]/td"));
				
				for(WebElement ele:allDates)
				{
					
					String date=ele.getText();
					
					if(date.equalsIgnoreCase("15"))
					{
						ele.click();
						break;
					}
					
				}
		 		
		 		driver.findElement(By.xpath("//*[@id=\"txtPeriodEndDate\"]")).click();
		 		//driver.findElement(By.xpath("//*[@id=\"txtPeriodEndDate\"]")).sendKeys(Enddate);//sending endDate
		 		//driver.findElement(By.xpath("/html/body/div[15]/div[1]/table/tbody/tr[4]/td[6]")).click();

		 		List<WebElement> allEndDates=driver.findElements(By.xpath("//table[@class=' table-condensed']/tbody/tr[2]/td"));
				for(WebElement element:allEndDates)
				{
					
					String enddate=element.getText();
					
					if(enddate.equalsIgnoreCase("26"))
					{
						element.click();
						break;
					}
					
				}
		 		
		 		driver.findElement(By.xpath("//*[@id=\"txtEvaluationDescription\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"txtEvaluationDescription\"]")).sendKeys(EvaluationDescription);
		 		
		 		  driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]")).click();
		 		  driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]")).sendKeys(EvaluatePersons);
		 		  Thread.sleep(2000);
		 		  driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
		 		  
		 		  
		 		  driver.findElement(By.xpath("//*[@id=\"s2id_autogen4\"]")).click();
		 		 driver.findElement(By.xpath("//*[@id=\"s2id_autogen4\"]")).sendKeys(SelectEvaluators);
		 		 Thread.sleep(2000);
		 		 driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
		 		 
		 		 Thread.sleep(8000);
		 		WebElement Result= driver.findElement(By.xpath("//*[@id=\"ddlResultareasType\"]"));
		 		clickElement(driver,Result);
		 		 Select ResultArea= new Select(driver.findElement(By.xpath("//*[@id=\"ddlResultareasType\"]")));
		 		 Thread.sleep(2000);
		 		ResultArea.selectByVisibleText("Select from all available result areas");
		 		
		 		
		 		Thread.sleep(6000);
		 		
		 		driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
		 		Thread.sleep(2000);
		 		//driver.findElement(By.xpath("//input[@class='select2-input']")).click();
		 		//Thread.sleep(2000);
		 		//driver.findElement(By.xpath("//input[@class='select2-input']")).sendKeys(ResultArea1);
		 		Thread.sleep(3000);
		 		
		 		driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
		 		Thread.sleep(20000);
		 		driver.findElement(By.xpath("//*[@id=\"dvResultAreas\"]/h4/div/span/button")).click();
		 		Thread.sleep(7000);
		 		Reporter.log("All details have been Entered");
		 		
		 		driver.findElement(By.xpath("//*[@id=\"displaymsg\"]")).click();
		 		
		 		Reporter.log("Evaluation is saved");
		 		
		 		Thread.sleep(15000);
		 		
		 		//getScreenShot("Evaluation completed");
		 		//driver.close();
		 		
		 		driver.quit();
		 		
		 		
		 		
		 		
		 		 
		 		 
		 		  
		 		  
		 		  
		 		
		 		
		 		
		 		
		 	
		 		
		 		
		 		
		 		
		 		
		 		
}
		 
}
