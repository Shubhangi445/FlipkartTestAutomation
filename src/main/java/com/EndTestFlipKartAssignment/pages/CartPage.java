package com.EndTestFlipKartAssignment.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	WebDriver driver;

	/*--------------------------Initializing Page Element----------------------*/

	public CartPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	/*--------------------------Declare Web Elements Via Different Locators----------------------*/

	@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]")
	public WebElement cartBtn;
	
	@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/a[1]/span[1]")
	public WebElement cartButton;
		
	@FindBy(how = How.CLASS_NAME , using = "_3dsJAO")
	public WebElement saveBtn;
	
	@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]")
	public WebElement confRemoveBtn;
	
	@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
	public WebElement message;
	
	@FindBy(how = How.CLASS_NAME , using = "_3gc7Vf")
	public WebElement address;
	
	@FindBy(how = How.XPATH , using = "_3JbnzD")
	public WebElement addressSelect;
	
	/*-------------------------------Using Web Elements in different Methods-------------------------------*/
	
	
	/*--------------------------ADD TO CART METHOD----------------------*/
	public void addToCart() throws InterruptedException 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0, 500)");
		
		String currentHandle = driver.getWindowHandle();
	    Set<String> handleSet = driver.getWindowHandles();
	    for (String handle : handleSet) {
	    if (!handle.equalsIgnoreCase(currentHandle)) {
	    driver.switchTo().window(handle);
	    	}
	    }
	    Thread.sleep(2000);
		cartBtn.click();
			
		}
	
	public void toCartElement() throws InterruptedException
	{	
		Thread.sleep(2000);
	    List<WebElement> elements = driver.findElements(By.className("_4rR01T"));
		elements.get(elements.size()-1).click();
	    
	}

	/*--------------------------SAVE FOR LATER METHOD----------------------*/

	public void save() throws InterruptedException
		{	
			WebDriverWait wait=new WebDriverWait(driver,30);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/a[1]/span[1]")));
			cartButton.click();

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0, document.body.getBoundingClientRect().height / 2)", "");	

			wait.until(ExpectedConditions.elementToBeClickable(By.className("_3dsJAO"))).click();
		}
	
	/*--------------------------REMOVE ITEM METHOD----------------------*/

	
	public void remove() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#container > div > div._1kfTjk > div._1rH5Jn > div._2Xfa2_ > div:nth-child(5) > div > div > a"))).click();
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.getBoundingClientRect().height / 2)", "");
		
		Thread.sleep(3000);
		List<WebElement> elements = driver.findElements(By.className("_3dsJAO"));
		elements.get(elements.size()-1).click();
        
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]")));
        confRemoveBtn.click();
	}
	
	/*--------------------------ADDRESS CHANGE IN CART METHOD----------------------*/

	public void changeAddress() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver,30);
	
		Thread.sleep(5000);
		cartButton.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.className("_3gc7Vf")));
		address.click();
		
		Thread.sleep(3000);
		List<WebElement> elements = driver.findElements(By.className("_3JbnzD"));
		elements.get(elements.size()-1).click();
	
	}
}
