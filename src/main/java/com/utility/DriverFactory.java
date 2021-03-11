package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DriverFactory {
	
//    public  WebDriver driver;
   
	
//	String hub = System.getProperty("target.hub");
    public static ThreadLocal <WebDriver> thlDrv = new ThreadLocal<>();
    
    
    ChromeOptions chromeOptions = new ChromeOptions();
    
    FirefoxOptions firefoxoption = new FirefoxOptions().setAcceptInsecureCerts(false);
  
	public  WebDriver initDriver(String browser) throws MalformedURLException {
		
		String	hubCond = System.getProperty("hub");
//		hubCond = "No";
		if (hubCond==null) {
			System.out.println("inside hub");
			
			if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
//			driver= new ChromeDriver(chromeOptions);
			thlDrv.set(new ChromeDriver(chromeOptions));
			
			}
			else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
//				driver= new FirefoxDriver(firefoxoption);
				thlDrv.set(new FirefoxDriver(firefoxoption));
				}
			
			else if (browser.equalsIgnoreCase("safari")) {
//				driver= new SafariDriver();
				thlDrv.set(new SafariDriver());
				}
			else {
				System.out.println("please define a proper browser value");
			}
		
		
		}
		
		else if (hubCond.equals("yes")){
			
			DesiredCapabilities cap = new DesiredCapabilities();
			if (browser.equalsIgnoreCase("firefox")) {
				System.out.println("launching ff");
				cap.setBrowserName(BrowserType.FIREFOX);
//				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			}
			else if(browser.equalsIgnoreCase("chrome")) {
				cap.setBrowserName(BrowserType.CHROME);
				ChromeOptions option = new ChromeOptions();
				/*option.addArguments("Headless");
				option.setAcceptInsecureCerts(true);*/
//				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			}
			
		}
		
		else {
			System.out.println("invalid value");
			
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
//		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		return getDriver();
		
		
	}
	
	public static synchronized WebDriver getDriver () {
		return thlDrv.get();
	}
	

}
