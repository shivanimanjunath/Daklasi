package Tutorial.Framework;

import java.awt.Window;
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

import Tutorial.Framework.TestComponents.BaseTest;

public class Shop2duplicateTest {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		
		
		
		LoginpageTest login=new LoginpageTest(driver);
		
	
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait w=new WebDriverWait(driver ,Duration.ofSeconds(5));
		login.LandOn();
		//driver.manage().window().maximize();		
		//login.Logincreds("strawberry@gmail.com", "Cream90!");
		
		//login.waitclass(By.id("toast-container"));
		
		ProductspageTest page = login.Logincreds("strawberry@gmail.com", "Cream90!");
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		
		
		//Thread.sleep(4000);
		/*String a[]= {"ZARA COAT 3","IPHONE 13 PRO"};	
		List<String> li= Arrays.asList(a);*/
		
		//Productspage page= new Productspage(driver);
		CheckoutTest c=	page.AddCart();
		
	//	List<WebElement> card=driver.findElements(By.xpath("//div[@class='card']/div/h5"));
	//	List<WebElement> elements=driver.findElements(By.xpath("//div[@class=\"card-body\"]/button[2]"));
		
	/*	for(int i=0;i<card.size();i++)
		{
			String name=card.get(i).getText();
			System.out.println(name);
			
			if(li.contains(name))
			{	
				
				elements.get(i).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
				System.out.println(driver.findElement(By.id("toast-container")).getText());
			}
		}*/
		
		
		
		
		Thread.sleep(2000);
	//String al=	driver.findElement(By.cssSelector("button[class='btn btn-custom'] label")).getText();
	 //System.out.println(al);
	// int n=Integer.parseInt(al);
	// Assert.assertEquals(n, li.size());
	 
	page.gotocart();
	 	 
	 login.visibility(By.xpath("//button[contains(text(),'Checkout')]"));
	 
	//List<WebElement> cart=driver.findElements(By.xpath("//div[@class='cartSection']/img"));
	 
	// Assert.assertEquals(cart.size(), li.size());
	// List<WebElement> carts=driver.findElements(By.cssSelector(".cartSection h3"));	
	 //System.out.println(carts.size());
	 
	 
//JavascriptExecutor js= (JavascriptExecutor) driver;
 //   js.executeScript("window.scrollBy(0,600)");
	
	//System.out.println(driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[4]")).getText());
	
//driver.findElement(By.cssSelector("div[class='cartSection'] h3")).getText();
	
	
	//Checkout c= new Checkout(driver);
		c.verifyproduct();
	c.checkoutclick();

	//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Aust");
	PlaceOrderTest p=new PlaceOrderTest(driver);
	
	p.placeorders();
	
	OrderconfirmationTest oc=new OrderconfirmationTest(driver);
	oc.confirmedorder();
	/*List<WebElement> autoselect=driver.findElements(By.cssSelector("span[class='ng-star-inserted']"));
	
	
	for(int i=0;i<autoselect.size();i++)
	{		
		if(autoselect.get(i).getText().equalsIgnoreCase("Australia"))
		{
			autoselect.get(i).click();
			break;
		}
	}*/
	
	}
}
