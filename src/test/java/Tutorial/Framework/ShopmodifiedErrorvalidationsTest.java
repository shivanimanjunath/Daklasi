package Tutorial.Framework;

import java.awt.Window;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Tutorial.Framework.TestComponents.BaseTest;
import Tutorial.Framework.TestComponents.Retry;

public class ShopmodifiedErrorvalidationsTest extends BaseTest{

	
		//WebDriver driver= new ChromeDriver();
	@Test (groups="ErrorValidations")	
	public void ErrorLogin() throws InterruptedException, IOException {		
			
		ProductspageTest page = login.Logincreds("strawberry@gmail.com", "Cream95!");
		Assert.assertEquals(login.Errorscenario(), "Incorrect email or password.");	

	}	
	
	@Test(retryAnalyzer=Retry.class)
	public void PlaceOrderError() throws InterruptedException, IOException {
		
		
		ProductspageTest page = login.Logincreds("strawberry@gmail.com", "Cream90!");
		CheckoutTest c=	page.AddCart();		
		Thread.sleep(2000);
	page.gotocart();	 	 
	 login.visibility(By.xpath("//button[contains(text(),'Checkout')]"));
		c.verifyproduct();
		Assert.assertFalse(c.verifyproduct());
		
	}	
	
	
}
