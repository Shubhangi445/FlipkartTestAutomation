package com.EndTestFlipKartAssignment.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndTestFlipKartAssignment.pages.LoginPage;
import com.EndTestFlipKartAssignment.pages.SearchHomePage;
import com.relevantcodes.extentreports.LogStatus;

public class SearchTest extends BaseTest {

/*-------------------------Providing Sheet Name From Excel File---------------------------------*/
	
	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("SearchTextSheetName");

	@Test (priority=4,groups = {"LogIn","valid","search"}, enabled = true)
	public void searchExactKeywordFunctionality() throws InterruptedException {
		
		int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		String actualTitle = "";
		String testName = "searchExactKeywordFunctionality";
			
		try
		{
			extentTest = extent.startTest("Verifying the functionality of searching Exact Keyword");
			
			//--------------------- Creating Objects Of Pages Required In This Test Case
			LoginPage Logpage = new LoginPage(driver);
			SearchHomePage search = new SearchHomePage(driver);
			
			//--------------------- Accessing Row Data From Excel File
			HashMap<String, String> testData = new HashMap<String,String>();
			testData = reader.getRowTestData(sheetName, testName);
			
		//Execution Required Field - Y/N			
			String executionRequired = testData.get("Execution Required");
			String expectedTitle = testData.get("Expected Title");
			
			//-------------------- Accessing Execution Permission From Excel File
			CommonUtils.toCheckExecutionRequired(executionRequired);
			CommonUtils.logTestData(sheetName, testName);			
			
			//-------------------- Accessing Data From Excel Sheet
			String userName = testData.get("UserName");
			String password = testData.get("Password");
			String text = testData.get("SearchText");	

			//-------------------- Accessing Method From Required Page
			Logpage.enterCredentials(userName, password);
			
			waitingTimeIsSetTo(2000);
			search.searchText(text);
			
			waitingTimeIsSetTo(3000);
			actualTitle = driver.getTitle();
			
			//----------------------ASSERTION
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			Assert.assertEquals(actualTitle,expectedTitle);
				
			//----------------------LOGGER INFO
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			logg.info("Search Functionality with Exact keyword is working successfully");
			
			//----------------------EXTENT REPORT INFO IF PASSED
			extentTest.log(LogStatus.INFO,"Item Searched : ", actualTitle);
			extentTest.log(LogStatus.PASS, "Search Functionality with exact keyword is working successfully");
			
			waitingTimeIsSetTo(3000);
			extent.endTest(extentTest);
		}
		
		catch(AssertionError e) 
		{
			//----------------------EXTENT REPORT INFO IF FAILED
			extentTest.log(LogStatus.FAIL, "Failed Test Cases");
			extent.endTest(extentTest);
		}
	}
	
	
	@Test (priority=5,groups = {"LogIn","valid","search"}, enabled = true)
	public void searchRandomKeywordFunctionality() throws InterruptedException {
		
		int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		String actualTitle = "";
		String testName = "searchRandomKeywordFunctionality";
		
		try
		{
			extentTest = extent.startTest("Verifying the functionality of searching Random Keyword");
			
			//--------------------- Creating Objects Of Pages Required In This Test Case
			LoginPage Logpage = new LoginPage(driver);
			SearchHomePage search = new SearchHomePage(driver);

			//--------------------- Accessing Row Data From Excel File
			HashMap<String, String> testData = new HashMap<String,String>();
			testData = reader.getRowTestData(sheetName, testName);
			
			//Execution Required Field - Y/N
			String executionRequired = testData.get("Execution Required");
			String expectedTitle = testData.get("Expected Title");
			
			//-------------------- Accessing Execution Permission From Excel File
			CommonUtils.toCheckExecutionRequired(executionRequired);
			CommonUtils.logTestData(sheetName, testName);
			
			//-------------------- Accessing Data From Excel Sheet
			String userName = testData.get("UserName");
			String password = testData.get("Password");
			String text = testData.get("SearchText");	

			//-------------------- Accessing Method From Required Page	
			waitingTimeIsSetTo(2000);
			Logpage.enterCredentials(userName, password);
					
			waitingTimeIsSetTo(2000);
			search.searchText(text);
			
			waitingTimeIsSetTo(5000);
			actualTitle = driver.getTitle();

			//----------------------ASSERTION
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			Assert.assertEquals(actualTitle,expectedTitle);
			
			//----------------------LOGGER INFO
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			logg.info("Search Functionality with Random keyword is working successfully");
			
			//----------------------EXTENT REPORT INFO IF PASSED
			extentTest.log(LogStatus.INFO,"Item Searched : ", actualTitle);
			extentTest.log(LogStatus.PASS, "Search Functionality with Random keyword is working successfully");
			extent.endTest(extentTest);
		}
		
		catch(AssertionError e) 
		{
			//----------------------EXTENT REPORT INFO IF FAILED
			extentTest.log(LogStatus.FAIL, "Failed Test Cases");
			extent.endTest(extentTest);
		}
	}
	
	@Test (priority=6,groups = {"LogIn","valid","search"}, enabled = true)
	public void applyFiltersSearchFunctionality() throws InterruptedException {
		
		int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		String actualTitle = "";
		String testName = "applyFiltersSearchFunctionality";
			
		try
		{
			extentTest = extent.startTest("Verifying the Filter functionality of searching");
			
			//--------------------- Creating Objects Of Pages Required In This Test Case
			LoginPage Logpage = new LoginPage(driver);
			SearchHomePage search = new SearchHomePage(driver);
			
			//--------------------- Accessing Row Data From Excel File
			HashMap<String, String> testData = new HashMap<String,String>();
			testData = reader.getRowTestData(sheetName, testName);
			
		//Execution Required Field - Y/N			
			String executionRequired = testData.get("Execution Required");
			String expectedTitle = testData.get("Expected Title");
		
			//-------------------- Accessing Execution Permission From Excel
			CommonUtils.toCheckExecutionRequired(executionRequired);
			CommonUtils.logTestData(sheetName, testName);			
			
			//-------------------- Accessing Data From Excel Sheet
			String userName = testData.get("UserName");
			String password = testData.get("Password");
			String text = testData.get("SearchText");	

			//-------------------- Accessing Method From Required Page	
			Logpage.enterCredentials(userName, password);
			
			waitingTimeIsSetTo(2000);
			search.searchText(text);
			
			waitingTimeIsSetTo(2000);
			search.applyFilters();
			
			waitingTimeIsSetTo(3000);
			actualTitle = driver.getTitle();
			
			//----------------------ASSERTION
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			Assert.assertEquals(actualTitle,expectedTitle);
			
			//----------------------LOGGER INFO
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			logg.info("Search Functionality with Exact keyword is working successfully");

			//----------------------EXTENT REPORT INFO IF PASSED
			extentTest.log(LogStatus.PASS, "Filters functionality of searching is working successfully");
			waitingTimeIsSetTo(3000);
			extent.endTest(extentTest);
		}
		
		catch(AssertionError e) 
		{
			//----------------------EXTENT REPORT INFO IF FAILED
			extentTest.log(LogStatus.FAIL, "Failed Test Cases");
			extent.endTest(extentTest);
		}
	}
	
	@Test (priority=7,groups = {"LogIn","valid","search"}, enabled = true)
	public void removeFiltersFunctionality() throws InterruptedException {
	
		int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		String actualTitle = "";
		String testName = "removeFiltersFunctionality";
			
		try
		{
			extentTest = extent.startTest("Verifying the Clear all filters functionality of searching");
			
			//--------------------- Creating Objects Of Pages Required In This Test Case
			LoginPage Logpage = new LoginPage(driver);
			SearchHomePage search = new SearchHomePage(driver);
			
			//--------------------- Accessing Row Data From Excel File
			HashMap<String, String> testData = new HashMap<String,String>();
			testData = reader.getRowTestData(sheetName, testName);
			
		//Execution Required Field - Y/N			
			String executionRequired = testData.get("Execution Required");
			String expectedTitle = testData.get("Expected Title");
		
			//-------------------- Accessing Execution Permission From Excel
			CommonUtils.toCheckExecutionRequired(executionRequired);
			CommonUtils.logTestData(sheetName, testName);			
			
			//-------------------- Accessing Method From Required Page
			String userName = testData.get("UserName");
			String password = testData.get("Password");
			String text = testData.get("SearchText");	

			//-------------------- Accessing Method From Required Page	
			Logpage.enterCredentials(userName, password);
						
			waitingTimeIsSetTo(3000);
			search.searchText(text);
			
			waitingTimeIsSetTo(2000);
			search.applyFilters();
			
			waitingTimeIsSetTo(2000);
			search.removeFilters();
			
			waitingTimeIsSetTo(3000);
			actualTitle = driver.getTitle();
			
			//----------------------ASSERTION
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			Assert.assertEquals(actualTitle,expectedTitle);
			
			//----------------------LOGGER INFO
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			logg.info("Clear all filters functionality of searching is working successfully");
			
			//----------------------EXTENT REPORT INFO IF PASSED
			extentTest.log(LogStatus.PASS, "Clear all filters functionality of searching is working successfully");
			waitingTimeIsSetTo(3000);
			extent.endTest(extentTest);
		}
		
		catch(AssertionError e) 
		{
			//----------------------EXTENT REPORT INFO IF FAILED
			extentTest.log(LogStatus.FAIL, "Failed Test Cases");
			extent.endTest(extentTest);
		}
	}
	
	@Test(priority=7,groups = {"LogIn"}, enabled = true)
	public void searchWithDropdownFunctionality() throws InterruptedException 	{
	
		int globalWaitTime = Integer.parseInt(prop.getProperty("globalWaitTime"));
		String actualTitle = "";
		String testName = "searchWithDropdownFunctionality";

		try
		{
			extentTest = extent.startTest("Verifying the Dropdown Search in MyAccounts");
			
			//--------------------- Creating Objects Of Pages Required In This Test Case
			LoginPage login = new LoginPage(driver);
			SearchHomePage searchDropDown = new SearchHomePage(driver);
						
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
			searchDropDown.searchWithoutKeyword();
			
			waitingTimeIsSetTo(4000);
			actualTitle = driver.getTitle();
			
			//----------------------ASSERTION
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			Assert.assertEquals(actualTitle,expectedTitle);
			
			//----------------------LOGGER INFO
			driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
			logg.info("Dropdown Search Functionality is working successfully");

			//----------------------EXTENT REPORT INFO IF PASSED
			extentTest.log(LogStatus.PASS, "Dropdown Search Functionality is working successfully");
			extent.endTest(extentTest);
		}
		
		catch(AssertionError e)
		{
			//----------------------EXTENT REPORT INFO IF FAILED
			extentTest.log(LogStatus.FAIL,"Failed Test Cases");
			extent.endTest(extentTest);
			
		}
	}
}
