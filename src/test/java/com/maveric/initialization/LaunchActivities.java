package com.maveric.initialization;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.maveric.utilities.PropertiesHandler;

public class LaunchActivities {

	public WebDriver driver;
	public WebDriverWait wait;
	public Properties prop;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters({"browser"})
	public void initialization(@Optional("chrome") String browser) throws IOException {
		switch (browser) {
		case "ie":
			System.setProperty("webdriver.ie.driver","Driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();			
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver","Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
			driver= new ChromeDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
			driver= new ChromeDriver();
			break;
		}
		
		
		
		driver.manage().window().maximize();
		//explicit Wait Example
		wait = new WebDriverWait(driver, 50);
		prop=PropertiesHandler.getPropertiesDetails("Utilities/data.properties");
		
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}
