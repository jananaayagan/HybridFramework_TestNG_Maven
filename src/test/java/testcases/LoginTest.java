package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import appConstants.AppConstants;
import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.LoginPage;

public class LoginTest extends BaseClass{
	
	@Test(dataProvider="loginDetails",dataProviderClass = CustomDataProvider.class)
	public void loginToApplication(String uname, String pass) {
		
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(uname, pass);
		login.clickSkipButton();
		login.verifyPageTitle();
		//Assert.assertEquals(AppConstants.pmSmartHomePageURL, driver.getCurrentUrl());
		login.logout();
	}
}
