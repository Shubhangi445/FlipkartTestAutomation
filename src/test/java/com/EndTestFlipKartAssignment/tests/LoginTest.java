package com.EndTestFlipKartAssignment.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndTestFlipKartAssignment.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest 
{
	/*-------------------------Providing Sheet Name From Excel File---------------------------------*/

	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("loginPageSheetName");
	
	@Test (priority=0,groups = {"LogIn","valid"}, enabled = true)
	public void validLogInFunctionality() throws InterruptedException 
	{
		int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		String actualTitle = "";
		String testName = "validLogInFunctionality";
		
		try
		{
			extentTest = extent.startTest("Verifying the functionality of  Valid Login page");
			
			//--------------------- Creating Objects Of Pages Required In This Test Case
			LoginPage Logpage = new LoginPage(driver);
			
			//--------------------- Accessing Row Data From Excel File
			HashMap<String, String> testData = new HashMap<String,String>();	
			testData = reader.getRowTestData(sheetName, testName);
			
			String executionRequired = testData.get("Execution Required");
			String expectedTitle = testData.get("Expected Title");
			
			//-------------------- Accessing Execution Permission From Excel
			CommonUtils.toCheckExecutionRequired(executionRequired);
			CommonUtils.logTestData(sheetName, testName);
						
			//-------------------- Accessing Data From Excel Sheet
			String userName = testData.get("UserName");
			String password = testData.get("Password");
	
			//-------------------- Accessing Method From Required Page	
			Logpage.enterCredentials(userName, password);

			waitingTimeIsSetTo(3000);
			actualTitle = driver.getTitle();
			
			//----------------------ASSERTION
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			Assert.assertEquals(actualTitle,expectedTitle);
			
			//----------------------LOGGER INFO
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			logg.info("Valid Login Functionality is working successfully");

			//----------------------EXTENT REPORT INFO IF PASSED
			extentTest.log(LogStatus.PASS, "Valid Login Functionality is working successfully");
			extent.endTest(extentTest);
		}
		
		catch(AssertionError e) 
		{
			//----------------------EXTENT REPORT INFO IF FAILED
			extentTest.log(LogStatus.FAIL, actualTitle);
			extent.endTest(extentTest);
		}
	}
	
	
	@Test (priority=0,groups = {"LogIn","valid"}, enabled = true)
	public void validEmailLogInFunctionality() throws InterruptedException 
	{
		int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		String actualTitle = "";
		String testName = "validEmailLogInFunctionality";
		
		try
		{
			extentTest = extent.startTest("Verifying the functionality of  Valid Login page");
			
			//--------------------- Creating Objects Of Pages Required In This Test Case
			LoginPage Logpage = new LoginPage(driver);
			
			//--------------------- Accessing Row Data From Excel File
			HashMap<String, String> testData = new HashMap<String,String>();	
			testData = reader.getRowTestData(sheetName, testName);
			
			String executionRequired = testData.get("Execution Required");
			String expectedTitle = testData.get("Expected Title");
			
			//-------------------- Accessing Execution Permission From Excel
			CommonUtils.toCheckExecutionRequired(executionRequired);
			CommonUtils.logTestData(sheetName, testName);
						
			//-------------------- Accessing Data From Excel Sheet
			String num = testData.get("UserName");
			String pass = testData.get("Password");
			
			//-------------------- Accessing Method From Required Page
			Logpage.enterCredentials(num, pass);

			waitingTimeIsSetTo(3000);
			actualTitle = driver.getTitle();
			
			//----------------------ASSERTION
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			Assert.assertEquals(actualTitle,expectedTitle);
			
			//----------------------LOGGER INFO
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			logg.info("Valid Login Functionality is working successfully");

			//----------------------EXTENT REPORT INFO IF PASSED
			extentTest.log(LogStatus.PASS, "Valid Login Functionality is working successfully");
			extent.endTest(extentTest);
		}
		
		catch(AssertionError e) 
		{
			//----------------------EXTENT REPORT INFO IF FAILED
			extentTest.log(LogStatus.FAIL, actualTitle);
			extent.endTest(extentTest);
		}
	}
	@Test (priority=1,groups = {"LogIn","invalid"}, enabled = true)
	public void invalidLogInFunctionality() throws InterruptedException 
	{
			int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
			String actualTitle="";
			String testName = "invalidLogInFunctionality";
			
			try{
				extentTest = extent.startTest("Verifying the functionality of Invalid Login page");
				
				//--------------------- Creating Objects Of Pages Required In This Test Case
				LoginPage Logpage = new LoginPage(driver);
				
				//--------------------- Accessing Row Data From Excel File
				HashMap<String, String> testData = new HashMap<String,String>();
				testData = reader.getRowTestData(sheetName, testName);
				
				String executionRequired = testData.get("Execution Required");
				String expectedTitle = testData.get("Expected Title");

				//-------------------- Accessing Execution Permission From Excel
				CommonUtils.toCheckExecutionRequired(executionRequired);
				CommonUtils.logTestData(sheetName, testName);
				
				//-------------------- Accessing Data From Excel Sheet
				String num = testData.get("UserName");
				String pass = testData.get("Password");
				
				//-------------------- Accessing Method From Required Page
				Logpage.enterCredentials(num, pass);
				
				actualTitle = Logpage.message.getText();
				
				//----------------------ASSERTION
				driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
				Assert.assertEquals(actualTitle,expectedTitle);
				
				//----------------------LOGGER INFO
				driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
				logg.info("Invalid Login Functionality is working successfully");

				//----------------------EXTENT REPORT INFO IF PASSED
				extentTest.log(LogStatus.PASS, "Invalid Login Functionality is working successfully");
				extent.endTest(extentTest);
			}
			
			catch(AssertionError e) 
			{
				//----------------------EXTENT REPORT INFO IF FAILED
				extentTest.log(LogStatus.FAIL, "Failed Test Case");
				extent.endTest(extentTest);
			}
	}
}
