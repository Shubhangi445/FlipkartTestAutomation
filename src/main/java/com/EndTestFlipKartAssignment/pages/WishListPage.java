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

public class WishListPage {

	/*--------------------------Initializing Page Element----------------------*/

	WebDriver driver;
	
	public WishListPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	/*--------------------------Declare Web Elements Via Different Locators----------------------*/

	@FindBy(how = How.CLASS_NAME , using = "eX72wL")
	public WebElement wishListBtn;

	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")
	public WebElement myAccountBtn;
	
	@FindBy(how=How.XPATH, using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[5]/a[1]")
	public WebElement wishlistOption;
	
	@FindBy(how=How.XPATH, using="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/a[1]/div[2]/div[2]/div[1]/span[1]/img[1]")
	public WebElement delete;
	
	@FindBy(how = How.CLASS_NAME , using = "_2sKwjB")
	public WebElement message;
		
	/*--------------------------Using Web Elements in different Methods----------------------*/

	 
	/*--------------------------ADD TO WISHLIST METHOD----------------------*/
	
	public void addToWishList()
	{
		// Wait till the element is not visible
		WebDriverWait wait=new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.className("eX72wL")));
		List<WebElement> elements = driver.findElements(By.className("eX72wL"));
		elements.get(elements.size()-1).click();
	}

	/*--------------------------REMOVE FROM WISHLIST METHOD----------------------*/

	public void removeFromWishlist() 
	{
		// Wait till the element is not visible
		WebDriverWait wait=new WebDriverWait(driver,35);
		Actions actionProvider = new Actions(driver);		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")));
		actionProvider.moveToElement(myAccountBtn).perform();	
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[5]/a[1]"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/a[1]/div[2]/div[2]/div[1]/span[1]/img[1]"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/a[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[2]"))).click();
		
    }
}		