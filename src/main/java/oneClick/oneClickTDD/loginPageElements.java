package oneClick.oneClickTDD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPageElements 
{

WebDriver driver;
	
	public loginPageElements(WebDriver driver)
	{
		
		this.driver=driver;
		
	}
	
	
	By emailPath = By.xpath("//*[@placeholder='Email Address']");
	By passWord =  By.xpath("//*[@placeholder='Password']");
	By submitbutton = By.xpath("//*[contains(text(),'Log In')]");
	
	By loginPageTitle = By.xpath("//*[contains(text(),'Log in to get')]");
	
	By resetbutton = By.xpath("//*[@value='Reset']");
	By signOutDropDown = By.xpath("//*[@data-toggle=\"dropdown\"]");
	
	By signout = By.xpath("//*[contains(text(),'Sign out')]");
	
	By forgetPass = By.xpath("//*[contains(text(),'Forgot')]");
	By forgetPassSend = By.xpath("//*[contains(text(),'Send')]");
	
	
	public WebElement EmailID()
	{
		
		return driver.findElement(emailPath);
		
	}
	
	public WebElement PassWord()
	{
		
		return driver.findElement(passWord);
		
	}

	public WebElement Submit()
	{
		
		return driver.findElement(submitbutton);
		
	}
	

	public WebElement loginPageTitle()
	{
		
		return driver.findElement(loginPageTitle);
		
	}
	
	public WebElement resetbutton()
	{
		
		return driver.findElement(resetbutton);
		
	}
	
	public WebElement signOutDropDown()
	{
		
		return driver.findElement(signOutDropDown);
		
	}
	
	public WebElement signout()
	{
		
		return driver.findElement(signout);
		
	}
	
	public WebElement forgetPass()
	{
		
		return driver.findElement(forgetPass);
		
	}
	
	public WebElement forgetPassSend()
	{
		
		return driver.findElement(forgetPassSend);
		
	}
}
