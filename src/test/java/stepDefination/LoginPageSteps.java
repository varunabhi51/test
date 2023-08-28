package stepDefination;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import helper.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import page.LoginPage;

public class LoginPageSteps  {

	public static WebDriver driver;
	LoginPage login = new LoginPage();

	

	

//	@When("user enter username and password")
//	public void user_enter_username_and_password() {
//
//		login.user_enter_username_and_password();
//	}

	@When("user enter {string} and {string}")
	public void user_enter_and(String uname, String pass) throws IOException {
		login.user_enter_username_and_password(uname, pass);

	}

	@And("user click on login button")
	public void user_click_on_login_button() {
		login.user_click_on_login_button();

	}

	@Then("Validate user logged in successfully")
	public void validate_user_logged_in_successfully() {
		login.validate_user_logged_in_successfully();

	}

}
