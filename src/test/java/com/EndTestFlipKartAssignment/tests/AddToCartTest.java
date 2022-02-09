package com.EndTestFlipKartAssignment.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndTestFlipKartAssignment.pages.CartPage;
import com.EndTestFlipKartAssignment.pages.LoginPage;
import com.EndTestFlipKartAssignment.pages.SearchHomePage;
import com.relevantcodes.extentreports.LogStatus;

public class AddToCartTest extends BaseTest{

	/*-------------------------Providing Sheet Name From Excel File---------------------------------*/

	private String sheetName = prop.getProperty("CartPageSheetName");
	
	@Test(priority=8,groups = {"LogIn"}, enabled = true)
	public void addToCartFunctionality() throws InterruptedException
	{
		int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		String actualTitle = "";
		String testName = "addToCartFunctionality";

		try{
			extentTest = extent.startTest("Verifying the Add to Cart functionality");
			
			//--------------------- Creating Objects Of Pages Required In This Test Case
			LoginPage Logpage = new LoginPage(driver);
			SearchHomePage search = new SearchHomePage(driver);
			CartPage addItem = new CartPage(driver);
		
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
			
			String text = testData.get("SearchText");	
			
			//-------------------- Accessing Method From Required Page						
			waitingTimeIsSetTo(3000);
			search.searchText(text);
						
			waitingTimeIsSetTo(3000);
			addItem.toCartElement();
			
			waitingTimeIsSetTo(3000);
			addItem.addToCart();

			waitingTimeIsSetTo(3000);
			actualTitle = driver.getTitle();
			
			//----------------------ASSERTION
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			Assert.assertEquals(actualTitle,expectedTitle);
			
			//----------------------LOGGER INFO
			logg.info("Add to Cart Functionality is working successfully");

			//----------------------EXTENT REPORT INFO IF PASSED
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			extentTest.log(LogStatus.PASS, "Add to Cart Functionality is working successfully");
			extent.endTest(extentTest);
		}
		
		catch(AssertionError e) {
			//----------------------EXTENT REPORT INFO IF FAILED
			extentTest.log(LogStatus.FAIL, "Failed Test Cases");
			extent.endTest(extentTest);
			
		}
	}
}
