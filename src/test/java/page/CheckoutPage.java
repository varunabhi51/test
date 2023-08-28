package page;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class CheckoutPage extends Base {
	// generix mehtod with included wait

	public By FirstName = By.xpath("//input[@id='first-name']");
	public By lastName = By.xpath("//input[@id='last-name']");
	public By postalCode = By.xpath("//input[@id='postal-code']");
	public By continueBtn = By.cssSelector("input#continue");
	public By finishbtn = By.cssSelector("button#finish");
	public By successMsg = By.cssSelector("h2.complete-header");
	public By errormsg = By.cssSelector("[data-test='error']");

	public void user_enter_information(String fname, String lname, String pcode) {

		waitForExpectedElement(FirstName).sendKeys(fname);

		waitForExpectedElement(lastName).sendKeys(lname);

		waitForExpectedElement(postalCode).sendKeys(pcode);

		waitForExpectedElement(continueBtn).click();

	}

	public void userPlaceAnOrder() throws IOException {

		takescreenshot();

		waitForExpectedElement(finishbtn).click();

	}

	public void validateOrderCondirmation() {

		String confirmationMessage = waitForExpectedElement(successMsg).getText();
		assertEquals("Thank you for your order!", confirmationMessage);
	}

	public void validateErrorMassage() {
		
		boolean error = waitForExpectedElement(errormsg).isDisplayed();

		assertTrue(error);
	}

}