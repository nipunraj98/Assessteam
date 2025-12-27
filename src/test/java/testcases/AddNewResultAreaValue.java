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
import pageObjects.addResultAreaValue;
import pageObjects.login;
import pageObjects.resultArea;
import resources.base;

public class AddNewResultAreaValue extends base{
	
	private static final String SeleniumTesting = null;
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
				driver.get("https://han9106.assessteam.com/");
				//Reporter.log(prop.getProperty("url"));
				//Reporter.log("Url is being hit");
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				Reporter.log("HomePage Navigation done");
			
				getScreenShot("Homepage");
				
			}
	 @Test(priority=1)
		
		public void b_LoginAssess() throws IOException, InterruptedException
			{
		 		login l=new login(driver);
		 		l.getUserName().sendKeys("monil.merai+es1@pulsesolutions.net");
		 		Reporter.log("username entered");
		 		l.getPassword().sendKeys("123456");
		 		Reporter.log("password entered");
		 		Thread.sleep(2000);
		 		
		 		driver.findElement(By.xpath("//button[@title='Login']")).click();
		 		
		 		Thread.sleep(2000);
		 		getScreenShot("AfterLoginPage");
		 		
		 		
			}
	// @Test(priority=2,dataProvider = "ResultAreaValue")
	
		@Test(priority=2)
		
		public void c_AddResultAreaValue() throws IOException, InterruptedException
			{
		 		addResultAreaValue arav= new addResultAreaValue(driver);
		 		Thread.sleep(4000);
		 		arav.getresultarea().click();//clicking Person tab
		 		
		 		Thread.sleep(2000);
		 		Reporter.log("The ResultArea tab is clicked");
		 		getScreenShot("ResultArea");
		 		arav.getaddresultarea().click();
		 		
		 		Reporter.log("Add a new Result is now being Clicked");
		 		Thread.sleep(2000);
		 		getScreenShot("AddResultAreaPage");
		 		
		 		arav.getresultareaname().click();//sending resultarea Name
		 		arav.getresultareaname().sendKeys("SeleniumTesting");//sending result areaa name
		 		Reporter.log("The resultarea name newly added is:" + "SeleniumTesting");
		 		
		 		arav.getjobtitle().click();//clicking select job title
		 		arav.getjobtitle().sendKeys("SeleniumTester");
		 		Thread.sleep(2000);
		 		arav.getjobtitleresult().click();
		 		Reporter.log("The job title selected is:" + "SeleniumTester");
		 		
		 		
		 		arav.getresultareatype().click();
		 		arav.getresultareatype().sendKeys("skills");//sending result area type
		 		Reporter.log("The result area type added is: " +"skills");
		 		
		 		arav.getdescription().click();
		 		arav.getdescription().sendKeys("This is for testing purpose for Automation" + 
		 				"");//sending description
		 		Reporter.log("The added new description is: " +"This is for testing purpose for Automation");
		 		
		 		arav.getsetupPI().click();
		 		
		 		Thread.sleep(2000);
		 		getScreenShot("Resultarea added");
		 		
		 		
		 		
		 		
		 		/*Reporter.log("The no of result areas added:" +loop);
		 		System.out.println("The no of persons added with result areas:" +loop);
		 		loop++;*/
		 		
		}
		
@Test(priority=3)
		
		public void d_AddPI() throws IOException, InterruptedException
			{
	
				Thread.sleep(4000);
				Reporter.log("Add Performance indicators page is being opened");
				driver.findElement(By.xpath("//input[@name='stPerformanceIndicatorsName']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@name='stPerformanceIndicatorsName']")).sendKeys("testing");
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//select[@id='ddlResultAreaScale']")).click();
				Select Scale=new Select(driver.findElement(By.xpath("//select[@id='ddlResultAreaScale']")));
				Scale.selectByVisibleText("4 point value scale");
				Reporter.log("4 point value scale is being selected");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@name='Save']")).click();
				Reporter.log("Performance indicator is being saved");
				
				
		 		
			}
	 
	/* @DataProvider
	 public static Object[][] ResultAreaValue() throws IOException
	 {
	 FileInputStream fileInputStream= new FileInputStream("C:\\Users\\pulse.tester\\Documents\\AssessTeam\\TestData.xlsx"); //Excel sheet file location get mentioned here
	     workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
	     worksheet=workbook.getSheet("AddResultArea");// get my sheet from workbook
	     XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
	  
	     int RowNum = worksheet.getLastRowNum();
	     System.out.println("The no of sets of data=" +RowNum);// count my number of Rows
	     int ColNum= Row.getLastCellNum(); // get last ColNum 
	     System.out.println(ColNum);
	      
	     Object Data[][]= new Object[RowNum][ColNum]; // pass my  count data in array
	      
	         for(int i=0; i<RowNum; i++) //Loop work for Rows
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
	 }*/
}
