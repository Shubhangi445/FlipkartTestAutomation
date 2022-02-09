package com.EndTestFlipKartAssignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchHomePage {

	WebDriver driver;
	
	/*--------------------------Initializing Page Element----------------------*/

	public SearchHomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	/*--------------------------Declare Web Elements Via Different Locators----------------------*/

		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")
		public WebElement searchField;
	
		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]/*[name()='svg'][1]")
		public WebElement searchBtn;
			
		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[7]/div[1]/div[1]")
		public WebElement filter;
		
		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[7]/div[2]/div[1]/div[2]/div[1]/label[1]/div[2]")
		public WebElement filterScreen;
		
		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/span[1]")
		public WebElement removefilters;
		
		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/a[1]/div[2]/div[1]/div[1]")
		public WebElement searchDropdown;
		
		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/a[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/a[8]")
		public WebElement dropdownClick;
		
		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/a[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/a[1]")
		public WebElement dropItemClick;
		
		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]/div[1]/img[1]")
		public WebElement elementClick;
		
		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]")
		public WebElement sortHighToLow;
		
		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]")
		public WebElement sortLowToHigh;
		
		/*--------------------------Using Web Elements in different Methods----------------------*/

		
		/*--------------------------SEARCH TEXT METHOD----------------------*/

		public void searchText(String text) throws InterruptedException
		{
			// Wait till the element is not visible
			WebDriverWait wait=new WebDriverWait(driver,30);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")));
		
			searchField.sendKeys(text);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]/*[name()='svg'][1]")));
			
			searchBtn.click();
		}
		
		/*--------------------------APPLY FILTER METHOD----------------------*/

		public void applyFilters() 
		{
			// Wait till the element is not visible
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")));
		
			filter.click();
			filterScreen.click();
			
		}
		
		/*--------------------------REMOVE FILTER METHOD----------------------*/

		public void removeFilters() 
		{
			// Wait till the element is not visible
			WebDriverWait wait=new WebDriverWait(driver,30);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/span[1]")));
			removefilters.click();
			
		}
		
		/*--------------------------SEARCH VIA DROPDOWN METHOD----------------------*/

		public void searchWithoutKeyword() throws InterruptedException
		{
			Actions actionProvider = new Actions(driver);

			Thread.sleep(12000);
			actionProvider.moveToElement(searchDropdown).perform();
				
			Thread.sleep(9000);
			actionProvider.moveToElement(dropdownClick).perform();
				
			dropItemClick.click();
		}
		
		/*--------------------------SORT FROM HIGH TO LOW METHOD----------------------*/

		public void sort_HighToLow() throws InterruptedException
		{
			// Wait till the element is not visible
			WebDriverWait wait=new WebDriverWait(driver,30);
			Actions actionProvider = new Actions(driver);
			
			Thread.sleep(12000);
			actionProvider.moveToElement(searchDropdown).perform();
				
			Thread.sleep(9000);
			actionProvider.moveToElement(dropdownClick).perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/a[1]/div[2]/div[1]/div[1]")));
			dropItemClick.click();
				
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]/div[1]/img[1]")));
			elementClick.click();
				
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]")));
			sortHighToLow.click();
		}
		
		/*--------------------------SORT FROM LOW TO HIGH METHOD----------------------*/

		public void sort_LowToHigh() throws InterruptedException
		{
			// Wait till the element is not visible
			WebDriverWait wait=new WebDriverWait(driver,30);
			Actions actionProvider = new Actions(driver);
			
			Thread.sleep(12000);
			actionProvider.moveToElement(searchDropdown).perform();
				
			Thread.sleep(9000);
			actionProvider.moveToElement(dropdownClick).perform();
				
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/a[1]/div[2]/div[1]/div[1]")));
			dropItemClick.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]/div[1]/img[1]")));
			elementClick.click();
				
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]")));
			sortLowToHigh.click();
		}
}
