package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.CommonActions;
import com.utility.DriverFactory;

public class LoginPage {
	
	
//	CommonActions action;
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
//		action = new CommonActions( driver);
//		System.out.println("driver value is *********************** : "+ driver);
	}

	CommonActions action = new CommonActions( driver);
   
	@FindBy(className ="login")
     WebElement signIN;
	
	public void clickSignIN() {
		
//		if (signIN.isDisplayed()) {
//			signIN.click();
//		}
		
		action.doClick(signIN);
		}

	
}
