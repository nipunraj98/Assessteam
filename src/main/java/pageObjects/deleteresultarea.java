package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class deleteresultarea {
	
	public WebDriver driver;
	By resulttab=By.xpath("//*[@id=\"A1\"]");
	By searcharea=By.xpath("//*[@id=\"txtSrc\"]");
	By search=By.xpath("//*[@id=\"divSearch\"]/div[2]/div/div/div[3]/div[1]/div/div/button");
	By delete=By.xpath("//*[@id=\"tdAction\"]/a[3]");
	By confirmdelete=By.xpath("//*[@id=\"divResultAreaDelete\"]/div[2]/button[1]");

	public deleteresultarea(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public WebElement getresulttab()
	{
		return driver.findElement(resulttab);
		
	}

	public WebElement getsearcharea()
	{
		return driver.findElement(searcharea);
		
	}

	public WebElement getsearch()
	{
		return driver.findElement(search);
		
	}
	
	public WebElement getdelete()
	{
		return driver.findElement(delete);
		
	}
	
	public WebElement getconfirmdelete()
	{
		return driver.findElement(confirmdelete);
		
	}


	}




