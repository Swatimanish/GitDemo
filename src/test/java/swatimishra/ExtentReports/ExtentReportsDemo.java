package swatimishra.ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {

	ExtentReports extent;
	
	@BeforeTest()
	public void config()
	{
		//ExtentReports, ExtentSparkReporter
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Test Result");
		reporter.config().setDocumentTitle("Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Swati Mishra");
	}
	@Test
	public void initialDemo()
	{
		ExtentTest test=extent.createTest("Initial demo"); //creation of a test case
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		//test.addScreenCaptureFromBase64String(outcome);
		extent.flush(); // necessary to flush to end listning report, it will update the status pass or fail 
		
	}
	
	@Test
	public void testlink()
	{
		ExtentTest test=extent.createTest("Check icon");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		Boolean visible=driver.findElement(By.cssSelector(".social-icon-one")).isEnabled();
		Assert.assertTrue(visible);
		extent.flush(); // necessary to flush to end listning report, it will update the status pass or fail 
		
	}


}
