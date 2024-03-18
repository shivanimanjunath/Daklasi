package Tutorial.Framework;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Tutorial.Framework.TestComponents.BaseTest;
import Tutorial.Framework.data.Shopdata;


public class ShopmodifiedwithJsonTest extends BaseTest{

	public OrderconfirmationTest oc;
	public String occ;
		//WebDriver driver= new ChromeDriver();
	
	
	@Test(dataProvider="getData")	
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {
		
			
		ProductspageTest page = login.Logincreds(input.get("email"), input.get("password"));
		CheckoutTest c=	page.AddCart();		
		Thread.sleep(2000);
	page.gotocart();	 	 
	 login.visibility(By.xpath("//button[contains(text(),'Checkout')]"));
		c.verifyproduct();
		PlaceOrderTest p=c.checkoutclick();	
		
		oc=p.placeorders();
	occ=oc.confirmedorder();
	}	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		Shopdata shop=new Shopdata();
	//List<HashMap<String,String>> map=shop.datashop();
		
 		List<HashMap<String,String>> map=datashop("C:\\Users\\theer\\eclipse-workspace-Shivani\\Framework\\src\\test\\java\\Tutorial\\Framework\\data\\testdata.json");
		
	return new Object[][] {{map.get(0)},{map.get(1)}};
		
	}
	
	
	
	
}
