package Tutorial.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Tutorial.Framework.PageAbstract.PageAbstractClassTest;

public class CheckoutTest extends PageAbstractClassTest{
	
	WebDriver driver;
	
	public CheckoutTest(WebDriver driver)
	{
		super(driver);
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}

@FindBy(css="li[class='totalRow'] button[class*='btn-primary']")
WebElement checkkoutbutton;

@FindBy(css="div[class='cartSection'] h3")
WebElement productss;
	
	public PlaceOrderTest checkoutclick()
	{
		
	  super.action().moveToElement(checkkoutbutton).click().build().perform();
	  PlaceOrderTest p=new PlaceOrderTest(driver);
	  return p;
	}
	
	
	public boolean verifyproduct()
	{
		ProductspageTest p=new ProductspageTest(driver);
		String a=p.Added();
		Assert.assertEquals(productss.getText(), a);
		return true;
		
	}
	
}
