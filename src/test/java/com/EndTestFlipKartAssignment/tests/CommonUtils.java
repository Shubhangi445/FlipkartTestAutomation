package com.EndTestFlipKartAssignment.tests;

import java.util.HashMap;

import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;

public class CommonUtils extends BaseTest{

	public static void logTestData(String worksheetName, String testCaseName) {

		   HashMap<String, String> testData = new HashMap<String, String>();
		   testData = reader.getRowTestData(worksheetName, testCaseName);

		   /*---------------------------- Printing All Data From Excel File---------------------------*/
		   logg.info("______________________________________________________________________");
		   extentTest.log(LogStatus.INFO, "_____________________________ Test Data ________________________________");

		   logg.info("Test data for Worksheet Name : '"+ worksheetName +"' and for Test Case : '"+ testCaseName + "'");
		   extentTest.log(LogStatus.INFO, "Test data For Worksheet Name : '"+ worksheetName +"' and for Test Case : '"+ testCaseName + "'");

		   for (HashMap.Entry<String, String> entry : testData.entrySet()) {

		      if(entry.getKey() != "" && entry.getValue() != "") {
		    	 
		         logg.info(entry.getKey() + " : " + entry.getValue().toString());
		         extentTest.log(LogStatus.INFO, entry.getKey() + " : " + entry.getValue().toString());

		      }
		   }

		   logg.info("______________________________________________________________________");
		   extentTest.log(LogStatus.INFO, "________________________________________________________________________");

		}
	
	   /*---------------------------- Accessing Execution Required From Excel File---------------------------*/

	public static void toCheckExecutionRequired(String executionRequired) {
		   
		   //-------------------------- If Execution Required Field Is No
		   if(executionRequired.equals("no")) {
		      extentTest.log(LogStatus.SKIP, "Execution Required : " + executionRequired.toUpperCase());
		      logg.info("Execution required is no , skipping the test");
		      throw new SkipException("Skipping this exception");
		   }
		   
		 //-------------------------- If Execution Required Field Is Empty
		   if(executionRequired.equals("")) {
		      extentTest.log(LogStatus.WARNING, "Execution Required : " + executionRequired.toUpperCase());
		      logg.info("Execution required is empty , skipping the test");
		      throw new SkipException("Skipping this exception");
		   }
		}
}
