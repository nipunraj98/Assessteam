package testcases;

import java.io.FileInputStream;
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

import pageObjects.Addperson;
import pageObjects.login;
import resources.base;

public class AddPerson extends base{
	
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
	 @Test(priority=2,dataProvider = "TestData")
	
		
		public void c_AddPeople(String FirstName, String LastName, String PersonCode, String DOJ, String Email, String ContactNumber, String HourlyPayRate, String Evaluator1, String Evaluator2, String PeerGroup, String Team, String JobTitle) throws IOException, InterruptedException
			{
		 		Addperson AP= new Addperson(driver);
		 		Thread.sleep(4000);
		 		AP.getperson().click();//clicking Person tab
		 		
		 		Thread.sleep(2000);
		 		Reporter.log("The Persons tab is clicked");
		 		getScreenShot("PersonTab");
		 		AP.getaddperson().click();
		 		
		 		Reporter.log("Add a new Person is now being Clicked");
		 		Thread.sleep(2000);
		 		getScreenShot("AddPersonpage");
		 		
		 		AP.getfirstname().click();
		 		AP.getfirstname().sendKeys(FirstName);//sending first name
		 		
		 	
		 		AP.getlastname().click();
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
		 		AP.gethourlypayrate().click();
		 		AP.gethourlypayrate().sendKeys(HourlyPayRate);
		 		AP.getevaluator().click();
		 		AP.getevaluator().sendKeys(Evaluator1);
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//span[@class='select2-match']")).click();
		 		Thread.sleep(3000);
		 		AP.getevaluator().sendKeys(Evaluator2);
		 		Thread.sleep(2000);
		 		driver.findElement(By.xpath("//span[@class='select2-match']")).click();
		 		Thread.sleep(3000);
		 		
		 		
				JavascriptExecutor jsePeerGroubTab= (JavascriptExecutor)driver;
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
		 		Thread.sleep(4000);
		 		
		 		AP.clicksave().click();
		 		Reporter.log("The no of persons added:" +loop);
		 		System.out.println("The no of persons added:" +loop);
		 		loop++;
		 		
		}
	 
	 @DataProvider
	 public static Object[][] TestData() throws IOException
	 {
	 FileInputStream fileInputStream= new FileInputStream("C:\\Users\\pulse.tester\\Documents\\AssessTeam\\TestData.xlsx"); //Excel sheet file location get mentioned here
	     workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
	     worksheet=workbook.getSheet("AddPerson");// get my sheet from workbook
	     XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
	  
	     int RowNum = worksheet.getLastRowNum();
	     System.out.println("The no of sets of data=" +RowNum);// count my number of Rows
	     int ColNum= Row.getLastCellNum(); // get last ColNum 
	     System.out.println(ColNum);
	      
	     Object Data[][]= new Object[RowNum][ColNum]; // pass my  count data in array
	      
	         for(int i=0; i<RowNum-1; i++) //Loop work for Rows
	         {  
	             XSSFRow row= worksheet.getRow(i+1);
	              
	             for (int j=0; j<ColNum; j++) //Loop work for colNum
	             {
	                 if(row==null)
	                     Data[i][j]= "";
	                 else
	                 {
	                     XSSFCell cell= row.getCell(j);
	                     if(cell==null)
	                         Data[i][j]= ""; //if it get Null value it pass no data 
	                     else
	                     {
	                     	
	                        // String value=String.formatCellValue(cell);
	                     	String value=formatter.formatCellValue(cell);
	                         Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
	                     }
	                 }
	             }
	         }

	     return Data;
	 }
}
