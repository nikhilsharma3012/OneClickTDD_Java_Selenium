package oneClick.oneClickTDD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class loginPage 
{
	 WebDriver driver;
	 DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
	    Date date = new Date(); 
	
	public loginPage(WebDriver driver)
	{
		
		this.driver=driver;
		
	}
	
	public void loginPageCalling() throws IOException, InterruptedException
	{
		
	Properties pro = new Properties();
	FileInputStream fis = new FileInputStream("Resources/testdata.properties");
	pro.load(fis);
	
	String emailID = pro.getProperty("email");
	String passkey = pro.getProperty("password");
	
	loginPageElements lg = new loginPageElements(driver);
	
	Thread.sleep(2000);
	lg.EmailID().sendKeys(emailID);
	
	Thread.sleep(2000);
	lg.PassWord().sendKeys(passkey);
	
	Thread.sleep(3000);
	File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(s, new File("oneClick SignIn"+dateFormat.format(date)+".png"));
	
	
	

	}
	
	public void verifyLoginPageTitle() throws IOException, InterruptedException
	{
		
		loginPageElements lg = new loginPageElements(driver);
		String actualTitle = lg.loginPageTitle().getText();
		System.out.println("Actual Login Page Title : "+actualTitle); 
		
		Assert.assertEquals(actualTitle, "Log in to get start");
	}
	
	
	public void submitLoginPage() throws IOException, InterruptedException
	{
		
		loginPageElements lg = new loginPageElements(driver);
		Thread.sleep(2000);		
		lg.Submit().click();
		
	}
	
	public void resetbuttonLoginPage() throws IOException, InterruptedException
	{
		
		loginPageElements lg = new loginPageElements(driver);
		Thread.sleep(2000);		
		lg.resetbutton().click();
		
	}

	
	public void signOut() throws InterruptedException
	{
		loginPageElements lg = new loginPageElements(driver);
		Thread.sleep(2000);
		
		lg.signOutDropDown().click();
		Thread.sleep(2000);
		lg.signout().click();
	}

	public void forgotPassword() throws InterruptedException, IOException
	{
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream("Resources/testdata.properties");
		pro.load(fis);
		String emailID = pro.getProperty("email");
		
		loginPageElements lg = new loginPageElements(driver);
		Thread.sleep(2000);
		
		lg.forgetPass().click();
		Thread.sleep(2000);
		lg.EmailID().sendKeys(emailID);
		lg.forgetPassSend().click();
		
	}
	
	
	
}
//Assert.assertEquals(we.sourceSiteValid().getText(), "Source Site is required.");