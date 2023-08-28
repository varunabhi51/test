package stepDefination;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.CheckoutPage;

public class CheckoutPageSteps {
	
	CheckoutPage  checkout = new CheckoutPage();
	
	@When("user enter information {string} {string} {string}")
	public void user_enter(String fname, String lname, String pcode) {
		checkout.user_enter_information(fname, lname, pcode);
	    
	}
	
	
	@Given("user place order with cash on delivery mode")
	public void user_place_order_with_cash_on_delivery_mode() throws IOException {
	    checkout.userPlaceAnOrder();
	}
	
	@Then ("validate order confirmation")
	public void validate_order_confirmation() {
		checkout.validateOrderCondirmation();


}
	
	@Then("validate error masssage")
	public void validate_error_massage() {
		checkout.validateErrorMassage();
	}
}