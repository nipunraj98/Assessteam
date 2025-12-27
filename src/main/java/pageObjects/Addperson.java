package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Addperson {
	public WebDriver driver;
	
By person=By.xpath("//a[@id='M4']");
By addperson=By.xpath("//*[@id=\"divSearch\"]/div[2]/div/div/div[1]/div[2]/a[1]");
By firstname=By.xpath("//*[@id=\"loPersonViewModel_stFirstName\"]");
By lastname=By.xpath("//*[@id=\"loPersonViewModel_stLastName\"]");
By personcode=By.xpath("//*[@id=\"loPersonViewModel_stPersonCode\"]");
By dateofjoining=By.xpath("//*[@id=\"txtDateJoin\"]");
By email=By.xpath("//*[@id=\"loPersonViewModel_stEmail\"]");
By contactnumber=By.xpath("//*[@id=\"loPersonViewModel_stContactNumber\"]");
By hourlypayrate=By.xpath("//*[@id=\"txtManHoursrate\"]");
By evaluator=By.xpath("//*[@id=\"s2id_autogen1\"]");
By peergrouptab=By.xpath("//*[@id=\"loPersonViewModel_inPersonDesignationLevelID\"]");
By team=By.xpath("//*[@id=\"select2-chosen-2\"]");
By jobtitle=By.xpath("//*[@id=\"select2-chosen-3\"]");
By save=By.xpath("//*[@id=\"btnAddPersonSetupKRALater\"]"); 
By setUpResultAreas=By.xpath("//*[@id=\"btnAddPerson\"]");


public Addperson(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
}

public WebElement getperson()
{
	return driver.findElement(person);
	
}

public WebElement getaddperson()
{
	return driver.findElement(addperson);
	
}


public WebElement getfirstname()
{
	return driver.findElement(firstname);
	
}

public WebElement getlastname()
{
	return driver.findElement(lastname);
	
}

public WebElement getpersoncode()
{
	return driver.findElement(personcode);
	
}
public WebElement getdateofjoining()
{
	return driver.findElement(dateofjoining);
	
}
public WebElement getemail()
{
	return driver.findElement(email);
	
}
public WebElement getcontactnumber()
{
	return driver.findElement(contactnumber);
	
}
public WebElement gethourlypayrate()
{
	return driver.findElement(hourlypayrate);
	
}
public WebElement getevaluator()
{
	return driver.findElement(evaluator);
	
}
public WebElement getpeergrouptab()
{
	return driver.findElement(peergrouptab);
	
}
public WebElement getteam()
{
	return driver.findElement(team);
	
}

public WebElement getjobtitle()
{
	return driver.findElement(jobtitle);
	
}

public WebElement clicksave()
{
	return driver.findElement(save);
	
}

public WebElement clickresultarea()
{
	return driver.findElement(setUpResultAreas);
	
}
}


