package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import browserFactory.BrowserFactory;
import dataProvider.ConfigReader;
import pages.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	
	
	@BeforeMethod
	//@BeforeClass
	public void setupBrowser() {
		
		System.out.println("LOG:INFO - Setting up browser");
		
		driver = BrowserFactory.startBrowser(ConfigReader.getProperty("browser"), ConfigReader.getProperty("url"));
	}
	@AfterMethod
	//@AfterClass
	public void tearDown() {
		
		driver.quit();
		System.out.println("LOG:INFO - Closing browser");
	}

}
