package com.maveric.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CorporatePointOfContactPage {
	
	
	
	@FindBy(xpath="//span[text()='Administration Contact']")
	WebElement admContact;
	
	@FindBy(xpath="//table[@id='yw0-body-table']/tbody/tr")
	List<WebElement> rowsEle;
	
	@FindBy(linkText="Corporate")
	WebElement corpEle;
	
	@FindBy(xpath="//a[text()='Point of Contact']")
	WebElement pocEle;
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CorporatePointOfContactPage(WebDriver driver,WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver, this); // this points to current pages
	}
	
	public void clickOnCorporateAndPOC()
	{
		Actions action = new Actions(driver);
		action.moveToElement(corpEle).build().perform();
		
		pocEle.click();
	}
	public void admClick()
	{
		admContact.click();
	}
	
	public int emailRowsSize(){
		 
		int noOfRows=rowsEle.size();
		return noOfRows;
		
	}
	public List<String> admEmails() {
		List<String> listOfEmails = new ArrayList<String>();
		
		for(int i=1;i<=emailRowsSize();i++) {
			//System.out.println("I Value Is "+i+" .");
			WebElement namesEle = driver.findElement(By.xpath("//table[@id='yw0-body-table']/tbody/tr["+i+"]/td[5]"));
			listOfEmails.add(namesEle.getText());
		}	
		return listOfEmails;		
	}
	
}
