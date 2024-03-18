package Tutorial.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tutorial.Framework.PageAbstract.PageAbstractClassTest;

public class LoginpageTest extends PageAbstractClassTest{
	
	WebDriver driver;
	
	public LoginpageTest(WebDriver driver)
	{
		super(driver);
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}

//	WebElement userName=driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userName;
		
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginClick;
	
	
	@FindBy(css="div[class*='toast-message']")
	WebElement Errormessage;
	
	
	public ProductspageTest Logincreds(String name , String pass)
	{
		userName.sendKeys(name);
		password.sendKeys(pass);
		loginClick.click();
		super.waitclass(By.id("toast-container"));
		return new ProductspageTest(driver);
		
	}
	
	public void LandOn()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String Errorscenario()
	{
		super.waitclass(By.cssSelector("div[class*='toast-message']"));
		String error=Errormessage.getText();
		return error;
	}
}
