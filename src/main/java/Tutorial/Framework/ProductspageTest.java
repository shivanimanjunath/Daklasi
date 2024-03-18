package Tutorial.Framework;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Tutorial.Framework.PageAbstract.PageAbstractClassTest;

public class ProductspageTest extends PageAbstractClassTest{
	
	WebDriver driver;
	
	public ProductspageTest(WebDriver driver)
	{
		super(driver);
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}

//	WebElement userName=driver.findElement(By.id("userEmail"));
	
	@FindBy(xpath="//div[@class='card']/div/h5")
	List<WebElement> card;
	
	@FindBy(css="div[class='card-body'] button[class*='w-10']")
	List<WebElement> elements;
	
	
	
	public List<String> TobeAddedList()
	{
		String a[]= {"ZARA COAT 3"};	
		List<String> li= Arrays.asList(a);
		return li;
	}
	
	public String Added()
	{
		String a="ZARA COAT 3";	
		return a;
		
	}
	
	public CheckoutTest AddCart()
	{

		for(int i=0;i<card.size();i++)
		{
			String name=card.get(i).getText();
			System.out.println(name);
			
			if(TobeAddedList().contains(name))
			{	
				//super.waity(elements.get(i));
				elements.get(i).click();
				super.waitclass(By.id("toast-container"));

			}
		}
		return new CheckoutTest(driver);
	}
	
}
