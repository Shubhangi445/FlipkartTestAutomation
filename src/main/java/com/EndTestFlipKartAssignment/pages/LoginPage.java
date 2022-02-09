package com.EndTestFlipKartAssignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{

	WebDriver driver;
	
	/*--------------------------Initializing Page Element----------------------*/

		public LoginPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}
	
		/*--------------------------Declare Web Elements Via Different Locators----------------------*/

		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
		public WebElement enterValidPhoneNumber;
		
		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]")
		public WebElement enterValidPassword;
	
		@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")
		public WebElement loginBtn;
		
		@FindBy(how = How.XPATH , using = "html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/span[3]/span[1]")
		public WebElement message;
		
		/*--------------------------Using Web Elements in different Methods----------------------*/

		
		/*--------------------------LOGIN METHOD----------------------*/

		public void enterCredentials(String num, String pass)
		{
			WebDriverWait wait=new WebDriverWait(driver,30);
	       
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")));
			enterValidPhoneNumber.sendKeys(num);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")));
			enterValidPassword.sendKeys(pass);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")));
			loginBtn.click();
		}		
}
