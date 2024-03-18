package Tutorial.Framework.StepDefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import Tutorial.Framework.CheckoutTest;
import Tutorial.Framework.LoginpageTest;
import Tutorial.Framework.OrderconfirmationTest;
import Tutorial.Framework.PlaceOrderTest;
import Tutorial.Framework.ProductspageTest;
import Tutorial.Framework.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionimplementTest extends BaseTest {
	
	public LoginpageTest login;
	public ProductspageTest page;
	public CheckoutTest check;
	public PlaceOrderTest place;
	public OrderconfirmationTest order;
	
	@Given("I land on the ecommerce website")
	public void I_land_on_the_ecommerce_website() throws IOException
	{
		login =Launchapp();
		
	}
	
	@Given("^I login using credentials (.+) and (.+)$")
	public void I_login_using_credentials_username_andpassword(String username , String password)
	{
		page= login.Logincreds(username, password);
	}
	
	 @When("I add product to the cart")
	 public void I_add_product_to_the_cart() throws InterruptedException
	 {
		check= page.AddCart();
		Thread.sleep(2000);
		page.gotocart();
		login.visibility(By.xpath("//button[contains(text(),'Checkout')]"));
	 }
	 
	 @And("checkout the product")
	 public void checkout_the_product()
	 {
		check.verifyproduct();
		place=check.checkoutclick();
	 }
	
	 @Then("I should be navigated to Order Confirmation page")
	 public void I_should_be_navigated_to_Order_Confirmation_page()
	 {
		 order= place.placeorders();
		 order.confirmedorder();
	 }
	 

		@Then("{string} should be dsiplayed")
		public void String_should_be_dsiplayed(String message)
		{
			Assert.assertEquals(login.Errorscenario(), message);
		}
	
}
