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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.Addperson;
import pageObjects.login;
import resources.base;

public class importCSV extends base{
	
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
	 		sheet=workbook.getSheet("SignUp");
	 		String email=sheet.getRow(1).getCell(3).getStringCellValue();
	 		String password=sheet.getRow(1).getCell(4).getStringCellValue();
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
			
			public void c_AddPerson() throws IOException, InterruptedException
				{
			 Addperson AP= new Addperson(driver);
		 		Thread.sleep(2000);
		 		AP.getperson().click();//clicking Person tab
		 		
		 		Thread.sleep(2000);
		 		Reporter.log("The Persons tab is clicked");
		 		//getScreenShot("PersonTab");
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//*[@id=\"divSearch\"]/div[2]/div/div/div[1]/div[2]/a[2]")).click();
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//*[@id=\"ddlImportType\"]")).click();
		 		Select importType= new Select(driver.findElement(By.xpath("//*[@id=\"ddlImportType\"]")));
		 		importType.selectByVisibleText("Person");
		 		Thread.sleep(2000);
		 		System.out.println("testing");
		 		//String info=driver.findElement(By.xpath("//*[@id=\"csv-upload-block\"]/div/h4")).getText();
		 		//System.out.println(info);
		 		//WebElement importbutton=driver.findElement(By.xpath("//*[@id=\"csv-upload-block\"]/div/h4/following-sibling::div/div/div/input"));
		 		//String text=importbutton.getText();
		 		//System.out.println(text);
		 		//OnclickElement(driver,importbutton);
		 		
		 	driver.findElement(By.xpath("//input[@type='file']")).click();
		 	Thread.sleep(2000);
		 	System.out.println("chossefile click");
		 		driver.findElement(By.xpath("//input[@id='btnUpload']")).click();
		 		Thread.sleep(2000);
		 		Reporter.log("Import button is being clicked");
		 		//getScreenShot("ImportPage");
		 		/*Runtime.getRuntime().exec("C:\\Users\\pulse.tester\\Documents\\AssessTeam\\upload1.exe");
		 		Thread.sleep(3000);
		 		Reporter.log("File is being selected");
		 		getScreenShot("People.CSV is being selected");
		 		driver.findElement(By.xpath("//*[@id=\"btnUpload\"]")).click();
		 		Reporter.log("File is being uploaded");
		 		Thread.sleep(3000);
		 		getScreenShot("People Tab page");
		 		driver.findElement(By.xpath("//*[@id=\"btnsave\"]")).click();
		 		Thread.sleep(2000);
		 		getScreenShot("Importpage");
		 		driver.findElement(By.xpath("//*[@id=\"btnImport\"]")).click();
		 		Thread.sleep(2000);
		 		getScreenShot("postImport");
		 		AP.getperson().click();
		 		Thread.sleep(2000);
		 		getScreenShot("Person tab");*/
		 		System.out.println("done");
		 		//driver.quit();
		 		
		 		
		 		
		 		
		 		
		 		  
		 		
		 		
		 		
				}
	
	
	
	

}
