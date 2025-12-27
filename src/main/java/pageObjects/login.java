package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class login {
	public WebDriver driver;
	
By username=By.xpath("//*[@id=\"Item1_stEmail\"]");
By password=By.xpath("//*[@id=\"Item1_stPassword\"]");
By loginButton=By.xpath("//button[@title='Login']");

public login(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
}


public WebElement getUserName()
{
	return driver.findElement(username);
	
}

public WebElement getPassword()
{
	return driver.findElement(password);
	
}

public WebElement ClickLogin()
{
	return driver.findElement(loginButton);
	
}


}

