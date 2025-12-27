package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class deleteperson {
	
	public WebDriver driver;
	
	By editicon=By.xpath("//*[@id=\"tdAction\"]/a[1]");
	By delete=By.xpath("//*[@id=\"frmEditPerson\"]/div[11]/div[3]/div/a[2]");
	By confirmdelete=By.xpath("//*[@id=\"divSearch\"]/div[2]/div/div/div/div[4]/div/a[1]");

	public deleteperson(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public WebElement getediticon()
	{
		return driver.findElement(editicon);
		
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




