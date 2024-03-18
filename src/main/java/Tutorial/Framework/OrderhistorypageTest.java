package Tutorial.Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tutorial.Framework.PageAbstract.PageAbstractClassTest;

public class OrderhistorypageTest extends PageAbstractClassTest{
	
	WebDriver driver;
	
	public OrderhistorypageTest(WebDriver driver)
	{
		super(driver);
		this.driver=driver;		
		PageFactory.initElements(driver, this);

	}
	
	
@FindBy(xpath="//tr[@class='ng-star-inserted']/th")
List<WebElement> ordernumbers;

@FindBy(xpath="//tr[@class='ng-star-inserted'][1]/td[2]")
WebElement ordern	;

	String name;
	public String ordername()
	{		
		super.waitclass(By.xpath("//tr[@class='ng-star-inserted'][1]/td[2]"));
		
	//	Orderconfirmation a=new Orderconfirmation(driver);
	/*	String b= x.split(" ")[1];
		System.out.println("*******b*******"+b);
		for(int i=0;i<ordernumbers.size();i++)
		{
		if(ordernumbers.get(i).getText().equalsIgnoreCase(b))
		{
			name =ordernumbers.get(i).findElement(By.xpath("th/following-sibling::td[2]")).getText();
			System.out.println("*******Name*******"+name);
		}
		
		}*/
		
		return ordern.getText();
	}
	
}
	

