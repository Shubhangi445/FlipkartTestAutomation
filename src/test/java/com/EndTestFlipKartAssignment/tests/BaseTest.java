package com.EndTestFlipKartAssignment.tests;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.EndTestFlipKartAssignment.utils.ExtractDataExcel;
import com.EndTestFlipKartAssignment.utils.ScreenShots;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	static String Browser;
	static WebDriver driver;
	
	/*--------------------------Declare File Handling----------------------*/
	
	static File file = new File("./Resources/config.properties");
	static FileInputStream fis = null;
	static Properties prop = new Properties();
	
	/*--------------------------Declare Logger----------------------*/

	public static Logger logg = LogManager.getLogger(BaseTest.class);
	
	/*--------------------------Declare Extent Report----------------------*/

	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	/*--------------------------Excel File Test Data Reader----------------------*/

	public static ExtractDataExcel reader = null ;
	
	static {
		
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			prop.load(fis);       
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	/*--------------------------Exception Handling for Excel File----------------------*/

	try {
		reader = new ExtractDataExcel(prop.getProperty("testDataFileLocation"));
		}
	catch(Exception e)
		{
		logg.error(e.getMessage());
		}
	
	}

	/*--------------------------Starting Extent Report----------------------*/
	
	@BeforeTest(groups = {"LogIn","report","sel"})
	public void setExtent() {
		extent = new ExtentReports("./Reports/ExtentReport.html");
	}

	/*-------------------------End Of Extent Report----------------------*/
	
	@AfterTest(groups = {"LogIn","report","sel"})
	public void endReport() throws InterruptedException {
		extent.endTest(extentTest);
		extent.flush();
		extent.close();
	}
	
	public void waitingTimeIsSetTo(int t) throws InterruptedException {	
		Thread.sleep(t);
	}
	
	/*--------------------------Screenshot For Failed Scenarios/Test Cases----------------------*/

	@AfterMethod(groups = {"LogIn","report","sel"})
	public void attachScreenshot(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			String screenshotPath = ScreenShots.CaptureScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath) );
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Successful");
		}
	}
	
	/*--------------------------- Drivers Declaration --------------------------*/

	@BeforeMethod(groups = {"LogIn","report","sel"})
	public static void initializeWebdriver() {
	
		Browser = prop.getProperty("browser");

		if (Browser.equalsIgnoreCase("chromehl")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1400,600");
			driver = new ChromeDriver(options);
		} 
		else if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (Browser.equalsIgnoreCase("firefox")) {
			System.setProperty(prop.getProperty("firefoxDriverProperty"),prop.getProperty("firefoxDriverPath"));
			driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
		} 
		else if (Browser.equalsIgnoreCase("edge")) {
			System.setProperty(prop.getProperty("edgeDriverProperty"),prop.getProperty("edgeDriverPath"));
			driver = new EdgeDriver();
			WebDriverManager.edgedriver().setup();
			
		}
		int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		
	}
	
	/*--------------------------- Initiaizing URL--------------------------*/
	
	@BeforeMethod(groups = {"LogIn","report","sel"})
	public static void openUrl() {
		driver.get(prop.getProperty("URL"));
	}

	/*--------------------------Closing Browser----------------------*/

	@AfterMethod(groups = {"LogIn","report","sel"})
	public static void closeBrowser(ITestResult result) {

		if(result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST FAILED "+result.getName());
			//extentTest.log(LogStatus.FAIL, "TEST FAILED THROWABLE EXC " + result.getThrowable()); // adding screenshot
			String screenshotPath = ScreenShots.CaptureScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Skipped " + result.getName());
		} 

		else if(result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Passed" + result.getName());
		} 
		// end the testcase in the extent report
		extent.endTest(extentTest);
		
		/*--------------------------Closing the Driver----------------------*/

		driver.quit();

	}
	
}
