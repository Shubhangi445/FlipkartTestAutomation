package com.EndTestFlipKartAssignment.utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SwitchWindowPage {

	WebDriver driver;
	public SwitchWindowPage(WebDriver driver) {
	this.driver=driver;
	}
	public boolean toTitle(String title) {
	String currentHandle= driver.getWindowHandle();
	Set<String> handleSet= driver.getWindowHandles();
	for(String handle: handleSet)
	{
	if(!handle.equalsIgnoreCase(currentHandle))
	{
	driver.switchTo().window(handle);
	if(driver.getTitle().equals(title)) {
	return true;
	}
	driver.switchTo().window(currentHandle);
	}
	}
	return false;
	}
}
