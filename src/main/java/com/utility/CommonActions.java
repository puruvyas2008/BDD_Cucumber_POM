package com.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions extends DriverFactory{
	WebDriver driver;
	WebDriverWait wt;
	
	public CommonActions (WebDriver driver) {
		this.driver = driver;
	}

	@SuppressWarnings("deprecation")
	public void  doClick(WebElement ele)
	{
		try {
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println("inside click method "+ele.getText());
//			wt =new WebDriverWait(driver, 10);
//			wt.until(ExpectedConditions.invisibilityOf(ele));
//			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
			ele.click();
		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ele.click();

	}

}
