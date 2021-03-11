package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pages.*;
import com.pages.LoginPage;
import com.utility.DriverFactory;

public class loginStep {

    
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	SignInPage signIn = new SignInPage(DriverFactory.getDriver());
	
	
	@Given("User Launches the app")
	public void launch() {
		
	}

	@Given("User is on login page")
	public void user_is_on_login_pag() {
		DriverFactory.getDriver().get("http://automationpractice.com/");
		
		loginPage.clickSignIN();
	}

	@When("User enters correct credentials as {string} and {string}")
	public void user_enters_correct_credentials(String email, String pass) {
		
		signIn.doEnterEmail(email);
		
	}

	@Then("User login successfully")
	public void user_login_successfully() {
		System.out.println("Hi");
	}
	
//	@When("User clicks signIn")
//	public void user_clicks_sign_in() {
//		
//		loginPage.doSignIn();
//	}
}
