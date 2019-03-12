package com.maveric.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MavericHomePage {
	By qmsLoc= By.xpath("//a[text()='QMS']");
	
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	public MavericHomePage(WebDriver driver,WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver, this); // this points to current pages
	}
	
	public String waitForQMSDisplayAndGetTitle()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(qmsLoc));		
		return driver.getTitle();
	}
	/*public static String getTitle(WebDriver driver) {
		String actualText=driver.getTitle();
		return actualText;
	}*/
	
	
}
