package helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static void clickElement(WebDriver driver, By loactor) {

		try {
			driver.findElement(loactor).click();
		} catch (Exception e) {
			try {
				System.out.println("Trying with action class click");
				Actions act = new Actions(driver);
				act.moveToElement(driver.findElement(loactor)).click().build().perform();

			} catch (Exception e1) {
				System.out.println("Trying with JS Click");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arugments[0].click", driver.findElement(loactor));

			}

		}

	}
	
	
	public static Alert waitForAlert(WebDriver driver) throws InterruptedException {
		
		Alert alt = null;
		
		for(int i=0;i<=15;i++) {
			
			try {
				alt = driver.switchTo().alert();
			}
			catch(NoAlertPresentException e){
				System.out.println("No Alert Found - waiting for Alert");
				
				waitForSeconds(1);
			}
		}
		
		return alt;
		
	}
	
	public static void waitForSeconds(int seconds) throws InterruptedException {
		
		Thread.sleep(seconds*1000);
		
	}
	
	public static String captureScreenShotInBase64(WebDriver driver) {
		
		TakesScreenshot ts =(TakesScreenshot)driver;
		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		
		return base64;
		
	}

	public static void captureScreenshot(WebDriver driver) {
		
		try {
			FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("./screenshots/Screenshot_"+getCurrentTime()+".png"));
		}
		catch(IOException e) {
			System.out.println("Something went wrong"+e.getMessage());
			
		}
	}
	
	public static String getCurrentTime() {
		String date = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
		return date; 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
