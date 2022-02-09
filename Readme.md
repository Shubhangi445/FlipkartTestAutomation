# About Project
----------------------------------------------------------------------------------
It is a Flipkart Automation Maven Project performed in JDK-11 using Selenium.

## TestNG file description
- Testng.xml : defines the tests related to different pages.

## Packages description 
 - com.EndTestFlipKartAssignment.pages : Defining all the pages actions and the respective object repository.
 - com.EndTestFlipKartAssignment.tests : Defining all the pages tests and assertions.
 - com.EndTestFlipKartAssignment.utils : Defining all the utilities needed for the tests.

## Tests.java files description 
-**BaseTest** : The main class which defines: 
- *@Test*- to run test
- *@BeforeMethod* - to run before test
- *@AfterMethod*  - to run after test
- *@BeforeSuite*  - to run before TestSuite
- *@AfterSuite*   - to run before TestSuite


## How to run

- Clone repo from the github link
- gitHub link :- **https://github.com/ssssssssssssssss/Flipkart_Automation**
- run RunAssignment.bat

## Important Note

-**To change browser ** - change the browser in config.properties:
- *FOR FIREFOX BROWSER* - firefox
- *FOR GOOGLE CHROME* - chrome
- *FOR MICROSOFT EDGE* - edge
- *FOR HEADLESS MODE* - chromehl

-If in any case test case shows that page is unable to load or unexpected error then run the test case again or reload page manually

## Important Directory

- Drivers : ./Drivers/
- Report File : ./Reports/ExtentReport.html
- Log File : ./Logs/
- Configuration File: ./Resources/config.properties
- Screenshots Folder: ./FailedScreenshots/
- Test Data File : ./Resources/DataSheet.xlsx

## How to run through jenkins

- download jenkins.war file
- run in cmd 

```
java -jar jenkins.war --httpPort=8080
```

- If you need steps for jenkins setup - GO TO WORD FILE ATTACHMENT-*JenkinsInstallationGuide* that is in this project only 

### Screenshots

- Screenshots gets generated after failing of test cases

### Reports

- Extent Report gets generated after the test run

## How to run in testNg

- In testng.xml use 

```
<suite name="Suite">...</suite>
```

## How to run in Maven command line

- In command prompt at projects location use 

```
mvn clean test
```

## Main Parameters in config.properties file

- browser : chromehl -> to run in headless mode

## Implemented features

-	Create atleast 20 automated scenarios across different flows and screens - **done** 
-	Implement POM - **done**
-	Test data should be read from excel. User has the ability to selective run the 	 	cases by 	marking yes in the Execution Required field in excel - **done**  
-	Global Parameters should be read from config file like browser name, test site 	URL,  	etc. 	should be read from a properties file - **done**  
-	Use proper waits i.e., implicit wait and explicit wait wherever necessary  - **done** 
-	The test should run on following browsers ME, Chrome, FF - **done** 
-	There should be an option to run the test cases in headless mode - **done**
-	Use Grouping, Priority, and enable/disable when creating the TestNG Test Cases 	- **done**  
-	Assertions should be used properly throughout the suite - **done** 
-	Put proper assertions and error screenshot in the extent report - **done**
-	Create reusable libraries and import these as jars in the current project - **done** 	(com.EndTestFlipKartAssignment.utils)
-	Create a ReadMe document which has the steps to install and run the code - **done**
-	Integrate your test suite with Jenkins and GitHub for CI/CD part -  **done**
-	Test Suite should be executable from command line using maven - **done**
-	Use Logger to implement logging in your test cases - **done**


## AUTHOR
-Shubhangi Sharma