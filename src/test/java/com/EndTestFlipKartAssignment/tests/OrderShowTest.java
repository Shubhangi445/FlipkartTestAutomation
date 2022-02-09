package com.EndTestFlipKartAssignment.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndTestFlipKartAssignment.pages.LoginPage;
import com.EndTestFlipKartAssignment.pages.MyAccountPage;
import com.relevantcodes.extentreports.LogStatus;

public class OrderShowTest extends BaseTest{

	/*-------------------------Providing Sheet Name From Excel File---------------------------------*/

	private String sheetName = prop.getProperty("MyAccountPageSheetName");
	
	@Test(priority=3,groups = {"LogIn"}, enabled = true)
	public void orderDisplayFunctionality() throws InterruptedException
	{
		int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		String actualTitle = "";
		String testName = "orderDisplayFunctionality";

		try{
			extentTest = extent.startTest("Verifying the Orders option in MyAccounts");
			
			//--------------------- Creating Objects Of Pages Required In This Test Case
			LoginPage login = new LoginPage(driver);
			MyAccountPage option = new MyAccountPage(driver);
						
			//--------------------- Accessing Row Data From Excel File
			HashMap<String, String> testData = new HashMap<String,String>();
			testData = reader.getRowTestData(sheetName, testName);
			
			String executionRequired = testData.get("Execution Required");
			String expectedTitle = testData.get("Expected Title");
			
			//-------------------- Accessing Execution Permission From Excel File
			CommonUtils.toCheckExecutionRequired(executionRequired);
			CommonUtils.logTestData(sheetName, testName);
			
			//-------------------- Accessing Data From Excel Sheet
			String userName = testData.get("UserName");
			String password = testData.get("Password");

			login.enterCredentials(userName, password);
			
			//-------------------- Accessing Method From Required Page
			option.orderShow();
			
			waitingTimeIsSetTo(3000);
			actualTitle = driver.getTitle();
			
			//----------------------ASSERTION
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			Assert.assertEquals(actualTitle,expectedTitle);
			
			//----------------------LOGGER INFO
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			logg.info("Orders Functionality is working successfully");

			//----------------------EXTENT REPORT INFO IF PASSED
			extentTest.log(LogStatus.PASS, "Orders Functionality is working successfully");
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
