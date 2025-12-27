package testcases;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcases.ExcelApiTest;
 
public class datadriven extends ExcelApiTest {
     
    String xlFilePath = "C:\\Users\\pulse.tester\\Documents\\AssessTeam\\TestData.xlsx";
    String sheetName = "Sheet1";
    ExcelApiTest eat = null;
    
     
    @Test(dataProvider = "ReadVariant")
    public void AddVariants(String FirstName, String LastName, String PersonCode, String DOJ, String Email) throws Exception
	{
	//Data will set in Excel sheet once one parameter will get from excel sheet to Respective locator position.
	
	System.out.println("First Name:" +FirstName);
	System.out.println("Last Name:" +LastName);
	System.out.println("Employee code:" +PersonCode);
	System.out.println("Date of Joining:" +DOJ);
	System.out.println("Email Address:" +Email);
}
     
   
     
   
}


