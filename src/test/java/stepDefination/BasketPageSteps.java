package stepDefination;

import io.cucumber.java.en.Given;
import page.BasketPage;

public class BasketPageSteps {
	
	BasketPage basket = new BasketPage();
	
	
	
	
	@Given("user add product into the basket from PLP page")
	public void user_add_product_into_the_basket_from_plp_page() {
		basket.user_add_product_into_the_basket_from_plp_page();
		basket.validateBasketCount();
	    
	}
	
	@Given("user navigate to cart page")
	public void user_navigate_to_cart_page() {
	    basket.clickoncheckoutButton();
	}

	
	@Given("user enter {string} {string} {string}")
	public void user_enter(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
