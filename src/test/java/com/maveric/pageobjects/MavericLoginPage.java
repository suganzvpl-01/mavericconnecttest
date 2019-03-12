package com.maveric.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MavericLoginPage {
	
	
	By invalidErrorLoc = By.xpath("//div[@id='LoginForm_password_em_']");
	
	@FindBy(css="#LoginForm_username")
	WebElement userNameEle;
	
	@FindBy(xpath="//input[@id='LoginForm_password']")
	WebElement passWordEle;
	
	@FindBy(name="yt0")
	WebElement submitEle;
	
	@FindBy(how=How.XPATH, using="//div[@id='LoginForm_password_em_']")
	WebElement errTextEle;
	
	@FindBy(tagName="a") // one more method @FindAll(@FindBy(tagname="a"))
	List<WebElement> allATag;  
	
	WebDriver driver;
	WebDriverWait wait;
	
	public MavericLoginPage(WebDriver driver,WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver, this); // this points to current pages
	}
		
	public void sendUserName(String userName)
	{
		
		userNameEle.sendKeys(userName);
	}
	public void sendPWD(String passWord)
	{
		passWordEle.sendKeys(passWord);
	}
	
	public void loginClick()
	{
		submitEle.click();
	}
	public String getInvalidErrorMessageAndWait()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidErrorLoc));
		return errTextEle.getText();		
	}
	public int getNoOfLinks()
	{
		int noOfLinks = allATag.size();
		return noOfLinks;
	}
	
	
	
}
