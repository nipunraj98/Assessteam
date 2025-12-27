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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.Addperson;
import pageObjects.login;
import resources.base;

public class AddPersonManually extends base{
	
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
		 		sheet=workbook.getSheet("ADDPersonManually");
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
			
			public void c_AddPerson() throws IOException, InterruptedException
				{
			 FileInputStream fisexcel= new FileInputStream(src);
		 		workbook= new XSSFWorkbook(fisexcel);
		 		sheet=workbook.getSheet("ADDPersonManually");
		 		//formatter.formatCellValue(cell);
		 		String FirstName=sheet.getRow(1).getCell(2).getStringCellValue();
		 		String LastName=sheet.getRow(1).getCell(3).getStringCellValue();
		 		String PersonCode=formatter.formatCellValue(sheet.getRow(1).getCell(4));
		 		String DOJ=formatter.formatCellValue(sheet.getRow(1).getCell(5));
		 		String Email=formatter.formatCellValue(sheet.getRow(1).getCell(6));
		 		String ContactNumber=formatter.formatCellValue(sheet.getRow(1).getCell(7));
		 		String HourlyPayRate=formatter.formatCellValue(sheet.getRow(1).getCell(8));
		 		String Evaluator1=formatter.formatCellValue(sheet.getRow(1).getCell(9));
		 		String PeerGroup=formatter.formatCellValue(sheet.getRow(1).getCell(10));
		 		String Team=formatter.formatCellValue(sheet.getRow(1).getCell(11));
		 		String JobTitle=formatter.formatCellValue(sheet.getRow(1).getCell(12));
		 		
			 Addperson AP= new Addperson(driver);
		 		Thread.sleep(2000);
		 		AP.getperson().click();//clicking Person tab
		 		
		 		Thread.sleep(2000);
		 		Reporter.log("The Persons tab is clicked");
		 		//getScreenShot("PersonTab");
		 		AP.getaddperson().click();
		 		
		 		Reporter.log("Add a new Person is now being Clicked");
		 		Thread.sleep(2000);
		 		//getScreenShot("AddPersonpage");
		 		
		 		String Caption=driver.findElement(By.xpath("//*[@id=\"divSearch\"]/div[2]/div[1]/div/div[1]/div")).getText();
		 		System.out.println(Caption);
		 		
		 		Thread.sleep(2000);
		 		String Captions=driver.findElement(By.xpath("//*[@id=\"divSearch\"]/div[1]/ul")).getText();
		 		System.out.println(Captions);
		 		
		 		WebElement Element=driver.findElement(By.xpath("//*[@id=\"loPersonViewModel_stFirstName\"]"));
		 		OnclickElement(driver,Element);
		 		
		 		//Actions actions = new Actions(driver);
		 		//WebElement elementLocator = driver.findElement(By.id("ID"));
		 		//actions.doubleClick(Element).perform();
		 		AP.getfirstname().sendKeys(FirstName);//sending first name
		 		
		 		OnclickElement(driver,AP.getlastname());
		 		//AP.getlastname().click();    
		 		AP.getlastname().sendKeys(LastName);
		 	
		 		
		 		AP.getpersoncode().clear();
		 		AP.getpersoncode().click();
		 		AP.getpersoncode().sendKeys(PersonCode);
		 		
		 		AP.getdateofjoining().click();
		 		AP.getdateofjoining().clear();
		 		AP.getdateofjoining().sendKeys(DOJ);
		 		AP.getdateofjoining().clear();
		 		AP.getdateofjoining().sendKeys(DOJ);
		 		
		 		
		 		AP.getemail().click();
		 		AP.getemail().sendKeys(Email);
		 		AP.getcontactnumber().click();
		 		AP.getcontactnumber().sendKeys(ContactNumber);
		 		
		 		driver.findElement(By.xpath("//span[@id='select2-chosen-5']")).click();
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//input[@id='s2id_autogen5_search']")).click();
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//input[@id='s2id_autogen5_search']")).sendKeys("SeleniumTester");
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("(//span[@class='select2-match'])")).click();
		 		Thread.sleep(2000);
		 		
		 		
		 		//AP.gethourlypayrate().click();
		 		//AP.gethourlypayrate().sendKeys(HourlyPayRate);
		 		AP.getevaluator().click();
		 		AP.getevaluator().sendKeys(Evaluator1);
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//span[@class='select2-match']")).click();
		 		Thread.sleep(2000);
		 		//AP.getevaluator().sendKeys(Evaluator2);
		 		//Thread.sleep(2000);
		 		//driver.findElement(By.xpath("//span[@class='select2-match']")).click();
		 		Thread.sleep(2000);
		 		
		 		
				/*JavascriptExecutor jsePeerGroubTab= (JavascriptExecutor)driver;
				jsePeerGroubTab.executeScript("arguments[0].scrollIntoView();", AP.getpeergrouptab());
				AP.getpeergrouptab().click();
		 	
		 		Select pg=new Select(AP.getpeergrouptab());
		 		pg.selectByVisibleText(PeerGroup);
		 		Thread.sleep(2000);
		 		
		 		AP.getteam().click();
		 		driver.findElement(By.xpath("//*[@id=\"s2id_autogen2_search\"]")).sendKeys(Team);
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//span[@class='select2-match']")).click();
		 		
		 		AP.getjobtitle().click();
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//*[@id=\"s2id_autogen3_search\"]")).sendKeys(JobTitle);
		 		Thread.sleep(3000);
		 		driver.findElement(By.xpath("//span[@class='select2-match']")).click();
		 		Thread.sleep(4000);*/
		 		
		 		AP.clicksave().click();
		 		Reporter.log("The person added");
		 		System.out.println("The no of persons added:" +loop);
		 		Thread.sleep(2000);
		 		//getScreenShot("Person added");
				}
		 
		 @Test(priority=3)
			
			public void d_mailClick() throws IOException, InterruptedException
			{
			 driver.get("https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/");
			 Reporter.log("Gmail is being opened");
			 FileInputStream fisexcel= new FileInputStream(src);
		 		workbook= new XSSFWorkbook(fisexcel);
		 		sheet=workbook.getSheet("ADDPersonManually");
		 		
		 		//driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a")).click();
		 		
		 		
		 		String emailId=sheet.getRow(1).getCell(13).getStringCellValue();
		 		String pwd=sheet.getRow(1).getCell(14).getStringCellValue();
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
		 		//getScreenShot("Gmail logged in");
		 		
		 		
		 		
		 		
			}
		 
		 @Test(priority=4)
			
			public void e_AssessMailClick() throws IOException, InterruptedException
			{
			 Thread.sleep(2000);
			 
		driver.findElement(By.xpath("//tr[@jscontroller='ZdOxDb']")).click();
			// OnclickElement(driver,Firstmail);
			 Thread.sleep(2000);
			 
			 Reporter.log("mail from AssessTeam is being clicked");
			// getScreenShot("AssessTeam Mail");
			 //driver.findElement(By.xpath("//*[@id=\":pv\"]")).click();
			 Thread.sleep(2000);
			// driver.findElement(By.xpath("//*[@id=\":oa\"]/div[1]/p/a")).click();
			 
			 ////*[@id=":nc"]/div[1]/p/a
			 driver.findElement(By.xpath(" //u[contains(text(),'Click here to get started')]  ")).click();
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
				
				//String wait=driver.findElement(By.xpath("//*[@id=\"wait\"]")).getText();
				//System.out.println(wait);
				//Reporter.log("Message from web" +wait);
				
				driver.findElement(By.xpath("//*[@id=\"txtNewPassword\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"txtNewPassword\"]")).sendKeys("123456");
				
				driver.findElement(By.xpath("//*[@id=\"txtConfirmNewPassword\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"txtConfirmNewPassword\"]")).sendKeys("123456");
				
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				
				Thread.sleep(2000);
				
				
				Reporter.log("User logged in successfully into AssessTeam");
				
				
				
				//getScreenShot("AssessTeam");
				Thread.sleep(2000);
				//driver.findElement(By.xpath("/html/body/div[10]/div/div[5]/a[1]")).click();// skip message pop up
				
				Thread.sleep(2000);
				
				//getScreenShot("AfterLogin");
				
				//driver.close();
				
				driver.quit();
				
				
						
				
				
			 
			}
		 


	}



