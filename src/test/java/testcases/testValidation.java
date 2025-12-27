package testcases;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.login;
import resources.base;

public class testValidation extends base{
	
	static XSSFWorkbook workbook;
    static XSSFSheet worksheet;
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
				driver.manage().deleteAllCookies();
				Reporter.log("HomePage Navigation done");
			
				getScreenShot("Homepage");
				
			}
	 @Test(priority=1)
		
		public void b_LoginAssess() throws IOException, InterruptedException
			{
		 		login l=new login(driver);
		 		l.getUserName().sendKeys(prop.getProperty("emailId"));
		 		Reporter.log("username entered");
		 		l.getPassword().sendKeys(prop.getProperty("pwd"));
		 		Reporter.log("password entered");
		 		
		 		l.ClickLogin().click();
		 		Thread.sleep(2000);
		 		getScreenShot("AfterLoginPage");
		 		
		 		
			}
	 @Test(priority=2)
	
		
		public void c_AddPeople() throws InterruptedException, IOException
	 	{
		 FileInputStream fileInputStream= new FileInputStream("C:\\Users\\pulse.tester\\Documents\\AssessTeam\\TestData.xlsx"); //Excel sheet file location get mentioned here
	     workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
	     worksheet=workbook.getSheet("test");// get my sheet from workbook
	     String Date=formatter.formatCellValue(worksheet.getRow(1).getCell(0)); 
		 		
		 		driver.findElement(By.xpath("//a[@id='M4']")).click();
		 		Thread.sleep(2000);
		 		Reporter.log("The Persons tab is clicked");
		 		driver.findElement(By.xpath("//*[@id=\"divSearch\"]/div[2]/div/div/div[1]/div[2]/a[1]")).click();
		 		Reporter.log("Add a new Person is now being Clicked");
		 		driver.findElement(By.xpath("//*[@id=\"loPersonViewModel_stFirstName\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"loPersonViewModel_stFirstName\"]")).sendKeys("Nisha");
		 		driver.findElement(By.xpath("//*[@id=\"loPersonViewModel_stLastName\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"loPersonViewModel_stLastName\"]")).sendKeys("Prakash");
		 		driver.findElement(By.xpath("//*[@id=\"loPersonViewModel_stPersonCode\"]")).clear();
		 		driver.findElement(By.xpath("//*[@id=\"loPersonViewModel_stPersonCode\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"loPersonViewModel_stPersonCode\"]")).sendKeys("1234");
		 		WebElement DOJ=driver.findElement(By.xpath("//*[@id=\"txtDateJoin\"]"));
		 		/*DOJ.clear();
		 		DOJ.click();
		 		JavascriptExecutor js = (JavascriptExecutor)driver;
		 		js.executeScript("arguments[0].setAttribute('value','"+Date+"');", DOJ);
		 		//DOJ.clear();
		 		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		 		//jse.executeScript("arguments[0].setAttribute('value','"+Date+"')", DOJ);*/
		 				
		 		driver.findElement(By.xpath("//*[@id=\"txtDateJoin\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"txtDateJoin\"]")).sendKeys(Date);
		 		DOJ.clear();
		 		DOJ.sendKeys(Date);
		 		
		 		
		 		//DOJ.click();
		 		//setDate(driver,"23-June-2019",DOJ);
		 		driver.findElement(By.xpath("//*[@id=\"loPersonViewModel_stEmail\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"loPersonViewModel_stEmail\"]")).sendKeys("nishart34@gmail.com");
		 		driver.findElement(By.xpath("//*[@id=\"loPersonViewModel_stContactNumber\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"loPersonViewModel_stContactNumber\"]")).sendKeys("1223423");
		 		driver.findElement(By.xpath("//*[@id=\"txtManHoursrate\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"txtManHoursrate\"]")).sendKeys("130");
		 		driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]")).sendKeys("John Mathew");
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//span[@class='select2-match']")).click();
		 		Thread.sleep(3000);
		 		driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]")).sendKeys("Johnson Williams");
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//span[@class='select2-match']")).click();
		 		Thread.sleep(3000);
		 		
		}
	 



}
