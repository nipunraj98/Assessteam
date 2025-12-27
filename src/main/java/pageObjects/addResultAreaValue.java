package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addResultAreaValue {
	public WebDriver driver;
	
By resultarea=By.xpath("//*[@id=\"A1\"]");
By addresultarea=By.xpath("//*[@id=\"divSearch\"]/div[2]/div/div/div[1]/div[2]/a");
By resultareaname=By.xpath("//*[@id=\"txtResultArea\"]");
By jobtitle=By.xpath("//input[@id='s2id_autogen1']");
By jobtitleresult=By.xpath("//span[@class='select2-match']");
By resultareatype=By.xpath("//*[@id=\"txtJobType\"]");
By description=By.xpath("//*[@id=\"txtDescription\"]");
By setupPI=By.xpath("//*[@id=\"btnSave\"]");



public addResultAreaValue(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
}

public WebElement getresultarea()
{
	return driver.findElement(resultarea);
	
}

public WebElement getaddresultarea()
{
	return driver.findElement(addresultarea);
	
}


public WebElement getresultareaname()
{
	return driver.findElement(resultareaname);
	
}

public WebElement getjobtitle()
{
	return driver.findElement(jobtitle);
	
}

public WebElement getresultareatype()
{
	return driver.findElement(resultareatype);
	
}
public WebElement getdescription()
{
	return driver.findElement(description);
	
}
public WebElement getsetupPI()
{
	return driver.findElement(setupPI);
	
}

public WebElement getjobtitleresult()
{
	return driver.findElement(jobtitleresult);
	
}

}


