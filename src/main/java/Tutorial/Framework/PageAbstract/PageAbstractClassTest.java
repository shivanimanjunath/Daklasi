package Tutorial.Framework.PageAbstract;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAbstractClassTest {
	
	WebDriver driver;
	
	public PageAbstractClassTest(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitclass(By findby)
	{	
	WebDriverWait w=new WebDriverWait(driver ,Duration.ofSeconds(8));
	w.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void waity(WebElement findby)
	{	
	WebDriverWait w=new WebDriverWait(driver ,Duration.ofSeconds(8));
	w.until(ExpectedConditions.visibilityOf(findby));
	}
	
	public void visibility(By findby)
	{
		WebDriverWait w=new WebDriverWait(driver ,Duration.ofSeconds(5));
		w.until(ExpectedConditions.elementToBeClickable(findby));
	}
	
	public Actions action()
	{
		Actions acti=new Actions(driver);
		return acti;
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement carticon;
	
	public void gotocart()
	{
		 carticon.click();
	}
}
