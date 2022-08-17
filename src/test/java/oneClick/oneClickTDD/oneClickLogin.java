package oneClick.oneClickTDD;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import oneClick.oneClickTDD.driverInitialization;




public class oneClickLogin extends driverInitialization 
{
	public WebDriver driver;
	
	@BeforeTest
	public void drivercalling() throws Exception
	{
		driver=browserIntializer();
		driver.manage().window().maximize();
		
		
	}
	
	@Test (priority=1)
	public void loginOneClick() throws Exception
	{
		loginPage lg = new loginPage(driver);
		lg.loginPageCalling();
		lg.submitLoginPage();
		lg.signOut();
		
	}
	
	@Test (priority=2)
	public void verifyLoginPageTitle() throws Exception
	{
		URL();
		loginPage lg = new loginPage(driver);
		lg.verifyLoginPageTitle();
		
	}
	
	@Test (priority=3)
	public void resetLoginPage() throws Exception
	{
		URL();
		loginPage lg = new loginPage(driver);
		lg.loginPageCalling();
		lg.resetbuttonLoginPage();
		
	}
	
	@Test (priority=4)
	public void forgetPassword() throws Exception
	{
		URL();
		loginPage lg = new loginPage(driver);
		
		lg.forgotPassword();
	}
	
	@AfterTest
	public void driverQuit() throws InterruptedException
	{
		Thread.sleep(6000);
		driver.close();
		driver.quit();
	}
	
	

}
