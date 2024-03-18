package Tutorial.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tutorial.Framework.PageAbstract.PageAbstractClassTest;

public class OrderconfirmationTest extends PageAbstractClassTest{
	
	WebDriver driver;
	
	public OrderconfirmationTest(WebDriver driver)
	{
		super(driver);
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}

	
	
@FindBy(css="tr[class='ng-star-inserted']")
WebElement ordernumber;

@FindBy(css="label[routerlink='/dashboard/myorders']")
WebElement orderhist;

	public String confirmedorder()
	{		
	//	super.waitclass(By.cssSelect or("h1[class='hero-primary']"));
		String x=ordernumber.getText();
		System.out.println("****ordernumber****"+x);
		return ordernumber.getText();
	}
	
	public OrderhistorypageTest Orderhistoryclick()
	{
		orderhist.click();
		OrderhistorypageTest op=new OrderhistorypageTest(driver);
		return op;
		
	}
	
}
