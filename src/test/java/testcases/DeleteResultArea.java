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
import pageObjects.deleteperson;
import pageObjects.deleteresultarea;
import pageObjects.login;
import resources.base;


public class DeleteResultArea extends base {
	private static final String DeleteResultAreaValue = null;
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
		 		Reporter.log("User is successfully login");
		 		
		 		
			}
	 @Test(priority=2, dataProvider= "DeleteResultAreaValue")
	 public void c_DeleteResult(String Resultarea) throws InterruptedException
	 {
		 deleteresultarea dra= new deleteresultarea(driver);
		 dra.getresulttab().click();// Result tab is being clicked
		 Reporter.log("Result tab is being clicked");
		 
		 dra.getsearcharea().click();
		 dra.getsearcharea().sendKeys(Resultarea);// result area is being sent from dataprovider
		 Reporter.log("The result which will be deleted is:" +Resultarea);
		 
		 Thread.sleep(5000);
		 
		 dra.getdelete().click();
		 Thread.sleep(2000);
		 
		 dra.getconfirmdelete().click();
		 Thread.sleep(2000);
		 
		 getScreenShot("deleted successfully");
		 
		 Reporter.log("The no of record/s deleted:" +loop);
		 System.out.println("The no of record/s deleted:" +loop);
		 loop++;
	 		
	 }
	 
	 @DataProvider
	 public static Object[][] DeleteResultAreaValue() throws IOException
	 {
	 FileInputStream fileInputStream= new FileInputStream("C:\\Users\\pulse.tester\\Documents\\AssessTeam\\TestData.xlsx"); //Excel sheet file location get mentioned here
	     workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
	     worksheet=workbook.getSheet("deleteresultarea");// get my sheet from workbook
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
	 }
	
	

}
