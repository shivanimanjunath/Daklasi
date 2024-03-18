package Tutorial.Framework.StepDefinition;

import java.io.IOException;

import org.testng.Assert;

import Tutorial.Framework.LoginpageTest;
import Tutorial.Framework.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionErrorTest extends BaseTest{

	public LoginpageTest login;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		login =Launchapp();
		
	}
	
	@When("^I enter the username (.+) and password (.+)$")  
	public void I_enter_the_username_and_password(String username , String password)
	{
		login.Logincreds(username, password);
		
	}
	
	
}
