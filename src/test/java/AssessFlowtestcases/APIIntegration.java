package AssessFlowtestcases;


	
	import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.Set;

	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Reporter;
	import org.testng.annotations.Test;

	import pageObjects.Addperson;
	import pageObjects.login;
	import resources.base;

	public class APIIntegration extends base{
		
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
		 		sheet=workbook.getSheet("ADDPersonManually");//APIIntegration
		 		String email=formatter.formatCellValue(sheet.getRow(1).getCell(0));
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
				
				public void c_APIIntegration() throws IOException, InterruptedException, Exception
					{
				 FileInputStream fisexcel= new FileInputStream(src);
			 		workbook= new XSSFWorkbook(fisexcel);
			 		sheet=workbook.getSheet("APIIntegration");
			 		//String email=sheet.getRow(1).getCell(0).getStringCellValue();
			 		//String password=sheet.getRow(1).getCell(1).getStringCellValue();
			 		
			 		driver.findElement(By.xpath("//*[@id=\"M9\"]")).click();
				 	Thread.sleep(2000);
				 	driver.findElement(By.xpath("//*[@id=\"liBranding\"]/a")).click();//clicking on Branding
				 	Thread.sleep(2000);
				 	String CompanyName=driver.findElement(By.xpath("//*[@id=\"loBranding_stCompanyName\"]")).getAttribute("value");
				 	System.out.println(CompanyName);
				 	Thread.sleep(2000);
				 	
				 	driver.findElement(By.xpath("//*[@id=\"liIntegration\"]/a")).click();
				 	Thread.sleep(2000);
				 	Reporter.log("Integration is being clicked");
				 	Thread.sleep(2000);
				 	driver.findElement(By.xpath("//*[@id=\"divSearch\"]/div[5]/div[3]/div/a")).click();
				 	Thread.sleep(2000);
				 	String SecretKey=driver.findElement(By.xpath("//*[@id=\"txtSecreteKey\"]")).getText();
				 	System.out.println(SecretKey);
				 	driver.findElement(By.xpath("//button[@class='btn green']")).click();
				 	Thread.sleep(2000);
				 	driver.switchTo().alert().accept();
				 	Thread.sleep(2000);
				 	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				 	Transferable contents = clipboard.getContents(null);
				 	String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
				 	System.out.println(x);
				 	
				 	//driver.findElement(By.xpath("//a[@href='https://restapi.assessteam.com/swagger/index.html']")).click();
				 	
				 	//Thread.sleep(4000);
				 	
				 	((JavascriptExecutor) driver).executeScript("window.open()");
				 	ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				 	driver.switchTo().window(tabs.get(1));
				 	
				 	driver.get("https://restapi.assessteam.com/swagger/index.html");
				 					 	
				 	Reporter.log("API Swagger UI has been opened");
				 	Thread.sleep(2000);
				 	driver.findElement(By.xpath("//*[@id=\"operations-Auth-AuthGeneratetokenPost\"]/div[1]/span[1]")).click();
				 	Thread.sleep(2000);
				 	driver.findElement(By.xpath("//div[@class='try-out']")).click();
				 	Thread.sleep(2000);
				 	driver.findElement(By.xpath("//*[@id=\"operations-Auth-AuthGeneratetokenPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr[2]/td[2]/input")).click();
				 	driver.findElement(By.xpath("//*[@id=\"operations-Auth-AuthGeneratetokenPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr[2]/td[2]/input")).sendKeys(x);
				 	Reporter.log("Secret Key has been pasted in swagger");
				 	//String CompanyName=formatter.formatCellValue(sheet.getRow(1).getCell(2));
				 	driver.findElement(By.xpath("//input[@placeholder='companyname - Company name']")).click();
				 	driver.findElement(By.xpath("//input[@placeholder='companyname - Company name']")).sendKeys(CompanyName);
				 	Thread.sleep(2000);
				 	driver.findElement(By.xpath("//button[@class='btn execute opblock-control__btn']")).click();
				 	Thread.sleep(2000);
				 	String Key=driver.findElement(By.xpath("//div[@class='highlight-code']/pre/span[17]")).getText().replace("\"", "");
				 	System.out.println(Key);
				 	String BearerKey= "Bearer" + " " +Key;
				 	System.out.println(BearerKey);
				 	driver.findElement(By.xpath("//button[@class='btn authorize unlocked']")).click();
				 	Thread.sleep(2000);
				 	driver.findElement(By.xpath("//input[@type='text']")).click();
				 	Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@type='text']")).sendKeys(BearerKey);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//button[@type='submit']")).click();
					Thread.sleep(2000);
					Reporter.log("Authorize successful");
					driver.findElement(By.xpath("//button[@class='btn modal-btn auth btn-done button']")).click();
					Thread.sleep(2000);

}
			 @Test(priority=3)
				
				public void d_AddPerson() throws IOException, InterruptedException
					{
				 FileInputStream fisexcel= new FileInputStream(src);
			 		workbook= new XSSFWorkbook(fisexcel);
			 		sheet=workbook.getSheet("APIIntegration");
			 		String firstName=sheet.getRow(1).getCell(3).getStringCellValue();
			 		String lastName=formatter.formatCellValue(sheet.getRow(1).getCell(4));
			 		String PersonCode=formatter.formatCellValue(sheet.getRow(1).getCell(5));
			 		driver.findElement(By.xpath("//div[@id='operations-Person-PersonAddpersonPost']")).click();
			 		Reporter.log("Post for add person is being clicked");
			 		Thread.sleep(2000);
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonAddpersonPost\"]/div[2]/div/div[1]/div[1]/div[2]/button")).click();
			 		Thread.sleep(2000);
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonAddpersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]/input")).click();
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonAddpersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]/input")).sendKeys(firstName);
			 		Thread.sleep(2000);
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonAddpersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr[2]/td[2]/input")).click();
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonAddpersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr[2]/td[2]/input")).sendKeys(lastName);
			 		Thread.sleep(2000);
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonAddpersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr[3]/td[2]/input")).click();
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonAddpersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr[3]/td[2]/input")).sendKeys(PersonCode);
			 		Reporter.log("All details have been entered for Person Code");
			 		Thread.sleep(2000);
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonAddpersonPost\"]/div[2]/div/div[2]/button")).click();
			 		Reporter.log("execute button is being clicked for add person");
			 		Thread.sleep(2000);
			 		String addpersonResult=driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonAddpersonPost\"]/div[2]/div/div[3]/div[2]/div/div/div[2]/div/pre")).getText();
			 		Reporter.log("The request Url after adding Person in Swagger" +addpersonResult);
			 		String AddPersonResponse=driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonAddpersonPost\"]/div[2]/div/div[3]/div[2]/div/div/table/tbody/tr/td[2]/div[1]/div/pre")).getText();
			 		Reporter.log("The Response after adding Person" +AddPersonResponse);
			 		Reporter.log("Add Person is completed");
			 		
			 
			 
			 
	}
			 @Test(priority=4)
				
				public void e_UpdatePerson() throws IOException, InterruptedException
					{
				 FileInputStream fisexcel= new FileInputStream(src);
			 		workbook= new XSSFWorkbook(fisexcel);
			 		sheet=workbook.getSheet("APIIntegration");
			 		String firstName=sheet.getRow(1).getCell(3).getStringCellValue();
			 		String UpdatedlastName=formatter.formatCellValue(sheet.getRow(1).getCell(6));
			 		System.out.println(UpdatedlastName);
			 		String PersonCode=formatter.formatCellValue(sheet.getRow(1).getCell(5));
			 		driver.findElement(By.xpath("//div[@id='operations-Person-PersonUpdatepersonPost']")).click();
			 		Thread.sleep(2000);
			 		Reporter.log("Post for update person is being clicked");
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonUpdatepersonPost\"]/div[2]/div/div[1]/div[1]/div[2]/button")).click();
			 		Thread.sleep(2000);
			 		Reporter.log("try it out button is being clicked");
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonUpdatepersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]/input")).click();
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonUpdatepersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]/input")).sendKeys(firstName);
			 		Thread.sleep(2000);
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonUpdatepersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr[2]/td[2]/input")).click();
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonUpdatepersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr[2]/td[2]/input")).sendKeys(UpdatedlastName);
			 		Thread.sleep(2000);
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonUpdatepersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr[3]/td[2]/input")).click();
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonUpdatepersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr[3]/td[2]/input")).sendKeys(PersonCode);
			 		
			 		Thread.sleep(2000);
			 		Reporter.log("All updated details have been entered and lastName is being updated");
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonUpdatepersonPost\"]/div[2]/div/div[2]/button[1]")).click();
			 		Reporter.log("Execute button is being clicked");
			 		Thread.sleep(2000);
			 		String RequestURL=driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonUpdatepersonPost\"]/div[2]/div/div[3]/div[2]/div/div/div[2]/div/pre")).getText();
			 		Reporter.log("The Request URL after updating details of Lastname" +RequestURL);
			 		String UpdatePersonResponse=driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonUpdatepersonPost\"]/div[2]/div/div[3]/div[2]/div/div/table/tbody/tr/td[2]/div[1]/div/pre")).getText();
			 		Reporter.log("The Response after updating Person" +UpdatePersonResponse);
			 		Reporter.log("Update Person is being completed");
			 		
	}
			 
			 @Test(priority=5)
				
				public void f_getPerson() throws IOException, InterruptedException
					{
				 FileInputStream fisexcel= new FileInputStream(src);
			 		workbook= new XSSFWorkbook(fisexcel);
			 		sheet=workbook.getSheet("APIIntegration");
			 		String firstName=sheet.getRow(1).getCell(3).getStringCellValue();
			 		String UpdatedlastName=formatter.formatCellValue(sheet.getRow(1).getCell(6));
			 		String PersonCode=formatter.formatCellValue(sheet.getRow(1).getCell(5));
			 		driver.findElement(By.xpath("//div[@id='operations-Person-PersonGetpersonPost']")).click();
			 		Thread.sleep(2000);
			 		Reporter.log("Post for get person is being clicked");
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonGetpersonPost\"]/div[2]/div/div[1]/div[1]/div[2]/button")).click();
			 		Thread.sleep(2000);
			 		Reporter.log("try it out button is being clicked");
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonGetpersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]/input")).click();
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonGetpersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]/input")).sendKeys("0001");
			 		
			 		Reporter.log("Person code is being entered");
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonGetpersonPost\"]/div[2]/div/div[2]/button")).click();
			 		Reporter.log("Execute button is being clicked");
			 		Thread.sleep(2000);
			 		//Reporter.log("GetPerson is being completed");
			 		String GetPersonResponse=driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonGetpersonPost\"]/div[2]/div/div[3]/div[2]/div/div/table/tbody/tr/td[2]/div[1]/div/pre")).getText();
			 		Reporter.log("The Response after executing get Person" +GetPersonResponse);
			 		Reporter.log("GetPerson is being completed");
			 		
			 		
			 		
			 				
			 
			 
	}
			 
			 @Test(priority=6)
				
				public void g_deletePerson() throws IOException, InterruptedException
					{
				 FileInputStream fisexcel= new FileInputStream(src);
			 		workbook= new XSSFWorkbook(fisexcel);
			 		sheet=workbook.getSheet("APIIntegration");
			 		String firstName=sheet.getRow(1).getCell(3).getStringCellValue();
			 		String UpdatedlastName=formatter.formatCellValue(sheet.getRow(1).getCell(6));
			 		String PersonCode=formatter.formatCellValue(sheet.getRow(1).getCell(5));
			 		driver.findElement(By.xpath("//div[@id='operations-Person-PersonDeletepersonPost']")).click();
			 		Thread.sleep(2000);
			 		Reporter.log("Post for delete person is being clicked");
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonDeletepersonPost\"]/div[2]/div/div[1]/div[1]/div[2]/button")).click();
			 		Thread.sleep(2000);
			 		Reporter.log("try it out button is being clicked");
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonDeletepersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]/input")).click();
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonDeletepersonPost\"]/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]/input")).sendKeys(PersonCode);
			 		Thread.sleep(2000);
			 		driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonDeletepersonPost\"]/div[2]/div/div[2]/button")).click();
			 		Reporter.log("person code is being entered and execute button is being clicked");
			 		Thread.sleep(2000);
			 		String deleteResult=driver.findElement(By.xpath("//*[@id=\"operations-Person-PersonDeletepersonPost\"]/div[2]/div/div[3]/div[2]/div/div/table/tbody/tr/td[2]/div[1]/div/pre")).getText();
			 		Reporter.log("Response after deleting person" +deleteResult);
			 		Reporter.log("delete Person is completed");
			 		
			 		driver.quit();
			 
	}
	}
