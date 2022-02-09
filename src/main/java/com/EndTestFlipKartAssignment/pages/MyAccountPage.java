package com.EndTestFlipKartAssignment.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
	
	WebDriver driver;	 

	/*--------------------------Initializing Page Element----------------------*/

	public MyAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	/*--------------------------Declare Web Elements Via Different Locators----------------------*/

	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")
	public WebElement myAccountBtn;

	@FindBy(how=How.XPATH, using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[10]/a[1]/div[1]")
	public WebElement logOutBtn;
	
	@FindBy(how=How.XPATH, using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[4]/a[1]/div[1]")
	public WebElement orderOption;
	
	@FindBy(how=How.XPATH, using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[1]/a[1]/div[1]")
	public WebElement myProfileBtn;
	
	@FindBy(how=How.XPATH, using="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/a[2]/div[1]")
	public WebElement manageAddress;
	
	@FindBy(how=How.CLASS_NAME, using="dpjmKp")
	public WebElement editOption;
	
	@FindBy(how=How.XPATH, using="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")
	public WebElement editAddress;

	@FindBy(how=How.CLASS_NAME, using="_1XFPmK")
	public WebElement edit;
	
	@FindBy(how=How.XPATH, using="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[8]/button[1]")
	public WebElement save;
	
	@FindBy(how=How.XPATH, using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/img[1]")
	public WebElement home;
	
	/*--------------------------Using Web Elements in different Methods----------------------*/

	/*--------------------------LOGOUT METHOD----------------------*/

	public void clickLogout() throws InterruptedException {
		// Wait till the element is not visible
		WebDriverWait wait=new WebDriverWait(driver,35);
		
		Actions actionProvider = new Actions(driver);	

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")));
		actionProvider.moveToElement(myAccountBtn).perform();	
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[10]/a[1]/div[1]")));
		logOutBtn.click();
	}
	
	/*--------------------------ORDERS LIST SHOW METHOD----------------------*/

	public void orderShow() {
		// Wait till the element is not visible
		WebDriverWait wait=new WebDriverWait(driver,30);
		
		Actions actionProvider = new Actions(driver);	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")));
		actionProvider.moveToElement(myAccountBtn).perform();	
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[4]/a[1]/div[1]")));
		orderOption.click();
	}
	
	/*--------------------------MY PROFILE EDIT METHOD----------------------*/

	public void myProfileEdit() throws InterruptedException {
		// Wait till the element is not visible
		WebDriverWait wait=new WebDriverWait(driver,30);
		
		Actions actionProvider = new Actions(driver);		
		Thread.sleep(4000);
		actionProvider.moveToElement(myAccountBtn).perform();	

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[1]/a[1]/div[1]")));
		myProfileBtn.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/a[2]/div[1]")));
		manageAddress.click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dpjmKp")));
		actionProvider.moveToElement(editOption).perform();
		
		editAddress.click();
		
		List<WebElement> elements = driver.findElements(By.className("_1XFPmK"));
		elements.get(elements.size()-1).click();
			
		save.click();

	}
	
	/*--------------------------HOME PAGE OPTION METHOD----------------------*/

	public void homePageOption() throws InterruptedException {
		// Wait till the element is not visible
		WebDriverWait wait=new WebDriverWait(driver,30);
		
		Actions actionProvider = new Actions(driver);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")));
		actionProvider.moveToElement(myAccountBtn).perform();	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[4]/a[1]/div[1]")));
		orderOption.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/img[1]")));
		home.click();
		Thread.sleep(4000);
	}
	
	
}

