package com.maveric.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.maveric.initialization.LaunchActivities;
import com.maveric.pageobjects.CorporatePointOfContactPage;
import com.maveric.pageobjects.MavericHomePage;
import com.maveric.pageobjects.MavericLoginPage;
import com.maveric.utilities.ExcelUtils;
import com.maveric.utilities.PropertiesHandler;


public class MaveriConnectTest extends LaunchActivities {
	
	@Test(groups="high")
	public void positiveCredentialCheckwithPOM() throws IOException {
	
		String userName=prop.getProperty("username");
		String passWord=prop.getProperty("pwd");
		
		MavericLoginPage login= new MavericLoginPage(driver, wait);
		
		login.sendUserName(userName);
		login.sendPWD(passWord);
		login.loginClick();
		
		MavericHomePage homePage= new MavericHomePage(driver, wait);
		
		String actualTitle=homePage.waitForQMSDisplayAndGetTitle();

		Assert.assertEquals(actualTitle,prop.getProperty("title") );
		
		CorporatePointOfContactPage corpPage= new CorporatePointOfContactPage(driver, wait);
		
		//POC Click
		corpPage.clickOnCorporateAndPOC();		
		corpPage.admClick();			
		
		List<String> emailsPOC=corpPage.admEmails();
		
		for(String email:emailsPOC) {
			System.out.println(email);
		}
		
					
	}
	
}
	


