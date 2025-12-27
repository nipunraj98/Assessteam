package resources;



	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
	import org.testng.annotations.AfterTest;

	import io.github.bonigarcia.wdm.WebDriverManager;


	public class base {
		
		public static WebDriver driver;
		public static Properties prop;
		
		
		
		public WebDriver InitializeBrowser() throws IOException {
			
			prop= new Properties();
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//data.properties");
			prop.load(fis);
			String browserName=prop.getProperty("browser");
			System.out.println("browser");
			if(browserName.equals("chrome"))
			{
				System.out.println("Chrome selected");
				//System.setProperty("webdriver.chrome.driver","C:\\Users\\nisha.prakash\\CallOutOrder\\src\\main\\java\\WebDrivers\\chromedriver.exe");
			   // WebDriverManager.chromedriver().setup();
				//driver=new ChromeDriver();
				String downloadFilepath="D:\\downloads";
				//System.setProperty("webdriver.chrome.driver","C:\\Users\\pulse.tester\\Downloads\\chromedriver_win32\\chromedriver.exe");
				 HashMap<String, Object> chromePrefs = new HashMap<String, Object>();  
				 chromePrefs.put("profile.default_content_settings.popups", 0);  
				 chromePrefs.put("download.default_directory", downloadFilepath);  
				 chromePrefs.put("credentials_enable_service", false);
				 chromePrefs.put("profile.password_manager_enabled", false);
				 //--allow-file-access
				 ChromeOptions options = new ChromeOptions();  
				 options.setExperimentalOption("prefs", chromePrefs);  
				 options.addArguments("--disable-notifications"); 
				 options.addArguments("disable-infobars");
				 options.addArguments("--allow-file-access-from-files");
				 options.setExperimentalOption("useAutomationExtension", false);
				 options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));    
				 DesiredCapabilities cap = DesiredCapabilities.chrome();  
				 cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);  
				 cap.setCapability(ChromeOptions.CAPABILITY, options);  
				  WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver(options); 
			}
			else if(browserName.equals("firefox"))
			{
				driver= new FirefoxDriver();
				
			}
			
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
		
			
			return driver;
			
			
		}
		
		public void getScreenShot(String Name)
	    {
	    	Calendar calendar = Calendar.getInstance();
	    	SimpleDateFormat formater  = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
	    	
	    	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	try
	    	{
	    		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+ "/src/main/java/ScreenShotSuccess/";
	    	    File destFile = new File((String) reportDirectory + Name +" "+ formater.format(calendar.getTime())+ ".png");    	
	           // FileUtils.copyFile(scrFile, destFile);
	    	    FileHandler.copy(scrFile, destFile);
	            Reporter.log("<a herf='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height='100' Width='100'/></a>");
	        }        
	     	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	
	    }
		public long getLatestFilefromDir(String dirPath){
		    File dir = new File(dirPath);
		    File[] files = dir.listFiles();
		    if (files == null || files.length == 0) {
		        return (Long) null;
		    }
		
		    File lastModifiedFile = files[0];
		    for (int i = 1; i < files.length; i++) {
		       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
		           lastModifiedFile = files[i];
		       }
		    }
		   
		    return lastModifiedFile.length();
		    
		}
		
		public String getLatestFilePathfromDir(String dirPath){
		    File dir = new File(dirPath);
		    File[] files = dir.listFiles();
		    if (files == null || files.length == 0) {
		        return (String) null;
		    }
		
		    File lastModifiedFile = files[0];
		    for (int i = 1; i < files.length; i++) {
		       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
		           lastModifiedFile = files[i];
		          // Long lastModifiedFileLength=lastModifiedFile.length();
		       }
		    }
		    Long lastModifiedFileLength=lastModifiedFile.length();
		   
		    return lastModifiedFile.getAbsolutePath();
		    
		}
		
		public static void setDate(WebDriver driver, String value, WebElement calLocator)
		{
			JavascriptExecutor jse= (JavascriptExecutor)driver;
			String script= "arguments[0].setAttribute('value','"+value+"');";
			jse.executeScript(script, calLocator);
		}
		
		public static void clickElement(WebDriver driver, WebElement calLocator)
		{
			JavascriptExecutor jse= (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView();", calLocator);
			calLocator.click();
		}
		
		public static void OnclickElement(WebDriver driver, WebElement calLocator)
		{
			JavascriptExecutor jse= (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", calLocator);
			calLocator.click();
		}
		
		public static void handleAlert() throws InterruptedException{
		    if(isAlertPresent()==true){
		    	
		        driver.findElement(By.xpath("//button[@class='update_profile']")).click();
		        
		    }
		}
		public static boolean isAlertPresent() throws InterruptedException{
			Thread.sleep(3000);
		     
		    	  if(driver.findElements(By.xpath("//button[@class='update_profile']")).size()!= 0) {
		    		  
		    		  return true;
		    		  
		    	  }
		    	  else {
		    		  
		    	  return false;
		    	  }
		    	  }
		
		
		
		@AfterTest
		public void Teardown()
		{
			//driver.close();
		}

}