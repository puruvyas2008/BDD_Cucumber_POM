package com.hooks;


import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.utility.ConfigReader;
import com.utility.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before
	public void launchBrowser(Scenario scenario) {
		
		System.out.println("Starting Scenario: " +scenario.getName()+" at: "+java.time.LocalDateTime.now());
		configReader = new ConfigReader();
		 prop= configReader.init_prop();
		 String browserName = System.getProperty("browser");
		 if (browserName==null) {
			 
			 browserName = prop.getProperty("browser");
		 }
		driverFactory = new DriverFactory();
		try {
			driver=driverFactory.initDriver(browserName);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
		
		 String url = prop.getProperty("url");
		
		 DriverFactory.getDriver().get(url);
	}

	@After
	public void quitBrowser() {
		driver.quit();
	}
	
	@AfterStep
	public void tearDown(Scenario scenario) {
		System.out.println("Ending Scenario: " +scenario.getName()+" at: "+ java.time.LocalDateTime.now());
		if (!scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}
	
	
	
}
