package com.EndTestFlipKartAssignment.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndTestFlipKartAssignment.pages.LoginPage;
import com.EndTestFlipKartAssignment.pages.WishListPage;
import com.relevantcodes.extentreports.LogStatus;

public class RemoveFromWishlist extends BaseTest{

	/*-------------------------Providing Sheet Name From Excel File---------------------------------*/
	
	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("WishlistPageSheetName");
	
	@Test(priority=12,groups = {"LogIn"}, enabled = true)
	public void removeFromWishlistFunctionality() throws InterruptedException
	{
		int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		String actualTitle = "";
		String testName = "removeFromWishlistFunctionality";

		try{
			extentTest = extent.startTest("Verifying the Remove from Wishlist functionality");
			
			//--------------------- Creating Objects Of Pages Required In This Test Case
			LoginPage Logpage = new LoginPage(driver);
			WishListPage wishlist = new WishListPage(driver);
			
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
			wishlist.removeFromWishlist();
			
			waitingTimeIsSetTo(2000);
			actualTitle = wishlist.message.getText();
			
			//----------------------ASSERTION
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			Assert.assertEquals(actualTitle, expectedTitle);
			
			//----------------------LOGGER INFO
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			logg.info("Remove from Wishlist Functionality is working successfully");

			//----------------------EXTENT REPORT INFO IF PASSED
			extentTest.log(LogStatus.INFO, actualTitle);
			extentTest.log(LogStatus.PASS, "Remove from Wishlist Functionality is working successfully");
			extent.endTest(extentTest);
		}
		
		catch(AssertionError e) {
			//----------------------EXTENT REPORT INFO IF FAILED
			extentTest.log(LogStatus.FAIL, "Failed Test Cases");
			extent.endTest(extentTest);
			
		}
	}
}
