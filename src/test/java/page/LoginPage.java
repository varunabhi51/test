package page;

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

public class LoginPage extends Base {
	
	public By userName = By.cssSelector("input#user-name");
	public By password = By.cssSelector("input#password");
	public By loginBt = By.cssSelector("input#login-button");
	

	public void user_enter_username_and_password(String email,String pass) throws IOException {
		
		waitForExpectedElement(userName).sendKeys(email);
        waitForExpectedElement(password).sendKeys(pass);
        takescreenshot();

	}

	public void user_click_on_login_button() {

		  WebElement loginBtn = driver.findElement(loginBt);
		  loginBtn.click();
		

	}

	public void validate_user_logged_in_successfully() {
		
		WebElement personIcon  = driver.findElement(By.cssSelector(""));
		mouseHover(personIcon);

	}

}
 