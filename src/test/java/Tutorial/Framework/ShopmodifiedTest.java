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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Tutorial.Framework.TestComponents.BaseTest;

public class ShopmodifiedTest extends BaseTest{

	public OrderconfirmationTest oc;
	public String occ;
		//WebDriver driver= new ChromeDriver();
	@Test(dataProvider="getData" , groups={"Purchase"})	
	public void submitOrder(String email , String password) throws InterruptedException, IOException {
		
			
		ProductspageTest page = login.Logincreds(email, password);
		CheckoutTest c=	page.AddCart();		
		Thread.sleep(2000);
	page.gotocart();	 	 
	 login.visibility(By.xpath("//button[contains(text(),'Checkout')]"));
		c.verifyproduct();
		PlaceOrderTest p=c.checkoutclick();	
		
		oc=p.placeorders();
	occ=oc.confirmedorder();
	}	
	
	@Test(dependsOnMethods={"submitOrder"},groups={"Purchase"})
	public void orderHistory()
	{
		OrderhistorypageTest op=oc.Orderhistoryclick();
	Assert.assertEquals(op.ordername(), "ZARA COAT 3");	
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
	return	new Object[][] {{"strawberry@gmail.com", "Cream90!"},{"shetty@gmail.com", "Iamking@000"}};
	}
	
}
