package oneClick.oneClickTDD;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReportNG 
{
	static ExtentReports extent;
	 static DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
	    static Date date = new Date(); 
	public static ExtentReports getReportObject()
	{
	//String path =System.getProperty("user.dir")+"\\Resources\\index.html";
		String path = System.getProperty("user.dir")+"\\reports\\"+dateFormat.format(date)+".html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("OneClick Automation Results");
	reporter.config().setDocumentTitle("OneClick");
	reporter.config().setTheme(Theme.DARK);
	
	 extent =new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("QA", "Nikhil Sharma");
	extent.setSystemInfo("Environment", "Development");
	extent.setSystemInfo("OS", "Windows");
	extent.setSystemInfo("Windows Version", "Windows 10");
	return extent;
	}
	
}
