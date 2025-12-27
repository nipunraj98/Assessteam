package AssessFlowtestcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.login;
import resources.base;

public class IntegrationWithWrikeflow extends base{
	
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
					driver.manage().deleteAllCookies();
					Reporter.log("The browser is being opened");
					System.out.println("browser");
					driver.get("https://www.wrike.com/login/");
					//Reporter.log(prop.getProperty("url"));
					Reporter.log("Wrike Url is being hit");
					driver.manage().window().maximize();
					//driver.manage().deleteAllCookies();
					Reporter.log("LoginPage is being displayed");
				
					//getScreenShot("Homepage");
					
				}
		 
		 @Test(priority=1)
			
			public void b_Wrikelogin() throws IOException, InterruptedException
				{
			 
			 FileInputStream fisexcel= new FileInputStream(src);
		 		workbook= new XSSFWorkbook(fisexcel);
		 		sheet=workbook.getSheet("Wrike");
		 		String email=sheet.getRow(1).getCell(0).getStringCellValue();
		 		String password=formatter.formatCellValue(sheet.getRow(1).getCell(1));
				
		 driver.findElement(By.xpath("//input[@id='login-input-id']")).click();
		 	Thread.sleep(1000);
		 	driver.findElement(By.xpath("//input[@id='login-input-id']")).sendKeys(email);
		 	Thread.sleep(2000);
		 	Reporter.log("Email is being entered for Wrike");
		 	
		 	driver.findElement(By.xpath("//button[@data-application='login-next']")).click();
		 	
		 	Thread.sleep(2000);
		 	driver.findElement(By.xpath("//input[@placeholder='Password']")).click();
		 	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		 	Thread.sleep(2000);
		 	driver.findElement(By.xpath("//button[@data-application='login-next']")).click();
		 	Thread.sleep(2000);
		 	Reporter.log("user signed into the wrike");
		 	Thread.sleep(2000);
		 	driver.findElement(By.xpath("//button[@data-application='login-forget']")).click();
		 	Thread.sleep(2000);
		 	Reporter.log("User clicked on forget button");
		 	
		 	
		
		
		
		  ((JavascriptExecutor)driver).executeScript("window.open()");
		  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(tabs.get(1));
		  driver.get("https://account.assessteam.com/login");
		  Reporter.log("User opened AT in new tab");
		 
	

}
	
	  @Test(priority=2)
	  
	  public void c_AssessTeamlogin() throws IOException, InterruptedException {
	  
	  FileInputStream fisexcel= new FileInputStream(src); workbook= new
	  XSSFWorkbook(fisexcel);
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
	  }
	  
	  @Test(priority=3)
	  
	  public void d_WrikeIntegration() throws IOException, InterruptedException
	  {
	  FileInputStream fisexcel= new FileInputStream(src); 
	  workbook= new XSSFWorkbook(fisexcel);
	   sheet=workbook.getSheet("Wrike"); 
	   
	   driver.findElement(By.xpath("//li[@id='liSettings']/a")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"liIntegration\"]/a")).click();
	  Thread.sleep(2000); 
	  Reporter.log("Integration is being clicked");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"divSearch\"]/div[5]/div[1]/div/a")).click();
	  
	  Thread.sleep(2000); 
	  Reporter.log("Wrike is being clicked");
	  driver.findElement(By.xpath("//*[@id=\"ancWrikeConnect\"]")).click();
	  Reporter.log("ConnectWrike is being clicked"); 
	  ArrayList<String> tabs = new  ArrayList<String>(driver.getWindowHandles());
	 
	  driver.switchTo().window(tabs.get(2)); 
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@data-application='consent-accept']")). click(); 
	 
	  Thread.sleep(2000); 
	  Reporter.log("user clicked on Accept");
	  driver.switchTo().window(tabs.get(0)); Thread.sleep(4000); ArrayList<String>
	  tab = new ArrayList<String>(driver.getWindowHandles());
	  driver.switchTo().window(tab.get(1));
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"chkAllWrikePerson\"]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"chkAllWrikePerson\"]")).click();//unchecked the selected results of table
	  
	  
	  //List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"tblPersonList\"]/tbody/tr"));
	 
	  //int rowCount=rows.size();
	  //System.out.println(rowCount);
	 /* String firstpart="//*[@id=\"tblPersonList\"]/tbody/tr[";
	 String secondpart="]/td[1]/div/span/input";
	 int rowcount=rowCount-1;
	 	Thread.sleep(2000);
	 	for(int i=1; i<3; i++)
	 	{
	 		String finalPart=firstpart + i + secondpart;*/
	 		driver.findElement(By.xpath("//*[@id=\"tblPersonList\"]/tbody/tr[1]/td[1]/div/span/input")).click();
	 		Thread.sleep(1000);
	 	
	  
	  
	  driver.findElement(By.xpath("//*[@id='btnWrikeImport']")).click();
	  
	  
	  Thread.sleep(2000); 
	  String SuccessMsg=driver.findElement(By.xpath("//div[@id='divWrikePersonsImported']" )).getText(); 
	 
	  Reporter.log(SuccessMsg); 
	  System.out.println(SuccessMsg);
	  Reporter.log("persons have been imported");
	  
	  driver.switchTo().window(tab.get(0)); 
	  Thread.sleep(2000);
	  
 
		 
		 Thread.sleep(2000);
		 	driver.findElement(By.xpath("//*[@id=\"ext-gen3\"]/ws-host/header/div[3]/div/ws-user-profile-menu/profile-widget/div/div/div[2]")).click();
		 	Reporter.log("User navigated to Wrike Page");
		 	Thread.sleep(2000);
		 	driver.findElement(By.xpath("//*[@id=\"ext-gen3\"]/wrike-floating-panel/div/wrike-select-list/a[2]")).click();
		 	////*[@id="ext-gen3"]/wrike-floating-panel/div/wrike-select-list/a[2]
		 	Thread.sleep(2000);
		 	driver.findElement(By.xpath("//a[@title='Apps access']")).click();
		 	Thread.sleep(2000);
		 	Reporter.log("user clicked on App access");
		 	driver.findElement(By.xpath("/html/body/apps-app/div/div/apps-access/wrike-notification-message/div[2]/button")).click();
		 	Reporter.log("AssessTeam access has been revoked");
		 	Thread.sleep(2000);
		 	
		 	//driver.quit();
	  }
	 
}
