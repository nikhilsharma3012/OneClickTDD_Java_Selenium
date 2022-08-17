package oneClick.oneClickTDD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverInitialization 
{
	public WebDriver driver;
	
	public void URL() throws IOException
	{
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream("Resources/testdata.properties");
		pro.load(fis);
		String website = pro.getProperty("URL");
		driver.get(website);
	}
	
	public WebDriver browserIntializer() throws IOException, InterruptedException
	{
		
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream("Resources/testdata.properties");
		pro.load(fis);
		
		String browserName=pro.getProperty("browser");
		String website = pro.getProperty("URL");
		
		
		if(browserName.equals("chrome") )
		{
			
			System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
			driver = new ChromeDriver();
			
			
		}
		else
		{
			
			System.setProperty("webdriver.gecko.driver", "Resources/geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		Thread.sleep(2000);
		URL();
		
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}

}
