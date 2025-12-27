package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPerson {
	public WebDriver driver;
	
By personcode=By.xpath("//*[@id=\"txtPersonCode\"]");
By search=By.xpath("//*[@id=\"btnSearch\"]");
By editIcon=By.xpath("//*[@id=\"tdAction\"]/a[1]");

public SearchPerson(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
}


public WebElement getpersoncode()
{
	return driver.findElement(personcode);
	
}

public WebElement getsearch()
{
	return driver.findElement(search);
	
}

public WebElement ClickeditIcon()
{
	return driver.findElement(editIcon);
	
}


}

