package com.EndTestFlipKartAssignment.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndTestFlipKartAssignment.pages.LoginPage;
import com.EndTestFlipKartAssignment.pages.SearchHomePage;
import com.relevantcodes.extentreports.LogStatus;

public class SortingTest extends BaseTest{
	
	/*-------------------------Providing Sheet Name From Excel File---------------------------------*/

	private String sheetName = prop.getProperty("SearchTextSheetName");
	
	@Test(priority=17,groups = {"LogIn"} , enabled = true)
	public void sortLowToHighFunctionality() throws InterruptedException
	{
		int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		String actualTitle = "";
		String testName = "sortLowToHighFunctionality";

		try
		{
			extentTest = extent.startTest("Verifying the sorting Low to High Functionality");
			
			//--------------------- Creating Objects Of Pages Required In This Test Case
			LoginPage login = new LoginPage(driver);
			SearchHomePage sort = new SearchHomePage(driver);
						
			//--------------------- Accessing Row Data From Excel File
			HashMap<String, String> testData = new HashMap<String,String>();
			testData = reader.getRowTestData(sheetName, testName);
			
			String executionRequired = testData.get("Execution Required");
			String expectedTitle = testData.get("Expected Title");
			
			//-------------------- Accessing Execution Permission From Excel File
			CommonUtils.toCheckExecutionRequired(executionRequired);
			CommonUtils.logTestData(sheetName, testName);
			
			//-------------------- Accessing Data From Excel Sheet
			String user = testData.get("UserName");
			String pass = testData.get("Password");
	
			login.enterCredentials(user, pass);
			
			//-------------------- Accessing Method From Required Page
			waitingTimeIsSetTo(5000);
			sort.sort_LowToHigh();
			
			waitingTimeIsSetTo(3000);
			actualTitle = driver.getTitle();
			
			//----------------------ASSERTION
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			Assert.assertEquals(actualTitle,expectedTitle);
			
			//----------------------LOGGER INFO
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			logg.info("Sorting Low to High Functionality is working successfully");

			//----------------------EXTENT REPORT INFO IF PASSED
			extentTest.log(LogStatus.PASS, "Sorting Low to High Functionality is working successfully");
			extent.endTest(extentTest);
		}
		
		catch(AssertionError e)
		{
			//----------------------EXTENT REPORT INFO IF FAILED
			extentTest.log(LogStatus.FAIL, actualTitle);
			extent.endTest(extentTest);
			
		}
	}
	
	@Test(priority=18,groups = {"LogIn"}, enabled = true)
	public void sortHighToLowFunctionality() throws InterruptedException
	{
		String actualTitle = "";
		String testName = "sortHighToLowFunctionality";

		try
		{
			extentTest = extent.startTest("Verifying the sorting High to Low Functionality");
			
			//--------------------- Creating Objects Of Pages Required In This Test Case
			LoginPage login = new LoginPage(driver);
			SearchHomePage sort = new SearchHomePage(driver);
						
			//--------------------- Accessing Row Data From Excel File
			HashMap<String, String> testData = new HashMap<String,String>();
			testData = reader.getRowTestData(sheetName, testName);
			
			String executionRequired = testData.get("Execution Required");
			String expectedTitle = testData.get("Expected Title");

			//-------------------- Accessing Execution Permission From Excel File
			CommonUtils.toCheckExecutionRequired(executionRequired);
			CommonUtils.logTestData(sheetName, testName);
			
			//-------------------- Accessing Data From Excel Sheet
			String user = testData.get("UserName");
			String pass = testData.get("Password");
	
			login.enterCredentials(user, pass);
			
			//-------------------- Accessing Method From Required Page	
			waitingTimeIsSetTo(3000);
			sort.sort_HighToLow();
			
			waitingTimeIsSetTo(3000);
			actualTitle = driver.getTitle();
			
			//----------------------ASSERTION
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			Assert.assertEquals(actualTitle,expectedTitle);
						
			//----------------------LOGGER INFO
			logg.info("Sorting High to Low Functionality is working successfully");
			
			//----------------------EXTENT REPORT INFO IF PASSED
			extentTest.log(LogStatus.PASS, "Sorting High to Low Functionality is working successfully");
			extent.endTest(extentTest);
		}
		
		catch(AssertionError e)
		{
			//----------------------EXTENT REPORT INFO IF FAILED
			extentTest.log(LogStatus.FAIL, actualTitle);
			extent.endTest(extentTest);
			
		}
	}
}
