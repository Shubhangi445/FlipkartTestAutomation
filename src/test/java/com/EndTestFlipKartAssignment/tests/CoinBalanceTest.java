package com.EndTestFlipKartAssignment.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndTestFlipKartAssignment.pages.LoginPage;
import com.EndTestFlipKartAssignment.pages.CoinBalancePage;
import com.relevantcodes.extentreports.LogStatus;

public class CoinBalanceTest extends BaseTest {

/*-------------------------Providing Sheet Name From Excel File---------------------------------*/

private String sheetName = prop.getProperty("CoinBalanceSheetName");
	
	@Test (priority=13, groups = {"LogIn","valid"}, enabled = true)
	public void BalanceCheckFunctionality() throws Exception 
	{
		int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		String actualTitle = "";
		String testName = "BalanceCheckFunctionality";
		
		try{
			extentTest = extent.startTest("Verifying the Coins Balance in Flipkart");
			
			//--------------------- Creating Objects Of Pages Required In This Test Case
			LoginPage Logpage = new LoginPage(driver);
			CoinBalancePage coin = new CoinBalancePage(driver);
			
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
			coin.checkCoinBalance();
			
			waitingTimeIsSetTo(3000);
			actualTitle = driver.getTitle();
			
			//----------------------ASSERTION
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			Assert.assertEquals(actualTitle,expectedTitle);
			
			//----------------------LOGGER INFO
			logg.info("Coin Balance Check is working successfully ");
			
			//----------------------EXTENT REPORT INFO IF PASSED
			extentTest.log(LogStatus.INFO, "Coin Balance : " + coin.message.getText() + " coins" );
			extentTest.log(LogStatus.PASS, "Coin balance checked successfully");

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
