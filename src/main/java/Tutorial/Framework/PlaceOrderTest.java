package Tutorial.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tutorial.Framework.PageAbstract.PageAbstractClassTest;

public class PlaceOrderTest extends PageAbstractClassTest{
	
	WebDriver driver;
	
	public PlaceOrderTest(WebDriver driver)
	{
		super(driver);
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath="//input[@placeholder='Select Country']")
WebElement country;
	
@FindBy(css=".ta-item:nth-of-type(1)")
WebElement selectedcountry;

@FindBy(css="a[class*='action__submit']")
WebElement submit;


	public OrderconfirmationTest placeorders()
	{
		super.action().sendKeys(country, "Aust").build().perform();	
		super.waitclass(By.cssSelector("button[class*='ng-star-inserted']"));
		
		selectedcountry.click();
		submit.click();
		OrderconfirmationTest oc=new OrderconfirmationTest(driver);
		return oc;
		
	}
	
}
