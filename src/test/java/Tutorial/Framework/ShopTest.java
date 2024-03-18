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

public class ShopTest {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		
		LoginpageTest login=new LoginpageTest(driver);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		WebDriverWait w=new WebDriverWait(driver ,Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		login.userName.sendKeys("strawberry@gmail.com");
		//driver.findElement(By.id("userEmail")).sendKeys("strawberry@gmail.com");
		login.password.sendKeys("Cream90!");
		//driver.findElement(By.id("userPassword")).sendKeys("Cream90!");
		login.loginClick.click();
		//driver.findElement(By.id("login")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		System.out.println(driver.findElement(By.id("toast-container")).getText());
		
		Thread.sleep(4000);
		String a[]= {"ZARA COAT 3","IPHONE 13 PRO"};	
		List<String> li= Arrays.asList(a);
		List<WebElement> card=driver.findElements(By.xpath("//div[@class='card']/div/h5"));
		List<WebElement> elements=driver.findElements(By.xpath("//div[@class=\"card-body\"]/button[2]"));
		
		for(int i=0;i<card.size();i++)
		{
			String name=card.get(i).getText();
			System.out.println(name);
			
			if(li.contains(name))
			{	
				
				elements.get(i).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
				System.out.println(driver.findElement(By.id("toast-container")).getText());
			}
		}
		
		Thread.sleep(2000);
	String al=	driver.findElement(By.cssSelector("button[class='btn btn-custom'] label")).getText();
	 System.out.println(al);
	 int n=Integer.parseInt(al);
	 Assert.assertEquals(n, li.size());
	 
	 driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	 	 
	 w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Checkout')]")));
	 
	List<WebElement> cart=driver.findElements(By.xpath("//div[@class='cartSection']/img"));
	 
	 Assert.assertEquals(cart.size(), li.size());
	 List<WebElement> carts=driver.findElements(By.cssSelector(".cartSection h3"));	
	 System.out.println(carts.size());
	 
	 
	JavascriptExecutor js= (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,600)");
	
	System.out.println(driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[4]")).getText());
	
	Actions acti=new Actions(driver);
	acti.moveToElement(driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[4]"))).click().build().perform();

	
	acti.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "Aust").build().perform();
	//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Aust");
	
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='ng-star-inserted']")));
	
	driver.findElement(By.cssSelector(".ta-item:nth-of-type(1)")).click();
	/*List<WebElement> autoselect=driver.findElements(By.cssSelector("span[class='ng-star-inserted']"));
	
	
	for(int i=0;i<autoselect.size();i++)
	{		
		if(autoselect.get(i).getText().equalsIgnoreCase("Australia"))
		{
			autoselect.get(i).click();
			break;
		}
	}*/
	driver.findElement(By.cssSelector("a[class*='action__submit']")).click();
	
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[class='hero-primary']")));
	System.out.println(driver.findElement(By.cssSelector("tr[class='ng-star-inserted']")).getText());
	}
}
