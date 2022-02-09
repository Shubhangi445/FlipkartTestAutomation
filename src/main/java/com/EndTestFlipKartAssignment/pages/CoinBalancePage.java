package com.EndTestFlipKartAssignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoinBalancePage {

	WebDriver driver;
	
	/*--------------------------Initializing Page Element----------------------*/

	public CoinBalancePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	/*--------------------------Declare Web Elements Via Different Locators----------------------*/

		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[2]/span[1]")
		public WebElement exploreBtn;
		
		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/img[2]")
		public WebElement coinBalance;
	
		@FindBy(how = How.CLASS_NAME , using = "EbcYjC")
		public WebElement message;
		
		/*--------------------------Using Web Elements in different Methods----------------------*/

		
		/*--------------------------COIN BALANCE CHECK METHOD----------------------*/

		
		public void checkCoinBalance() throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[2]/span[1]"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/img[2]"))).click();
		}
}
