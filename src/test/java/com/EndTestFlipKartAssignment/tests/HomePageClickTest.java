package com.EndTestFlipKartAssignment.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndTestFlipKartAssignment.pages.LoginPage;
import com.EndTestFlipKartAssignment.pages.MyAccountPage;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageClickTest extends BaseTest{
	
	/*-------------------------Providing Sheet Name From Excel File---------------------------------*/

	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("MyAccountPageSheetName");

	@Test(priority=16,groups = {"LogIn"}, enabled = true)
	public void HomePageClickFunctionality() throws InterruptedException
	{
		int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		String actualTitle = "";
		String testName = "HomePageClickFunctionality";

		try{
			extentTest = extent.startTest("Verifying the Home Page option");
			
			//--------------------- Creating Objects Of Pages Required In This Test Case
			LoginPage login = new LoginPage(driver);
			MyAccountPage home = new MyAccountPage(driver);
					
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
			login.enterCredentials(userName, password);
			
			waitingTimeIsSetTo(3000);
			home.homePageOption();
			
			waitingTimeIsSetTo(4000);
			actualTitle = driver.getTitle();

			//----------------------ASSERTION
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			Assert.assertEquals(actualTitle,expectedTitle);
			
			//----------------------LOGGER INFO
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);	
			logg.info("Home Page option is working successfully");

			//----------------------EXTENT REPORT INFO IF PASSED
			extentTest.log(LogStatus.PASS, "Home Page option is working successfully");
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
