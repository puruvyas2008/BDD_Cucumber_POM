package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.CommonActions;
import com.utility.DriverFactory;

public class SignInPage {
	
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	private WebDriver driver;
	CommonActions action = new CommonActions( driver);
   
	@FindBy(id ="email")
     WebElement eMail;
	
	

	public void doEnterEmail(String email) {
		System.out.println("entering password");
		eMail.sendKeys("mymail");
		
	}

	public void doEnterPassword(String pass) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
