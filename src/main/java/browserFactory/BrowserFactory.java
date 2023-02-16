package browserFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getBrowserInstance() {
		return driver;
		
	}
	
	public static WebDriver startBrowser(String browserName, String applicationURL) {
		
		
		if(browserName.contains("Chrome") || browserName.contains("GC") || browserName.contains("Google Chrome")) {
			
			driver = new ChromeDriver();
		}
		else if(browserName.contains("FireFox") || browserName.contains("FF") || browserName.contains("Mozilla FireFox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.contains("Safari") || browserName.contains("SF") || browserName.contains("Apple Safari")) {
			
			driver = new SafariDriver();			
		}
		else if(browserName.contains("Edge") || browserName.contains("ME") || browserName.contains("Microsoft Edge")) {
			driver = new EdgeDriver();
		}
		
		else {
			Reporter.log("The given brower "+ browserName + "is not valid , so launch with Chrome browser");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		
		driver.get(applicationURL);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		return driver;
		
	}

}
