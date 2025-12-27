package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class editresultArea {
	
	public WebDriver driver;
	
	By searchresultarea=By.xpath("//*[@id=\"select2-chosen-5\"]");
	By enterSearchresult=By.xpath("//*[@id=\"s2id_autogen5_search\"]");
	By includebutton=By.xpath("//*[@id=\"frmEditResultAreaForPerson\"]/h4/div/span/button");
	By savebutton=By.xpath("//*[@id=\"btnEditPersonResultArea\"]");
	By resultareas=By.xpath("//*[@id=\"divSearch\"]/div[2]/div[1]/div/div[1]/ul/li[2]/a");

	public editresultArea(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public WebElement getsearchresultarea()
	{
		return driver.findElement(searchresultarea);
		
	}

	public WebElement getenterSearchresult()
	{
		return driver.findElement(enterSearchresult);
		
	}

	public WebElement getincludebutton()
	{
		return driver.findElement(includebutton);
		
	}
	
	public WebElement getsavebutton()
	{
		return driver.findElement(savebutton);
		
	}
	//
	public WebElement getresultareas()
	{
		return driver.findElement(resultareas);
		
	}



	}




