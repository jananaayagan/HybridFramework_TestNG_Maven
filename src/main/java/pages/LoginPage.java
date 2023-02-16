package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import appConstants.AppConstants;



public class LoginPage {

	WebDriver  driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By userName = By.id("loginId");
	By passWord = By.name("password");
	By login = By.name("Submit");
	By skip = By.id("closebutn");
	By logout = By.linkText("Logout");
	

	public void loginToApplication(String username, String password) {

		driver.findElement(userName).sendKeys(username);
		driver.findElement(passWord).sendKeys(password);
		driver.findElement(login).click();

	}

	public void clickSkipButton() {

		if (driver.findElement(skip).isDisplayed()) {
			driver.findElement(skip).click();
		} else {
			System.out.println("Skip popup is not present");
		}
	}

	public void verifyPageTitle() {
		if (driver.getTitle().contains(AppConstants.pmSmartPageTitle)) {
			Assert.assertTrue(true);
			System.out.println("Login successful");
		}

	}
	public  void logout() {
		
		driver.switchTo().defaultContent();
		driver.findElement(logout).click();
		driver.switchTo().alert().accept();
		
		
	}
	
	
	
	

}
