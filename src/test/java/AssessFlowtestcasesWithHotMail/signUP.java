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
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import resources.base;

public class signUP extends base {
	
	static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    XSSFCell cell;
    public static DataFormatter formatter= new DataFormatter();
    
    File src=new File("C:\\Users\\pulse.tester\\Documents\\AssessTeam\\TestData.xlsx");
    
	
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
		
		public void b_signUp() throws IOException, InterruptedException
			{	
		 		FileInputStream fisexcel= new FileInputStream(src);
		 		workbook= new XSSFWorkbook(fisexcel);
		 		sheet=workbook.getSheet("SignUp");
		 		String FullName=sheet.getRow(1).getCell(0).getStringCellValue();
		 		String CompanyName=sheet.getRow(1).getCell(1).getStringCellValue();
		 		String Country=sheet.getRow(1).getCell(2).getStringCellValue();
		 		String email=sheet.getRow(1).getCell(3).getStringCellValue();
		 		String password=sheet.getRow(1).getCell(4).getStringCellValue();
		 		
		 		
		 		
		 		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[1]/div[6]/div/div/a")).click();
		 		Thread.sleep(3000);
		 		
		 		Set<String>windows= driver.getWindowHandles();
				Iterator<String> wnew= windows.iterator();
				String ParentId= wnew.next();
			
				Thread.sleep(2000);
				String ChildId= wnew.next();
			
				driver.switchTo().window(ChildId);
				Thread.sleep(2000);
				Reporter.log("Switched to signup page");
				getScreenShot("signup page");
				
		 		String Title= driver.findElement(By.xpath("//*[@id=\"frmSignup\"]/div/div/div[2]")).getText();
		 		System.out.println(Title);
		 		
		 				
		 		WebElement Firstname=driver.findElement(By.xpath("//input[@id='txtFullName']"));
		 		Thread.sleep(2000);
		 		clickElement(driver,Firstname);
		 		
		 		driver.findElement(By.xpath("//*[@id=\"txtFullName\"]")).sendKeys(FullName);
		 		driver.findElement(By.xpath("//*[@id=\"txtCompanyName\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"txtCompanyName\"]")).sendKeys(CompanyName);
		 		
		 		driver.findElement(By.xpath("//*[@id=\"ddlCountry\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"ddlCountry\"]")).sendKeys(Country);
		 		
		 		driver.findElement(By.xpath("//*[@id=\"txtEmail\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"txtEmail\"]")).sendKeys(email);
		 		
		 		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).click();
		 		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys(password);
		 		
		 		Reporter.log("Mandatory fields are being entered");
		 		getScreenShot("All details have been entered");
		 		
		 		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		 		
		 		Reporter.log("Save button is being clicked ");
		 		getScreenShot("Post signUp");
		 		
			}

	 @Test(priority=2)
		
		public void c_mailClick() throws IOException, InterruptedException
		{
		 driver.get("https://outlook.live.com");
		 Reporter.log("Hotmail is being opened");
		 FileInputStream fisexcel= new FileInputStream(src);
	 		workbook= new XSSFWorkbook(fisexcel);
	 		sheet=workbook.getSheet("SignUp");
	 		
	 		//driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a")).click();
	 		
	 		
	 		String emailId=sheet.getRow(1).getCell(6).getStringCellValue();
	 		String pwd=sheet.getRow(1).getCell(7).getStringCellValue();
	 		Thread.sleep(2000);
	 		
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
	 		//getScreenShot("Gmail logged in");
	 		
	 		
		}
	 
	 @Test(priority=3)
		
		public void d_AssessMailClick() throws IOException, InterruptedException
		{
		 Thread.sleep(4000);
		 
		driver.findElement(By.xpath("//div[@class='BVgxayg_IGpXi5g7S77GK']/div/div")).click();
		Thread.sleep(2000);
		
		
		 Thread.sleep(2000);
		 
		 Reporter.log("mail from AssessTeam is being clicked");
		// getScreenShot("AssessTeam Mail");
		 //driver.findElement(By.xpath("//*[@id=\":pv\"]")).click();
		 Thread.sleep(2000);
		// driver.findElement(By.xpath("//*[@id=\":oa\"]/div[1]/p/a")).click();
		 
		 ////*[@id=":nc"]/div[1]/p/a
		 driver.findElement(By.xpath("//div[@class='wide-content-host']/div/div[2]/div/div/div/div//p/a")).click();
		 ////*[@id="wait"]
		 Reporter.log("link for verifying the mail id is being clicked");
		 Set<String>windows= driver.getWindowHandles();
			Iterator<String> wnew= windows.iterator();
			String ParentId= wnew.next();
		
			Thread.sleep(2000);
			String ChildId= wnew.next();
			String ChildId2= wnew.next();
		
			driver.switchTo().window(ChildId2);
			Thread.sleep(2000);
			//getScreenShot("verifying mail");
			
			//String wait=driver.findElement(By.xpath("//*[@id=\"wait\"]")).getText();
			//System.out.println(wait);
			//Reporter.log("Message from web" +wait);
			Thread.sleep(10000);
			String ready=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/h2")).getText();
			System.out.println(ready);
			Reporter.log("Message from web" +ready);
			getScreenShot("Account Ready");
			
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/p/a")).click();
			Thread.sleep(4000);
			
			Reporter.log("User logged in successfully into AssessTeam");
			
			
			driver.findElement(By.xpath("//a[@class='introjs-button introjs-skipbutton']")).click();
			Reporter.log("Navigated to Dashboard");
			getScreenShot("AssessTeam");
			//driver.close();
			driver.quit();
			
			
					
			
			
		 
		}
}
