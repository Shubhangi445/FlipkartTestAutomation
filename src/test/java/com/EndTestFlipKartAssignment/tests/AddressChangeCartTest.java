package com.EndTestFlipKartAssignment.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndTestFlipKartAssignment.pages.CartPage;
import com.EndTestFlipKartAssignment.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class AddressChangeCartTest extends BaseTest{
	
/*-------------------------Providing Sheet Name From Excel File---------------------------------*/
	
	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("CartPageSheetName");
	
	@Test(priority=14,groups = {"LogIn"}, enabled = true)
	public void addressChangeInCartFunctionality() throws InterruptedException
	{
		int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		String actualTitle = "";
		String testName = "addressChangeInCartFunctionality";

		try
		{
			extentTest = extent.startTest("Verifying the Address change functionality in Cart");
			
			//--------------------- Creating Objects Of Pages Required In This Test Case
			LoginPage Logpage = new LoginPage(driver);
			CartPage cart = new CartPage(driver);
			
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
	
			Logpage.enterCredentials(userName, password);
			
			//-------------------- Accessing Method From Required Page						
			waitingTimeIsSetTo(3000);
			cart.changeAddress();

			waitingTimeIsSetTo(3000);
			actualTitle = driver.getTitle();
			
			//----------------------ASSERTION
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			Assert.assertEquals(actualTitle,expectedTitle);
			
			//----------------------LOGGER INFO
			logg.info("Address change functionality is working successfully");
			
			//----------------------EXTENT REPORT INFO IF PASSED
			extentTest.log(LogStatus.PASS, "Address change functionality is working successfully");
			extent.endTest(extentTest);
		}
		
		catch(AssertionError e) {
			//----------------------EXTENT REPORT INFO IF FAILED
			extentTest.log(LogStatus.FAIL, "Failed Test Cases");
			extent.endTest(extentTest);
			
		}
	}
}
